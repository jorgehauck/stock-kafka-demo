package br.com.example.kafka.consumer.services;

import br.com.example.kafka.consumer.dto.StockDTO;
import br.com.example.kafka.consumer.dto.StockListDTO;
import br.com.example.kafka.consumer.entities.StockEntity;
import br.com.example.kafka.consumer.repositories.IStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockService {
    @Autowired
    private IStockRepository repository;
    @Transactional
    public List<StockDTO> insertDataStock(StockListDTO stockDTO) {
        List<StockEntity> stockList = new ArrayList<>();

        for (StockDTO item : stockDTO.getCompras()) {
            StockEntity stockEntity = new StockEntity();
            stockEntity.setTicker(item.getTicker());
            stockEntity.setPreco(item.getPreco());
            stockEntity.setQuantidade(item.getQuantidade());
            stockEntity.setDataCompra(LocalDateTime.parse(item.getDataCompra()));
            stockEntity.setTotalCompra(item.getTotalCompra());
            stockList.add(stockEntity);
        }
        stockList = repository.saveAll(stockList);
        return stockList.stream().map(x -> new StockDTO(x)).collect(Collectors.toList());
    }
}
