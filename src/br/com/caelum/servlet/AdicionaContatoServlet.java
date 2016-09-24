package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class AdicionaContatoServlet extends HttpServlet {

		 protected void service(HttpServletRequest request, HttpServletResponse response)
		 throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		
		// pegando os par�metros do request
		 String nome = request.getParameter("nome");
		 String endereco = request.getParameter("endereco");
		 String email = request.getParameter("email");
		 String dataEmTexto = request.getParameter("dataNascimento");
		 Calendar dataNascimento = null;
		
		 // fazendo a convers�o da data
		 try {
		 Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
		 dataNascimento = Calendar.getInstance();
		 dataNascimento.setTime(date);
		 } catch (ParseException e) {
		 out.println("Erro de convers�o da data");
		 return; //para a execu��o do m�todo
		 }
		
		 // monta um objeto contato
		 Contato contato = new Contato();
		 contato.setNome(nome);
		 contato.setEndereco(endereco);
		 contato.setEmail(email);
		 contato.setDataNascimento(dataNascimento);
		
		 // salva o contato
		 ContatoDAO dao = new ContatoDAO();
		 dao.adiciona(contato);
		
		 // imprime o nome do contato que foi adicionado
		 out.println("<html>");
		 out.println("<body>");
		 out.println("Contato " + contato.getNome() + " adicionado com sucesso");
		 out.println("</body>");
		 out.println("</html>");
		
		 }
}
