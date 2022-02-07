package com.fabiosmedeiros.model;

public class ClientePessoaJuridica extends Pessoa {
	
	private String cnpj;
	
	public String getCnpj() {
		return this.cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	@Override
	public String toString() {
		return "[Cliente{nome:" + this.getNome() + ",cnpj:" + this.getCnpj() +
			   ",dataRegistro:" + this.getDataRegistro() + ",dataAtualizacao:" + 
			   this.getDataAtualizacao() + "}]";
	}
	
}
