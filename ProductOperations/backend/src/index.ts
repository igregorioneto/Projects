import express  from "express";
import { config } from "dotenv";
import { MongoClient } from "./database/mongo";
import { MongoGetProductsRepository } from "./repositories/product/get-products/mong-get-products";
import { GetProductsController } from "./controllers/product/get-products/get-products";

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

    const port = process.env.PORT || 3000;

    app.listen(port, () => console.log(`listening on port ${port}!`));
};

main();

