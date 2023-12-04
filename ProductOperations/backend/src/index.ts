import express  from "express";
import { config } from "dotenv";
import { MongoClient } from "./database/mongo";
import { MongoGetProductsRepository } from "./repositories/product/get-products/mong-get-products";
import { GetProductsController } from "./controllers/product/get-products/get-products";
import { MongoCreateProductsRepository } from "./repositories/product/create-products/mong-create-products";
import { CreateProductController } from "./controllers/product/create-product/create-product";
import { MongoGetProductsByPriceRepository } from "./repositories/product/get-products-by-price/mong-get-products-by-price";
import { GetProductsByPriceController } from "./controllers/product/get-products-by-price/get-products-by-price";


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

    const port = process.env.PORT || 3000;

    app.listen(port, () => console.log(`listening on port ${port}!`));
};

main();

