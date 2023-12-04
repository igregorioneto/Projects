import { ObjectId } from "mongodb";
import { IDeleteProductRepository } from "../../../controllers/product/delete-product/protocols";
import { IGetProductsRepository } from "../../../controllers/product/get-products/protocols";
import { MongoClient } from "../../../database/mongo";
import { Product } from "../../../models/product";
import { MongoProduct } from "../../mongo-protocols";

/**
 * Repositório dos Produtos que esta ligado ao mongo DB
 * Referente a deletar produto do mongo
 * 
 * @author Greg
 * @version 1.0
 * @since 2023-12-04
 */
export class MongoDeleteProductRepository implements IDeleteProductRepository {

    /**
     * Método para deletar produto no MongoDB
     * 
     * @param
     * @return Product[]
     */
    async deleteProduct(id: string): Promise<Product> {
        const product = await MongoClient.db
                .collection<MongoProduct>("products")
                .findOne({ _id: new ObjectId(id) });

        if (!product) {
            throw new Error("Product not found!");
        }

        const { deletedCount } = await MongoClient.db
                .collection("products")
                .deleteOne({ _id: new ObjectId(id) });

        if (!deletedCount) {
            throw new Error("Product not deleted!");
        }

        const { _id, ...rest } = product;
        return { id: _id.toHexString(), ...rest };
    }
}