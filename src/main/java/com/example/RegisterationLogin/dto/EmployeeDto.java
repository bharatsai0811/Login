package com.example.RegisterationLogin.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Integer id;
    private String employeeName;
    private String employeeMail;
    private String password;
}
