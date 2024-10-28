package br.com.fleetmanagement.entity;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.fleetmanagement.enuns.UsuarioEnuns;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tab_usuario")
public class Usuario implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuario;
    private String nom_usuario;
    private String sen_usuario;

    @Column(name = "email_usuario")
    private String email;

    private String cpf_usuario;
    private String rg_usuario;
    private String cep;
    private String cidade;
    private String bairro;

    @Enumerated(EnumType.STRING)
    private UsuarioEnuns role;

    public Usuario(String email, String sen_usuario, UsuarioEnuns role) {
        this.email = email;
        this.sen_usuario = sen_usuario;
        this.role = role;
    }

    public Usuario() {
    }

    public Usuario(Long idusuarioLong, String nom_usuario, String sen_usuario, String email, String cpf_usuario, String rg_usuario, String cep, String cidade, String bairro, UsuarioEnuns role) {
        this.idusuario = idusuarioLong;
        this.nom_usuario = nom_usuario;
        this.sen_usuario = sen_usuario;
        this.email = email;
        this.cpf_usuario = cpf_usuario;
        this.rg_usuario = rg_usuario;
        this.cep = cep;
        this.cidade = cidade;
        this.bairro = bairro;
        this.role = role;
    }

    // Override methods from UserDetails for Spring Security
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role.equals(UsuarioEnuns.ADMIN)) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public String getPassword() {
        return this.sen_usuario;
    }

    @Override
    public String getUsername() {
        return this.email;
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

    // Getters and Setters
    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getNom_usuario() {
        return nom_usuario;
    }

    public void setNom_usuario(String nom_usuario) {
        this.nom_usuario = nom_usuario;
    }

    public String getSen_usuario() {
        return sen_usuario;
    }

    public void setSen_usuario(String sen_usuario) {
        this.sen_usuario = sen_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf_usuario() {
        return cpf_usuario;
    }

    public void setCpf_usuario(String cpf_usuario) {
        this.cpf_usuario = cpf_usuario;
    }

    public String getRg_usuario() {
        return rg_usuario;
    }

    public void setRg_usuario(String rg_usuario) {
        this.rg_usuario = rg_usuario;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public UsuarioEnuns getRole() {
        return role;
    }

    public void setRole(UsuarioEnuns role) {
        this.role = role;
    }
}
