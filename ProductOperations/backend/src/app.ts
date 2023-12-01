const express = require('express');
const mongoose = require('mongoose');

// Para poder utilizar o dotenv
require('dotenv').config();

const app = express();
const PORT = process.env.PORT || 3000;

// Middleware para análise da requisição
app.use(express.json());

// Conectando ao MongoDB utilizando o Mongoose
const MONGODB_URI = process.env.MONGODB_URI || 'mongodb://localhost:27017/productdb';
mongoose.connect(MONGODB_URI, {
    user: process.env.MONGO_INITDB_ROOT_USERNAME,
    pass: process.env.MONGO_INITDB_ROOT_PASSWORD,
    authSource: 'admin',
    dbName: 'productdb',
});

// Rotas
app.get('/', (req, res) => {
    res.send('Hello World!');
});

// Iniciando o servidor
app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
});

