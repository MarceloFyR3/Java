package repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import model.Pet;

public class PetRepository {
	
	public static boolean Incluir(Pet pet) {
		
		try {
			String  url = "jdbc:sqlite:C:\\ProgramFacul\\Java\\TrabalhoFinal\\db\\petshop.db";
			
			Connection conexao = DriverManager.getConnection(url);
			
			Statement comando = conexao.createStatement();
			
			String query = "Insert INTO pet (nome, porte, idade, proprietarioId) values ('" + pet.nome + "', '" + pet.porte + "', " + pet.idade + ", " + pet.proprietarioId + ")";
			
			comando.execute(query);
			
			return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
	}
	
	public static boolean Editar(Pet pet) {
		
		try {
			String  url = "jdbc:sqlite:C:\\ProgramFacul\\Java\\TrabalhoFinal\\db\\petshop.db";
			
			Connection conexao = DriverManager.getConnection(url);
			
			Statement comando = conexao.createStatement();
			
			String query = "UPDATE pet SET nome = '" + pet.nome + "', porte = '" + pet.porte + "' , idade = " + pet.idade + " WHERE proprietarioId = " + pet.proprietarioId + " AND id = " + pet.id;
			
			comando.execute(query);
			
			return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
	}
	
	
	public static boolean Excluir(int petId) {
		
		try {
			String  url = "jdbc:sqlite:C:\\ProgramFacul\\Java\\TrabalhoFinal\\db\\petshop.db";
			
			Connection conexao = DriverManager.getConnection(url);
			
			Statement comando = conexao.createStatement();
			
			String query = "DELETE FROM pet WHERE id = " + petId;
			
			comando.execute(query);
			
			return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
	}

	public static List<Pet> BuscarPetsPorProprietario(int proprietarioId){
		
		try {
			List<Pet> pets = new ArrayList<Pet>();
			
			String  url = "jdbc:sqlite:C:\\ProgramFacul\\Java\\TrabalhoFinal\\db\\petshop.db";
			
			Connection conexao = DriverManager.getConnection(url);
			
			String query = "SELECT * FROM pet WHERE proprietarioId = " + proprietarioId;
			
			Statement comando = conexao.createStatement();		
			ResultSet resultado = comando.executeQuery(query);
			
			while (resultado.next()) {
				Pet pet = new Pet();
				pet.id = resultado.getInt("id");
				pet.nome = resultado.getString("nome");
				pet.porte = resultado.getString("porte");
				pet.idade = resultado.getInt("idade");
				pet.proprietarioId = resultado.getInt("proprietarioId");
				
				pets.add(pet);
			}
			
			return pets;
			
		} catch (Exception e) {
			return null;
		}
	}
	
	public static Pet BuscarPetPorId(int id, int proprietarioId){
		
		try {
			List<Pet> pets = new ArrayList<Pet>();
			
			String  url = "jdbc:sqlite:C:\\ProgramFacul\\Java\\TrabalhoFinal\\db\\petshop.db";
			
			Connection conexao = DriverManager.getConnection(url);
			
			String query = "SELECT * FROM pet WHERE id = " + id + " AND proprietarioId =" + proprietarioId;
			
			Statement comando = conexao.createStatement();		
			ResultSet resultado = comando.executeQuery(query);
			
			while (resultado.next()) {
				Pet pet = new Pet();
				pet.id = resultado.getInt("id");
				pet.nome = resultado.getString("nome");
				pet.porte = resultado.getString("porte");
				pet.idade = resultado.getInt("idade");
				pet.proprietarioId = resultado.getInt("proprietarioId");
				
				pets.add(pet);
			}

			return pets.get(0);
			
		} catch (Exception e) {
			return null;
		}
	}
}
