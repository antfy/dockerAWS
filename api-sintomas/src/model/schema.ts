import mongoose from "mongoose";

interface Sintomas {
  especialidade: string;
  sintomaId: number;
  sintoma: string;
  parteCorpo: string;
  regiaoCorpo: string;
}

const sintomasSchema = new mongoose.Schema<Sintomas>({
  especialidade: String,
  sintomaId: String,
  sintoma: String,
  parteCorpo: String,
  regiaoCorpo: String,
});

export default mongoose.model("Sintomas", sintomasSchema);
