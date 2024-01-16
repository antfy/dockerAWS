import { Request, Response } from "express";
import Medicos from "../model/MedicoSchema";


interface Sintomas {
  _id: string;
  especialidade: string;
  nome: string;
  crm: string;
}


class MedicosController {
  async findMedico(req: Request, res: Response) {

    const { especialidade } = req.params;
    const listasMedicos = await Medicos.find({
      "especialidade": especialidade
    })
    return res.json(listasMedicos);
  }
}
export default new MedicosController();
