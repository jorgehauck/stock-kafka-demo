package br.com.example.kafka.consumer.repositories;

import br.com.example.kafka.consumer.entities.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStockRepository extends JpaRepository<StockEntity, Long> {
}
