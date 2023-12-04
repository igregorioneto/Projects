import { Product } from "../../../models/product";

export interface GetProductsByPriceParams {
    price: number;
}

export interface IGetProductsByPriceRepository {
    getProductsByPrice(params: GetProductsByPriceParams): Promise<Product[]>;
}