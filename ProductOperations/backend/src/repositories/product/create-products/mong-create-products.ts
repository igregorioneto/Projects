import { CreateProductParams, ICreateProductRepository } from "../../../controllers/product/create-product/protocols";
import { IGetProductsRepository } from "../../../controllers/product/get-products/protocols";
import { MongoClient } from "../../../database/mongo";
import { Product } from "../../../models/product";
import { MongoProduct } from "../../mongo-protocols";

/**
 * Repositório dos Produtos que esta ligado ao mongoDB
 * Método responsável por criar um Produto no MongoDB
 * 
 * @param
 * @return Product[]
 */
export class MongoCreateProductsRepository implements ICreateProductRepository {
    async createProduct(params: CreateProductParams): Promise<Product> {
        const { insertedId } = await MongoClient.db
            .collection("products")
            .insertOne(params);

        const product = await MongoClient.db
            .collection<MongoProduct>("products")
            .findOne({ _id: insertedId }); 

        if (!product) {
            throw new Error("Product not created");
        }

        const { _id, ...rest } = product;

        return { id: _id.toHexString(), ...rest };    
    }
}