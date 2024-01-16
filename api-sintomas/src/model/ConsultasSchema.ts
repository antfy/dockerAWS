import mongoose from "mongoose";

interface Consultas {
  medicoID: string;
  pacienteID: string;
  status: string;
}

const ConsultasSchema = new mongoose.Schema<Consultas>({
  medicoID: String,
  pacienteID: String,
  status: String
});

export default mongoose.model("Consultas", ConsultasSchema);
