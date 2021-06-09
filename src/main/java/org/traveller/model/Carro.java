package org.traveller.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Carro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int ano;
	
	private String modelo;
	
	private String marca;
	
	private String cor;
	
	@Enumerated(EnumType.ORDINAL)
	private Tipo tipo;
	
	@Enumerated(EnumType.ORDINAL)
	private Combustivel tipoFuel;
	
	private int qtdLugares;
	
	
	@ManyToOne
	@JoinColumn(name = "user_aval")
	private Avaliacao aval;
	
	public Carro(int ano, String modelo, String marca, String cor, Tipo tipo, Combustivel tipoFuel, int qtdLugares) {
		super();
		this.ano = ano;
		this.modelo = modelo;
		this.marca = marca;
		this.cor = cor;
		this.tipo = tipo;
		this.tipoFuel = tipoFuel;
		this.qtdLugares = qtdLugares;
	}
	
	
	
	public Avaliacao getAval() {
		return aval;
	}


	public void setAval(Avaliacao aval) {
		this.aval = aval;
	}


	public Carro() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Combustivel getTipoFuel() {
		return tipoFuel;
	}

	public void setTipoFuel(Combustivel tipoFuel) {
		this.tipoFuel = tipoFuel;
	}

	public int getQtdLugares() {
		return qtdLugares;
	}

	public void setQtdLugares(int qtdLugares) {
		this.qtdLugares = qtdLugares;
	}
	
	
	
}
