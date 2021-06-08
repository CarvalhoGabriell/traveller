package org.traveller.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	private String email;
	private String senha;
	private String nome;
	private String tipo;
	
	@Temporal(TemporalType.DATE)
	private Calendar dtNascimento = Calendar.getInstance();

	//Construtores

	public Usuario() {super();}
	
	public Usuario(int idUsuario, String email, String senha, String nome, Calendar dtNascimento, String  tipo) {
		super();
		this.idUsuario = idUsuario;
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.tipo = tipo;
	}

	
	public Usuario(String email, String senha, String nome, Calendar dtNascimento, String tipo) {
		super();
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.tipo = tipo;
	}


	//Getters and Setters
	
	public String getNome() {
		return nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

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

	public Calendar getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Calendar dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	
	
}
