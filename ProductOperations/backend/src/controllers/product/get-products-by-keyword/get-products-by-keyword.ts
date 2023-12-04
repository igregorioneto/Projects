import { Product } from "../../../models/product";
import { MongoGetProductsByKeywordRepository } from "../../../repositories/product/get-products-by-keyword/mongo-get-products-by-keyword";
import { ok, serverError } from "../../helpers";
import { HttpRequest, HttpResponse, IController } from "../../protocols";
import { GetProductsByKeywordParams, IGetProductsByKeywordRepository } from "./protocols";

/**
 * Controller para Buscar Produtos com base na descrição
 * 
 * @author Greg
 * @version 1.0
 * @since 2023-12-04
 * 
 */
export class GetProductsByKeywordController implements IController {
    constructor(private readonly getProductsByKeywordRepository: IGetProductsByKeywordRepository) {}
    

    /**
     * Método do handle para busca de produtos cadastrados no banco
     * com base na descricao como uma palavra chave
     * 
     * @param
     * @return Product[]
     * 
     */
    async handle(httpRequest: HttpRequest<GetProductsByKeywordParams>): Promise<HttpResponse<Product[] | string>> {
        try {
            const products = await this.getProductsByKeywordRepository.getProductsByKeyword(
                httpRequest.body!
            );
            return ok<Product[]>(products);
        } catch (error) {
            return serverError();
        }
    }    
}