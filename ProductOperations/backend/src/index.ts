import express  from "express";
import { config } from "dotenv";
import { MongoClient } from "./database/mongo";

const main = async ()=> {
    config();

    const app = express();

    app.use(express.json());

    await MongoClient.connect();

    app.get("/", async (req, res) => {
        console.log("Hello World!");
    })

    const port = process.env.PORT || 3000;

    app.listen(port, () => console.log(`listening on port ${port}!`));
};

main();

