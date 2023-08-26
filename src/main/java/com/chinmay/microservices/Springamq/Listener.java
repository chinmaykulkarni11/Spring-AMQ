package com.chinmay.microservices.Springamq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
@Slf4j
public class Listener {

    @JmsListener(destination = "testAMQQueue")
    public void onMessage(Message message) {
        try {
            log.info("Received Message: " + message.toString());
        } catch (Exception e) {
            log.error("Received Exception : " + e);
        }

    }

}
