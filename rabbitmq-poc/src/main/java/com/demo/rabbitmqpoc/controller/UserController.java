package com.demo.rabbitmqpoc.controller;

import com.demo.rabbitmqpoc.entity.UserRegistrationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value="/api", produces = MediaType.APPLICATION_JSON_VALUE,
consumes=MediaType.APPLICATION_JSON_VALUE)
@RestController
@Slf4j
public class UserController {

    private final RabbitTemplate rabbitTemplate;

    public UserController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/user")
    public String createUser(@RequestBody UserRegistrationRequest request) {
        rabbitTemplate.convertAndSend("","q.user-registration",request);
        return "ok";
    }
}
