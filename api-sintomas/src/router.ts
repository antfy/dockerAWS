import { Router } from "express";
import SintomasController from "./controllers/sintomasController";

const router = Router();

router.get("/", SintomasController.index);
router.get("/filtro/:id", SintomasController.findSitomas);

export default router;
