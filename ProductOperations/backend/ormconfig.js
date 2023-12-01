module.exports = {
    type: 'mongodb',
    url: process.env.MONGODB_URI || 'mongodb://localhost:27017/testdb',
    useNewUrlParser: true,
    useUnifiedTopology: true,
    synchronize: true,
    logging: true,
    entities: ['src/models/*.ts'],
    migrations: ['src/migrations/*.ts'],
    subscribers: ['src/subscribers/*.ts'],
};