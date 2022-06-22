package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Constantes;
import model.Proprietario;

public class ProprietarioRepository {
	
	public static boolean Incluir(Proprietario proprietario) {
		
		try {
			String  url = "jdbc:sqlite:C:\\ProgramFacul\\Java\\TrabalhoFinal\\db\\petshop.db";
			
			Connection conexao = DriverManager.getConnection(url);
			
			Statement comando = conexao.createStatement();
			
			String query = "Insert INTO proprietario (nome, cpf) values ('" + proprietario.nome + "', '" + proprietario.cpf + "')";
			
			comando.execute(query);
			
			return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
	}
	
	public static Proprietario ConsultarPorCPF(String nome) {
		
		try {
			String  url = "jdbc:sqlite:C:\\ProgramFacul\\Java\\TrabalhoFinal\\db\\petshop.db";
			
			Connection conexao = DriverManager.getConnection(url);
			
			String query = "Select * from proprietario where cpf = '" + nome + "'";
			
			Statement comando = conexao.createStatement();		
			ResultSet resultado = comando.executeQuery(query);
			
			Proprietario prop = new Proprietario();
			
			while (resultado.next()) {
				int id = resultado.getInt(1);
				String name = resultado.getString(2);
				String cpf = resultado.getString(3);
				
				prop.id = id;
				prop.nome = name;
				prop.cpf = cpf;			
			}
			
			return prop;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
	}

}
