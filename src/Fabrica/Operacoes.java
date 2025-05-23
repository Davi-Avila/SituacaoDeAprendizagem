package Fabrica;
import java.util.*;
public class Operacoes {
	List <Integer> maquinas = new ArrayList <>();
	List <String> setores = new ArrayList <>();
	int semana[][] = new int[8][6];
	int semana2[][] = new int[8][6];
	int dia = 0;
	int maquina = 1;
	
	Scanner entrada = new Scanner(System.in);
	public void menu() {
		System.out.println("---MENU---");
		System.out.println("1 - Cadastrar máquina");
		System.out.println("2 - Registrar produção do dia");
		System.out.println("3 - Visualizar relatório semanal");
		System.out.println("4 - Visualizar maquinas");
		System.out.println("5 - Encerrar sistema");
	}
	
	public void maquinas() {
		System.out.println("Máquinas: ");
		System.out.println(maquinas);
		System.out.println(setores);
	}
	
	public void cadastrar() {
		int opcao = 0;
		System.out.println("Digite o setor da máquina " + maquina + "(limite de 6 máquinas)\n1- Algodão\n2- Poliéster\n3- Mistos");
		opcao = entrada.nextInt();
		switch (opcao) {
		case 1:
			setores.add("algodao");
			break;
		case 2:
			setores.add("poliester");
			break;
		case 3:
			setores.add("mistos");
			break;
		default:
			System.out.println("Você não digitou um setor válido, tente novamente.");
			return;
		}
		System.out.println("Máquina registrada com sucesso!");
		maquinas.add(maquina);
		maquina ++;
		
	}
	
	public void RegistrarProducao() {
		dia++;
		for(int i = 0;i < maquinas.size();i++) {
			System.out.println("Digite a produção da máquina " + maquinas.get(i) + ": ");
			semana[dia][i] = entrada.nextInt();
		}
	}
	
	public void relatorio() {
				//Faz a soma da produção de cada dia da semana
		int soma = 0;
		int media = 0;
		for (int i = 0;i < 5;i++) {
			for (int j = 0;j < 4;j++) {
				soma += semana[j][i];
				if(semana[j][i] > 0) {
					media++;
				}
			}
			semana[6][i] = soma;
			if (media > 0) {
			semana[7][i] = semana[6][i] / media;
			}
			soma = 0;
			media = 0;
		}
		
		
		
		
		System.out.println("Relatório da semana por máquinas:\nLinha 1:Máquinas\nLinhas2-6: Dias da semana"
							+ "\nLinha 7: Soma da produção\n" + "Linha 8: Média produzida por cada máquina ");
		for (int i = 0;i < maquinas.size();i++) {
			System.out.print(maquinas.get(i) + "       ");
		}
		
		for (int i = 0;i < semana.length;i++) {
			for(int j = 0;j < semana[i].length;j++) {
			System.out.print(semana[i][j] + "	");
			}
			System.out.println();
		}
		
		int somaA = 0; int somaP = 0; int somaM = 0;
		int mediaA = 0; int mediaP = 0; int mediaM = 0;
		
		for (int i = 0;i < setores.size();i++) {
			switch (setores.get(i)) {
			case "algodao":
				somaA += semana[6][i];
				mediaA++;
				break;
			case "poliester":
				somaP += semana[6][i];
				mediaP++;
				break;
			case "mistos":
				somaM += semana[6][i];
				mediaM++;
				break;
			}	
		}
		if(mediaA == 0) {
			mediaA = somaA;
		}else {
		mediaA = somaA / mediaA;
		}
		
		if(mediaP == 0) {
			mediaP = somaP;
		}else {
		mediaP = somaP / mediaP;;
		}
		
		if(mediaM == 0) {
			mediaM = somaM;
		}else {
		mediaM = somaP / mediaP;
		}
		
		int opcao = 0;
		while (opcao != 4) {
			System.out.println("Digite qual setor deseja ver a produção total e sua média"
							+ "(1- Algodão, 2- Poliéster, 3- Mistos, 4- Sair: ");
			opcao = entrada.nextInt();
			switch(opcao) {
			case 1:
				System.out.println("Produção total do setor de algodão: " + somaA);
				System.out.println("Média da produção: " + mediaA);
				break;
			case 2:
				System.out.println("Produção total do setor de algodão: " + somaP);
				System.out.println("Média da produção: " + mediaP);
				break;
			case 3:
				System.out.println("Produção total do setor de algodão: " + somaM);
				System.out.println("Média da produção: " + mediaM);
				break;
			case 4:
				break;
			}
		}
		
		
		
		
		
		if (semana2[0][0] != 0) {
			System.out.println("Relatório da semana anterior: ");
			System.out.println(dia);
			for (int i = 0;i < 3;i++) {
				for(int j = 0;j < 6;j++) {
					System.out.print(semana2[i][j]);
					}
					System.out.println();
				}
		}
		semana2 = semana.clone();
		
	}

}
