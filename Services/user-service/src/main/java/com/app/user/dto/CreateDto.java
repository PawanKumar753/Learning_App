package com.app.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDto {
    private String sname;
    private String saddr;
    private String email;
    private Long mobile;
    private String password;
    private Set<String> courseList = new HashSet<>();
}
