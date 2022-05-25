import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {

		String nome = "";
		String matricula = "";
		double[] notas = new double[5];
		
		Scanner capturar = new Scanner(System.in);
		
		System.out.println("Informe a matricula do Aluno ");
		matricula = capturar.nextLine();
		
		System.out.println("Informe a nome do Aluno ");
		nome = capturar.nextLine();
		
		int contador = 0;
		double notaFinal = 0;
		
		do {			
			System.out.println("Digite a "+ (contador + 1) +"a nota: ");
			double temp = capturar.nextDouble();
			
			if(temp >= 0 && temp <= 10) {
				notas[contador] = temp;
				contador++;
			} else {
				System.out.println("A nota " + temp + " é inválida!");
			}
		} while(contador < 5);
		
		System.out.println("");
		System.out.println("==== Relatório ====");
		System.out.println("Aluno: " + nome);
		System.out.println("Matricula: " + matricula);
		
		for (int i = 0; i < notas.length; i++)
			System.out.println("Nota " + (i + 1) + ": " + notas[i]);
			
	}
}
