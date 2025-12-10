Sistema de Gerenciamento de Estoque (Spring Boot)
Visão Geral

Aplicação de gerenciamento de estoque desenvolvida em Java Spring Boot, com arquitetura organizada em entidades, repositórios e serviços. O objetivo é registrar entradas e saídas de produtos, gerenciar fornecedores, usuários e manter controle completo do inventário.
O sistema utiliza um banco de dados relacional, podendo compartilhar o mesmo servidor da Smart House do usuário.

Funcionalidades Principais

Registro de Produtos.

Controle de Estoque.

Registro de Entradas e Saídas de estoque.

Cadastro e consulta de Usuários, Clientes e Fornecedores.

Auditoria automática via herança da classe Entidade.

Integração com Docker (containerização do backend e banco).

API REST estruturada com Spring Boot para comunicações futuras com GUI, sensores ou sistemas externos.

Tecnologias Utilizadas

Java 17+

Spring Boot

Spring Web

Spring Data JPA

Spring Security (planejado)

Spring AOP (auditoria opcional)

JPA / Hibernate

MySQL ou SQL Server

Docker (com Docker Compose)

Lombok

Maven

Estrutura das Entidades
Entidade (classe base)
 ├── Usuario
 ├── Cliente
 ├── Fornecedor
 ├── Produto
 ├── Estoque
 ├── EstoqueEntrada
 └── EstoqueSaida


A classe base Entidade contém:

UUID

Datas de criação e atualização

Auditoria com AuditingEntityListener

Endpoints (Exemplos)
Produto

POST /produtos — cria produto

GET /produtos — lista produtos

GET /produtos/{id} — consulta produto

PUT /produtos/{id} — atualiza produto

DELETE /produtos/{id} — remove produto

Estoque

GET /estoque — consulta saldo do estoque

POST /estoque/entrada — registra entrada

POST /estoque/saida — registra saída

(Endpoints podem variar conforme implementação final.)

Banco de Dados

Modelo relacional com tabelas normalizadas:

usuarios

clientes

fornecedores

produtos

estoque

estoque_entrada

estoque_saida

Chaves e relacionamentos seguem a herança da classe Entidade.

Docker (Resumo)
Dockerfile

Backend empacotado em imagem Java com JAR final.

docker-compose.yml

Serviços:

api

mysql ou sqlserver

Volume persistente para banco

Rede compartilhada

Como Executar
Pré-requisitos

Java 17+

Maven

Docker (opcional, se usar containerização)

Executar via Maven
mvn clean install
mvn spring-boot:run

Executar via Docker
docker-compose up -d

Estrutura do Projeto
src/
 ├── main/
 │   ├── java/
 │   │   └── com.suaempresa.estoque/
 │   │        ├── controllers
 │   │        ├── services
 │   │        ├── repositories
 │   │        └── models
 │   └── resources/
 │       ├── application.yml
 │       └── schemas.sql (opcional)

Futuras Implementações

Integração com WebSockets.

Autenticação avançada (usuários e administradores).

Painel gráfico via web ou app.

Logs estruturados acessíveis ao usuário quando desejado.
