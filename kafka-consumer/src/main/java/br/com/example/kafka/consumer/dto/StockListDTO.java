package br.com.example.kafka.consumer.dto;

import java.util.ArrayList;
import java.util.List;

public class StockListDTO {
    private List<StockDTO> compras = new ArrayList<>();
    public List<StockDTO> getCompras() {
        return compras;
    }
    @Override
    public String toString() {
        return "StockListDTO{" +
                "compras=" + compras +
                '}';
    }
}
