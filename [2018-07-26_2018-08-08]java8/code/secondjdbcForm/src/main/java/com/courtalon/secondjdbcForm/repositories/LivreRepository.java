package com.courtalon.secondjdbcForm.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.courtalon.secondjdbcForm.metier.Livre;

public class LivreRepository {
	public static final String SELECT_ALL_SQL 
		= "select `id`, `titre`, `auteur`, `isbn`, `nb_pages` from `livre`";
	public static final String SELECT_BY_ID_SQL 
		= "select `id`, `titre`, `auteur`, `isbn`, `nb_pages` from `livre` where `id`=?";
	public static final String INSERT_ONE_SQL 
	= "insert into `livre` (`titre`, `auteur`, `isbn`, `nb_pages`) VALUES (?, ?, ?, ?)";
	public static final String UPDATE_ONE_SQL 
	= "update `livre` set `titre`=?, `auteur`=?, `isbn`=?, `nb_pages`=? where `id`=?";
	
	
	private Connection connection;

	private PreparedStatement selectAllStatement;
	private PreparedStatement selectOneByIdStatement;
	private PreparedStatement insertOneStatement;
	private PreparedStatement updateOneStatement;
	
	public LivreRepository(Connection connection) {
		this.connection = connection;
		try {
			this.selectAllStatement = connection.prepareStatement(SELECT_ALL_SQL);
			this.selectOneByIdStatement = connection.prepareStatement(SELECT_BY_ID_SQL);
			this.insertOneStatement = connection.prepareStatement(INSERT_ONE_SQL);
			this.updateOneStatement = connection.prepareStatement(UPDATE_ONE_SQL);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Livre> findAll() {
		// tableau vide pour commencer
		ArrayList<Livre> livres = new ArrayList<>();
		
		try {
			// executer la requete de séléction
			ResultSet rs = selectAllStatement.executeQuery();
			while (rs.next()) {
				// pour chaque ligne dans le resultSet
				// instancier un livre et l'ajouter dans le tableau 'livres'
				livres.add(fillLivreFromRow(rs));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// renvoyer le tableau des livres requeté depuis la base
		return livres;
	}
	
	public Livre findById(int id) {
		
		try {
			// vider/nettoyer les paremetre utilisé précédement s'il y en a
			selectOneByIdStatement.clearParameters();
			// passage de la valeur id du livre recherché
			selectOneByIdStatement.setInt(1, id);
			// execution de la requete
			ResultSet rs = selectOneByIdStatement.executeQuery();
			if (rs.next()) {
				Livre livre = fillLivreFromRow(rs);
				rs.close();
				return livre;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void save(Livre livre) {
		if (livre.getId() == 0) {
			// insertion
			try {
				insertOneStatement.clearParameters();
				insertOneStatement.setString(	1, livre.getTitre());
				insertOneStatement.setString(	2, livre.getAuteur());
				insertOneStatement.setString(	3, livre.getIsbn());
				insertOneStatement.setInt(		4, livre.getNb_pages());
				insertOneStatement.executeUpdate();
			} catch (SQLException e) {e.printStackTrace();}
		}
		else {
			// update
			try {
				updateOneStatement.clearParameters();
				updateOneStatement.setString(	1, livre.getTitre());
				updateOneStatement.setString(	2, livre.getAuteur());
				updateOneStatement.setString(	3, livre.getIsbn());
				updateOneStatement.setInt(		4, livre.getNb_pages());
				updateOneStatement.setInt(		5, livre.getId());
				updateOneStatement.executeUpdate();
			} catch (SQLException e) {e.printStackTrace();}
		}
	}
	
	
	

	private Livre fillLivreFromRow(ResultSet rs) throws SQLException {
		Livre livre = new Livre(
				rs.getInt("id"),
				rs.getString("titre"),
				rs.getString("isbn"),
				rs.getString("auteur"),
				rs.getInt("nb_pages"));
		return livre;
	}
	
}
