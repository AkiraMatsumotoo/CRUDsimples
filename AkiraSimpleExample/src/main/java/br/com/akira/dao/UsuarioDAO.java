package br.com.akira.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.akira.entidade.Usuario;
import br.com.akira.jdbc.util.ConnectionFactory;

public class UsuarioDAO {

	private Connection conn = ConnectionFactory.getConnection();

	
	/**
	 * 
	 * @param Usuario , cadastra um usuario no banco
	 * @throws SQLException
	 */
	public void cadastrar(Usuario u) throws SQLException {
		String sql = "INSERT INTO usuario(nome,login,senha)VALUES(?,?,?)";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, u.getNome());
			ps.setString(2, u.getLogin());
			ps.setString(3, u.getSenha());
			ps.execute();
			System.out.println("Cadastrado com sucesso !!!");
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			conn.close();
		}
	}

	/**
	 * 
	 * @param Usuario, Exclui um Usuario no banco
	 * @throws SQLException
	 */
	public void excluir(Usuario u) throws SQLException {
		String sql = "DELETE FROM usuario WHERE id=?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, u.getId());
			ps.execute();
			System.out.println("Excluido com sucesso !!!");
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			conn.close();
		}
	}

	
	/**
	 * 
	 * @param Usuario, Atualiza um USuario no banco
	 * @throws SQLException
	 */
	public void atualizar(Usuario u) throws SQLException {
		String sql = "UPDATE usuario SET nome=?,login=?,senha=? WHERE id=?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, u.getNome());
			ps.setString(2, u.getLogin());
			ps.setString(3, u.getSenha());
			ps.setInt(4, u.getId());
			ps.execute();
			System.out.println("Atualizado com sucesso !!!");
			conn.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	/**
	 * 
	 * @param Usuario, Busca um Usuario no banco atraves do ID
	 * @return um Usuario, caso não tenha retorna nulo
	 * @throws SQLException
	 */
	public Usuario buscarPorId(Usuario u) throws SQLException {
		String sql = "SELECT * FROM usuario WHERE id=?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, u.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				return usuario;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			conn.close();
		}
		return null;
	}

	/**
	 * Busca todos os Usuarios no banco
	 * @return uma lista de Usuarios
	 * @throws SQLException
	 */
	public List<Usuario> buscarTodos() throws SQLException {
		String sql = "SELECT * FROM usuario";
		List<Usuario> lista = new ArrayList<>();
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				lista.add(usuario);
			}
			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			conn.close();
		}
	}

	
	/**
	 * 
	 * @param Usuario
	 * @return um Usuario com os todos os dados, caso não tenha retorna nulo
	 * @throws SQLException
	 */
	public Usuario login(Usuario u) throws SQLException {
		String sql = "SELECT * FROM usuario WHERE login=? AND senha=?";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, u.getLogin());
			ps.setString(2, u.getSenha());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				return usuario;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		return null;
	}

	
	
	/**
	 * Caso o ID seja nulo ele Cadastra,se não ele Altera
	 * @param Usuairo
	 * @throws SQLException
	 */
	public void salvar(Usuario u) throws SQLException {
		if (u.getId() == null || u.getId() == 0) {
			cadastrar(u);
		} else {
			atualizar(u);
		}
	}
}
