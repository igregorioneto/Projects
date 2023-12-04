import { GetProductsByKeywordParams, IGetProductsByKeywordRepository } from "../../../controllers/product/get-products-by-keyword/protocols";
import { MongoClient } from "../../../database/mongo";
import { Product } from "../../../models/product";
import { MongoProduct } from "../../mongo-protocols";
/**
 * Repositório dos Produtos que esta ligado ao mongoDB
 * Para retornar uma lista de produtos com base em um preço.
 * @author Greg
 * @version 1.0
 * @since 2023-12-03
 */
export class MongoGetProductsByKeywordRepository implements IGetProductsByKeywordRepository {
    /**
     * Este método faz chamada a todos os produtos cadastrados no mongo 
     * com base no valor do preço informado.
     * 
     * @param Preço
     * @version 1.0
     * @since 2023-12-03
     */
    async getProductsByKeyword(params: GetProductsByKeywordParams): Promise<Product[]> {
        const { keyword } = params;

        const products = await MongoClient.db
                .collection<MongoProduct>("products")
                .find({ descricao: { $regex: new RegExp(keyword, 'i') } })
                .toArray();

        return products.map(({ _id, ...rest }) => ({
            ...rest,
            id: _id.toHexString()
        }));
    }
}