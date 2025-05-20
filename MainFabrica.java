package Fabrica;

import java.util.Scanner;

public class MainFabrica {
	public static void main(String[]args) {
		Scanner entrada = new Scanner(System.in);
		Operacoes operacao = new Operacoes();
		operacao.menu();
		int opcao =  entrada.nextInt();
		
		while (opcao != 5) {
			operacao.menu();
			switch (opcao) {
			case 1:
				operacao.cadastrar();
				break;
			case 2:
				operacao.RegistrarProducao();
				break;
			case 3:
				operacao.relatorio();
				break;
			default: 
				System.out.println("Opção invalida");
				break;
			}	
		}
		entrada.close();
	}
}
