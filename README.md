# Javer Bank - Client Service (App 1)

## Visão Geral
O serviço client (`app1`) do Javer Bank atua como intermediário entre a camada de requisições (Client Service) e o backend (`Manager Service`), processando requisições e fornecendo consultas via Swagger para operações com clientes e cálculo de score de crédito. Poderá ser utilizado futuramente como API para consumo pelo frontend ou outras aplicações.

## Funcionalidades
- Envio de requisições para criação, atualização, deleção e recuperação de um ou mais clientes;
- Cálculo do score de crédito com base nas informações do cliente;
- Documentação de API com Swagger.

## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot**
- **Feign Client**
- **Lombok**
- **Maven**
- **Swagger**
- **AWS Elastic Beanstalk**

## Documentação da API
A documentação da API está disponível e interativa via Swagger em modo local ou na nuvem.

## Acessando a documentação:
Em modo local, acesse http://localhost:8081/swagger-ui/index.html
Na AWS, após o deploy, acesse: http://deploy-app1-env.eba-p833t9um.us-east-1.elasticbeanstalk.com/swagger-ui/index.html
OBS.: O link pode estar depreciado caso o serviço Elestic Beanstalk para esta aplicação não esteja disponível no momento da consulta.