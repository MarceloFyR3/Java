package Service;

import java.util.Scanner;

public class EscolhaOpcao {
	
	public static int escolheOpcaoPossuiCadastro(Scanner scanner) {
	    int opcao;
	    boolean erro = true;
	    
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
	
	public static int escolheOpcaoCadastro(Scanner sc) {
		System.out.println("\n");
	    int opcao;
	    boolean erro = true;
	    
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
	
	public static int escolheOpcaoCadastroNaoEncontrado(Scanner sc) {
		System.out.println("\n");
	    int opcao;
	    boolean erro = true;
	    
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

	public static int escolheOpcaoProprietario(Scanner sc) {
		System.out.println("\n");
	    int opcao;
	    boolean erro = true;
	    
	    do {
	      try {
	    	System.out.println("** O QUE PRECISA? **");
	    	System.out.println("( 1 ) - AGENDAR SERVICO PET");
	    	System.out.println("( 2 ) - CADASTRAR PET");
	    	System.out.println("( 3 ) - LISTAR PETS");
	    	System.out.println("( 4 ) - EDITAR PET");
	    	System.out.println("( 5 ) - EXCLUIR PET");
	        System.out.println("( 0 ) - Sair do Programa a qualquer momento");
	        System.out.printf("Digite uma opcão: ");
	        opcao = Integer.parseInt(sc.nextLine());
	        
	        if(opcao == 0) {
	          System.out.println("\nO programa será finalizado");
	          erro = false;
	        }
	        if(opcao < 6 && opcao > 0) {
	          erro = false;
	        }
	        if(opcao > 5) {
	          System.out.println("Escolha um número entre 0 e 5\n");
	        }
	      }
	      catch(NumberFormatException e) {
	    	  System.out.println("Escolha um número entre 0 e 5\n");
	    	  opcao = 0;
	      } 
	      catch (Exception e) {
	    	  System.out.println("\n** Erro SCANNER **\n" + e.getMessage());
	    	  opcao = 0;
	      }
	    } while (erro);
	    return opcao;
	}
	
	public static int escolheOpcaoSemPets(Scanner sc) {
	    int opcao;
	    boolean erro = true;
	    
	    do {
	      try {
	    	System.out.println("** VOCÊ NÃO POSSUI PET CADASTRADO? **");
	    	System.out.println("( 1 ) - CADASTRAR");
	    	System.out.println("( 2 ) - VOLTAR MENU ANTERIOR");
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
	
}
