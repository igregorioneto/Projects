import { Product } from "../../../models/product";
import { ok, serverError } from "../../helpers";
import { HttpResponse, IController } from "../../protocols";
import { IGetProductsRepository } from "./protocols";


export class GetProductsController implements IController {
    constructor(private readonly getProductsRepository: IGetProductsRepository) {}
    
    async handle(): Promise<HttpResponse<Product[] | string>> {
        try {
            const products = await this.getProductsRepository.getProducts();
            return ok<Product[]>(products);
        } catch (error) {
            return serverError();
        }
    }    
}