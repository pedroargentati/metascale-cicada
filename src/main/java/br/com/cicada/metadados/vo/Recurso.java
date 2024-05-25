package br.com.cicada.metadados.vo;

import br.com.cicada.metadados.enums.MetodoEnum;

public class Recurso {

	private String recurso;
	private MetodoEnum metodo;

	public String getRecurso() {
		return recurso;
	}

	public void setRecurso(String recurso) {
		this.recurso = recurso;
	}

	public MetodoEnum getMetodo() {
		return metodo;
	}

	public void setMetodo(MetodoEnum metodo) {
		this.metodo = metodo;
	}

}
