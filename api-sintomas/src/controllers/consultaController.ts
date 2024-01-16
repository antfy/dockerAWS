import { Request, Response } from "express";
import Consultas from "../model/ConsultasSchema";


interface Consultas {
  medicoID: string;
  pacienteID: string;
  status: string;
}


class ConsultasController {
  async criar(req: Request, res: Response) {

    const reque= req.body;

    const consulta = Consultas.create({
      medicoID: "123",
      pacienteID: "123",
      status: "agendada"
    })

    return res.json(consulta);
      
  }


  async find(req: Request, res: Response) {

    const { id } = req.params;
    const listasConsultas = await Consultas.find({
      "pacienteID": id
    })
    return res.json(listasConsultas);
  }
}
export default new ConsultasController();
