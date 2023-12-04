import { Product } from "../../../models/product";
import { MongoGetProductsByPriceRepository } from "../../../repositories/product/get-products-by-price/mong-get-products-by-price";
import { ok, serverError } from "../../helpers";
import { HttpRequest, HttpResponse, IController } from "../../protocols";
import { GetProductsByPriceParams } from "./protocols";

/**
 * Controller para Buscar Produtos acima de um valor
 * 
 * @author Greg
 * @version 1.0
 * @since 2023-12-03
 * 
 */
export class GetProductsByPriceController implements IController {
    constructor(private readonly getProductsByPriceRepository: MongoGetProductsByPriceRepository) {}
    

    /**
     * Método do handle para busca de produtos cadastrados no banco
     * acima de um valor específico
     * 
     * @param
     * @return Product[]
     * 
     */
    async handle(httpRequest: HttpRequest<GetProductsByPriceParams>): Promise<HttpResponse<Product[] | string>> {
        try {
            const products = await this.getProductsByPriceRepository.getProductsByPrice(
                httpRequest.body!,
            );
            return ok<Product[]>(products);
        } catch (error) {
            return serverError();
        }
    }    
}