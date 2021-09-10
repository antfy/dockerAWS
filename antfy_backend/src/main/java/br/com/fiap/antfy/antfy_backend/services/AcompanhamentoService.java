package br.com.fiap.antfy.antfy_backend.services;

import br.com.fiap.antfy.antfy_backend.Model.AcompanhamentoModel;
import br.com.fiap.antfy.antfy_backend.Model.DTO.CadastraAcompanhamentoDTO;
import br.com.fiap.antfy.antfy_backend.Repository.AcompanhamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Service
public class AcompanhamentoService implements Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    AcompanhamentoRepository repository;

    @Autowired
    PacienteService pacienteService;


    public List<AcompanhamentoModel> buscarPorPaciente(Integer id) {
        List<AcompanhamentoModel> model = repository.findByPaciente(pacienteService.buscarUm(id));
        return model;
    }

    public AcompanhamentoModel cadrastrarAcompanhamento(CadastraAcompanhamentoDTO acompanhamentoDTO) {

        if (acompanhamentoDTO.getAltura() == null || acompanhamentoDTO.getPeso() == null) {
            var acompanhamentos = buscarPorPaciente(acompanhamentoDTO.getPaciente());
            if (acompanhamentos.size() != 0) {
                acompanhamentoDTO.setAltura(acompanhamentoDTO.getAltura() == null ? acompanhamentos.get(acompanhamentos.size() - 1).getAltura() : acompanhamentoDTO.getAltura());
                acompanhamentoDTO.setPeso(acompanhamentoDTO.getPeso() == null ? acompanhamentos.get(acompanhamentos.size() - 1).getPeso() : acompanhamentoDTO.getPeso());
            }
        }
        var acompanhamento = new AcompanhamentoModel(null, acompanhamentoDTO.getPeso(),
                acompanhamentoDTO.getAltura(), acompanhamentoDTO.getTemperatura(),
                acompanhamentoDTO.getPrecao(), acompanhamentoDTO.getBatimento(),
                new Date(), pacienteService.buscarUm(acompanhamentoDTO.getPaciente()));

        return repository.save(acompanhamento);
    }
}
