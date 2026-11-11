package com.edi.ai.controller;

import com.edi.ai.service.AlertConsumer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alerts")
public class AlertController {

    private final AlertConsumer alertConsumer;

    public AlertController(AlertConsumer alertConsumer) {
        this.alertConsumer = alertConsumer;
    }

    @GetMapping
    public List<String> getAlerts() {
        return alertConsumer.getAlerts();
    }
}
