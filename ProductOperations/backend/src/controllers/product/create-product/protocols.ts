import { Product } from "../../../models/product";

export interface CreateProductParams {
    name: string;
    price: number;
    descricao: string;
}

export interface ICreateProductRepository {
    createProduct(params: CreateProductParams): Promise<Product>;
}