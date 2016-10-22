import java.sql.SQLException;
import java.util.List;

import br.com.akira.dao.UsuarioDAO;
import br.com.akira.entidade.Usuario;

public class TesteUsuarioDAO {

	public static void main(String[] args) throws SQLException {
		// cadastrar();
		// excluir();
		// atualizar();
		// buscarPorID();
		 //buscaTodos();
		// salvar();

		login();
	}

	private static void login() throws SQLException {
		Usuario u = new Usuario();
		u.setLogin("Ant");
		u.setSenha("010");
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario loginAutenticado = dao.login(u);
		
		System.out.println(loginAutenticado);
	}

	private static void salvar() throws SQLException {
		Usuario u = new Usuario();
		u.setId(0);
		u.setNome("Pedro");
		u.setLogin("ped");
		u.setSenha("321");

		UsuarioDAO dao = new UsuarioDAO();
		dao.salvar(u);
	}

	private static void buscaTodos() throws SQLException {
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> usuarios = dao.buscarTodos();

		for (Usuario u : usuarios) {
			System.out.println(u);
		}
	}

	private static void buscarPorID() throws SQLException {
		Usuario u = new Usuario();
		u.setId(2);

		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuBuscado = dao.buscarPorId(u);

		System.out.println(usuBuscado);
	}

	private static void atualizar() throws SQLException {
		Usuario u = new Usuario();
		u.setId(2);
		u.setNome("Akira");
		u.setLogin("aki");
		u.setSenha("123");

		UsuarioDAO dao = new UsuarioDAO();
		dao.atualizar(u);
	}

	private static void excluir() throws SQLException {
		Usuario u = new Usuario();
		u.setId(1);

		UsuarioDAO dao = new UsuarioDAO();
		dao.excluir(u);
	}

	private static void cadastrar() throws SQLException {
		Usuario u = new Usuario();
		u.setNome("João");
		u.setLogin("joa");
		u.setSenha("123");

		UsuarioDAO dao = new UsuarioDAO();
		dao.cadastrar(u);
	}

}
