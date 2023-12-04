import { Product } from "../../../models/product";

export interface UpdateProductParams {
    name?: string;
    price?: number;
    descricao?: string;
}

export interface IUpdateUpdateRepository {
    updateProduct(id: string, params: UpdateProductParams): Promise<Product>;
}