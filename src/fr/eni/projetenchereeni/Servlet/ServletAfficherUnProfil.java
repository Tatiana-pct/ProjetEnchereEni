
package fr.eni.projetenchereeni.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.eni.projetenchereeni.bll.BusinessException;
import fr.eni.projetenchereeni.bll.UtilisateurManager;
import fr.eni.projetenchereeni.bo.Utilisateur;

/**
 * Servlet implementation class ServletAfficherUnProfil
 */
@WebServlet("/ServletAfficherUnProfil")
public class ServletAfficherUnProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UtilisateurManager utilisateurManager = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idEnString = request.getParameter("id");
		if (idEnString != null) {
			try {
				int noUtilisateur = Integer.parseInt(idEnString);
				UtilisateurManager utilisateurManager = new UtilisateurManager();
				Utilisateur utilisateur = utilisateurManager.selectId(noUtilisateur);
				request.setAttribute("sessionUtilisateur", utilisateur);
				request.setAttribute("valider", 1);
			} catch (BusinessException e) {
				e.printStackTrace();
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/MonProfil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/ModifierProfil.jsp");
	}

}
