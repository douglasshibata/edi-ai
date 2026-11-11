package com.edi.ai.controller;

import com.edi.ai.service.IngestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/ingest")
public class IngestionController {

    private final IngestionService ingestionService;

    public IngestionController(IngestionService ingestionService) {
        this.ingestionService = ingestionService;
    }

    @PostMapping("/text")
    public Map<String, String> ingestText(@RequestBody Map<String, String> request) {
        String content = request.get("content");
        ingestionService.ingestText(content);
        return Map.of("message", "Documento ingerido com sucesso no Qdrant");
    }
}
