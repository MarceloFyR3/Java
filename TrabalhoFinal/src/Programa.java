import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import Service.EscolhaOpcao;
import model.Pet;
import model.Proprietario;
import repository.PetRepository;
import repository.ProprietarioRepository;

public class Programa {

	public static void main(String[] args) throws SQLException {
		work();
	}
	
	public static void work() {
		int opcao;	
		var scanner = new Scanner(System.in);
		
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("||||||||||||||||||| ** SEJA BEM VINDO AO SEU PET ** ||||||||||||||||||||||");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		
		System.out.println("");

		opcao = EscolhaOpcao.escolheOpcaoPossuiCadastro(scanner); 
		
		if(opcao == 1) {			
			jaCadastrado(scanner);		
  		} else if(opcao == 2) {
  			naoCadastrado(scanner);
  		}
	}

	private static Proprietario procurarProprietario(String cpf) {	
		var proprietario = ProprietarioRepository.ConsultarPorCPF(cpf);
	
		return proprietario;
	}

	private static void jaCadastrado(Scanner scanner) {
		int opcao;
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("");
			System.out.println("Digite seu CPF: ");
			String cpf = sc.nextLine();	
				
			var proprietario = procurarProprietario(cpf);
			
			if(proprietario.nome == null) {
					
				 opcao = EscolhaOpcao.escolheOpcaoCadastroNaoEncontrado(scanner);
				
				if(opcao == 1) {				
					jaCadastrado(scanner);					
				} else if (opcao == 2 ){
					work();
				}
				
			} else {
				System.out.println("");
				System.out.println("Olá " + proprietario.nome);
				
				//Todo: Criar escolha para listar(Selecionar) Pet ou cadastrar 
				
				opcaoProprietario(scanner, proprietario);
					
				
			}
		} catch (Exception e) {
			System.out.println("\n** Erro SCANNER **\n" + e.getMessage());
		}
	}

	private static void opcaoProprietario(Scanner scanner, Proprietario proprietario) {
		
		int opcao = EscolhaOpcao.escolheOpcaoProprietario(scanner);
		
		if(opcao == 1) {
		
			List<Pet> pets = PetRepository.BuscarPetsPorProprietario(proprietario.id);
			
			if(pets.size() == 0) {
				System.out.println("");
				opcao = EscolhaOpcao.escolheOpcaoSemPets(scanner);
				
				if(opcao == 1) {
					boolean cadastroPet = CadastroPet(scanner, proprietario);
					
					if(cadastroPet) {
						System.out.println("");
						opcaoProprietario(scanner, proprietario);
					}
					
				} else if(opcao == 2) {
					opcaoProprietario(scanner, proprietario);
				}				
				
			} else {
				//TODO:
				//Criar agenda para consulta, banho e tosa
			}
		} else if (opcao == 2) {
			boolean cadastroPet = CadastroPet(scanner, proprietario);
			
			if(cadastroPet) {
				System.out.println("");
				opcaoProprietario(scanner, proprietario);
			}			
		} else if (opcao == 3) {
			List<Pet> pets = PetRepository.BuscarPetsPorProprietario(proprietario.id);
			
			if(pets == null) {
				System.out.println("");
				opcao = EscolhaOpcao.escolheOpcaoSemPets(scanner);
				
				if(opcao == 1) {
					boolean cadastroPet = CadastroPet(scanner, proprietario);
					
					if(cadastroPet) {
						System.out.println("");
						opcaoProprietario(scanner, proprietario);
					}
					
				} else if(opcao == 2) {
					opcaoProprietario(scanner, proprietario);
				}				
				
			} else {
				System.out.println("");
				
				for (int i = 0; i < pets.size(); i++) {
					System.out.println("id: " + pets.get(i).id + " Nome: " + pets.get(i).nome + " Idade: " + pets.get(i).idade + " Porte: " + pets.get(i).porte);
				}
				
				opcaoProprietario(scanner, proprietario);
			}
		} else if (opcao == 4) {
			
			List<Pet> pets = PetRepository.BuscarPetsPorProprietario(proprietario.id);
			
			if(pets == null) {
				
				opcao = EscolhaOpcao.escolheOpcaoSemPets(scanner);
				
				if(opcao == 1) {
					boolean cadastroPet = CadastroPet(scanner, proprietario);
					
					if(cadastroPet) {
						System.out.println("");
						opcaoProprietario(scanner, proprietario);
					}
					
				} else if(opcao == 2) {
					opcaoProprietario(scanner, proprietario);
				}	
			} else {
				
				System.out.println("");
				
				for (int i = 0; i < pets.size(); i++) {
					System.out.println("id: " + pets.get(i).id + " Nome: " + pets.get(i).nome + " Idade: " + pets.get(i).idade + " Porte: " + pets.get(i).porte);
				}
				System.out.println("");
				System.out.println("DIGITE UM ID PARA EDITAR.");
				int idPet = Integer.parseInt(scanner.nextLine());

				Pet pp = PetRepository.BuscarPetPorId(idPet, proprietario.id);
				
				if(pp == null) {
					System.out.println("OPÇÃO INVALIDA, TENTE NOVAMENTE!");
					opcaoProprietario(scanner, proprietario);
				}
				
				boolean editPet = EditarPet(scanner, proprietario, pp);
				
				if(editPet) {
					opcaoProprietario(scanner, proprietario);
				}
			}
		} else if (opcao == 5) {
			
			List<Pet> pets = PetRepository.BuscarPetsPorProprietario(proprietario.id);
			
			if(pets == null) {
				
				opcao = EscolhaOpcao.escolheOpcaoSemPets(scanner);
				
				if(opcao == 1) {
					boolean cadastroPet = CadastroPet(scanner, proprietario);
					
					if(cadastroPet) {
						System.out.println("");
						opcaoProprietario(scanner, proprietario);
					}
					
				} else if(opcao == 2) {
					opcaoProprietario(scanner, proprietario);
				}	
			} else {
				
				System.out.println("");
				
				for (int i = 0; i < pets.size(); i++) {
					System.out.println("id: " + pets.get(i).id + " Nome: " + pets.get(i).nome + " Idade: " + pets.get(i).idade + " Porte: " + pets.get(i).porte);
				}
				System.out.println("");
				System.out.println("DIGITE UM ID PARA EXCLUIR.");
				int idPet = Integer.parseInt(scanner.nextLine());

				Pet pp = PetRepository.BuscarPetPorId(idPet, proprietario.id);
				
				if(pp == null) {
					System.out.println("OPÇÃO INVALIDA, TENTE NOVAMENTE!");
					opcaoProprietario(scanner, proprietario);
				}
				
				boolean exclude = PetRepository.Excluir(pp.id);
				
				System.out.println("");
					
				if(exclude) {
					System.out.println("APAGADO COM SUCESSO!");
					opcaoProprietario(scanner, proprietario);
				} else {
					System.out.println("ERRO! Tente novamente.");
				}
			}
		}
	}
	
	private static boolean EditarPet(Scanner sc, Proprietario prop, Pet pet) {
		System.out.println("");
		System.out.println("Atualizar o nome " + pet.nome + " para: ");
		String nome = sc.nextLine();
		
		System.out.println("Atualizar o porte " + pet.porte + " para: ");
		String porte = sc.nextLine();
		
		System.out.println("Atualizar a idade " + pet.idade + " para: ");
		String idade = sc.nextLine();
		
		if(nome.isEmpty()) {
			nome = pet.nome;
		}
		
		if(porte.isEmpty()) {
			porte = pet.porte;
		}
		
		if(idade.isEmpty()) {
			idade = Integer.toString(pet.idade);
		}
			
		pet.nome = nome;
		pet.porte = porte;
		pet.idade = Integer.parseInt(idade);
		pet.proprietarioId = prop.id;
			
		boolean insert = PetRepository.Editar(pet);
			
		System.out.println("");
			
		if(insert) {
			System.out.println("EDITADO COM SUCESSO!");
		} else {
			System.out.println("ERRO! Tente novamente.");
		}
		
		return insert;
	}
	
	private static boolean CadastroPet(Scanner sc, Proprietario prop) {
		System.out.println("");
		System.out.println("Informe o nome do Pet: ");
		String nome = sc.nextLine();
		
		System.out.println("Informe o porte do Pet: ");
		String porte = sc.nextLine();
		
		System.out.println("Informe o idade do Pet: ");
		String idade = sc.nextLine();
			
		Pet pet = new Pet();
		pet.nome = nome;
		pet.porte = porte;
		pet.idade = Integer.parseInt(idade);
		pet.proprietarioId = prop.id;
			
		boolean insert = PetRepository.Incluir(pet);
			
		System.out.println("");
			
		if(insert) {
			System.out.println("INSERIDO COM SUCESSO!");
		} else {
			System.out.println("ERRO! Tente novamente.");
		}
		
		return insert;
	}

	private static void naoCadastrado(Scanner sc) {
		int opcao;		
	    try {
			opcao = EscolhaOpcao.escolheOpcaoCadastro(sc);
				
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
					
				opcao = EscolhaOpcao.escolheOpcaoPossuiCadastro(sc);
					
			} else if (opcao == 2) {
				System.out.println("\n** OBRIGADO POR ESCOLHER NOSSO PETSHOP VOLTE SEMPRE **\n");
				work();
			}
		} catch (Exception e) {
			System.out.println("\n** Erro SCANNER **\n" + e.getMessage());
		}
	}
	
}
