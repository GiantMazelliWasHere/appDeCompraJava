package br.com.comprasonline.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FecahrOrcl {

	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
		String user = "rm553236";
		String pass = "080799";
		
		try (Connection connection = DriverManager.getConnection(url, user, pass)) {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
