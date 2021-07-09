/**
 * 
 */
package fr.eni.projetenchereeni.dal;

import java.util.List;

import fr.eni.projetenchereeni.bo.Enchere;

/**
 * @author Jm
 *
 */
public interface EnchereDAO {

	public void insert(Enchere enchere);
	
	public List<Enchere> selectAll();
	
	public Enchere selectByIdArticle(int noArticle);
	
	public List<Enchere> selectByUtil(int numUtil);
	
	public void delete(int noArticle);
	
}
