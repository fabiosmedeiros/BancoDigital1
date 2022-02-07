package com.fabiosmedeiros.model;

public class ClientePessoaFisica extends Pessoa {

	private String cpf;
	
	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return "[Cliente{nome:" + this.getNome() + ",cpf:" + this.getCpf() +
			   ",dataRegistro:" + this.getDataRegistro() + ",dataAtualizacao:" + 
				this.getDataAtualizacao() + "}]";
	}
	
}
