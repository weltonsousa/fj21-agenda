package br.com.caelum.teste;

import java.util.Calendar;

import br.com.caelum.dao.ContatoDAO;
import br.com.caelum.modelo.Contato;

public class TestaInsere {

	public static void main(String[] args) throws ClassNotFoundException {

		// pronto para gravar
		Contato contato = new Contato();
		contato.setNome("Caelum");
		contato.setEmail("contato@caelum.com.br");
		contato.setEndereco("R. Vergueiro 3185 cj57");
		contato.setDataNascimento(Calendar.getInstance());

		// grave nessa conexão!!!
		ContatoDAO dao = new ContatoDAO();

		// método elegante
		dao.adiciona(contato);

		System.out.println("Gravado!");
	}
}
