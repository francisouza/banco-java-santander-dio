import java.util.Scanner;

import com.bancodigital.models.*;
import com.bancodigital.services.*;

public class Main {



	public static void main(String[] args) {
		boolean ligado = true;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite seu nome: ");
	    String nomeCliente = scanner.nextLine();
		Cliente cliente = new Cliente();
		cliente.setNome(nomeCliente);
		System.out.println("Deseja entrar em sua:\n1- Conta corrente\n2- Conta pupança");
		int tipoConta = scanner.nextInt();
		Conta contaCorrente = new ContaCorrente(cliente);
		Conta contaPoupanca = new ContaPoupanca(cliente);
		
		while(ligado) {
			if (tipoConta == 1) {
				System.out.println("Seja bem vindo à sua conta corrente, " + nomeCliente);
				System.out.println("Selecione o número do serviço que desejar: ");
				System.out.println("1- Depositar\n2- Sacar\n3- Transferir\n4- Exibir extrato\n");
				int opcao = scanner.nextInt();
				switch (opcao) {
				case 1: {
					System.out.println("Qual valor deseja depositar?");
				    double valor = scanner.nextDouble();
				    contaCorrente.depositar(valor);
				    System.out.println("Você realizou um depósito de R$" + valor);
				    break;
				}
				
				case 2: {
					System.out.println("Qual valor deseja sacar?");
					double valor = scanner.nextDouble();
					contaCorrente.sacar(valor);
					break;
				}
				
				case 3: {
					System.out.println("Digite a quantia que deseja transferir:\n");
				    double valor = scanner.nextDouble();
				    System.out.println("Para qual conta deseja transferir:");
				    System.out.println("1- Conta corrente\n2- Conta poupança");
					int tipoContaLoop = scanner.nextInt();
				    if (tipoContaLoop == 1) {
				    	System.out.println("Não pode transferir quantias de uma conta para a mesma conta!");
				    } else if (tipoContaLoop == 2) {
				    	contaCorrente.transferir(valor, contaPoupanca);
					}
					break;
				}
				
				case 4: {
					contaCorrente.imprimirExtrato();
					break;
				}
				default:
					throw new IllegalArgumentException("Você digitou um número inválido: " + opcao);
				}
				
			} else if (tipoConta == 2) {
				System.out.println("Seja bem vindo à sua conta poupança, " + nomeCliente);
				System.out.println("Selecione o número do serviço que desejar: ");
				System.out.println("1- Depositar\n2- Sacar\n3- Transferir\n4- Exibir extrato\n");
				int opcao = scanner.nextInt();
				switch (opcao) {
				case 1: {
					System.out.println("Qual valor deseja depositar?");
				    double valor = scanner.nextDouble();
				    contaPoupanca.depositar(valor);
				    System.out.println("Você realizou um depósito de R$" + valor);
				    break;
				}
				
				case 2: {
					System.out.println("Qual valor deseja sacar?");
					double valor = scanner.nextDouble();
					contaPoupanca.sacar(valor);
					break;
				}
				
				case 3: {
					System.out.println("Digite a quantia que deseja transferir:\n");
				    double valor = scanner.nextDouble();
				    System.out.println("Para qual conta deseja transferir:");
				    System.out.println("1- Conta corrente\n2- Conta poupança");
					int tipoContaLoop = scanner.nextInt();
				    if (tipoContaLoop == 1) {
				    	contaPoupanca.transferir(valor, contaCorrente);
				    } else if (tipoContaLoop == 2) {
				    	System.out.println("Não pode transferir quantias de uma conta para a mesma conta!");
					}
					break;
				}
				
				case 4: {
					contaPoupanca.imprimirExtrato();
					break;
				}
				default:
					throw new IllegalArgumentException("Você digitou um número inválido: " + opcao);
				}
			}
		}
		
	
	}


}