package br.com.caelum.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.caelum.jdbc.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conex�o aberta!");
		connection.close();
	}

}
