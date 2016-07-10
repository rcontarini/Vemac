package br.com.vemac.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.vemac.model.GenericModel;

@Entity
public class Usuario extends GenericModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1269479718137506137L;
	@Column
	private String nome;
	@Column
	private String email;
	@Column
	private String senha;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
