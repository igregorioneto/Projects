"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = require("express");
const ProductController_1 = require("../controllers/ProductController");
const router = (0, express_1.Router)();
router.get("/products/:name", ProductController_1.ProductController.getProductByName);
router.get("/products", ProductController_1.ProductController.getAllProducts);
exports.default = router;
