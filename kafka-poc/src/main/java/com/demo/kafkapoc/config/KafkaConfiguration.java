package com.demo.kafkapoc.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfiguration {

    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name("demo").partitions(4).build();
    }
//
//    @Bean
//    public NewTopic streamsInputTopic() {
//        return TopicBuilder.name("streamInput").partitions(2).build();
//    }
//
//    @Bean
//    public NewTopic streamsOutputTopic() {
//        return TopicBuilder.name("streamOutput").partitions(2).build();
//    }
//


}
