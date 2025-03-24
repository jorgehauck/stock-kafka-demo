package br.com.example.kafka_producer.controllers;

import br.com.example.kafka_producer.dto.StockDTO;
import br.com.example.kafka_producer.services.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
public class KafkaProducerController {
    @Autowired
    private KafkaProducerService producerService;
    @PostMapping("/send")
    public ResponseEntity<Void> sendMessageKafka(@RequestBody StockDTO stockDTO) {
        producerService.sendMessage(stockDTO);
        return ResponseEntity.ok().build();
    }
}
