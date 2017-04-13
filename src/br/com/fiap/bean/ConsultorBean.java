package br.com.fiap.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.entity.Consultor;
import br.com.fiap.exception.WebServiceException;
import br.com.fiap.repository.ConsultorRepository;

@ManagedBean
public class ConsultorBean {
	private Consultor consultor;
	private ConsultorRepository rep;

	//metodo de inicializacao do bean
	@PostConstruct
	private void init(){
		consultor = new Consultor();
		rep = new ConsultorRepository();
	}
	
	public void cadastrar() {
		FacesMessage msg;
		rep = new ConsultorRepository();
		try {
			rep.cadastrar(consultor);
			msg = new FacesMessage("Cadastro Realizado");
		} catch (WebServiceException e) {
			// TODO Auto-generated catch block
			msg =new FacesMessage("ERRO" + e.getMessage());
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Consultor getConsultor() {
		return consultor;
	}

	public void setConsultor(Consultor consultor) {
		this.consultor = consultor;
	}

}
