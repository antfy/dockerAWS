package br.com.fiap.antfy.antfy_backend.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.fiap.antfy.antfy_backend.Enum.PerfilUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserSS implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> autorizacao;

    public UserSS(Integer id, String username, String password, Set<PerfilUser> perfis) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.autorizacao = perfis.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao()))
                .collect(Collectors.toList());
    }

    public Integer getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return autorizacao;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
