import { Product } from "../../../models/product";
import { badRequest, created, serverError } from "../../helpers";
import { HttpRequest, HttpResponse, IController } from "../../protocols";
import { CreateProductParams, ICreateProductRepository } from "./protocols";


/**
 * Controller para Criar Produto
 * 
 * @author Greg
 * @version 1.0
 * @since 2023-12-03
 * 
 */
export class CreateProductController implements IController {
    constructor(private readonly createProductRepository: ICreateProductRepository) {}
    

    /**
     * Método do handle para cadastrar produto no banco
     * 
     * @param HttpRequest do tipo CreateProductParams
     * @return Produto cadastrado
     * 
     */
    async handle(httpRequest: HttpRequest<CreateProductParams>): Promise<HttpResponse<Product | string>> {
        try {
            const requiredFields = ["name", "price"];

            for (const field of requiredFields) {
                if (!httpRequest?.body?.[field as keyof CreateProductParams]?.toString().length) {
                    return badRequest(`Field ${field} is required!`);
                }                
            }

            const product = await this.createProductRepository.createProduct(
                httpRequest.body!,
            );

            return created<Product>(product);
        } catch (error) {
            return serverError();
        }
    }    
}