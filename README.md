# Comunicação Assíncrona entre Microserviços: User e Email

Este projeto demonstra a comunicação assíncrona entre dois microserviços independentes: o **User Microservice** e o **Email Microservice**. O fluxo principal envolve o cadastro de um novo usuário e o envio de um e-mail de boas-vindas.

**Fluxo de Comunicação:**

1.  **Cadastro de Usuário:** Um cliente (e.g., uma aplicação web) envia os dados do novo usuário (nome de usuário e e-mail) via requisição HTTP para o **Serviço de Cadastro** (implementado dentro do User Microservice).
2.  **Persistência no User Microservice:** O **User Microservice** recebe a requisição, valida os dados (Spring Validation), persiste o usuário em seu banco de dados PostgreSQL (Spring Data JPA).
3.  **Publicação de Mensagem:** Após o sucesso no cadastro, o **User Microservice** publica uma mensagem contendo as informações do novo usuário (e.g., ID e e-mail) em uma fila do RabbitMQ (Spring AMQP).
4.  **Consumo de Mensagem:** O **Email Microservice** está escutando a fila do RabbitMQ (Spring AMQP). Ao receber a mensagem de novo usuário, ele a processa.
5.  **Envio de E-mail:** O **Email Microservice** utiliza o Spring Mail para enviar um e-mail de boas-vindas para o endereço de e-mail do novo usuário (configurado com SMTP Gmail).
6.  **Persistência no Email Microservice:** O **Email Microservice** também persiste a informação sobre o e-mail enviado em seu próprio banco de dados.

## Tecnologias Utilizadas

As seguintes tecnologias foram utilizadas no desenvolvimento deste projeto:

* **Java JDK 17:** Linguagem de programação principal.
* **Maven:** Ferramenta de gerenciamento de dependências e build.
* **PostgreSQL:** Banco de dados utilizado pelo User Microservice.
* **RabbitMQ:** Broker de mensagens para comunicação assíncrona.
* **CloudAMQP:** Serviço de hospedagem do RabbitMQ utilizado.
* **SMTP Gmail:** Serviço de e-mail utilizado para o envio de e-mails.
* **Spring Boot:** Framework Java para desenvolvimento rápido de aplicações.
* **Spring Web:** Módulo do Spring para desenvolvimento de aplicações web (API REST para cadastro).
* **Spring Data JPA:** Módulo do Spring para facilitar a interação com bancos de dados JPA.
* **Spring Validation:** Módulo do Spring para realizar validação de dados.
* **Spring AMQP:** Módulo do Spring para integração com o RabbitMQ.
* **Spring Mail:** Módulo do Spring para envio de e-mails.

## Pré-requisitos

Antes de executar o projeto, certifique-se de ter as seguintes ferramentas instaladas e configuradas:

* **Java JDK 17** ou superior.
* **Maven** instalado.
* Uma instância do **PostgreSQL** em execução (com as configurações de banco de dados necessárias).
* Uma conta no **CloudAMQP** (ou outra instância do RabbitMQ) com as credenciais configuradas.
* Uma conta **Gmail** com a opção "Acesso a apps menos seguros" habilitada (ou configuração de "App passwords" se a autenticação de dois fatores estiver ativa).


## Próximos Passos e Melhorias

Algumas ideias para futuros desenvolvimentos e melhorias:

* **Tratamento de Erros:** Implementar um tratamento de erros mais robusto em ambos os microserviços, incluindo retentativas em caso de falha na comunicação com o broker ou no envio de e-mail.
* **Monitoramento e Logging:** Adicionar ferramentas de monitoramento e logging para acompanhar o desempenho e o comportamento dos microserviços em tempo real.
* **Testes:** Escrever testes unitários e de integração para garantir a qualidade e a confiabilidade do código.
* **Segurança:** Implementar mecanismos de segurança para proteger a comunicação entre os microserviços e os dados dos usuários.
* **Configuração Externa:** Utilizar um serviço de configuração centralizado (e.g., Spring Cloud Config) para gerenciar as configurações dos microserviços.
* **Containerização:** Empacotar os microserviços em containers Docker para facilitar a implantação e o escalonamento.
* **Orquestração:** Utilizar uma ferramenta de orquestração de containers (e.g., Kubernetes) para gerenciar a implantação e o escalonamento dos microserviços.

## Contribuição

Se você tiver alguma sugestão de melhoria ou encontrar algum problema, sinta-se à vontade para abrir uma issue ou enviar um pull request.
