# 📈 Kafka Stock Trading Demo

Este projeto demonstra a implementação de um sistema de mensageria utilizando Apache Kafka para processar compras de ações na bolsa de valores. O **Producer** envia um JSON contendo os detalhes da compra, e o **Consumer** recebe e armazena esses dados em um banco de dados em memória H2.

## 🛠 Tecnologias Utilizadas
- **Java 21**
- **Spring Boot**
- **Spring Kafka**
- **Apache Kafka**
- **Banco de dados H2**
- **Docker** (para subir o Kafka e Zookeeper)

## 📂 Estrutura do Projeto

### Producer (`br.com.example.kafka.producer`)
- **config** - Configurações do Kafka
- **controllers** - Endpoints REST para envio de mensagens
- **dto** - Data Transfer Objects (DTOs)
- **services** - Lógica de envio de mensagens para o Kafka

### Consumer (`br.com.example.kafka.consumer`)
- **config** - Configurações do Kafka
- **controllers** - Endpoints REST para consulta
- **dto** - Data Transfer Objects (DTOs)
- **services** - Lógica de processamento das mensagens
- **repository** - Interface para acesso ao banco de dados

## 🚀 Como Executar o Projeto

1. **Subir o Apache Kafka e Zookeeper**
   - O projeto inclui um arquivo `docker-compose.yml`, que facilita a execução dos serviços necessários.
   - Para subir os serviços, execute:
     ```sh
     docker-compose up -d
     ```

2. **Executar o Producer**
   ```sh
   mvn spring-boot:run -pl kafka_producer
   ```

3. **Executar o Consumer**
   ```sh
   mvn spring-boot:run -pl kafka_consumer
   ```

## 📄 Exemplo de JSON Enviado pelo Producer
```json
{
    "compras": [
        {
            "ticker": "PETR3",
            "quantidade": 100,
            "preco": 33.50
        },
        {
            "ticker": "VALE3",
            "quantidade": 50,
            "preco": 67.20
        },
        {
            "ticker": "BBDC3",
            "quantidade": 100,
            "preco": 25.80
        },
        {
            "ticker": "TAEE11",
            "quantidade": 130,
            "preco": 38.54
        },
        {
            "ticker": "ITUB4",
            "quantidade": 80,
            "preco": 32.60
        }
    ]
}
```

## 🏦 Banco de Dados
O Consumer salva os dados no **H2 Database**. Para acessar o console web:
```
http://localhost:8081/h2-console
```
- **JDBC URL:** `jdbc:h2:mem:testdb`
- **Usuário:** `sa`
- **Senha:** *(vazia)*

## 📌 Observações
- O Kafka precisa estar rodando antes de iniciar o Producer e o Consumer.
- O Consumer está configurado para consumir mensagens do tópico automaticamente.
- A lista de compras é encapsulada em um objeto DTO (`StockListDTO`) para garantir compatibilidade com Kafka.

---

## 📌 Contribuição
Se quiser contribuir, basta fazer um fork do repositório e abrir um **Pull Request**. 😃

---

🚀 **Desenvolvido por José Jorge**
