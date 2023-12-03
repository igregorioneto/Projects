import { IGetProductsRepository } from "../../../controllers/product/get-products/protocols";
import { MongoClient } from "../../../database/mongo";
import { Product } from "../../../models/product";
import { MongoProduct } from "../../mongo-protocols";

/**
 * Repositório dos Produtos que esta ligado ao mongo DB
 * Este método faz chamada a todos os produtos cadastrados no mongo e retorna
 * com o tratamento do id.
 * 
 * @param
 * @return Product[]
 */
export class MongoGetProductsRepository implements IGetProductsRepository {
    async getProducts(): Promise<Product[]> {
        const products = await MongoClient.db
                .collection<MongoProduct>("products")
                .find({})
                .toArray();

        return products.map(({ _id, ...rest }) => ({
            ...rest,
            id: _id.toHexString()
        }));
    }
}