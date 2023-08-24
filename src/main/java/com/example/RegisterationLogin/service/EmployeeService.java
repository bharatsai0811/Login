package com.example.RegisterationLogin.service;

import com.example.RegisterationLogin.dto.EmployeeDto;
import com.example.RegisterationLogin.dto.LoginDto;
import com.example.RegisterationLogin.entity.Employee;
import com.example.RegisterationLogin.payloadresponse.LoginMessage;
import com.example.RegisterationLogin.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
private EmployeeRepo employeeRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public String addEmployee( EmployeeDto employeeDto) {
        Employee employee=new Employee(

                employeeDto.getId(),
                employeeDto.getEmployeeName(),
                employeeDto.getEmployeeMail(),
                passwordEncoder.encode(employeeDto.getPassword()));
        employeeRepo.save(employee);
        return employee.getEmployeeName();
    }
    public LoginMessage loginEmployee(LoginDto loginDto) {
        Employee employee1 = employeeRepo.findByEmployeeMail(loginDto.getUsername());

        if (employee1 != null) {
            String password = loginDto.getPassword();
            String encodedPassword = employee1.getPassword();
            boolean isPasswordCorrect = passwordEncoder.matches(password, encodedPassword);

            if (isPasswordCorrect) {
                return new LoginMessage("Login Successful", true);
            } else {
                return new LoginMessage("Password Incorrect", false);
            }
        } else {
            return new LoginMessage("Email Not Available", false);
        }
    }

}
