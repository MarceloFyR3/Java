package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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

}
