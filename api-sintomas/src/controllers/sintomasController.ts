import { Request, Response } from "express";
import Sintomas from "../model/SintomasSchema";
import Medicos from "../model/MedicoSchema";
import Funcoes from "../service/Util";

interface Sintomas {
  _id: string;
  especialidade: string;
  sintomaId: string;
  sintoma: string;
  parteCorpo: string;
  regiaoCorpo: string;
}
interface Especialidade {
  especialidade: string;
  contador: number;
}

interface Sintoma {

  sintoma: string;
  sintomaId: string;
}

class SintomasController {
  async index(req: Request, res: Response) {

    const sintomas = Array<Sintoma>();
    const setSintomas = new Set();
    const listasSintomas = await Sintomas.find();

    listasSintomas.forEach((s: Sintoma) =>{
      sintomas.push({
        sintoma: s.sintoma,
        sintomaId: s.sintomaId
      })
    })

    const sintomasFiltrados = sintomas.filter((s: Sintoma) =>{
      const duplicatedPerson = setSintomas.has(s.sintomaId);
      setSintomas.add(s.sintomaId);
      return !duplicatedPerson;
    })

    return res.json(sintomasFiltrados);
  }

  async findSitomas(req: Request, res: Response) {
    const especialidades = Array<Especialidade>();
    let especialidade: Especialidade = {
      especialidade: "",
      contador: 0,
    };

    const { id } = req.params;
    const sintomasRequest = id.split(",");

    const listasSintomas = await Sintomas.find({
      "sintomaId":{ $in: sintomasRequest },
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

    const listasMedicos = await Medicos.find({
      "especialidade": especialidade.especialidade
    })

    const retorno = {
      especialidade,
      listasMedicos
    }

    return res.json(retorno);
  }
}
export default new SintomasController();
