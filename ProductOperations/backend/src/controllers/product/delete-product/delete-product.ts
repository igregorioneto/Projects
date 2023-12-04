import { Product } from "../../../models/product";
import { badRequest, ok, serverError } from "../../helpers";
import { HttpRequest, HttpResponse, IController } from "../../protocols";
import { IDeleteProductRepository } from "./protocols";

/**
 * Controller para Deletar Produto
 * 
 * @author Greg
 * @version 1.0
 * @since 2023-12-04
 * 
 */
export class DeleteProductController implements IController {
    constructor(private readonly deleteProductRepository: IDeleteProductRepository) {}
    
    /**
     * Método do handle para deletar produto pelo id
     * 
     * @param id do produto
     * @return Product
     * 
     */
    async handle(httpRequest: HttpRequest<any>): Promise<HttpResponse<Product | string>> {
        try {
            const id = httpRequest?.params?.id;

            if (!id) {
                return badRequest("Missing id");
            }

            const product = await this.deleteProductRepository.deleteProduct(id);
            return ok<Product>(product);
        } catch (error) {
            return serverError();
        }
    }    
}