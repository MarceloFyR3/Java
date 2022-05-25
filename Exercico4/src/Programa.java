import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nome = "";
		String matricula = "";
		double[] notas = new double[5];
		double[] pesos = new double[5];
		
		pesos[0] = 0.05;
		pesos[1] = 0.05;
		pesos[2] = 0.2;
		pesos[3] = 0.2;
		pesos[4] = 0.5;
		
		Scanner capturar = new Scanner(System.in);
		
		System.out.println("Informe a matricula do Aluno ");
		matricula = capturar.nextLine();
		
		System.out.println("Informe a nome do Aluno ");
		nome = capturar.nextLine();
		
		int contador = 0;
		double notaFinal = 0;
		String textoResultado = "Aprovado ()Sim (x)Não";
		
		do {			
			System.out.println("Digite a "+ (contador + 1) +"a nota: ");
			double temp = capturar.nextDouble();
			
			if(temp >= 0 && temp <= 10) {
				notas[contador] = temp;
				notaFinal = notaFinal + (temp * pesos[contador]);
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
		
		if(notaFinal >= 6)
			textoResultado = "Aprovado (x)Sim ()Não";
		
		System.out.println("Nota Final " + notaFinal);
		System.out.println(textoResultado);
	}

}
