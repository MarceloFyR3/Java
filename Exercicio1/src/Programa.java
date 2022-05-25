
public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String matricula = "111111";
		String nome = "Marcelo Drumand";
		String textoAprovado = "Aprovado ()Sim (x)Não";
		double nota1 = 7;
		double nota2 = 2;
		double notaFinal = (nota1 + nota2) / 2;
		
		if(notaFinal >= 6) {
			textoAprovado = "Aprovado ()Sim (x)Não";
		}
		
		System.out.println("Mat: " + matricula);		
		System.out.println("Nome: " +nome);
		System.out.println(textoAprovado);
		System.out.println("Nota Final: " + notaFinal);
	}

}
