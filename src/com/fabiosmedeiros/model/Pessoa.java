package com.fabiosmedeiros.model;

import java.time.LocalDate;
import java.util.List;

public abstract class Pessoa {
	
	private String nome;
	private LocalDate dataRegistro;
	private LocalDate dataAtualizacao;
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public LocalDate getDataRegistro() {
		return this.dataRegistro;
	}
	
	public void setDataRegistro(LocalDate dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	
	public LocalDate getDataAtualizacao() {
		return this.dataAtualizacao;
	}
	
	public void setDataAtualizacao(LocalDate dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
	public void listaPessoas(List<Pessoa> pessoas) {
		for(Pessoa pessoa: pessoas) {
			System.out.println(pessoa);
		}
	}
	
	// Exibindo dados de pessoas do tipo física e jurídica.
	public static void exibirDados(List<Pessoa> pessoas) {
		for(Pessoa umaPessoa: pessoas) {
			System.out.println(umaPessoa);
		}
	}
	
}
