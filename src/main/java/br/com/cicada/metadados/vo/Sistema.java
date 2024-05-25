package br.com.cicada.metadados.vo;

import br.com.cicada.metadados.enums.TipoTecnologiaEnum;

public class Sistema {

	private String nome;
	private TipoTecnologiaEnum tecnologia;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoTecnologiaEnum getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(TipoTecnologiaEnum tecnologia) {
		this.tecnologia = tecnologia;
	}

}
