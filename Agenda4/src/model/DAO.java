package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO implements Connectable {
	
	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "w!z84$&z84R00T";
	
	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * Testar conexao.
	 */
	public void testarConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} 
	}

	/**
	 * Inserir novo contato.
	 *
	 * @param contato the contato
	 */
	public void inserirNovoContato(JavaBeans contato) {
		String sql = "insert into contatos (nome, fone, email) values (?, ?, ?);";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Listar contatos.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listarContatos() {
		ArrayList<JavaBeans> lista = new ArrayList<>();
		String sql = "select * from contatos order by nome;";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				lista.add(new JavaBeans(idcon, nome, fone, email));
			}
			con.close();
			return lista;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Selecionar contato.
	 *
	 * @param parameter the parameter
	 * @return the java beans
	 */
	public JavaBeans selecionarContato(String parameter) {
		String sql = "select * from contatos where idcon = ?";
		JavaBeans contato = new JavaBeans();
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, parameter);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				contato.setIdcon( rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			con.close();
			return contato;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Editar contato.
	 *
	 * @param contato the contato
	 */
	public void editarContato(JavaBeans contato) {
		String sql = "update contatos set nome=?, fone=?, email=? where idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Deletar contato.
	 *
	 * @param parameter the parameter
	 */
	public void deletarContato(String parameter) {
		String sql = "delete from contatos where idcon = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, parameter);
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
