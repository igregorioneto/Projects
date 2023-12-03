import { Product } from "../../../models/product";

export interface CreateProductParams {
    name: string;
    price: number;
}

export interface ICreateProductRepository {
    createProduct(params: CreateProductParams): Promise<Product>;
}