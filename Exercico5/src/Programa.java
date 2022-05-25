import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		File arquivo = new File("C:\\ProgramFacul\\Java\\Exercico5\\src\\studants.csv");
		Scanner leitor = new Scanner(arquivo);
		
		leitor.nextLine();
		
		Studant[] studants = new Studant[4];
		int contador = 0;
		
		while (leitor.hasNext()) {
			String linha = leitor.nextLine();
			
			String[] dados = linha.split(";");
			
			Studant studant = new Studant();
			
			studant.Matricula = dados[0];
			studant.Nome = dados[1];
			studant.Nota1 = Double.parseDouble(dados[2]) ;
			studant.Nota2 = Double.parseDouble(dados[3]) ;
			studant.Nota3 = Double.parseDouble(dados[4]) ;
			
			studants[contador] = studant;
			
			contador++;
			
			//System.out.println(linha);
			
		}
		
		for (int i = 0; i < studants.length; i++) {
			Studant a = studants[i];
			System.out.println("Mat " +  a.Matricula);
			System.out.println("Nome: " +  a.Nome);
			System.out.println("Nota1: " +  a.Nota1);
			
			System.out.println();
			
		}
		
		leitor.close();

	}

}
