package br.com.fiap.antfy.antfy_backend.services;


import br.com.fiap.antfy.antfy_backend.Enum.PerfilUser;
import br.com.fiap.antfy.antfy_backend.Model.MedicoModel;
import br.com.fiap.antfy.antfy_backend.Model.PacienteModel;
import br.com.fiap.antfy.antfy_backend.Repository.MedicoRepository;
import br.com.fiap.antfy.antfy_backend.Repository.PacienteRepository;
import br.com.fiap.antfy.antfy_backend.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        MedicoModel medico = medicoRepository.findByEmail(email);
        PacienteModel paciente = pacienteRepository.findByEmail(email);

        if (medico == null && paciente == null) {
            throw new UsernameNotFoundException(email);
        }
        UserSS userSS;
        Set<PerfilUser> perfis = new HashSet<>();

        if (medico == null) {

            perfis.add(PerfilUser.PACIENTE);
            userSS = new UserSS(paciente.getIdPaciente(), paciente.getEmail(), paciente.getSenha(), perfis);

        } else {
            perfis.add(PerfilUser.MEDICO);
            userSS = new UserSS(medico.getIdMedico(), medico.getEmail(), medico.getSenha(),perfis);
        }
        return userSS;
    }

}
