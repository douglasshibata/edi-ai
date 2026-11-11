package com.edi.ai.route;

import com.edi.ai.config.RabbitConfig;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class AlertRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // Error handling with Dead Letter Channel
        errorHandler(deadLetterChannel("spring-rabbitmq:" + RabbitConfig.DLX_EXCHANGE + "?routingKey=" + RabbitConfig.DLQ_ROUTING_KEY + "&autoDeclare=false"));

        // Consumer Route
        // Consumes from the alert queue, logs it, and forwards it to alertConsumer bean
        from("spring-rabbitmq:" + RabbitConfig.ALERT_EXCHANGE + "?queues=" + RabbitConfig.ALERT_QUEUE + "&routingKey=" + RabbitConfig.ALERT_ROUTING_KEY + "&autoDeclare=false")
            .routeId("ediAlertConsumerRoute")
            .log("Apache Camel: Novo alerta recebido para processamento: ${body}")
            .to("bean:alertConsumer?method=handleAlert");

        // Producer Route
        // Simulates business monitoring by producing alerts every 30 seconds
        from("timer:alertTimer?period=30000")
            .routeId("ediAlertProducerRoute")
            .process(exchange -> {
                String alertMessage = "ALERTA: Queda de 10% detectada nas vendas da região Norte - ID: " + java.util.UUID.randomUUID().toString();
                exchange.getIn().setBody(alertMessage);
            })
            .log("Apache Camel: Produzindo alerta de negócios via timer: ${body}")
            .to("spring-rabbitmq:" + RabbitConfig.ALERT_EXCHANGE + "?routingKey=edi.alert.sales&autoDeclare=false");
    }
}
