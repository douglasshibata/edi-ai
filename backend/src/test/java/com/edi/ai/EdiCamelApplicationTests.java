package com.edi.ai;

import org.apache.camel.CamelContext;
import org.apache.camel.Route;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class EdiCamelApplicationTests {

    @Autowired
    private CamelContext camelContext;

    @Test
    void camelContextLoadsAndRoutesAreActive() {
        // Verify Camel Context is successfully loaded
        assertThat(camelContext).isNotNull();
        assertThat(camelContext.isStarted()).isTrue();

        // Verify our custom alert consumer route is loaded
        Route consumerRoute = camelContext.getRoute("ediAlertConsumerRoute");
        assertThat(consumerRoute).isNotNull();

        // Verify our custom alert producer route is loaded
        Route producerRoute = camelContext.getRoute("ediAlertProducerRoute");
        assertThat(producerRoute).isNotNull();
    }
}
