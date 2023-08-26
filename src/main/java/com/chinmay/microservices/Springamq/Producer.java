package com.chinmay.microservices.Springamq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;

@Slf4j
@Configuration
public class Producer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    Queue queue;

    @Autowired
    @Value("${active-mq.producer}")
    private String producerName;

    public void sendMessage(String string) {
        try {
            log.info("Attempting Send message to : " + producerName);
            jmsTemplate.convertAndSend(queue,string);
            log.info(" Send message Successful : " + producerName);

        } catch (Exception exception) {
            log.error("Exception during send Message: ", exception);
        }
    }

}
