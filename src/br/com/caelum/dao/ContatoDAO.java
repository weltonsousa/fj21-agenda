package br.com.caelum.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.modelo.Contato;

//import br.com.caelum.jdbc.ConnectionFactory;
//import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDAO {

	// a conexão com o banco de dados
	private Connection connection;

	public ContatoDAO() throws ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();

	}

	public void adiciona(Contato contato) {
		String sql = "insert into contatos (nome,email,endereco,dataNascimento) values (?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);

			// seta os valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
		public List<Contato> getLista() {
			try {
				List<Contato> contatos = new ArrayList<Contato>();
				PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");

				ResultSet rs = stmt.executeQuery();

				while(rs.next()) {
					Contato contato = new Contato();
					
					//popula o objeto contato
					contato.setId(rs.getLong("id"));
					contato.setNome(rs.getString("nome"));
					contato.setEmail(rs.getString("email"));
					contato.setEndereco(rs.getString("endereco"));

					//popula a data de nascimento do contato, fazendo a conversao
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getDate("dataNascimento"));
					contato.setDataNascimento(data);

					//adiciona o contato na lista
					contatos.add(contato);
				}

				rs.close();
				stmt.close();

				return contatos;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		public void exclui(Contato contato) {
			String sql = "delete from contatos where id=?";
			try {
				PreparedStatement stmt = this.connection.prepareStatement(sql);
				stmt.setLong(1, contato.getId());
				stmt.execute();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		public void atualiza(Contato contato) {
			String sql = "update contatos set nome = ?, email = ?, endereco = ?, dataNascimento = ? where id = ?";
			try {
				PreparedStatement stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, contato.getNome());
				stmt.setString(2, contato.getEmail());
				stmt.setString(3, contato.getEndereco());
				stmt.setDate(4, new java.sql.Date(contato.getDataNascimento().getTimeInMillis()));
				stmt.setLong(5, contato.getId());

				stmt.execute();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}