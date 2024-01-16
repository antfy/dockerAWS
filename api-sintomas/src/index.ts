import express from "express";
import mongoose from "mongoose";
import router from "./router";

const port = 3333;
const app = express();

mongoose.connect("mongodb://localhost:27017/api-sintomas", {
  useNewUrlParser: true,
  useFindAndModify: true,
  useUnifiedTopology: true,
});

app.use(router);
app.use(express.json);

app.listen(port, () => {
  console.log(`O servidor esta rodando na porta ${port}`);
});
