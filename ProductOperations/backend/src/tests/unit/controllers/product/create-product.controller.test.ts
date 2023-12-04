import { describe, it } from "node:test";
import {expect, jest, test} from '@jest/globals';
import { CreateProductParams, ICreateProductRepository } from "../../../../controllers/product/create-product/protocols";
import { Product } from "../../../../models/product";
import { CreateProductController } from "../../../../controllers/product/create-product/create-product";
import { HttpRequest } from "../../../../controllers/protocols";
import { badRequest } from "../../../../controllers/helpers";


class CreateProductsRepositoryMock implements ICreateProductRepository {
    async createProduct(params: CreateProductParams): Promise<Product> {
        return {
            id: 'mockedId',
            name: params.name,
            price: params.price,
            descricao: params.descricao
        };
    }
    
}

describe('CreateProductController', () => {
    it('should return 400 if required field is missing', async () => {
        const createProductRepositoryMock = new CreateProductsRepositoryMock();
        const createProductController = new CreateProductController(createProductRepositoryMock);

        const httpRequest: HttpRequest<CreateProductParams> = {
            body: { price: 20 },
        };

        const httpResponse = await createProductController.handle(httpRequest);
        expect(httpResponse).toEqual(badRequest('Field name is required!'));

    });
})