package br.com.example.kafka.consumer.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_stock")
public class StockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String ticker;
    private Integer quantidade;
    private BigDecimal preco;
    private LocalDateTime dataCompra;
    private BigDecimal totalCompra;
    public StockEntity() {}
    public StockEntity(UUID id, String ticker, Integer quantidade, BigDecimal preco, LocalDateTime dataCompra, BigDecimal totalCompra) {
        this.id = id;
        this.ticker = ticker;
        this.quantidade = quantidade;
        this.preco = preco;
        this.dataCompra = dataCompra;
        this.totalCompra = totalCompra;
    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }
    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }
    public BigDecimal getTotalCompra() {
        return totalCompra;
    }
    public void setTotalCompra(BigDecimal totalCompra) {
        this.totalCompra = totalCompra;
    }

}
