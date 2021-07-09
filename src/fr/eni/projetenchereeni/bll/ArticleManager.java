package fr.eni.projetenchereeni.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projetenchereeni.bo.Article;
import fr.eni.projetenchereeni.bo.Retrait;
import fr.eni.projetenchereeni.dal.ArticleDAO;
import fr.eni.projetenchereeni.dal.DALException;
import fr.eni.projetenchereeni.dal.DAOFactory;

public class ArticleManager implements ArticleDAO{
	ArticleDAO articleDAO;
	
	public ArticleManager() {
		this.articleDAO = DAOFactory.getArticleDAO();
	
	}

	@Override
	public Article selectById(int numArticle) {
		Article article = this.articleDAO.selectById(numArticle);
		return article;
	
	}

	@Override
	public List<Article> selectAll() {
		List<Article> article = new ArrayList<Article>();
		article = this.articleDAO.selectAll();
		return article;
	}

	@Override
	public List<Article> selectByCat(int numCategorie) throws DALException {
		List<Article>articles = new ArrayList<Article>();
		articles = this.articleDAO.selectByCat(numCategorie);
		return articles;
	}

	@Override
	public List<Article> selectByNom(String recherche) {
		List<Article>articles = new ArrayList<Article>();
		articles= this.articleDAO.selectByNom(recherche);
		return articles;
	}

	

	@Override
	public void update(Article article) {
		this.articleDAO.update(article);
		return;
	}

	@Override
	public void delete(Article article) {
		this.articleDAO.delete(article);
	}

	public void insert(Article article, Retrait retrait) {
		this.articleDAO.insert(article, retrait);
	}

}
