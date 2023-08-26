package com.chinmay.microservices.Springamq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Controller {
    @Autowired
    Producer jmsProducer;

    @GetMapping(value = "/api/amq")
    public String sendMessage() {
        jmsProducer.sendMessage("Chinmay " + Runtime.getRuntime());
        return ResponseEntity.ok("Done").toString();
    }

    @GetMapping(value = "/api/health")
    public String health() {
        return ResponseEntity.ok("UP").toString();
    }


}
