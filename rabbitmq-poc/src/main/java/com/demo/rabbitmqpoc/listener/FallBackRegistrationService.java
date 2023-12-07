package com.demo.rabbitmqpoc.listener;

import com.demo.rabbitmqpoc.entity.UserRegistrationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FallBackRegistrationService {

    @RabbitListener(queues = {"q.fall-back-registration"})
    public void onRegistrationFailure(UserRegistrationRequest failedRegistration){
        log.info("Executing fallback for failed registration {}", failedRegistration);
    }
}
