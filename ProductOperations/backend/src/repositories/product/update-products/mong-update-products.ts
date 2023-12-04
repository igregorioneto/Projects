import { ObjectId } from "mongodb";
import { CreateProductParams, ICreateProductRepository } from "../../../controllers/product/create-product/protocols";
import { IGetProductsRepository } from "../../../controllers/product/get-products/protocols";
import { IUpdateUpdateRepository } from "../../../controllers/product/update-product/protocols";
import { MongoClient } from "../../../database/mongo";
import { Product } from "../../../models/product";
import { MongoProduct } from "../../mongo-protocols";

/**
 * Repositório dos Produtos que esta ligado ao mongoDB
 * Método responsável por realizar a atualização de um produto
 * 
 * @author Greg
 * @version 1.0
 * @since 2023-12-04
 */
export class MongoUpdateProductsRepository implements IUpdateUpdateRepository {
    
    
    /**
     * Método de atualização do produto no mongoDB
     * 
     * @param id do produto
     * @param parametros do produto para atualização
     * @return um produto atualizado.
     */
    async updateProduct(id: string, params: CreateProductParams): Promise<Product> {
        await MongoClient.db.collection("products").updateOne(
            { _id: new ObjectId(id) },
            { $set: { ...params, } }
        )

        const product = await MongoClient.db
            .collection<MongoProduct>("products")
            .findOne({ _id: new ObjectId(id) }); 

        if (!product) {
            throw new Error("Product not updated");
        }

        const { _id, ...rest } = product;

        return { id: _id.toHexString(), ...rest };    
    }
}