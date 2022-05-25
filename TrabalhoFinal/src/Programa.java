import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import model.Constantes;
import model.Proprietario;
import repository.ProprietarioRepository;

import java.sql.Statement;

public class Programa {

	public static void main(String[] args) throws SQLException {
		
		int opcao;		
	    Scanner sc = new Scanner(System.in);
		
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("||||||||||||||||||| ** SEJA BEM VINDO AO SEU PET ** ||||||||||||||||||||||");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		
		System.out.println("\n");

		opcao = escolheOpcaoPossuiCadastro(); 
		
		if(opcao == 1) {
  			
  			System.out.println("Digite seu CPF: ");
  			String cpf = sc.nextLine();
  			System.out.println("Voc� digitou: " + cpf);
  			
 
  			
  		} else {
  			opcao = escolheOpcaoCadastro();
  			
  			if(opcao == 1) {

  				System.out.println("Informe seu nome: ");
  	  			String nome = sc.nextLine();
  	  			
  	  			System.out.println("Informe seu CPF: ");
  	  			String cpf = sc.nextLine();
  	  			
  				Proprietario proprietario = new Proprietario();
  				proprietario.nome = nome;
  				proprietario.cpf = cpf;
  				
  				System.out.println("\n");
  				
  				boolean insert = new ProprietarioRepository().Incluir(proprietario);
  				
  				System.out.println(insert);
  				if(insert) {
  					System.out.println("INSERIDO COM SUCESSO!");
  				} else {
  					System.out.println("ERRO! Tente novamente.");
  				}
  				
  				opcao = escolheOpcaoPossuiCadastro();
  				
  				//TODO: Parei aqui
  				
  			} else if (opcao == 2) {
  				System.out.println("OBRIGADO POR ESCOLHER NOSSO PETSHOP VOLTE SEMPRE");
  			}
  		}
		
	}
	
	public static int escolheOpcaoPossuiCadastro() {
	    int opcao;
	    boolean erro = true;
	    var scanner = new Scanner(System.in);
	    
	    do {
	      try {
	    	System.out.println("** VO�� J� POSSUI CADASTRO? **");
	    	System.out.println("( 1 ) - SIM");
	    	System.out.println("( 2 ) - N�O");
	    	System.out.println("( 0 ) - Sair do Programa a qualquer momento");
	        System.out.printf("Digite uma opc�o: ");
	        opcao = Integer.parseInt(scanner.nextLine());
	        
	        if(opcao == 0) {
	          System.out.println("\nO programa ser� finalizado");
	          erro = false;
	        }
	        if(opcao < 3 && opcao > 0) {
	          erro = false;
	        }
	        if(opcao > 2) {
	          System.out.println("Escolha um n�mero entre 0 e 2\n");
	        }
	      }
	      catch(NumberFormatException e) {
	    	  System.out.println("Escolha um n�mero entre 0 e 2\n");
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
	    	System.out.println("( 2 ) - N�O");
	        System.out.println("( 0 ) - Sair do Programa a qualquer momento");
	        System.out.printf("Digite uma opc�o: ");
	        opcao = Integer.parseInt(sc.nextLine());
	        
	        if(opcao == 0) {
	          System.out.println("\nO programa ser� finalizado");
	          erro = false;
	        }
	        if(opcao < 3 && opcao > 0) {
	          erro = false;
	        }
	        if(opcao > 2) {
	          System.out.println("Escolha um n�mero entre 0 e 2\n");
	        }
	      }
	      catch(NumberFormatException e) {
	    	  System.out.println("Escolha um n�mero entre 0 e 2\n");
	    	  opcao = 0;
	      }
	    } while (erro);
	    return opcao;
	}
	
	public static void ListarPet() throws SQLException {
		
		String  url = "jdbc:sqlite:C:\\ProgramFacul\\Java\\TrabalhoFinal\\db\\petshop.db";
		
		Connection conexao = DriverManager.getConnection(url);
		
		// 2. Criar e executar da consulta.
		Statement comando = conexao.createStatement();		
		ResultSet resultado = comando.executeQuery(new Constantes().SELECT_PET);
		
		while (resultado.next()) {
			int id = resultado.getInt(1);
			String nome = resultado.getString(2);
			String porte = resultado.getString(3);
			int idade = resultado.getInt(4);
			
			System.out.println("Id: " + id + " | Nome: "  + nome + " | Porte: " + porte + " | Idade: " + idade);
		}
		
	}
	
	public static void IncluirPet() throws SQLException {
		
		String  url = "jdbc:sqlite:C:\\ProgramFacul\\Java\\TrabalhoFinal\\db\\petshop.db";
		
		Connection conexao = DriverManager.getConnection(url);
		
		// 2. Criar e executar da consulta.
		Statement comando = conexao.createStatement();
		boolean insert = comando.execute(new Constantes().CREATE_PET);
		
		if(insert) {
			System.out.println("Inserido com sucesso!");
		}
		
	}

}
