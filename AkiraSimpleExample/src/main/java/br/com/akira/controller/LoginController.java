package br.com.akira.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.akira.dao.UsuarioDAO;
import br.com.akira.entidade.Usuario;

@WebServlet("/loginController")
public class LoginController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/**
		 * Invalída a sessao caso tente acessar pela URL(get) 
		 * Retorna a pagina de login
		 */
		HttpSession sessao = req.getSession(false);
		if (sessao != null) {
			sessao.invalidate();
		}
		resp.sendRedirect("login.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Pega os parametros da tela login
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		Usuario u = new Usuario();
		u.setLogin(login);
		u.setSenha(senha);

		try {
			UsuarioDAO dao = new UsuarioDAO();
			Usuario loginConfirmado = dao.login(u);
			
			/**
			 * Se o Usuario for diferente de nulo, cria uma session e atribui
			 */
			if (loginConfirmado!=null) {
				HttpSession sessao = req.getSession();
				sessao.setAttribute("loginConfirmado", loginConfirmado);
				
				//Tempo maximo de intervalo 1min
				sessao.setMaxInactiveInterval(60*1);
				
				//encaminha para pagina index
				req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
			}else {
				resp.getWriter().println("<script> window.alert('Erro ao logar') </script>");
				resp.getWriter().println("<script> location.href=('login.jsp') </script>");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
