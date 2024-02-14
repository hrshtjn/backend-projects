package com.demo.kafkapoc.service;

import com.demo.kafkapoc.util.FakeDataUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class QuoteService {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    //TODO - uncomment below line to send random quotes to kafka
    @Scheduled(fixedRate = 5000)
    public void sendRandomQuotes() {
        List<String> quotes = FakeDataUtil.getFakeQuotes(2);
        quotes.forEach(quote -> {
            log.info("Sending quote: {}", quote);
            kafkaProducerService.sendQuote(quote);
        });
    }
}
