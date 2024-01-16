import { Router } from "express";
import SintomasController from "./controllers/sintomasController";
import MedicosController from "./controllers/medicoController";
import ConsultaController from "./controllers/consultaController";

const routes  =  Router();

routes.get("/", SintomasController.index);
routes.get("/filtro/:id", SintomasController.findSitomas);
routes.get("/medico/:especialidade", MedicosController.findMedico);

routes.get("/consulta/:id", ConsultaController.find);
routes.post("/consulta", ConsultaController.criar);

export default routes ;
