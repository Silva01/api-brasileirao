# Gerenciamento do Campeonato Brasileiro - API REST

[![Java CI with Maven](https://github.com/Silva01/api-brasileirao/actions/workflows/maven.yml/badge.svg?branch=main)](https://github.com/Silva01/api-brasileirao/actions/workflows/maven.yml)
![Maven Version](https://img.shields.io/badge/maven-3.8.1-blue)
![JDK Version](https://img.shields.io/badge/jdk-17-orange)
![License](https://img.shields.io/github/license/silva01/api-brasileirao)


Esta API REST foi desenvolvida para auxiliar a CBF no gerenciamento do Campeonato Brasileiro, incluindo funcionalidades para gerenciar times, jogadores, transferências e torneios.

## Stack Utilizada

- Linguagem: Java
- Framework: Spring Boot
- Banco de dados: H2 (em memória)
- Documentação da API: Open API

## Funcionalidades

### Fase 1

1. Times
- CRUD de times
- Atributos: Nome, Localidade
2. Jogadores
- CRUD de jogadores
- Atributos: Nome, Data de Nascimento, País, Time
3. Transferências
- CRUD de transferências
- Atributos: Jogador, Time de Origem, Time de Destino, Data, Valor

### Fase 2

1. Torneios
- CRUD de torneios
2. Times cadastrados em Torneios
- CRUD de times em torneios
3. Partidas Cadastradas entre Times, em Torneios
- CRUD de partidas entre times em torneios
4. Eventos de Partida
- Cadastrar eventos que ocorrem em uma partida

## Instalação e Execução

1. Clone este repositório

```bash
git clone https://github.com/silva01/campeonato-brasileiro-api.git
```

2. Navegue até o diretório do projeto

```bash
cd campeonato-brasileiro-api
```

3. Compile e execute a aplicação utilizando o Maven Wrapper

```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`.

## Documentação da API

A documentação da API, seguindo o padrão Open API, pode ser acessada em `http://localhost:8080/swagger-ui.html`.

## Demonstração

Em Construção

## Autor

- Nome: [Daniel Silva](https://github.com/Silva01)
