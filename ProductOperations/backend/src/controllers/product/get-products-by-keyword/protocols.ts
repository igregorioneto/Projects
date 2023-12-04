import { Product } from "../../../models/product";

export interface GetProductsByKeywordParams {
    keyword: string;
}

export interface IGetProductsByKeywordRepository {
    getProductsByKeyword(params: GetProductsByKeywordParams): Promise<Product[]>;
}