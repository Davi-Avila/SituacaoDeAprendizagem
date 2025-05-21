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
		for (int i = 0;i < 5;i++) {
			for (int j = 0;j < 4;j++) {
				soma += semana[j][i];
			}
			semana[6][i] = soma;
			soma = 0;
		}
		
		for (int i = 0; i < 5;i++) {
			semana[7][i] = semana[6][i] / dia;
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
