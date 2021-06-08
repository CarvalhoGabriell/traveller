package org.traveller.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Carro carro) {
		
		if (carro == null) {
			return Response
					.status(Response.Status.BAD_REQUEST)
					.build(); //400
		}
		try {
			dao.save(carro);
		} catch (Exception e) {
			
			return Response.status(
					Response.Status.INTERNAL_SERVER_ERROR)
					.entity(carro)
					.build(); //500
		}
		return Response.status(Response.Status.CREATED)
				.entity(carro)
				.build(); //201
	}
	
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") Long id, Carro carro) {
		
		carro = dao.findBy(id);
		if (carro == null) {
			
			return Response
					.status(Response.Status.NOT_FOUND)
					.build();
		}
		
		try {
			dao.delete(id);
		} catch (Exception e) {
			
			return Response.status(
					Response.Status.INTERNAL_SERVER_ERROR)
					.entity(carro)
					.build(); //500
		}
		
		return Response
				.status(Response.Status.OK)
				.entity(carro)
				.build();
		
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Long id,Carro carro) {
		if (carro == null) {
			return Response
					.status(Response.Status.BAD_REQUEST)
					.entity(carro)
					.build();
		}
		
		carro.setId(id);
		if (dao.findBy(id) == null) {
			return Response
					.status(Response.Status.NOT_FOUND)
					.build();
		}
		try {
			dao.update(carro);
		} catch (Exception e) {
			return Response.status(
					Response.Status.INTERNAL_SERVER_ERROR)
					.entity(carro)
					.build(); //500
		}

		return Response
				.status(Response.Status.OK)
				.entity(carro)
				.build();
	}
	
	@GET
	@Path("{id}")
	public Response showAll(@PathParam("id") Long id) {
		
		Carro carro = dao.findBy(id);
		if (carro == null) {
			
			return Response
					.status(Response.Status.NOT_FOUND)
					.build();
		}
		return Response
				.status(Response.Status.OK)
				.entity(carro)
				.build();
	}
}
