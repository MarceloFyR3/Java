package Service;

import java.util.Scanner;

public class EscolhaOpcao {
	
	public static int escolheOpcaoPossuiCadastro() {
	    int opcao;
	    boolean erro = true;
	    var scanner = new Scanner(System.in);
	    
	    do {
	      try {
	    	System.out.println("** VOÇÊ JÁ POSSUI CADASTRO? **");
	    	System.out.println("( 1 ) - SIM");
	    	System.out.println("( 2 ) - NÃO");
	    	System.out.println("( 0 ) - Sair do Programa a qualquer momento");
	        System.out.printf("Digite uma opcão: ");
	        opcao = Integer.parseInt(scanner.nextLine());
	        
	        if(opcao == 0) {
	          System.out.println("\nO programa será finalizado");
	          erro = false;
	        }
	        if(opcao < 3 && opcao > 0) {
	          erro = false;
	        }
	        if(opcao > 2) {
	          System.out.println("Escolha um número entre 0 e 2\n");
	        }
	      }
	      catch(NumberFormatException e) {
	    	  System.out.println("Escolha um número entre 0 e 2\n");
	    	  opcao = 0;
	      }
	    } while (erro);
	    return opcao;
	}
	
	public static int escolheOpcaoCadastro() {
		System.out.println("\n");
	    int opcao;
	    boolean erro = true;
	    Scanner sc = new Scanner(System.in);
	    
	    do {
	      try {
	    	System.out.println("** DESEJA CADASTRAR? **");
	    	System.out.println("( 1 ) - SIM");
	    	System.out.println("( 2 ) - NÃO");
	        System.out.println("( 0 ) - Sair do Programa a qualquer momento");
	        System.out.printf("Digite uma opcão: ");
	        opcao = Integer.parseInt(sc.nextLine());
	        
	        if(opcao == 0) {
	          System.out.println("\nO programa será finalizado");
	          erro = false;
	        }
	        if(opcao < 3 && opcao > 0) {
	          erro = false;
	        }
	        if(opcao > 2) {
	          System.out.println("Escolha um número entre 0 e 2\n");
	        }
	      }
	      catch(NumberFormatException e) {
	    	  System.out.println("Escolha um número entre 0 e 2\n");
	    	  opcao = 0;
	      }
	    } while (erro);
	    return opcao;
	}
	
	public static int escolheOpcaoCadastroNaoEncontrado() {
		System.out.println("\n");
	    int opcao;
	    boolean erro = true;
	    Scanner sc = new Scanner(System.in);
	    
	    do {
	      try {
	    	System.out.println("** PROPRIETARIO NÃO ENCONTRADO? **");
	    	System.out.println("( 1 ) - TENTAR NOVAMENTE");
	    	System.out.println("( 2 ) - VOLTAR MENU PRINCIPAL");
	        System.out.println("( 0 ) - Sair do Programa a qualquer momento");
	        System.out.printf("Digite uma opcão: ");
	        opcao = Integer.parseInt(sc.nextLine());
	        
	        if(opcao == 0) {
	          System.out.println("\nO programa será finalizado");
	          erro = false;
	        }
	        if(opcao < 3 && opcao > 0) {
	          erro = false;
	        }
	        if(opcao > 2) {
	          System.out.println("Escolha um número entre 0 e 2\n");
	        }
	      }
	      catch(NumberFormatException e) {
	    	  System.out.println("Escolha um número entre 0 e 2\n");
	    	  opcao = 0;
	      }
	    } while (erro);
	    return opcao;
	}

	public static int escolheOpcaoProprietario() {
		System.out.println("\n");
	    int opcao;
	    boolean erro = true;
	    
	    do {
	      try (Scanner sc = new Scanner(System.in)){
	    	System.out.println("** O QUE PRECISA? **");
	    	System.out.println("( 1 ) - AGENDAR SERVICO");
	    	System.out.println("( 2 ) - VER PETS");
	        System.out.println("( 0 ) - Sair do Programa a qualquer momento");
	        System.out.printf("Digite uma opcão: ");
	        opcao = Integer.parseInt(sc.nextLine());
	        
	        if(opcao == 0) {
	          System.out.println("\nO programa será finalizado");
	          erro = false;
	        }
	        if(opcao < 3 && opcao > 0) {
	          erro = false;
	        }
	        if(opcao > 2) {
	          System.out.println("Escolha um número entre 0 e 2\n");
	        }
	      }
	      catch(NumberFormatException e) {
	    	  System.out.println("Escolha um número entre 0 e 2\n");
	    	  opcao = 0;
	      } 
	      catch (Exception e) {
	    	  System.out.println("\n** Erro SCANNER **\n" + e.getMessage());
	    	  opcao = 0;
	      }
	    } while (erro);
	    return opcao;
	}
}
