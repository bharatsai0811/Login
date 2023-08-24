package com.example.RegisterationLogin.service.impl;

import com.example.RegisterationLogin.dto.EmployeeDto;
import com.example.RegisterationLogin.entity.Employee;
import com.example.RegisterationLogin.repo.EmployeeRepo;
import com.example.RegisterationLogin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EmployeeServiceImpl {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addEmployee( EmployeeDto employeeDto) {
        Employee employee=new Employee(

        employeeDto.getId(),
        employeeDto.getEmployeeName(),
       employeeDto.getEmployeeMail(),
      employeeDto.getPassword());
        employeeRepo.save(employee);
        return employee.getEmployeeName();
    }
}
