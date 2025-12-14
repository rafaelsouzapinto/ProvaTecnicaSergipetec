# 💰 API de Férias do Servidor

Esta é uma API REST desenvolvida em **Spring Boot 3** que simula um sistema de gestão e consulta de períodos de férias e informações básicas de pagamento de servidores públicos.
A aplicação é entregue totalmente containerizada usando Docker Compose, priorizando a simplicidade na execução e a segurança das credenciais.

## 🚀 Começando

Estas instruções permitirão que você configure e execute a aplicação (API + Banco de Dados) com um único comando Docker.

### 📋 Pré-requisitos

Você precisa apenas das seguintes ferramentas instaladas e em execução:

```
Docker | Docker Compose
```

### 🔒 Configuração de Variáveis de Ambiente (Segurança)

**Passo Obrigatório:** Crie o arquivo **`.env`** na **raiz do projeto** com o seguinte conteúdo. O Docker Compose irá ler estas variáveis para configurar o banco e a API.

```
# .env (CRIE ESTE ARQUIVO LOCALMENTE NA RAIZ DO PROJETO)
DB_NAME=provasergipetec
DB_USER=postgres
DB_PASS=postgres

API_PORT=8080
```

### 🔧 Instalação e Execução

A API e o banco de dados serão inicializados juntos.

<strong>1. Executar o Docker Compose</strong>

Abra o **terminal** na raiz do projeto (onde está o docker-compose.yml) e execute:
```
docker-compose up --build
```
O argumento --build garante que a imagem da API seja criada com as últimas alterações antes de iniciar.


<strong>2. Verificação de Dados (Inicialização)</strong>

Após a inicialização do Spring Boot, o banco de dados será automaticamente populado com dados de demonstração (servidores, férias e pagamentos) através do arquivo:
```
src/main/resources/data.sql
```

### 🌐 Acesso à Aplicação

* **API REST:** http://localhost:8080
* **Banco de Dados (Postgres):** localhost:5432

### 💻 Endpoints da API 

| Recurso                       | Método | Endpoint                           |
|-------------------------------|--------|------------------------------------|
| Simulação de login          | POST   | `/login`                           |
| Lista de períodos de férias do Servidor | GET    | `/servidores/{id}/ferias`          |
| Solicita um novo período de férias       | POST   | `/ferias`                          |
| Detalhes de férias   | GET    | `/ferias/{id}`                 |



### 🛠️ Detalhes Técnicos

* **Back-end:** Java 21, Spring Boot 3, Spring Data JPA.
* **Banco de Dados:** PostgreSQL.
* **Build:** Maven
