# Use a imagem oficial do MongoDB
FROM mongo:latest
# Porta padrão
EXPOSE 27017
# Autenticação do mongo
ENV MONGO_INITDB_ROOT_USERNAME=admin
ENV MONGO_INITDB_ROOT_PASSWORD=admin

# Diretorio de armazenamento
RUN mkdir -p /data/db

# Inicializando o Mongo ao inicializar o container
CMD [ "mongod" ]