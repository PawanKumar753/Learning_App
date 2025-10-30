package com.app.user.dto;

import com.app.user.entity.Education;
import com.app.user.entity.Intrests;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDTO {

    private String sname;
    private String saddr;
    private String email;
    private Long mobile;
    private String password;

    private Set<Intrests> intrests = new HashSet<>();
    private List<Education> educationList = new ArrayList<>();

}
