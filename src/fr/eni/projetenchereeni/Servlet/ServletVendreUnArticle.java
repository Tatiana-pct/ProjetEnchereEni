package fr.eni.projetenchereeni.Servlet;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetenchereeni.bll.ArticleManager;
import fr.eni.projetenchereeni.bll.BusinessException;
import fr.eni.projetenchereeni.bll.CategorieManager;
import fr.eni.projetenchereeni.bll.UtilisateurManager;
import fr.eni.projetenchereeni.bo.Article;
import fr.eni.projetenchereeni.bo.Categorie;
import fr.eni.projetenchereeni.bo.Retrait;
import fr.eni.projetenchereeni.bo.Utilisateur;
import fr.eni.projetenchereeni.message.LecteurMessage;


/**
 * Servlet implementation class ServletNouvelleVente
 */
@WebServlet("/ServletVendreUnArticle")

public class ServletVendreUnArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String uploadPath;
	UtilisateurManager utilisateurManager = null;
	Article unArticle = null;
	Retrait unRetrait = null;
	ArticleManager articleManager = null;
	CategorieManager categoriesManager = null;

	@Override
	public void init() throws ServletException {
		utilisateurManager = new UtilisateurManager();
		unArticle = new Article();
		unRetrait = new Retrait();
		articleManager = new ArticleManager();
		categoriesManager = new CategorieManager();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Categorie> categories = categoriesManager.selectAll();
			request.setAttribute("categories", categories);
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/pageVendreUnArticle.jsp").forward(request,
				response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");

		// Recuperer les parametres

		String article = request.getParameter("article");
		String description = request.getParameter("description");
		int categorie = Integer.parseInt(request.getParameter("categorie"));
		int miseAPrix = Integer.parseInt(request.getParameter("prixInitial"));
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String debutEnchere = request.getParameter("debutEnchere");
		String finEnchere = request.getParameter("finEnchere");
		int numeroUtilisateur = Integer.parseInt(request.getParameter("numeroUtilisateur"));
		Date dateDebutEnchere = Date.valueOf(debutEnchere);
		Date dateFinEnchere = Date.valueOf(finEnchere);

		// Je recup les données saisies dans le formulaire et je les attributs à l'objet
		
		unArticle.setNomArticle(article);
		unArticle.setDescription(description);
		unArticle.setDateDebutEnchere(dateDebutEnchere);
		unArticle.setDateFinEnchere(dateFinEnchere);
		unArticle.setPrixInitial(miseAPrix);
		unArticle.setPrixVente(miseAPrix);
		unArticle.setNumVendeur(utilisateur);
		unArticle.setNumArticle(categorie);

		unRetrait.setRue(rue);
		unRetrait.setVille(ville);
		unRetrait.setCodePostal(codePostal);
		articleManager.insert(unArticle, unRetrait);
		System.out.println("YESSSSSS");
		String MESSAGEREUSSITE = "Nouvelle article mis en vente avec succès";
		request.setAttribute("réussite", MESSAGEREUSSITE);

		// Afficher les articles de la base de données
		
		ArticleManager articleManager = new ArticleManager();
		List<Article> listeArticle = null;
		listeArticle = articleManager.selectAll();
		request.setAttribute("listeArticle", listeArticle);
		
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/AcceuilConnecte");
		rd.forward(request, response);

	}

	
}