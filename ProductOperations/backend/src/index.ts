import express  from "express";
import { config } from "dotenv";
import { MongoClient } from "./database/mongo";
import { MongoGetProductsRepository } from "./repositories/product/get-products/mong-get-products";
import { GetProductsController } from "./controllers/product/get-products/get-products";
import { MongoCreateProductsRepository } from "./repositories/product/create-products/mong-create-products";
import { CreateProductController } from "./controllers/product/create-product/create-product";
import { MongoGetProductsByPriceRepository } from "./repositories/product/get-products-by-price/mong-get-products-by-price";
import { GetProductsByPriceController } from "./controllers/product/get-products-by-price/get-products-by-price";
import { MongoGetProductsByKeywordRepository } from "./repositories/product/get-products-by-keyword/mongo-get-products-by-keyword";
import { GetProductsByKeywordController } from "./controllers/product/get-products-by-keyword/get-products-by-keyword";
import { MongoUpdateProductsRepository } from "./repositories/product/update-products/mong-update-products";
import { UpdateProductController } from "./controllers/product/update-product/update-product";
import { MongoDeleteProductRepository } from "./repositories/product/delete-product/mong-delete-product";
import { DeleteProductController } from "./controllers/product/delete-product/delete-product";


/**
 * Configuração das rotas que estão sendo utilizadas com base no Pattern SOLID
 * 
 */
const main = async ()=> {
    config();

    const app = express();

    app.use(express.json());

    await MongoClient.connect();

    app.get("/", async (req, res) => {
        console.log("Hello World!");
    });

    app.get("/products", async (req, res) => {
        const mongoGetProductsRepository = new MongoGetProductsRepository();
        const getProductController = new GetProductsController(mongoGetProductsRepository);
        const { status, body } = await getProductController.handle();
        res.status(status).send(body);
    });

    app.post("/products", async (req, res) => {
        const mongoCreateProductsRepository = new MongoCreateProductsRepository();
        const createProductController = new CreateProductController(mongoCreateProductsRepository);
        const { status, body } = await createProductController.handle({
            body: req.body,
        });

        res.status(status).send(body);
    });

    app.post("/products-by-price", async (req, res) => {
        const mongoGetProductsByPriceRepository = new MongoGetProductsByPriceRepository();
        const getProductByPriceController = new GetProductsByPriceController(mongoGetProductsByPriceRepository);
        const { status, body } = await getProductByPriceController.handle({
            body: req.body
        });
        res.status(status).send(body);
    });

    app.post("/products-by-keyword", async (req, res) => {
        const mongoGetProductsByKeywordRepository = new MongoGetProductsByKeywordRepository();
        const getProductByKeywordController = new GetProductsByKeywordController(mongoGetProductsByKeywordRepository);
        const { status, body } = await getProductByKeywordController.handle({
            body: req.body
        });
        res.status(status).send(body);
    });

    app.patch("/products/:id", async (req, res) => {
        const mongoUpdateProductsRepository = new MongoUpdateProductsRepository();
        const updateProductController = new UpdateProductController(mongoUpdateProductsRepository);
        const { status, body } = await updateProductController.handle({
            body: req.body,
            params: req.params,
        });

        res.status(status).send(body);
    });

    app.delete("/products/:id", async (req, res) => {
        const mongoUpdateProductsRepository = new MongoDeleteProductRepository();
        const udeleteProductController = new DeleteProductController(mongoUpdateProductsRepository);
        const { status, body } = await udeleteProductController.handle({
            params: req.params,
        });

        res.status(status).send(body);
    });

    const port = process.env.PORT || 3000;

    app.listen(port, () => console.log(`listening on port ${port}!`));
};

main();

