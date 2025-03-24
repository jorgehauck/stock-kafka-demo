package br.com.example.kafka.consumer.services;

import br.com.example.kafka.consumer.dto.StockDTO;
import br.com.example.kafka.consumer.entities.StockEntity;
import br.com.example.kafka.consumer.repositories.IStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class StockService {
    @Autowired
    private IStockRepository repository;
    @Transactional
    public StockDTO insertDataStock(StockDTO stockDTO) {

        StockEntity stockEntity = new StockEntity();
        stockEntity.setTicker(stockDTO.getTicker());
        stockEntity.setPreco(stockDTO.getPreco());
        stockEntity.setQuantidade(stockDTO.getQuantidade());
        stockEntity.setDataCompra(LocalDateTime.parse(stockDTO.getDataCompra()));
        stockEntity.setTotalCompra(stockDTO.getTotalCompra());

        stockEntity = repository.save(stockEntity);

        return new StockDTO(stockEntity);
    }
}
