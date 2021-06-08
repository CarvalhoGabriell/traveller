package org.traveller.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.traveller.dao.CarroDAO;
import org.traveller.model.Carro;

@Named
@RequestScoped
public class CarroBean {
	
	Carro carro = new Carro();
	
	
	public CarroBean() {
		super();
	}

	public CarroBean(Carro carro) {
		super();
		this.carro = carro;
	}

	
	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public List<Carro> getCarros() {
		return new CarroDAO().getAllCarros();
	}
}
