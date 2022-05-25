import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] nomes = new String[5];
		String[] matriculas = new String[5];
		double[] notas1 = new double[5];
		
		
		double[] notas2 = new double[5];
		double[] notasFinais = new double[5];

		String textoResultado = "Aprovado ()Sim (x)Não";
		
		Scanner capturar = new Scanner(System.in);
		
		for(int i = 0; i < 4; i++) {
			System.out.println("Informe a matricula do Aluno " + (i + 1));
			matriculas[i] = capturar.nextLine();
			
			System.out.println("Informe a nome do Aluno " + (i + 1));
			nomes[i] = capturar.nextLine();
			
			System.out.println("Informe a Nota 1 do Aluno " + (i + 1));
			notas1[i] = capturar.nextDouble();
			
			System.out.println("Informe a Nota 2 do Aluno " + (i + 1));
			notas2[i] = capturar.nextDouble();
			capturar.nextLine();
			System.out.println("");
		}
		
		for(int i = 0; i < 5; i++) {
			
			notasFinais[i] = (notas1[1] + notas2[2]) / 2;
			
			if(notasFinais[i] >= 6) {
				textoResultado = "Aprovado ()Sim (x)Não";
			}
			
			System.out.println("Mat: " + matriculas[i]);		
			System.out.println("Nome: " + nomes[i]);
			System.out.println(textoResultado);
			System.out.println("Nota Final: " + notasFinais[i]);
			System.out.println("");
			System.out.println("--------------------------------");
		}

		capturar.close();
	}

}
