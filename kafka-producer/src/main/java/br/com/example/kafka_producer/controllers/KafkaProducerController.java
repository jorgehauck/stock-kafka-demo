package br.com.example.kafka_producer.controllers;

import br.com.example.kafka_producer.dto.StockListDTO;
import br.com.example.kafka_producer.services.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/producer")
public class KafkaProducerController {
    @Autowired
    private KafkaProducerService producerService;
    @PostMapping("/compra")
    public ResponseEntity<Void> sendMessageKafka(@RequestBody StockListDTO stockDTO) {
        producerService.sendMessage(stockDTO);
        return ResponseEntity.ok().build();
    }
}
