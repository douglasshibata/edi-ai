package com.edi.ai.service;

import com.edi.ai.config.RabbitConfig;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AlertProducer {

    private final ProducerTemplate producerTemplate;

    public AlertProducer(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }

    // Note: Automatic scheduled alerts are now handled via Camel Timer in AlertRoute.java.
    // This method is kept for manual triggers and uses Camel's ProducerTemplate.
    public void simulateBusinessMonitoring() {
        String alertMessage = "ALERTA: Queda de 10% detectada nas vendas da região Norte - ID: " + UUID.randomUUID().toString();
        producerTemplate.sendBody("spring-rabbitmq:" + RabbitConfig.ALERT_EXCHANGE + "?routingKey=edi.alert.sales", alertMessage);
        System.out.println("Alerta enviado via Apache Camel ProducerTemplate: " + alertMessage);
    }
}
