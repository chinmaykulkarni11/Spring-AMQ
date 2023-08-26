package com.chinmay.microservices.Springamq;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSslConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

@Slf4j
@org.springframework.context.annotation.Configuration
public class Configuration {

    @Value("${active-mq.broker-url}")
    public String BROKER_URL;


    @Bean
    public Queue queue() {
        return new ActiveMQQueue("testAMQQueue");
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        log.info("BROKER_URL : " + BROKER_URL);
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQSslConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(BROKER_URL);
        return activeMQConnectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory());
        //jmsTemplate.setPubSubDomain(true);
        return jmsTemplate;

    }


}
