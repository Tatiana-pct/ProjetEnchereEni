/**
 * 
 */
package fr.eni.projetenchereeni.dal;

import java.util.List;

import fr.eni.projetenchereeni.bll.BusinessException;
import fr.eni.projetenchereeni.bo.Article;
import fr.eni.projetenchereeni.bo.Retrait;

/** 
 * @author Jm
 *
 */
public interface ArticleDAO {

	public Article selectById(int numArticle);	
	public List<Article> selectAll();	
	public List<Article> selectByCat(int numCategorie) throws DALException;
	public List<Article> selectByNom(String recherche);
	public void update(Article article);
	public void delete (Article article);
	public void insert(Article article, Retrait retrait);
		

}
