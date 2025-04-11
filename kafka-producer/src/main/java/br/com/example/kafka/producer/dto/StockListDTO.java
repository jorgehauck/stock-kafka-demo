package br.com.example.kafka.producer.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

public class StockListDTO {
    @NotEmpty(message = "É necessário informar pelo menos uma ação para a compra.")
    @Valid
    private List<StockDTO> compras = new ArrayList<>();
    public List<StockDTO> getCompras() {
        return compras;
    }
}
