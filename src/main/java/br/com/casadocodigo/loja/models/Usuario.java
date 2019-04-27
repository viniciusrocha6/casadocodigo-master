package br.com.casadocodigo.loja.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	private String senha;

	private String nome;

	@Transient
	private String senhaConfere;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Usuario_Role", joinColumns = @JoinColumn(name = "email"), inverseJoinColumns = @JoinColumn(name = "role_nome"))
	private List<Role> roles = new ArrayList<>();

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}

	@Override
	public String getPassword() {
		return this.senha;
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

	public String getSenhaConfere() {
		return senhaConfere;
	}

	public void setSenhaConfere(String senhaConfere) {
		this.senhaConfere = senhaConfere;
	}

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", senha=" + senha + ", nome=" + nome + ", senhaConfere=" + senhaConfere
				+ "]";
	}

}
