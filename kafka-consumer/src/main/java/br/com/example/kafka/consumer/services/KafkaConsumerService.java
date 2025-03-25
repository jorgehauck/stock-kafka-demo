package br.com.example.kafka.consumer.services;


import br.com.example.kafka.consumer.dto.StockListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @Autowired
    private StockService stockService;
    @KafkaListener(topics = "compras-acoes", groupId = "meu-grupo", containerFactory = "orderKafkaListenerContainerFactory")
    public void consume(StockListDTO stockDTO) {
        stockService.insertDataStock(stockDTO);
    }
}
