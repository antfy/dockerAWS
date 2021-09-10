interface ResultadoVerificacao {
  index: number;
  resultado: boolean;
}

interface Especialidade {
  especialidade: string;
  contador: number;
}

class Funcoes {
  verificaArray(
    especialidades: Array<Especialidade>,
    especialidade: string
  ): ResultadoVerificacao {
    for (let index = 0; index < especialidades.length; index++) {
      if (especialidade === especialidades[index].especialidade) {
        return { index, resultado: true };
      }
    }
    return {
      index: -1,
      resultado: false,
    };
  }
}

export default new Funcoes();
