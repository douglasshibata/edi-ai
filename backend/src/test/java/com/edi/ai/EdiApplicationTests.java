package com.edi.ai;

import com.edi.ai.service.AlertProducer;
import com.edi.ai.service.IngestionService;
import com.edi.ai.service.ChatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class EdiApplicationTests {

    @Autowired(required = false)
    private ChatService chatService;

    @Autowired(required = false)
    private IngestionService ingestionService;

    @Autowired(required = false)
    private AlertProducer alertProducer;

	@Test
	void contextLoads() {
        assertThat(chatService).isNotNull();
        assertThat(ingestionService).isNotNull();
        assertThat(alertProducer).isNotNull();
	}

}
