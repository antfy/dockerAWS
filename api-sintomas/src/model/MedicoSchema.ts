import mongoose from "mongoose";

interface Medico {
  especialidade: string;
  crm: number;
  nome: string;

}

const medicoSchema = new mongoose.Schema<Medico>({
  especialidade: String,
  nome: String,
  crm: String,
});

export default mongoose.model("Medicos", medicoSchema);
