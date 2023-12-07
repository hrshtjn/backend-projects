package com.demo.rabbitmqpoc.listener;

import com.demo.rabbitmqpoc.entity.UserRegistrationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SendSmsListener {

    @RabbitListener(queues = "q.send-sms")
    public void sendSms(UserRegistrationRequest request) {

        log.info("Sending sms to {} ", request.getPhoneNumber());
    }
}
