package br.com.cicada.metadados.vo;

import br.com.cicada.metadados.enums.TipoDadoEnum;

public class TipoDado {

	private String nome;
	private TipoDadoEnum tipo;
	private Object valor;
	private boolean eOutroObjeto;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoDadoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoDadoEnum tipo) {
		this.tipo = tipo;
	}

	public Object getValor() {
		return valor;
	}

	public void setValor(Object valor) {
		this.valor = valor;
	}

	public boolean iseOutroObjeto() {
		return eOutroObjeto;
	}

	public void seteOutroObjeto(boolean eOutroObjeto) {
		this.eOutroObjeto = eOutroObjeto;
	}

}
