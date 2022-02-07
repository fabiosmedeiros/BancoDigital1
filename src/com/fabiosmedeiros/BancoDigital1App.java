package com.fabiosmedeiros;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fabiosmedeiros.exception.SaldoInsuficienteException;
import com.fabiosmedeiros.model.*;

/**
 * Dom�nio/Problema
 * Um banco oferece aos seus clientes dois tipos de contas (corrente e poupan�a),
 * as quais possuem as funcionalidades de dep�sito, saque e transfer�ncia (entre
 * contas da pr�pria institui��o). 
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
		// Instanciando um cliente do tipo pessoa f�sica.
		ClientePessoaFisica cliente1 = new ClientePessoaFisica();
	
		// Invocando m�todos.
		cliente1.setNome("Fabio S Medeiros");
		cliente1.setCpf("12332100109");
		cliente1.setDataRegistro(LocalDate.now());
		
		// Adicionandp o cliente na lista.
		pessoas.add(cliente1);
		
		// Instanciando outro cliente do tipo pessoa f�sica.
		ClientePessoaFisica cliente2 = new ClientePessoaFisica();
		
		// Invocando m�todos.
		cliente2.setNome("Ronaldo Bastos");
		cliente2.setCpf("98891265741");
		cliente2.setDataRegistro(LocalDate.now());
		
		// Adicionandp o cliente na lista.
		pessoas.add(cliente2);
		
		// Instanciando um cliente do tipo pessoa jur�dica.
		ClientePessoaJuridica cliente3 = new ClientePessoaJuridica();
		
		// Invocando m�todos.
		cliente3.setNome("Julia Brito");
		cliente3.setCnpj("012741000192");
		cliente3.setDataRegistro(LocalDate.now());
		
		// Adicionandp o cliente na lista.
		pessoas.add(cliente3);
				
		// Printando a lista de clientes (pessoa f�sica e pessoa jur�dica).
		System.out.println("***********Lista de Clientes****************");
		Pessoa.exibirDados(pessoas);
		System.out.println("********************************************");
		
		// Criando uma conta corrente.
		ContaCorrente contaCorrente1 = new ContaCorrente();
		
		// Setando um cliente.
		contaCorrente1.setPessoa(cliente1);
		
		// Realizando um dep�sito.
		contaCorrente1.depositar(100D);
		
		// Criando uma outra conta corrente.
		ContaCorrente contaCorrente2 = new ContaCorrente();
		
		// Setando um cliente.
		contaCorrente2.setPessoa(cliente2);
		
		// Realizando um dep�sito.
		contaCorrente2.depositar(180D);
		
		// Criando uma conta poupan�a.
		ContaPoupanca contaPoupanca1 = new ContaPoupanca();
		
		// Setando um cliente.
		contaPoupanca1.setPessoa(cliente3);
		
		// Realizando dep�sitos.
		contaPoupanca1.depositar(250D);
		contaPoupanca1.depositar(120D);
		
		// Realizando um saque em uma conta sem fundos. Exception!
		try {
			contaCorrente1.sacar(1200D);
		} catch (SaldoInsuficienteException e) {
			System.out.println("Transa��o n�o realizada. Cliente " + 
								contaPoupanca1.getPessoa().getNome() + " " + e.getMessage());			
		}
		
		// Realizando saque em uma conta do tipo conta corrente.
		contaCorrente1.sacar(100);
		
		// Tentando transferir um valor n�o dispon�vel em conta. Exception!
		try {
			contaPoupanca1.transferir(contaCorrente1, 1000D);
		} catch (SaldoInsuficienteException e) {
			System.out.println("Transa��o n�o realizada. " + e.getMessage());
		}
				
		// Adicionandp as contas na lista de contas.		
		contas.add(contaCorrente1);
		contas.add(contaCorrente2);
		contas.add(contaPoupanca1);
		
		// Exibindo as contas, por meio de um m�todo est�tico da classe Conta.
		Conta.exibirContas(contas);
	}

}
