package br.com.dio.banco_dio;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Início do sistema
		System.out.println(">>>>>>>>>>>  BANCO DIO <<<<<<<<<<<");
		System.out.println();

		System.out.println(" DIGITE SEU NOME :  ");
		String nomeCliente = sc.nextLine();
		Cliente cliente1 = new Cliente();
		cliente1.setNome(nomeCliente);
	
		

		
		if(cliente1 != null) { //valida o objeto 
			System.out.println();
			System.out.println(" -----------------------------------");
			System.out.println("| 01 -  CONTA CORRENTE             |");
			System.out.println("| 02 -  CONTA POUPANÇA             | ");
			System.out.println(" -----------------------------------");
			int opcao = sc.nextInt();

			System.out.println();

			switch (opcao) {

			case 1:
				Conta cp = new ContaPoupanca(cliente1);
				System.out.println("CONTA POUPANÇA CRIADA COM SUCESSO!!! ,Sr(a):" +
				nomeCliente + ".");

				cp.operacao();
				break;
			case 2:
				Conta cc = new ContaCorrente(cliente1);
				System.out.println("CONTA CORRENTE CRIADA COM SUCESSO!!! Sr(a):" +
				 nomeCliente + ".");
				cc.operacao();

			}
		}
		sc.close();

	}
}
