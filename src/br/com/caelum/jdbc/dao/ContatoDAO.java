package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDAO {

	private Connection connection;

	public ContatoDAO() {
		connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato) {
		String sql = "insert into contatos (nome, email, endereco, dataNascimento) values (?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			Date data = new Date(contato.getDataNascimento().getTimeInMillis());
			stmt.setDate(4, data);
			
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao adicionar um novo contato no banco", e);
		}
	}
	
	public List<Contato> getContatos() {
		String sql = "select * from contatos";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			List<Contato> contatos = new ArrayList<>();
			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				Date date = rs.getDate("dataNascimento");
				Calendar data = Calendar.getInstance();
				data.setTime(date);
				contato.setDataNascimento(data);
				
				contatos.add(contato);
			}
			stmt.close();
			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao listar os contatos do banco", e);
		}
	}
	
}