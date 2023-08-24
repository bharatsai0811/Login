package com.example.RegisterationLogin.payloadresponse;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginMessage {
    private String Message;
    private Boolean status;

}
