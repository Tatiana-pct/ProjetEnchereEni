package fr.eni.projetenchereeni.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetenchereeni.bll.UtilisateurManager;
import fr.eni.projetenchereeni.bo.Utilisateur;

/**
 * Servlet implementation class SupprimerProfil
 */
@WebServlet("/SupprimerProfil")
public class ServletSupprimerProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur u = null;
		u = (Utilisateur) request.getSession().getAttribute("sessionUtilisateur");
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		
		utilisateurManager.deleteUser(u.getNumUtilisateur());
		//Récupération et destruction de la session en cours 
		HttpSession session = request.getSession();
		session.invalidate();
		
		// Redirection vers l'accueil ! 
		response.sendRedirect( "./Accueil" );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}