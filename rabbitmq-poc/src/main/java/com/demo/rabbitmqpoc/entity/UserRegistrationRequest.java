package com.demo.rabbitmqpoc.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;

@Data
public class UserRegistrationRequest implements Serializable {
    public String username;
    public String email;
    public String phoneNumber;
}
