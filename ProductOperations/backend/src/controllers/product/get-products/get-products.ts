import { Product } from "../../../models/product";
import { ok, serverError } from "../../helpers";
import { HttpResponse, IController } from "../../protocols";
import { IGetProductsRepository } from "./protocols";

/**
 * Controller para Buscar Produtos
 * 
 * @author Greg
 * @version 1.0
 * @since 2023-12-03
 * 
 */
export class GetProductsController implements IController {
    constructor(private readonly getProductsRepository: IGetProductsRepository) {}
    

    /**
     * Método do handle para busca de produtos cadastrados no banco
     * 
     * @param
     * @return Product[]
     * 
     */
    async handle(): Promise<HttpResponse<Product[] | string>> {
        try {
            const products = await this.getProductsRepository.getProducts();
            return ok<Product[]>(products);
        } catch (error) {
            return serverError();
        }
    }    
}