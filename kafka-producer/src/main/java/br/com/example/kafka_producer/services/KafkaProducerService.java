package br.com.example.kafka_producer.services;

import br.com.example.kafka_producer.dto.StockDTO;
import br.com.example.kafka_producer.dto.StockListDTO;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@EnableKafka
@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, StockListDTO> kafkaTemplate;
    public KafkaProducerService(KafkaTemplate<String, StockListDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(StockListDTO stockDTO) {
        stockDTO.getCompras().forEach(x -> {
            x.setDataCompra(LocalDateTime.now().toString());
        });
        kafkaTemplate.send("compras-acoes", stockDTO);
    }
}
