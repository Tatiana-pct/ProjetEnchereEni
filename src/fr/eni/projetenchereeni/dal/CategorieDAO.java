/**
 * 
 */
package fr.eni.projetenchereeni.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.projetenchereeni.bll.BusinessException;
import fr.eni.projetenchereeni.bo.Categorie;

/**
 * @author "niic0las"
 *
 */
public interface CategorieDAO {

	public void insertCategorie(Categorie categorie) throws DALException;
	List<Categorie> selectAllcat() throws DALException;
	public void deleteCategorie(int noCategorie) throws DALException;
	public void deleteCategorie(String libelle) throws DALException;
	public Categorie selectByIdCat(int noCategorie) throws DALException;
	public void update(Categorie categorie) throws DALException ;
	public List<Categorie> selectAll() throws BusinessException, SQLException;


	
	
}
