package com.app.user.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class LoginAttemptService {

    private static final Logger log = LoggerFactory.getLogger(LoginAttemptService.class);
    private static final int MAX_ATTEMPTS = 3;
    private static final long LOCK_TIME_DURATION=10*60;   //10m

    private final StringRedisTemplate redisTemplate;

    public String getAttemptsKey(String email){
        return "LOGIN_ATTEMPT:" + email;
    }

    public String getLockKey(String email){
        return "LOCKER:" + email;
    }

    public void recordFailedAttempt(String email){
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String key = getAttemptsKey(email);

        Long attempts = redisTemplate.opsForValue().increment(key);

        if(attempts == 1){
            redisTemplate.expire(key, LOCK_TIME_DURATION, TimeUnit.SECONDS);
        }

        if(attempts >= MAX_ATTEMPTS){
            redisTemplate.opsForValue().set(getLockKey(email), "true", LOCK_TIME_DURATION, TimeUnit.SECONDS);
        }

        log.info("Failed attempts for " + email + " = " + attempts);
        System.out.println("Failed attempts for " + email + " = " + attempts);
    }

    public void resetAttempts(String email){
        redisTemplate.delete(getLockKey(email));
        redisTemplate.delete(getAttemptsKey(email));
    }

    public boolean isBlocked(String email){
        return Boolean.TRUE.equals(redisTemplate.hasKey(getLockKey(email)));
    }


}
