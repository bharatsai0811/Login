package com.example.RegisterationLogin.controller;

import com.example.RegisterationLogin.dto.EmployeeDto;
import com.example.RegisterationLogin.dto.LoginDto;
import com.example.RegisterationLogin.payloadresponse.LoginMessage;
import com.example.RegisterationLogin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employee")
@CrossOrigin
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public String addEmployee(@RequestBody EmployeeDto employeeDto)
    {
        return employeeService.addEmployee(employeeDto);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginMessage> loginEmployee(@RequestBody LoginDto loginDto)
    {
        LoginMessage loginMessage=employeeService.loginEmployee(loginDto);
        return ResponseEntity.ok(loginMessage);

    }

}
