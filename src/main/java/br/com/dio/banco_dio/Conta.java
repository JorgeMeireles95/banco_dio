package br.com.dio.banco_dio;

import lombok.Getter;

import lombok.Setter;

@Getter
@Setter

public abstract class Conta implements IConta {
	private static final int AGENCIA_PADRAO = 0001;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		if (saldo >= valor) { // Valida se o valor sacado está disponível na conta
			System.out.println("Saque liberado");
			saldo -= valor;
			System.out.printf(" Saldo atual R$: %.2f", saldo);
			System.out.printf(" \n Valor do saque R$: %.2f", valor);

			System.out.println();

		} else {
			System.out.println();
			System.out.println("Valor do saque é maior do que o saldo");
			System.out.println();
		}

	}

	@Override
	public void depositar(double valor) {
		saldo += valor;

	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);

	}

	protected void imprimirInfosComuns() {
		System.out.println();
		System.out.println(String.format("Titular %s", this.cliente.toString()));
		System.out.println(String.format("Agencia %d", this.agencia));
		System.out.println(String.format("Conta %d", this.numero));
		System.out.println(String.format("Saldo R$: %.2f", this.saldo));
		System.out.println();
	}

	@SuppressWarnings("resource")
	public void operacao() {

		// Instância criada para testar o metodo tranferir
		Cliente cliente0 = new Cliente();
		cliente0.setNome("Kamila");
		Conta cc0 = new ContaCorrente(cliente0);
		cc0.depositar(100);

		System.out.println();
		System.out.println("DESEJA REALIZAR ALGUMA OPERAÇÃO? (S/N)");
		String acaoConta = (new java.util.Scanner(System.in)).next();

		if (acaoConta.equalsIgnoreCase("s")) {

			boolean op = false;

			while (!op) {
				System.out.println("|------------OPERAÇÕES------- ");
				System.out.println("| 04 - TRANSFERIR             ");
				System.out.println("| 03 - DEPOSITAR              ");
				System.out.println("| 02 - SAQUE     			  ");
				System.out.println("| 01 - SALDO    		      ");
				System.out.println("| 00 - CANCELAR  			  ");
				System.out.println("| ----------------------------");
				int operacao = (new java.util.Scanner(System.in)).nextInt();
				switch (operacao) {
				case 0:
					op = true;
					System.out.println("FINALIZADO");
					break;
				case 1:
					extrato();
					break;
				case 2:
					System.out.println();
					System.out.println("DIGITE O VALOR QUE DESEJA SACAR ");
					double valorsaque = (new java.util.Scanner(System.in)).nextDouble();
					sacar(valorsaque);
					System.out.println();
					break;

				case 3:
					System.out.println();
					System.out.println("DIGITE O VALOR QUE DESEJA DEPOSITAR");
					double valorDeposito = (new java.util.Scanner(System.in)).nextDouble();
					depositar(valorDeposito);
					System.out.println();
					break;
				case 4:
					System.out.println();
					System.out.println("DIGITE O VALOR QUE QUER TRANSFERIR");
					double valorTransferir = (new java.util.Scanner(System.in)).nextDouble();
					System.out.println("DIGITE A CONTA");
					transferir(valorTransferir, cc0);
					System.out.println();
					break;
				default:
					System.out.println("VALOR INVÁLIDO");
				}
			}

		} else {
			System.out.println("FINALIZADO");
		}
	}

}
