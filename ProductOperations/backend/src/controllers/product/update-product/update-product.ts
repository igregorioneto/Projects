import { Product } from "../../../models/product";
import { badRequest, ok, serverError } from "../../helpers";
import { HttpRequest, HttpResponse, IController } from "../../protocols";
import { IUpdateUpdateRepository, UpdateProductParams } from "./protocols";


/**
 * Controller para atualizar produto
 * 
 * @author Greg
 * @version 1.0
 * @since 2023-12-04
 * 
 */
export class UpdateProductController implements IController {
    constructor(private readonly updateProductRepository: IUpdateUpdateRepository) {}
    

    /**
     * Método do handle para cadastrar produto no banco
     * 
     * @param HttpRequest do tipo UpdatedProductParams
     * @return Produto cadastrado
     * 
     */
    async handle(httpRequest: HttpRequest<UpdateProductParams>): Promise<HttpResponse<Product | string>> {
        try {
            const id = httpRequest?.params?.id;
            const body = httpRequest?.body;

            if (!body) {
                return badRequest("Missing fields!");
            }

            if (!id) {
                return badRequest("Missing id!");
            }

            const fields: (keyof UpdateProductParams)[] = [
                "name",
                "price",
                "descricao"
            ];

            const fieldsIsNotAllowed = Object.keys(body).some(
                (key) => !fields.includes(key as keyof UpdateProductParams)
            );


            if (fieldsIsNotAllowed) {
                return badRequest("Fields is not allowed!");
            }

            const product = await this.updateProductRepository.updateProduct(
                id,
                body,
            );

            return ok<Product>(product);
        } catch (error) {
            return serverError();
        }
    }    
}