package com.fabiosmedeiros;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fabiosmedeiros.exception.SaldoInsuficienteException;
import com.fabiosmedeiros.model.*;

/**
 * Domínio/Problema
 * Um banco oferece aos seus clientes dois tipos de contas (corrente e poupança),
 * as quais possuem as funcionalidades de depósito, saque e transferência (entre
 * contas da própria instituição). 
 * Criado em : 05/02/2022
 * Alterado em : 06/02/2022 
 * @author fabiosmedeiros
 * @version 1.0
 */
public class BancoDigital1App {

	// Declarando um List<Pessoa>. Aqui teremos objetos do tipo ClientePessoaFisica e ClientePessoaJuridica.
	static List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	// Declarando um List<Conta>. Aqui teremos objetos do tipo ContaCorrente e ContaPoupanca.
	static List<Conta> contas = new ArrayList<Conta>();
	
	public static void main(String[] args) {
		// Instanciando um cliente do tipo pessoa física.
		ClientePessoaFisica cliente1 = new ClientePessoaFisica();
	
		// Invocando métodos.
		cliente1.setNome("Fabio S Medeiros");
		cliente1.setCpf("12332100109");
		cliente1.setDataRegistro(LocalDate.now());
		
		// Adicionandp o cliente na lista.
		pessoas.add(cliente1);
		
		// Instanciando outro cliente do tipo pessoa física.
		ClientePessoaFisica cliente2 = new ClientePessoaFisica();
		
		// Invocando métodos.
		cliente2.setNome("Ronaldo Bastos");
		cliente2.setCpf("98891265741");
		cliente2.setDataRegistro(LocalDate.now());
		
		// Adicionandp o cliente na lista.
		pessoas.add(cliente2);
		
		// Instanciando um cliente do tipo pessoa jurídica.
		ClientePessoaJuridica cliente3 = new ClientePessoaJuridica();
		
		// Invocando métodos.
		cliente3.setNome("Julia Brito");
		cliente3.setCnpj("012741000192");
		cliente3.setDataRegistro(LocalDate.now());
		
		// Adicionandp o cliente na lista.
		pessoas.add(cliente3);
				
		// Printando a lista de clientes (pessoa física e pessoa jurídica).
		System.out.println("***********Lista de Clientes****************");
		Pessoa.exibirDados(pessoas);
		System.out.println("********************************************");
		
		// Criando uma conta corrente.
		ContaCorrente contaCorrente1 = new ContaCorrente();
		
		// Setando um cliente.
		contaCorrente1.setPessoa(cliente1);
		
		// Realizando um depósito.
		contaCorrente1.depositar(100D);
		
		// Criando uma outra conta corrente.
		ContaCorrente contaCorrente2 = new ContaCorrente();
		
		// Setando um cliente.
		contaCorrente2.setPessoa(cliente2);
		
		// Realizando um depósito.
		contaCorrente2.depositar(180D);
		
		// Criando uma conta poupança.
		ContaPoupanca contaPoupanca1 = new ContaPoupanca();
		
		// Setando um cliente.
		contaPoupanca1.setPessoa(cliente3);
		
		// Realizando depósitos.
		contaPoupanca1.depositar(250D);
		contaPoupanca1.depositar(120D);
		
		// Realizando um saque em uma conta sem fundos. Exception!
		try {
			contaCorrente1.sacar(1200D);
		} catch (SaldoInsuficienteException e) {
			System.out.println("Transação não realizada. Cliente " + 
								contaPoupanca1.getPessoa().getNome() + " " + e.getMessage());			
		}
		
		// Realizando saque em uma conta do tipo conta corrente.
		contaCorrente1.sacar(100);
		
		// Tentando transferir um valor não disponível em conta. Exception!
		try {
			contaPoupanca1.transferir(contaCorrente1, 1000D);
		} catch (SaldoInsuficienteException e) {
			System.out.println("Transação não realizada. " + e.getMessage());
		}
				
		// Adicionandp as contas na lista de contas.		
		contas.add(contaCorrente1);
		contas.add(contaCorrente2);
		contas.add(contaPoupanca1);
		
		// Exibindo as contas, por meio de um método estático da classe Conta.
		Conta.exibirContas(contas);
	}

}
