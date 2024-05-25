package br.com.cicada.metadados.vo;

import java.util.List;

public class Objeto {

	private List<TipoDado> atributos;
	private boolean eLista;
	private TipoDado tipoDadoLista;

	public List<TipoDado> getAtributos() {
		return atributos;
	}

	public void setAtributos(List<TipoDado> atributos) {
		this.atributos = atributos;
	}

	public boolean iseLista() {
		return eLista;
	}

	public void seteLista(boolean eLista) {
		this.eLista = eLista;
	}

	public TipoDado getTipoDadoLista() {
		return tipoDadoLista;
	}

	public void setTipoDadoLista(TipoDado tipoDadoLista) {
		this.tipoDadoLista = tipoDadoLista;
	}

}
