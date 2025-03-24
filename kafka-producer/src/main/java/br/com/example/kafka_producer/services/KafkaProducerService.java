package br.com.example.kafka_producer.services;

import br.com.example.kafka_producer.dto.StockDTO;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@EnableKafka
@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, StockDTO> kafkaTemplate;
    public KafkaProducerService(KafkaTemplate<String, StockDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(StockDTO stockDTO) {
        stockDTO.setDataCompra(LocalDateTime.now().toString());
        kafkaTemplate.send("compras-acoes", stockDTO);
    }
}
