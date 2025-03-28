package br.com.example.kafka.consumer.dto;

import br.com.example.kafka.consumer.entities.StockEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class StockDTO implements Serializable {
    private String ticker;
    private Integer quantidade;
    private BigDecimal preco;
    private String dataCompra;
    private BigDecimal totalCompra;
    public StockDTO() {}
    public StockDTO(String ticker, Integer quantidade, BigDecimal preco, String dataCompra) {
        this.ticker = ticker;
        this.quantidade = quantidade;
        this.preco = preco;
        this.dataCompra = dataCompra;
    }
    public StockDTO(StockEntity entity) {
        this.ticker = entity.getTicker();
        this.quantidade = entity.getQuantidade();
        this.preco = entity.getPreco();
        this.dataCompra = entity.getDataCompra().toString();
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }
    public BigDecimal getTotalCompra() {
        return totalCompra;
    }
    public void setTotalCompra(BigDecimal totalCompra) {
        this.totalCompra = totalCompra;
    }

    @Override
    public String toString() {
        return "StockDTO{" +
                "ticker='" + ticker + '\'' +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                ", dataCompra=" + dataCompra +
                '}';
    }
}
