package br.com.dio.banco_dio;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);

	}

	@Override
	public void extrato() {
		System.out.println("Extrato Conta Poupança");
		super.imprimirInfosComuns();

	}

}
