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
import fr.eni.projetenchereeni.bo.Enchere;
import fr.eni.projetenchereeni.bo.Utilisateur;

/**
 * @author Jm
 *
 */
public class EnchereDAOJdbcImpl implements EnchereDAO {


	private static final String insert= "INSERT INTO ENCHERES VALUES (?,?,?,?)";

	private static final String selectAll= "SELECT no_utlisateur, no_article, date_enchere, montant_enchere FROM ENCHERES";

	private static final String selectByIdArticle ="SELECT e.no_article, a.no_article, u.no_utilisateur, e.date_enchere, e.montant_enchere, e.no_utilisateur,"
			+ " u.pseudo, a.prix_vente, a.prix_initial, a.date_fin_encheres"
			+ "FROM ARTICLES_VENDUS a INNER JOIN ENCHERES e ON a.no_article = e.no_article"
			+ "INNER JOIN UTILISATEURS u ON a.no_utilisateur = u.no_utilisateur AND a.no_utilisateur = u.no_utilisateur WHERE e.no_article=?";

	private static final String selectByUtil ="SELECT e.no_article, a.no_article, u.no_utilisateur, e.date_enchere, e.montant_enchere, e.no_utilisateur,"
			+ "	 u.pseudo, a.prix_vente, a.prix_initial, a.date_fin_encheres"
			+ "	FROM ARTICLES_VENDUS a INNER JOIN ENCHERES e ON a.no_article = e.no_article"
			+ "	NNER JOIN UTILISATEURS u ON a.no_utilisateur = u.no_utilisateur AND a.no_utilisateur = u.no_utilisateur WHERE u.no_utilisateur=?";

	private static final String delete ="DELETE FROM ENCHERES WHERE no_article=?";




	@Override
	public void insert(Enchere enchere) {

		try {
			Connection cnx = ConnectionProvider.getConnection();

			PreparedStatement pstmt = cnx.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1,enchere.getNumUtil().getNumUtilisateur() );
			pstmt.setInt(2,enchere.getArticle().getNumArticle());
			pstmt.setDate(3, (Date) enchere.getDateEnchere());
			pstmt.setInt(4,enchere.getPrixEnchere());

			pstmt.executeUpdate();
			ResultSet rsNumEchere = pstmt.getGeneratedKeys();
			if(rsNumEchere.next()) {
				enchere.setNumEnchere(rsNumEchere.getInt(1));
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Enchere> selectAll() {
		List<Enchere> listeEnchere = new ArrayList<Enchere>();
		PreparedStatement pstmt=null;
		try {
			Connection cnx = ConnectionProvider.getConnection();
			pstmt = cnx.prepareStatement(selectAll);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				Enchere enchere = new Enchere();
				enchere.setArticle((Article) rs.getObject("no_article"));
				enchere.setNumUtil((Utilisateur) rs.getObject("no_utilisateur"));
				enchere.setDateEnchere(rs.getDate("date_enchere"));
				enchere.setPrixEnchere(rs.getInt("montant_enchere"));

				listeEnchere.add(enchere);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listeEnchere;
	}


	@Override
	public void delete(int noArticle) {
		try {
			Connection cnx = ConnectionProvider.getConnection();

			PreparedStatement pstmt = cnx.prepareStatement(delete);
			pstmt.setInt(1,noArticle);
			pstmt.executeUpdate();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Enchere selectByIdArticle(int noArticle) {
		Enchere enchere = new Enchere();
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(selectByIdArticle);
			pstmt.setInt(1, noArticle);
			pstmt.setInt(2, noArticle);
			ResultSet rs = pstmt.executeQuery(); 

			if (rs.next()) {
				Article article = new Article();
				Utilisateur acheteur = new Utilisateur();
				Utilisateur vendeur = new Utilisateur(); 

				vendeur.setNumUtilisateur(rs.getInt("no_utilisateur"));
				article.setNumArticle(rs.getInt("no_article"));
				article.setNumVendeur(vendeur);
				article.setPrixInitial(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				acheteur.setNumUtilisateur(rs.getInt("no_utilisateur"));


				enchere.setArticle((Article) rs.getObject("no_article"));
				enchere.setNumUtil((Utilisateur) rs.getObject("no_utilisateur"));
				enchere.setDateEnchere(rs.getDate("date_enchere"));
				enchere.setPrixEnchere(rs.getInt("montant_enchere"));	
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return enchere;
	}

	@Override
	public List<Enchere> selectByUtil(int numUtil) {
		List<Enchere> listeEncheres = new ArrayList<Enchere>();
			
			try {
				Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement pstmt = cnx.prepareStatement(selectByUtil);
				pstmt.setInt(1, numUtil);
				ResultSet rs = pstmt.executeQuery();
				Enchere enchere=null;
				Article article = new Article();
				Utilisateur acheteur = new Utilisateur();
				
				while (rs.next()) {
					
					article.setNumArticle(rs.getInt("no_article"));
					acheteur.setNumUtilisateur(rs.getInt("no_utilisateur"));
					enchere = new Enchere();
					enchere.setArticle((Article) rs.getObject("no_article"));
					enchere.setNumUtil((Utilisateur) rs.getObject("no_utilisateur"));
					enchere.setDateEnchere(rs.getDate("date_enchere"));
					enchere.setPrixEnchere(rs.getInt("montant_enchere"));

					listeEncheres.add(enchere);
					
				}
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		return listeEncheres;
	}

}
