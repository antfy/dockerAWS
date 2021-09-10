package br.com.fiap.antfy.antfy_backend.services;

import br.com.fiap.antfy.antfy_backend.Enum.StatusConsulta;
import br.com.fiap.antfy.antfy_backend.Model.ConsultaModel;
import br.com.fiap.antfy.antfy_backend.Model.DTO.*;
import br.com.fiap.antfy.antfy_backend.Model.MedicoModel;
import br.com.fiap.antfy.antfy_backend.Model.PacienteModel;
import br.com.fiap.antfy.antfy_backend.Repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.*;

@Service
public class ConsultaService {

    @Autowired
    private WebClient webClient;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private ConsultaRepository repository;

    public List<SintomasApiDTO> buscarSintomas() {
        Mono<SintomasApiDTO[]> monoSintomas = webClient.method(HttpMethod.GET).uri("/")
                .retrieve().bodyToMono(SintomasApiDTO[].class);
        SintomasApiDTO[] listaSintomas = monoSintomas.block();
        return List.of(listaSintomas);
    }


    public RetornoCriaConsultaDTO criarConsulta(CriaConsultaDTO criaConsultaDTO) {
        Mono<SintomaFiltoDTO> monoSintomaFintro = webClient.method(HttpMethod.GET).uri("/filtro/{listaID}", criaConsultaDTO.getListaSintomaId())
                .retrieve().bodyToMono(SintomaFiltoDTO.class);

        var paciente = pacienteService.buscarUm(criaConsultaDTO.getPacenteID());
        var consulta = new ConsultaModel(new Date(), StatusConsulta.CONSULTA_CRIADA.getCode(), paciente);

        repository.save(consulta);

        SintomaFiltoDTO SintomaFilto = monoSintomaFintro.block();

        var listaMedico = medicoService.buscarPorEspecialidade(SintomaFilto.getEspecialidade());

        return new RetornoCriaConsultaDTO(consulta, listaMedico);

    }

    public ConsultaModel confirmarConsulta(ConfirmaConsultaDTO confirmaConsultaDTO) {
        var consulta = repository.getOne(confirmaConsultaDTO.getConsultaID());
        MedicoModel medico = medicoService.buscarUm(confirmaConsultaDTO.getMedicoID());

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, 5);

        consulta.setDataAgendada(cal.getTime());
        consulta.setStatus(StatusConsulta.CONSULTA_AGENDADA.getCode());
        consulta.setMedico(medico);

        return repository.save(consulta);
    }

    public ConsultaModel finalizarConsulta(Integer id) {
        var consulta = repository.getOne(id);

        consulta.setDataFim(new Date());
        consulta.setStatus(StatusConsulta.CONSULTA_ATENDIDA.getCode());

        return repository.save(consulta);
    }

    public void cancelarConsulta(Integer id) {
        var consulta = repository.getOne(id);
        consulta.setStatus(StatusConsulta.CONSULTA_CANCELADA.getCode());
        repository.save(consulta);
    }

    public List<ConsultaModel> buscarConsulta(String email) {
        MedicoModel medico = medicoService.findByEmail(email);
        PacienteModel paciente = pacienteService.findByEmail(email);

        if (medico == null && paciente == null) {
            throw new UsernameNotFoundException(email);
        }
        List<ConsultaModel> listaDeConsultas = new ArrayList<>();

        if (medico == null) {
            listaDeConsultas = repository.findByPaciente(paciente);
        } else {
            listaDeConsultas = repository.findByMedico(medico);
        }

        return listaDeConsultas;
    }
}
