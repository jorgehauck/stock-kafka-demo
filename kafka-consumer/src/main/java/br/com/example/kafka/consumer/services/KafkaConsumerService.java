package br.com.example.kafka.consumer.services;

import br.com.example.kafka.consumer.dto.StockDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class KafkaConsumerService {
    @Autowired
    private StockService stockService;
    @KafkaListener(topics = "meu-topico", groupId = "meu-grupo", containerFactory = "orderKafkaListenerContainerFactory")
    public void consume(StockDTO stockDTO) {
        stockService.insertDataStock(stockDTO);
    }
}
