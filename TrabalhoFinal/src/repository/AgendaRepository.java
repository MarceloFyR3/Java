package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import model.Agenda;

public class AgendaRepository {

	public static boolean Incluir(Agenda agenda) {
		
		try {
			String  url = "jdbc:sqlite:C:\\ProgramFacul\\Java\\TrabalhoFinal\\db\\petshop.db";
			
			Connection conexao = DriverManager.getConnection(url);
			
			Statement comando = conexao.createStatement();
			
			String query = "Insert INTO Agenda (Dia, Hora, PetId, ProprietarioId, NomeProprietario) values ('" + agenda.dia + "', '" + agenda.hora + "', " + agenda.petId + ", " + agenda.proprietarioId + ", '"+ agenda.nomeProprietario+"')";
			
			comando.execute(query);
			
			return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
	}
}
