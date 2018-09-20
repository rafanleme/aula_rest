package br.com.senai.aula_rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.aula_rest.config.ConnectionDB;
import br.com.senai.aula_rest.vo.Filme;

public class FilmeDao {

	Connection con;
	PreparedStatement ps;

	public List<Filme> listar() throws SQLException {
		String sql = " SELECT * FROM filme ";

		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Filme> lista = new ArrayList<Filme>();
		while (rs.next()) {
			Filme f = new Filme(rs.getInt("filme_id"), rs.getString("titulo"), rs.getString("descricao"),
					rs.getString("ano_de_lancamento"));
			lista.add(f);
		}
		return lista;
	}

	public boolean inserir(Filme f) throws SQLException {
		String sql = "INSERT INTO filme VALUES (0,?,?,?)";

		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1, f.getTitulo());
		ps.setString(1, f.getDescricao());
		ps.setString(1, f.getAnoLancamento());
		if (ps.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

	public boolean editar(Filme f) throws SQLException {
		String sql = "UPDATE filme " + " SET titulo = ? "
				+ " SET descricao = ? "
				+ " SET ano_de_lancamento = ? "
				+ " WHERE filme_id = ? ";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1, f.getTitulo());
		ps.setString(2, f.getDescricao());
		ps.setString(3, f.getAnoLancamento());
		ps.setInt(4, f.getFilme_id());
		if (ps.executeUpdate() > 0) {
			return true;
		}
		return false;

	}

	public boolean excluir(Filme c) throws SQLException {
		String sql = "DELETE FROM filme WHERE filme_id = ?";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setInt(1, c.getFilme_id());
		if (ps.executeUpdate() > 0) {
			return true;
		}
		return false;

	}

}
