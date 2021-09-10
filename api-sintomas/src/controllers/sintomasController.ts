import { Request, Response } from "express";
import Sintomas from "../model/schema";
import Funcoes from "../service/Util";

interface Sintomas {
  _id: string;
  especialidade: string;
  sintomaId: number;
  sintoma: string;
  parteCorpo: string;
  regiaoCorpo: string;
}
interface Especialidade {
  especialidade: string;
  contador: number;
}

class SintomasController {
  async index(req: Request, res: Response) {
    const listasSintomas = await Sintomas.find();
    return res.json(listasSintomas);
  }

  async findSitomas(req: Request, res: Response) {
    const especialidades = Array<Especialidade>();
    let especialidade: Especialidade = {
      especialidade: "",
      contador: 0,
    };

    const { id } = req.params;
    const sintomasRequest = id.split(",");
    // const sintomasRequest = 'teste' 

    const listasSintomas = await Sintomas.find({
      sintomaId: sintomasRequest,
    });

    listasSintomas.forEach((sintoma: any) => {
      const verificacao = Funcoes.verificaArray(
        especialidades,
        sintoma.especialidade
      );

      if (verificacao.resultado) {
        especialidades[verificacao.index].contador++;
      } else {
        especialidades.push({
          especialidade: sintoma.especialidade,
          contador: 1,
        });
      }
    });

    for (let index = 0; index < especialidades.length; index++) {
      if (especialidades[index].contador > especialidade.contador) {
        especialidade = especialidades[index];
      } else if (especialidades[index].contador === especialidade.contador) {
        especialidade = {
          especialidade: "Clinico geral",
          contador: especialidades[index].contador,
        };
      }
    }

    return res.json(especialidade);
  }
}
export default new SintomasController();
