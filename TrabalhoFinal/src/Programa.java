import java.sql.SQLException;
import java.util.Scanner;

import Service.EscolhaOpcao;
import model.Proprietario;
import repository.ProprietarioRepository;

public class Programa {

	public static void main(String[] args) throws SQLException {
		work();
	}
	
	public static void work() {
		int opcao;	
		
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("||||||||||||||||||| ** SEJA BEM VINDO AO SEU PET ** ||||||||||||||||||||||");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		
		System.out.println("");

		opcao = EscolhaOpcao.escolheOpcaoPossuiCadastro(); 
		
		if(opcao == 1) {			
			jaCadastrado();		
  		} else if(opcao == 2) {
  			naoCadastrado();
  		}
	}

	private static Proprietario procurarProprietario(String cpf) {	
		var proprietario = ProprietarioRepository.ConsultarPorCPF(cpf);
	
		return proprietario;
	}

	private static void jaCadastrado() {
		int opcao;
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("");
			System.out.println("Digite seu CPF: ");
			String cpf = sc.nextLine();	
				
			var proprietario = procurarProprietario(cpf);
			
			if(proprietario.nome == null) {
					
				 opcao = EscolhaOpcao.escolheOpcaoCadastroNaoEncontrado();
				
				if(opcao == 1) {				
					jaCadastrado();					
				} else if (opcao == 2 ){
					work();
				}
				
			} else {
				System.out.println("");
				System.out.println("Olá " + proprietario.nome);
				
				//Todo: Criar escolha para listar(Selecionar) Pet ou cadastrar 
				
				opcao = EscolhaOpcao.escolheOpcaoProprietario();
				
			}
		} catch (Exception e) {
			System.out.println("\n** Erro SCANNER **\n" + e.getMessage());
		}
	}

	private static void naoCadastrado() {
		int opcao;		
	    try (Scanner sc = new Scanner(System.in)) {
			opcao = EscolhaOpcao.escolheOpcaoCadastro();
				
			if(opcao == 1) {
				System.out.println("Informe seu nome: ");
				String nome = sc.nextLine();
				
				System.out.println("Informe seu CPF: ");
				String cpf = sc.nextLine();
					
				Proprietario proprietario = new Proprietario();
				proprietario.nome = nome;
				proprietario.cpf = cpf;
					
				boolean insert = ProprietarioRepository.Incluir(proprietario);
					
				System.out.println("");
					
				if(insert) {
					System.out.println("INSERIDO COM SUCESSO!");
				} else {
					System.out.println("ERRO! Tente novamente.");
				}
					
				System.out.println("");
					
				opcao = EscolhaOpcao.escolheOpcaoPossuiCadastro();
					
			} else if (opcao == 2) {
				System.out.println("\n** OBRIGADO POR ESCOLHER NOSSO PETSHOP VOLTE SEMPRE **\n");
				work();
			}
		} catch (Exception e) {
			System.out.println("\n** Erro SCANNER **\n" + e.getMessage());
		}
	}
	
}
