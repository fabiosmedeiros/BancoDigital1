package com.fabiosmedeiros.model;

import java.time.LocalDate;
import java.util.List;

import com.fabiosmedeiros.exception.SaldoInsuficienteException;

public abstract class Conta {
	
	private static final int AGENCIA_PADRAO= 1;
	protected int numero;
	protected Pessoa pessoa;
	protected double saldo;
	protected LocalDate dataRegistro;
	protected LocalDate dataAtualizacao;
		
	public Conta() {
		this.dataRegistro = LocalDate.now();
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getAgencia() {
		return AGENCIA_PADRAO;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public LocalDate getDataRegistro() {
		return dataRegistro;
	}
	
	public void setDataRegistro(LocalDate dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	
	public LocalDate getDataAtualizacao() {
		return dataAtualizacao;
	}
	
	public void setDataAtualizacao(LocalDate dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
	public void sacar(double valor) {
		this.saldo -= valor;
	}
	
	public void depositar(double valor) {
		this.saldo += valor;
	}
	
	public void transferir(Conta contaDestino, double valor) {
		if (valor > this.getSaldo()) {
			throw new SaldoInsuficienteException
				("Saldo insuficiente. Cliente " + 
				  this.getPessoa().getNome() + ", Conta " + this.getNumero() +
				  ", Saldo " + this.getSaldo());
		}
		sacar(valor);
		contaDestino.depositar(valor);
	}
	
	// Exibindo dados das Contas.
	public static void exibirContas(List<Conta> contas) {
		for(Conta umaConta: contas) {
			System.out.println(umaConta);
		}
	}
	
}
