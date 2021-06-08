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

	public String login() {
		System.out.println("Inicializando login");
		
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		boolean exist = new UsuarioDao().exist(usuario);
		
		if(exist && usuario.getTipo() == "admin") {
			context.getExternalContext().getSessionMap().put("usuario", usuario);
			return "usuario?faces-redirect=true";
		}
		
		context.getExternalContext().getFlash().setKeepMessages(true);
		
		context.addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuário ou senha incorretos", ""));
			return "login?faces-redirect=true";
			
	}
	
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
