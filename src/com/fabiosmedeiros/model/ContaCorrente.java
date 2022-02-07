package com.fabiosmedeiros.model;

public class ContaCorrente extends Conta {

	private static int SEQUENCIAL = 0;
	
	public ContaCorrente() {
		SEQUENCIAL++;
		this.numero = SEQUENCIAL;
	}
	
	@Override
	public String toString() {
		String mensagem = null;
		
		if (saldo == 0) {
			mensagem = "ZERADO";
		} 
		
		if (saldo < 0) {
			mensagem = "NEGATIVO" + this.getSaldo(); 
		}
		
		return "[ContaCorrente{numero=" + this.getNumero() + ",agencia:" + this.getAgencia() +
			   ",nome:" + this.getPessoa().getNome() + ",saldo:" + 
			   (mensagem != null ? mensagem : this.getSaldo()) +
			   ",dataRegistro:" + this.getDataRegistro() + ",dataAtualizacao:" + 
			   this.getDataAtualizacao() + "}]";
	}
	
}
