/**
 * 
 */
package fr.eni.projetenchereeni.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetenchereeni.bo.Article;
import fr.eni.projetenchereeni.bo.Categorie;
import fr.eni.projetenchereeni.bo.Retrait;
import fr.eni.projetenchereeni.bo.Utilisateur;

/** 
 * @author Jm
 *
 */


public class ArticleDAOJdbcImpl implements ArticleDAO {

	//Select 
	public static final String selectById = 
			"SELECT a.no_article, a.nom_article, a.description, a.date_debut_encheres, a.date_fin_encheres, a.prix_initial, a.prix_vente, a.no_categorie, a.no_utilisateur,"
					+ " c.no_categorie, c.libelle FROM ARTICLES_VENDUS a INNER JOIN CATEGORIES c ON a.no_categorie=c.no_categorie WHERE no_article=?";
	public static final String selectByVendeur = 
			"SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_categorie, no_utilisateur"
					+ " FROM ARTICLES_VENDUS WHERE no_utilisateur=?";
	public static final String selectByCat = 
			"SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_categorie, no_utilisateur"
					+ " FROM ARTICLES_VENDUS WHERE no_categorie=?";
	public static final String SelectAll = 
			"SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_categorie, no_utilisateur"
					+ " FROM ARTICLES_VENDUS";

	//insert/update
	public static final String Insert = 
			"INSERT INTO ARTICLES_VENDUS "
					+ "(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_categorie, no_utilisateur) "
					+ "VALUES(?,?,?,?,?,?,?,?)";	

	public static final String Update = 
			"UPDATE ARTICLES_VENDUS SET "
					+ "nom_article=?, description=?, date_debut_enchere=?, date_fin_enchere=?, prix_initial=?, prix_vente=?, no_categorie=?"
					+ "WHERE no_article=?";	

	//delete
	public static final String Delete = 
			"DELETE FROM ARTICLES_VENDUS WHERE no_article=?; ";



	@Override
	public Article selectById(int numArticle) {
		Article article=null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;


		// Obtention d'une connection via le Pool
		try {
			Connection cnx = ConnectionProvider.getConnection();
			// Prepparation requete	
			pstmt = cnx.prepareStatement(selectById);
			pstmt.setInt(1, numArticle);
			// Execution	
			rs = pstmt.executeQuery();
			//Article trouvé	
			if (rs.next()) {
				Utilisateur numUtil = new Utilisateur();
				Categorie numCat = new Categorie();

				article = new Article(rs.getString("nom_article"),
						rs.getString("description"),
						rs.getDate("date_debut_encheres"),
						rs.getDate("date_fin_encheres"),
						rs.getInt("prix_initial"),
						rs.getInt("prix_vente"),
						numCat,
						numUtil);


			}	

		} catch (SQLException e) {
			e.printStackTrace();
		}					
		return article;
	}


	@Override
	public List<Article> selectAll() {
		List<Article> listeArticle = new ArrayList<Article>();
		PreparedStatement pstmt=null;

		try {
			Connection cnx = ConnectionProvider.getConnection();

			pstmt = cnx.prepareStatement(SelectAll);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Article article = new Article();
				article.setNumArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEnchere(rs.getDate("date_debut_encheres"));
				article.setDateFinEnchere(rs.getDate("date_debut_encheres"));
				article.setPrixInitial(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setNumVendeur((Utilisateur) rs.getObject("no_utilisateur"));
				article.setNumCategorie((Categorie) rs.getObject("no_utilisateur"));

				listeArticle.add(article);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listeArticle;
	}



	@Override
	public List<Article> selectByCat(int numCategorie)  {
		List<Article> listeArticle = new ArrayList<Article>();
		try (
				Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement pstt = cnx.prepareStatement(selectByCat);
				) {

			pstt.setInt(1, numCategorie);
			ResultSet rs = pstt.executeQuery();

			while (rs.next()) {
				Article article = new Article();

				article.setNumArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEnchere(rs.getDate("date_debut_encheres"));
				article.setDateFinEnchere(rs.getDate("date_debut_encheres"));
				article.setPrixInitial(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));


				listeArticle.add(article);
			}

		}  catch (SQLException e) {
			e.printStackTrace();
		}

		return listeArticle;
	}



	public void insert(Article article, Retrait retrait) {

		// Obtention d'une connection via le Pool
		try {
			Connection cnx = ConnectionProvider.getConnection();

			//PrÃ©paration requete	
			PreparedStatement pstmt = cnx.prepareStatement(Insert,PreparedStatement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, article.getNomArticle());
			pstmt.setString(2, article.getDescription());
			pstmt.setDate(3, (Date) article.getDateDebutEnchere());
			pstmt.setDate(4, (Date) article.getDateFinEnchere());
			pstmt.setInt(5, article.getPrixInitial());
			pstmt.setInt(6, article.getPrixVente());		
			pstmt.setInt(7, article.getNumVendeur().getNumUtilisateur());
			pstmt.setInt(8, article.getNumCategorie().getNumCategorie());

			//execution requete			
			pstmt.executeUpdate();
			//rajouter le no_article  genere par la BDD	
			ResultSet rsNumArticle = pstmt.getGeneratedKeys();
			if(rsNumArticle.next()) {
				article.setNumArticle(rsNumArticle.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	@Override
	public void update(Article article) {
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(Update);
			pstmt.setString(1, article.getNomArticle());
			pstmt.setString(2, article.getDescription());
			pstmt.setDate(3, (Date) article.getDateDebutEnchere());
			pstmt.setDate(4, (Date) article.getDateFinEnchere());
			pstmt.setInt(5, article.getPrixInitial());
			pstmt.setInt(6, article.getPrixVente());
			pstmt.setInt(7, article.getNumVendeur().getNumUtilisateur());
			pstmt.setInt(8, article.getNumCategorie().getNumCategorie());

			int res = pstmt.executeUpdate();
			if (res !=1 ) {
				throw new Exception("Update error");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Article article) {		
		try {
			Connection cnx = ConnectionProvider.getConnection();

			PreparedStatement pstmt = cnx.prepareStatement(Delete);
			pstmt.setInt(1, article.getNumArticle());
			pstmt.executeUpdate();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	@Override
	public List<Article> selectByNom(String recherche) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
