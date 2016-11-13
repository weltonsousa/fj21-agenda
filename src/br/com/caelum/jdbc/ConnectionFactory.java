package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() throws ClassNotFoundException {

		System.out.println("Conectando ao banco");
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "admin");
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}
}
