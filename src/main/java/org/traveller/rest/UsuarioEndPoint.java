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

import org.traveller.dao.UsuarioDao;
import org.traveller.model.Usuario;



@Path("usuarioT")
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioEndPoint {

	UsuarioDao dao = new UsuarioDao();
	
	//Listar todos os usuários
	@GET
	public List<Usuario> index(){
		return dao.getAll();
	}
	
	//Criar novo usuário
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Usuario usuario) {
		if(usuario == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}try {
			dao.save(usuario);
		}catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		return Response.status(Response.Status.CREATED).entity(usuario).build();
	}
	
	
	//Procurar usuário pelo ID
	@GET
	@Path("{id}")
	public Response show(@PathParam("id") int id) {
		Usuario usuario = dao.findById(id);
		
		if(usuario == null) {
			return Response.status(Response.Status.NOT_FOUND).build();	
		}
		return Response.status(Response.Status.OK).entity(usuario).build();
	}
	
	//Atualizar um novo usuário
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, Usuario usuario) {
		if(usuario == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
		usuario.setIdUsuario(id);

		try {
			dao.update(usuario);
		}catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(usuario).build();
		}
		return Response.status(Response.Status.OK).entity(usuario).build();
	}
	//Deletar um usuário
	@DELETE
	@Path("{id}")
	public Response deleteUser(@PathParam("id") int id,Usuario user) {
		user = dao.findById(id);
		if (user == null) {
			
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		try {
			dao.delete(id);
		} catch (Exception e) {
			
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(user).build(); 
		}
		
		return Response.status(Response.Status.OK).entity(user).build();
		
	}
	
	
}
