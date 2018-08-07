package com.courtalon.exercice8Form.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.courtalon.exercice8Form.metier.Produit;

public class ProduitRepository {
	public static final String SELECT_ALL_SQL 
		= "SELECT `id`,`libelle`,`prix`,`poids` FROM `produit`";
	public static final String SELECT_ONE_SQL
		= "SELECT `id`,`libelle`,`prix`,`poids` FROM `produit` WHERE `id`=?";
	public static final String INSERT_ONE_SQL 
		= "INSERT INTO `produit` (`libelle`,`prix`,`poids`) VALUES(?,?,?)";
	public static final String UPDATE_ONE_SQL 
		= "UPDATE `produit` set `libelle`=?,`prix`=?,`poids`=?  WHERE `id`=?";
	public static final String DELETE_ONE_SQL
		= "DELETE FROM `produit` WHERE `id`=?";
	public static final String SEARCH_BY_LIBELLE
		= "SELECT `id`,`libelle`,`prix`,`poids` FROM `produit` WHERE `libelle` LIKE ?";
	
	
	
	private Connection connection;

	private PreparedStatement selectAllStatement;
	private PreparedStatement selectOneStatement;
	private PreparedStatement insertOneStatement;
	private PreparedStatement updateOneStatement;
	private PreparedStatement deleteOneStatement;
	private PreparedStatement searchByLibelleStatement;
	
	public ProduitRepository(Connection connection) {
		this.connection = connection;
		try {
			this.selectAllStatement = connection.prepareStatement(SELECT_ALL_SQL);
			this.selectOneStatement = connection.prepareStatement(SELECT_ONE_SQL);
			this.insertOneStatement = connection.prepareStatement(INSERT_ONE_SQL);
			this.updateOneStatement = connection.prepareStatement(UPDATE_ONE_SQL);
			this.deleteOneStatement = connection.prepareStatement(DELETE_ONE_SQL);
			this.searchByLibelleStatement = connection.prepareStatement(SEARCH_BY_LIBELLE);

		} catch (SQLException e) {e.printStackTrace();}
	}
	
	
	private Produit fillFormRs(ResultSet rs) throws SQLException {
		return new Produit(rs.getInt("id"),
				rs.getString("libelle"),
				rs.getDouble("prix"),
				rs.getDouble("poids"));
	}

	public List<Produit> findAll() {
		ArrayList<Produit> produits = new ArrayList<>();
		try {
			selectAllStatement.clearParameters();
			ResultSet rs = selectAllStatement.executeQuery();
			while (rs.next()) {
				produits.add(fillFormRs(rs));
			}
			rs.close();
		} catch (SQLException e) {e.printStackTrace();}
		return produits;
	}
	
	public Produit findOne(int id) {
		try {
			selectOneStatement.clearParameters();
			selectOneStatement.setInt(1, id);
			ResultSet rs = selectOneStatement.executeQuery();
			if (rs.next()) {
				Produit p = fillFormRs(rs);
				rs.close();
				return p;
			}
		} catch (SQLException e) {e.printStackTrace();}
		return null;
	}
	
	public void save(Produit p) {
		if (p.getId() == 0) {
			try {
				insertOneStatement.clearParameters();
				insertOneStatement.setString(1, p.getLibelle());
				insertOneStatement.setDouble(2, p.getPrix());
				insertOneStatement.setDouble(3, p.getPoids());
				insertOneStatement.executeUpdate();
			} catch (SQLException e) {e.printStackTrace();}
		}
		else {
			try {
				updateOneStatement.clearParameters();
				updateOneStatement.setString(1, p.getLibelle());
				updateOneStatement.setDouble(2, p.getPrix());
				updateOneStatement.setDouble(3, p.getPoids());
				updateOneStatement.setInt(4, p.getId());
				updateOneStatement.executeUpdate();
			} catch (SQLException e) {e.printStackTrace();}
		}
	}
	
	public void delete(int id) {
		try {
			deleteOneStatement.clearParameters();
			deleteOneStatement.setInt(1, id);
			deleteOneStatement.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();}
	}
	// recherche sur libelle avec clause LIKE
	public List<Produit> searchByLibelle(String searchTerm) {
		ArrayList<Produit> produits = new ArrayList<>();
		try {
			searchByLibelleStatement.clearParameters();
			searchByLibelleStatement.setString(1,"%" + searchTerm +"%");
			ResultSet rs = searchByLibelleStatement.executeQuery();
			while (rs.next()) {
				produits.add(fillFormRs(rs));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produits;
	}
	
}
