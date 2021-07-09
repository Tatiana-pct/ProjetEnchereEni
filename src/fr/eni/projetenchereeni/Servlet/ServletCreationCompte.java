package fr.eni.projetenchereeni.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetenchereeni.bll.BusinessException;
import fr.eni.projetenchereeni.bll.UtilisateurManager;
import fr.eni.projetenchereeni.bo.Utilisateur;
import fr.eni.projetenchereeni.dal.DALException;
import fr.eni.projetenchereeni.message.LecteurMessage;

/**@author tatiana
 * Servlet implementation class ServletCreationCompte
 */

@WebServlet(name="/ServletCreationCompte",
			urlPatterns = {"/CreationCompte", "/MofiderProfil"})
public class ServletCreationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//transfere de l'affichage a la jsp
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/CreationCompte.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		
		//recuperation des champs du formulaire
		
		String pseudo = request.getParameter("pseudo");
		String nom= request.getParameter("nom");
		String prenom= request.getParameter("prenom");
		String mail= request.getParameter("mail");
		String telephone= request.getParameter("telephone");
		String rue= request.getParameter("rue");
		String codePostale= request.getParameter("codepostale");
		String ville =request.getParameter("ville");
		String motDePasse = request.getParameter("motDePasse");
		String credit= request.getParameter("credit");
		String administrateur = request.getParameter("administrateur");
		
	
		
		try {
			//ajout de l'utilisateur
			Utilisateur u = UtilisateurManager.getInstance().insertUser(pseudo, nom, prenom, mail, telephone, rue, codePostale, ville, motDePasse, credit, administrateur) ;
			
			//connexion de l'utilisateur
			
			session.setAttribute("utilisateurConnecter", u);
			
			//si tout va bien je le connect
			
			response.sendRedirect(request.getContextPath() + "/Acceuil");
		
			
		
			
		} catch (BusinessException e) {
			request.setAttribute("pseudo",pseudo);
			request.setAttribute("nom",nom);
			request.setAttribute("prenom",prenom);
			request.setAttribute("email",mail);
			request.setAttribute("telephone",telephone);
			request.setAttribute("rue",rue);
			request.setAttribute("codePostal",codePostale);
			request.setAttribute("ville",ville);
			request.setAttribute("motDePasse", motDePasse);
			request.setAttribute("credit", credit);
			request.setAttribute("administrateur", motDePasse);
			
			request.setAttribute("lecteurMessage", new LecteurMessage());
			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
			
		} catch (DALException e) {
			// Sinon je retourne à la page d'inscription pour indiquer les problèmes:
			e.printStackTrace();
			request.setAttribute("listeCodesErreur", e.getMessage());
			rd = request.getRequestDispatcher("/WEB-INF/jsp/CreationCompte.jsp");
			rd.forward(request, response);

		}
	}
}

