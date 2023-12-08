# Projetos

## Projeto 1: Middleware para Integração com APIs

### Descrição
O projeto "Middleware para Integração com APIs" oferece funcionalidades de middleware para facilitar a integração com APIs externas. Ele fornece uma abordagem genérica para consultas a APIs, simplificando a comunicação e o processamento de dados.

### Recursos Principais
- Middleware reutilizável para consultas a APIs externas.
- Facilita a integração com diferentes endpoints e serviços.
- Suporta diversos métodos HTTP (GET, POST, etc.).
- Tratamento de erros e respostas para uma integração robusta.

### Tecnologias Utilizadas
- **Java:** Plataforma de desenvolvimento que oferece uma abordagem eficiente e poderosa para criar aplicativos escaláveis e de alto desempenho.
- **Spring:** Framework para desenvolvimento de aplicações Java que simplifica a configuração, promove boas práticas de programação e oferece uma ampla variedade de módulos para diferentes aspectos do desenvolvimento.
- **Spring Boot:** Extensão do framework Spring que simplifica o processo de configuração e desenvolvimento de aplicativos Java.
- **JUnit:** Framework de teste para Java que facilita a criação e execução de testes unitários.

## Spring Architecture

### Descrição
Estudo da Arquitetura do Spring com assuntos em questão: Path params, tratamento de exceção, Padrão de projetos VO, Flyway, Content Negotiation, HATEOAS, Swagger, CORS, Autenticação e Spring Security, Rest Assured, Testcontainers, JUnit, Query params, Busca paginada, Upload e Download de arquivos, Dockerização da aplicação, Implementação na AWS e Integração Contínua com AWS e GitHub Actions.

### Recursos Principais
- [ x ] **Path Params e Tratamento de Exceção:** Utilização de Path Params para receber parâmetros na URL e implementação de tratamento de exceções para lidar com erros de forma robusta.
- [ X ] **Padrão de Projetos VO (Value Object):** Adoção do padrão de projetos Value Object para representar valores sem identidade.
- [ X ] **Flyway:** Utilização do Flyway para controle de versionamento e migração do banco de dados.
- [ X ] **Content Negotiation:** Implementação do Content Negotiation para suportar diferentes formatos de resposta (JSON, XML, etc.) de acordo com as preferências do cliente.
- [ X ] **HATEOAS (Hypermedia as the Engine of Application State):** Adição de links HATEOAS nos recursos da API, facilitando a navegação e descoberta de endpoints.
- [ X ] **Swagger:** Documentação da API utilizando Swagger para facilitar o entendimento e teste da API.
- [  ] **CORS (Cross-Origin Resource Sharing):** Configuração do CORS para permitir requisições de diferentes origens.
- [  ] **Autenticação e Spring Security:** Implementação de autenticação segura usando Spring Security, garantindo a proteção dos endpoints sensíveis.
- [  ] **Blindagem da API com Rest Assured:** Testes automatizados com Rest Assured para assegurar a integridade da API.
- [  ] **Testcontainers e JUnit:** Utilização do Testcontainers junto com JUnit para testes de integração, facilitando a execução de testes em ambientes isolados e controlados.
- [  ] **Query Params e Busca Paginada:** Adição de suporte para Query Params para filtrar resultados e busca paginada para lidar com grandes conjuntos de dados.
- [  ] **Upload e Download de Arquivos:** Implementação de endpoints para upload e download de arquivos, permitindo a manipulação de recursos binários.
- [  ] **Dockerização da Aplicação:** Criação de Dockerfile para empacotar a aplicação em containers, simplificando a implantação e garantindo consistência de ambientes.
- [  ] **Implementação na AWS:** Configuração e implantação da aplicação na Amazon Web Services (AWS) para garantir escalabilidade e disponibilidade.
- [  ] **Integração Contínua com AWS e GitHub Actions:** Configuração de pipelines de integração contínua com AWS CodePipeline ou GitHub Actions, garantindo testes e deploy automatizados em ambientes de produção.

### Tecnologias Utilizadas
- **Java:** Linguagem de programação utilizada para desenvolvimento na plataforma Spring.
- **Spring Boot:** Framework para desenvolvimento de aplicações Java com facilidade.
- **MySQL:** Banco de dados relacional utilizado para armazenamento de dados.
- **Spring Data JPA:** Biblioteca do Spring que simplifica a interação com bancos de dados relacionais.
- **Swagger:** Ferramenta para documentação de APIs.
- **Spring Security:** Módulo de segurança do Spring para autenticação e controle de acesso.
- **Rest Assured:** Framework de teste para APIs REST em Java.
- **Testcontainers:** Biblioteca para facilitar testes de integração utilizando contêineres.
- **JUnit:** Framework de testes unitários para Java.
- **Docker:** Plataforma para desenvolvimento, envio e execução de aplicações em contêineres.
- **AWS:** Amazon Web Services, provedor de serviços de computação em nuvem.


## Product Operations API

### Descrição
Esta API foi desenvolvida utilizando Node.js, TypeScript e MongoDB. Ela fornece endpoints para realizar operações CRUD em uma entidade fictícia "Produto", incluindo a capacidade de buscar produtos, criar, atualizar, deletar, buscar produtos acima de um valor específico e buscar produtos com base em uma palavra-chave na descrição.

### Recursos Principais
- **Operações CRUD:** Endpoint para criar, ler, atualizar e deletar produtos.
- **Consulta por Preço:** Endpoint para listar produtos com preço acima de um valor especificado.
- **Consulta por Palavra-Chave:** Endpoint para listar produtos contendo uma palavra-chave específica na descrição.

### Tecnologias Utilizadas
- **Node.js:** Plataforma de execução JavaScript.
- **TypeScript:** Superset do JavaScript que adiciona tipagem estática.
- **MongoDB:** Banco de dados NoSQL para armazenamento de dados.
- **Express:** Framework web para Node.js facilitando o desenvolvimento de APIs.
- **Mongoose:** ODM (Object Data Modeling) para MongoDB, facilitando a interação com o banco de dados.
- **Jest:** Framework de teste para JavaScript e TypeScript.


