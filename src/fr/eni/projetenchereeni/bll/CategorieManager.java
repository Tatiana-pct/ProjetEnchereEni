
package fr.eni.projetenchereeni.bll;

import java.sql.SQLException;
import java.util.List;

import fr.eni.projetenchereeni.bo.Categorie;
import fr.eni.projetenchereeni.dal.CategorieDAO;
import fr.eni.projetenchereeni.dal.DALException;
import fr.eni.projetenchereeni.dal.DAOFactory;

/**
 * @author "niic0las"
 *
 */
public class CategorieManager {
	
	private CategorieDAO categorieDAO;
	
	/* 
	 * Constructeur de CategorieManager 
	 */
	public CategorieManager( ) {
		this.categorieDAO = DAOFactory.getCategorieDAO();
	}

	public void insertCategorie(int numCategorie, String libelle) throws DALException {
		Categorie categorie = new Categorie();
		categorie.setNumCategorie(numCategorie);
		categorie.setLibelle(libelle);
		this.categorieDAO.insertCategorie(categorie);
	}
	
	public List<Categorie> selectAllCat() throws DALException, BusinessException, SQLException {
		return categorieDAO.selectAll();
	}
	
	public void deleteCategorie(int numCategorie) throws DALException {
		this.categorieDAO.deleteCategorie(numCategorie);
	}
	
	public void deleteCategorie(String libelle) throws DALException {
		this.categorieDAO.deleteCategorie(libelle);
	}
	
	public List<Categorie> selectAll() throws BusinessException, SQLException {
			List<Categorie> categories = this.categorieDAO.selectAll();
			return categories;
	}
}
	