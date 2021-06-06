package org.traveller.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.traveller.dao.UsuarioDao;
import org.traveller.model.Usuario;



@Named
@RequestScoped
public class UsuarioBean {
	private Usuario usuario = new Usuario();

	
	public void save() {
		new UsuarioDao().save(this.usuario);
		
		System.out.println("Salvando" + this.usuario);
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("Usuario cadastrado com sucesso"));
	}
	
	public List<Usuario> getUsuarios(){
		return new UsuarioDao().getAll();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
