package org.traveller.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.traveller.dao.CarroDAO;
import org.traveller.model.Carro;

@Path("/carros")
@Produces(MediaType.APPLICATION_JSON)
public class CarroEndPoint {
	
	CarroDAO dao = new CarroDAO();
	
	@GET
	public List<Carro> indexCarro() {
		
		return dao.getAllCarros();
	}
}
