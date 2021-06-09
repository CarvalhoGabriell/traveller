package org.traveller.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.traveller.dao.AvaliarDAO;
import org.traveller.model.Avaliacao;
import org.traveller.model.Usuario;


public class AvaliacaoBean {
	
	Avaliacao aval = new Avaliacao();

	public Avaliacao getAval() {
		return aval;
	}

	public void setAval(Avaliacao aval) {
		this.aval = aval;
	}

	public AvaliacaoBean(Avaliacao aval) {
		super();
		this.aval = aval;
	}

	public AvaliacaoBean() {
		super();
	}
	
	public void saveAvaliacao() {
		FacesContext context = FacesContext.getCurrentInstance();
		Usuario user = (Usuario) context.getExternalContext().getSessionMap().get("user");
		aval.setUser(user);
		new AvaliarDAO().save(aval);
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("Avaliação realizada com sucesso. Obrigado pelo feedback!"));
	}
	
	public List<Avaliacao> getAllcomments() {
		
		return new AvaliarDAO().showAll();
	}
	
	public List<Avaliacao> getAllOne() {
		FacesContext context = FacesContext.getCurrentInstance();
		Usuario user = (Usuario) context.getExternalContext().getSessionMap().get("user");
		return new AvaliarDAO().showOneComent(user);
	}
}
