package com.demo.rabbitmqpoc.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.RetryInterceptorBuilder;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.retry.RejectAndDontRequeueRecoverer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.interceptor.RetryOperationsInterceptor;

@Configuration
public class RabbitmqConfig {

    private final CachingConnectionFactory cachingConnectionFactory;

    public RabbitmqConfig(CachingConnectionFactory cachingConnectionFactory) {
        this.cachingConnectionFactory = cachingConnectionFactory;
    }

       @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(Jackson2JsonMessageConverter jackson2JsonMessageConverter) {
        RabbitTemplate template = new RabbitTemplate(cachingConnectionFactory);
        template.setMessageConverter(converter());
        return template;
    }

    @Bean
    public Declarables createPostRegistartionSchema(){

        return new Declarables(
                new FanoutExchange("x.post-registration"),
                new Queue("q.send-email" ),
                new Queue("q.send-sms"),
                new Binding("q.send-email", Binding.DestinationType.QUEUE, "x.post-registration", "send-email", null),
                new Binding("q.send-sms", Binding.DestinationType.QUEUE, "x.post-registration", "send-sms", null));

    }

    @Bean
    public RetryOperationsInterceptor retryInterceptor(){
        return RetryInterceptorBuilder.stateless().maxAttempts(3)
                .backOffOptions(2000, 2.0, 100000)
                .recoverer(new RejectAndDontRequeueRecoverer())
                .build();
    }


    //naming the bean rabbitListenerContainerFactory overrides the default listener container factory.
    // Thus this retry mechanism will get activated for all the listeners.
    // If you don’t want this and want this mechanism only for UserRegistrationListener,
    // do the following. Rename the factory something else..
    // Like: registrationListenerContainerFactory then mention it in the RabbitListener annotation line
    // @RabbitListener(queues = {"q.user-registration"}, containerFactory = "registrationListenerContainerFactory")
    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory, cachingConnectionFactory);
        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
        factory.setAdviceChain(retryInterceptor());
        return factory;
    }

    @Bean
    public Declarables createDeadLetterSchema(){
        return new Declarables(
                new DirectExchange("x.registration-failure"),
                new Queue("q.fall-back-registration"),
                new Binding("q.fall-back-registration", Binding.DestinationType.QUEUE,"x.registration-failure", "fall-back", null)
        );
    }

    @Bean
    public Queue createUserRegistrationQueue() {

        return QueueBuilder.durable("q.user-registration")
                .withArgument("x-dead-letter-exchange","x.registration-failure")
                .withArgument("x-dead-letter-routing-key","fall-back")
                .build();
    }
}
