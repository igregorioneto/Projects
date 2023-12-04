# Product Operations API

## Descrição
Bem-vindo à API Product Operations! Esta API foi desenvolvida utilizando Node.js, TypeScript e MongoDB. Ela fornece endpoints para realizar operações CRUD em uma entidade fictícia "Produto", incluindo a capacidade de buscar produtos, criar, atualizar, deletar, buscar produtos acima de um valor específico e buscar produtos com base em uma palavra-chave na descrição.

## Tecnologias Utilizadas
- Node.js
- TypeScript
- MongoDB

## Configuração do Projeto

### Clonando o Repositório
```bash
git clone https://github.com/seu-usuario/product-operations-api.git
cd product-operations-api
cd backend
```

### Instalando Dependências
```bash
npm install
```

### Executando o Docker Compose
```bash
docker-compose up -d
```

### Parar o Container
```bash
docker-compose down
```

### Variáveis de Ambiente
```bash
MONGODB_URI=mongodb://mongo:27017/productdb
MONGO_INITDB_ROOT_USERNAME=usuario
MONGO_INITDB_ROOT_PASSWORD=senha
PORT=3000
```

## Rotas
### Criar Produto

Cria um novo produto.

- **Endpoint**: `POST /products`
- **Corpo da Requisição (JSON)**:
  
  ```json
  {
    "name": "Frango",
    "price": 15,
    "descricao": "alimento"
  }


### Atualizar Produto

Atualiza um produto existente.

- **Endpoint**: `PATCH /products/:id`
- **Corpo da Requisição (JSON)**:

  ```json
  {
    "name": "Sabonete",
    "price": 2,
    "descricao": "alimento"
  }


### Deletar Produto

Deleta um produto existente.

- **Endpoint**: `DELETE /products/:id`

#### Exemplo de Requisição

```http
DELETE /products/656d1e92882b9a1dc3790954
```


### Listar Todos os Produtos

Retorna todos os produtos cadastrados.

- **Endpoint**: `GET /products`

#### Exemplo de Requisição

```http
GET /products
```

### Buscar Produtos por Palavra-Chave na Descrição

Retorna produtos cujas descrições contenham a palavra-chave especificada.

- **Endpoint**: `POST /products-by-keyword`
- **Corpo da Requisição (JSON)**:

  ```json
  {
    "keyword": "alimento"
  }


### Buscar Produtos com Preço Maior que o Valor Informado

Retorna produtos com preço acima do valor especificado.

- **Endpoint**: `POST /products-by-price`
- **Corpo da Requisição (JSON)**:

  ```json
  {
    "price": 1
  }