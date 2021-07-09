/**
 * 
 */
package fr.eni.projetenchereeni.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projetenchereeni.bo.Enchere;
import fr.eni.projetenchereeni.dal.DAOFactory;
import fr.eni.projetenchereeni.dal.EnchereDAO;

/**
 * @author tatiana
 *
 */
public class EnchereManager {

	EnchereDAO enchereDao;
	
	public EnchereManager() {
		this.enchereDao = DAOFactory.getEnchereDAO();
	
	
	}
	
	
	public Enchere insert(Enchere enchere) {
		this.enchereDao.insert(enchere);
		return enchere;
	}


	public List<Enchere> selectAll() {
		List<Enchere> enchere = new ArrayList<Enchere>();
		enchere = this.enchereDao.selectAll();
		return enchere;
		
	}
	public Enchere selectByIdArticle(int noArticle) {
		Enchere enchere = this.enchereDao.selectByIdArticle(noArticle);
		return enchere;
	}
	public List<Enchere> selectByUtil(int numUtil) {
		List<Enchere>enchere = new ArrayList<Enchere>();
		enchere = this.enchereDao.selectByUtil(numUtil);
		return enchere;
	}
	public void delete(int noArticle) {
		this.enchereDao.delete(noArticle);
		
	}




	
}
