# 📈 Kafka Stock Trading Demo

Este é um projeto simples de demonstração do **Apache Kafka** utilizando **Spring Boot**, onde um **Producer** envia dados de compra de ações na bolsa de valores e um **Consumer** recebe esses dados e os salva em um banco de dados **H2 (em memória)**.

---

## 📌 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot** (Producer & Consumer)
- **Apache Kafka**
- **Banco de dados H2** (Em memória)
- **Docker** (para rodar o Kafka)

---

## 🚀 Como Funciona?

### ✅ **Producer** (Envia os dados para o Kafka)
O Producer envia um objeto JSON para um tópico Kafka chamado `compras-acoes`.

🔹 **Exemplo de JSON enviado pelo Producer:**
```json
{
    "ticker": "PETR3",
    "quantidade": 100,
    "preco": 33.50
}
```

### ✅ **Consumer** (Recebe e processa os dados)
O Consumer escuta o tópico `compras-acoes`, recebe o JSON enviado e salva os dados no banco **H2**.

---

```
kafka-stock-trading/
│── producer/
│   ├── src/main/java/br/com/example/kafka_producer/
│   │   ├── config/
│   │   ├── controllers/
│   │   ├── dto/
│   │   ├── services/
│── consumer/
│   ├── src/main/java/br/com/example/kafka/consumer/
│   │   ├── config/
│   │   ├── controllers/
│   │   ├── dto/
│   │   ├── services/
│   │   ├── repository/
│── README.md
```

---

## ⚙️ Como Rodar o Projeto?

### 1️⃣ **Subir o Kafka via Docker**
Se você não tem o Kafka rodando, utilize o **Docker Compose** para iniciar os serviços:
```sh
docker-compose up -d
```

### 2️⃣ **Rodar o Producer**
```sh
cd producer
mvn spring-boot:run
```

### 3️⃣ **Rodar o Consumer**
```sh
cd consumer
mvn spring-boot:run
```

### 4️⃣ **Enviar uma mensagem para o Kafka**
Você pode usar o **Postman** ou o **cURL** para enviar um JSON para o Producer:
```sh
curl -X POST "http://localhost:8080/producer/send" -H "Content-Type: application/json" -d '{
    "ticker": "PETR3",
    "quantidade": 100,
    "preco": 33.50
}'
```

### 5️⃣ **Verificar os dados salvos no H2**
Após rodar o Consumer, acesse o console do H2 para verificar os registros:
```
http://localhost:8081/h2-console
```
🔹 **JDBC URL:** `jdbc:h2:mem:stockdb`

---

## 📊 Monitoramento e Logs
Para acompanhar os logs do Kafka e dos serviços:
```sh
docker logs -f kafka
```
Ou diretamente no **Producer** e **Consumer**:
```sh
tail -f producer/logs/app.log
```
```sh
tail -f consumer/logs/app.log
```

---

## 📌 Contribuição
Se quiser contribuir, basta fazer um fork do repositório e abrir um **Pull Request**. 😃

---

🚀 **Desenvolvido por José Jorge**
