/**
 * 
 */
package fr.eni.projetenchereeni.dal;

/**
 * @author Jm
 *
 */
public abstract class DAOFactory {


	public static UtilisateurDAO getUtilisateurDAO() 
	{
		return new UtilisateursDAOJdbcImpl();
	}
	
	public static ArticleDAO getArticleDAO() 
	{
		return new ArticleDAOJdbcImpl();
	}
	
	public static EnchereDAO getEnchereDAO()
	{
		return new EnchereDAOJdbcImpl();
	}
	
	public static CategorieDAO getCategorieDAO()
	{
		return new CategorieDAOJdbcImpl();
	}
	
	public static RetraitDAO getRetraitDAO() 
	{
	return new RetraitDAOJdbcImpl()	;
	}

	
}
