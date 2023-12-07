package com.demo.rabbitmqpoc.listener;

import com.demo.rabbitmqpoc.entity.UserRegistrationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SendEmailListener {

    @RabbitListener(queues = "q.send-email")
    public void sendEmail(UserRegistrationRequest request) {

        log.info("Sending email to {}", request.getEmail());
    }
}
