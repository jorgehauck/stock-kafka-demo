package br.com.example.kafka.producer.controllers;

import br.com.example.kafka.producer.dto.StockListDTO;
import br.com.example.kafka.producer.services.KafkaProducerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
public class StockKafkaProducerController {
    @Autowired
    private KafkaProducerService producerService;
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/compra")
    public ResponseEntity<StockListDTO> sendMessageKafka(@Valid @RequestBody StockListDTO stockDTO) {
        producerService.sendMessage(stockDTO);
        return ResponseEntity.ok().body(stockDTO);
    }
}
