package br.com.example.kafka.producer.dto;

import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;

public class StockDTO implements Serializable {
    @NotBlank(message = "Campo requerido")
    private String ticker;
    @NotNull(message = "Campo requerido")
    @Positive(message = "O preço deve ser positivo")
    private Integer quantidade;
    @NotNull(message = "Campo requerido")
    @Positive(message = "O preço deve ser positivo")
    @DecimalMin(value = "0.01", message = "O preço da ação deve ser no mínimo 0.01.")
    @Digits(integer = 10, fraction = 2, message = "O preço deve ter no máximo 10 dígitos na parte inteira e 2 na parte decimal.")
    private BigDecimal preco;
    private String dataCompra;
    public StockDTO() {}
    public StockDTO(String ticker, Integer quantidade, BigDecimal preco, String dataCompra) {
        this.ticker = ticker;
        this.quantidade = quantidade;
        this.preco = preco;
        this.dataCompra = dataCompra;
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
}
