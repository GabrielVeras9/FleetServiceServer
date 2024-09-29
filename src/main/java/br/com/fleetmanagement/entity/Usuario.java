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
@Table(name = "tab_usuario")//, schema = "fleet_homol")
public class Usuario implements UserDetails{
	
	/**
	 * 
	 */
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
	private UsuarioEnuns Role;
	
	public Usuario(String email, String sen_usuario,UsuarioEnuns role) {
		this.email = email;
		this.sen_usuario = sen_usuario;
		this.Role = role;
	}
	
	public Usuario () {	
	}

	public Usuario(Long idusuarioLong, String nom_usuario, String sen_usuario, String email,
			String cpf_usuario, String rg_usuario, String cep, String cidade, String bairro, UsuarioEnuns Role) {
		this.idusuario = idusuarioLong;
		this.nom_usuario = nom_usuario;
		this.sen_usuario = sen_usuario;
		this.email = email;
		this.cpf_usuario = cpf_usuario;
		this.rg_usuario = rg_usuario;
		this.cep = cep;
		this.cidade = cidade;
		this.bairro = bairro;
		this.Role = Role;
	}
	//This is Override security//
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	    if (this.Role.equals(UsuarioEnuns.ADMIN)) {
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
    
    //Terminate the implementation in Override//

	public Long getIdusuarioLong() {
		return idusuario;
	}

	public void setIdusuarioLong(Long idusuarioLong) {
		this.idusuario = idusuarioLong;
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

	public String getemail() {
		return email;
	}

	public void setemail(String email_usuario) {
		this.email = email_usuario;
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
		return Role;
	}

	public void setRole(UsuarioEnuns role) {
		Role = role;
	}
}
