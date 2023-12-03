import { Router } from "express";
import { ProductController } from "../controllers/ProductController";

const router = Router();

router.get("/products/:name", ProductController.getProductByName);
router.get("/products", ProductController.getAllProducts);

export default router;