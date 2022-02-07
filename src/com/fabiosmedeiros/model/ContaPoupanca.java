package com.fabiosmedeiros.model;

public class ContaPoupanca extends Conta {

	private static int SEQUENCIAL = 99999;
	
	public ContaPoupanca() {
		SEQUENCIAL = SEQUENCIAL + 5;
		this.numero = SEQUENCIAL;
	}
	
	@Override
	public String toString() {
		return "[ContaPoupanca{numero=" + this.getNumero() + ",agencia:" + this.getAgencia() +
			   ",nome:" + this.getPessoa().getNome() + ",saldo:" + this.getSaldo() +
			   ",dataRegistro:" + this.getDataRegistro() + ",dataAtualizacao:" + 
			   this.getDataAtualizacao() + "}]";
	}
	
}
