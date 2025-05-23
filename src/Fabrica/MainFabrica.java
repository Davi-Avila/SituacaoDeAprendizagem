package Fabrica;

import java.util.Scanner;

public class MainFabrica {
	public static void main(String[]args) {
		Scanner entrada = new Scanner(System.in);
		Operacoes operacao = new Operacoes();
		int opcaoMenu = 0;
		
		while (opcaoMenu != 5) {
			operacao.menu();
			opcaoMenu = entrada.nextInt();
			switch (opcaoMenu) {
			case 1:
				operacao.cadastrar();
				break;
			case 2:
				operacao.RegistrarProducao();
				break;
			case 3:
				operacao.relatorio();
				break;
			case 4:
				operacao.maquinas();
				break;
			default: 
				System.out.println("Opção invalida");
				break;
			}	
		}
		entrada.close();
	}
}
