package com.edi.ai.service;

import com.edi.ai.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class AlertConsumer {

    private final List<String> processedAlerts = new CopyOnWriteArrayList<>();

    // Note: Replaced `@RabbitListener(queues = RabbitConfig.ALERT_QUEUE)` with Apache Camel Route
    // located in AlertRoute.java to handle advanced integration, EIP routing, and DLC error handling.
    public void handleAlert(String message) {
        System.out.println("Alerta recebido via Apache Camel: " + message);
        processedAlerts.add(message);
    }

    public List<String> getAlerts() {
        return new ArrayList<>(processedAlerts);
    }
}
