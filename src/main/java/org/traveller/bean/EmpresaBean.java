package org.traveller.bean;



import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.traveller.dao.EmpresaDao;
import org.traveller.model.Empresa;


@Named
@RequestScoped
public class EmpresaBean {
	 Empresa empresa = new Empresa();

	public EmpresaBean(Empresa empresa) {
		super();
		this.empresa = empresa;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
}
