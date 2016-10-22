package br.com.akira.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.akira.dao.UsuarioDAO;
import br.com.akira.entidade.Usuario;

@WebServlet("/usuController")
public class UsuarioController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao");
	

		/**
		 * acao=list
		 * Lista todos os Usuarios do Banco de dados
		 */
		if (acao.equals("list")) {
			UsuarioDAO dao = new UsuarioDAO();
			List<Usuario> buscarTodos;
			try {
				buscarTodos = dao.buscarTodos();
				req.setAttribute("lista", buscarTodos);
				req.getRequestDispatcher("WEB-INF/listaUsuarios.jsp").forward(req, resp);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		/**
		 * acao=cad
		 * Cadastra os Usuario no Banco de dados
		 */
		else if (acao.equals("cad")) {
			Usuario u = new Usuario();
			u.setId(0);
			u.setNome("");
			u.setLogin("");
			u.setSenha("");
			req.setAttribute("usuario", u);
			req.getRequestDispatcher("WEB-INF/cadUsuario.jsp").forward(req, resp);
		}

		/**
		 * acao=exc
		 * Exclui o Usuario do Banco de dados atraves do ID
		 */
		else if (acao.equals("exc")) {
			int id = Integer.parseInt(req.getParameter("id"));
			Usuario u = new Usuario();
			u.setId(id);
			UsuarioDAO dao = new UsuarioDAO();
			try {
				dao.excluir(u);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		/**
		 * acao=alt
		 * Pega o ID ,preenche o Formulario de cadastro e depois altera(salva) 
		 */
		else if (acao.equals("alt")) {
			int id = Integer.parseInt(req.getParameter("id"));
			Usuario usuario = new Usuario();
			usuario.setId(id);
			UsuarioDAO dao = new UsuarioDAO();

			try {
				Usuario usuBuscado = dao.buscarPorId(usuario);
				req.setAttribute("usuario", usuBuscado);
				req.getRequestDispatcher("WEB-INF/cadUsuario.jsp").forward(req, resp);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Pega os parametros do formulario cadastro
		int id = Integer.parseInt(req.getParameter("id"));
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		Usuario u = new Usuario();
		u.setId(id);
		u.setNome(nome);
		u.setLogin(login);
		u.setSenha(senha);

		//salva no banco
		UsuarioDAO dao = new UsuarioDAO();
		try {
			dao.salvar(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
