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




/**
 * Servlet implementation class ServletModificationProfil
 */
@WebServlet("/ServletModificationProfil")
public class ServletModificationProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtilisateurManager utilisateursManager =  null;
    private String message = "";
    private String error= "";

    @Override
    public void init() throws ServletException {
        
    	super.init();
        utilisateursManager = utilisateursManager.getInstance();
        
    }
  

    
 	/**
 	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
 	 */
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ModifierProfil.jsp");
 		rd.forward(request, response);
 	}

 	/**
 	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 	 */
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		Utilisateur u = null;
 		//récuperation de l'utilisateur dans le contexte de session
 		u = (Utilisateur) request.getSession().getAttribute("sessionUtilisateur");
 		
 		//récuperation de tout les champs modifiable depuis la jsp
 		
 		String nom=request.getParameter("nom");
 		String prenom=request.getParameter("prenom");
 		String mail=request.getParameter("mail");
 		String telephone=request.getParameter("telephone");
 		String rue=request.getParameter("rue");
 		String codepostale=request.getParameter("codepostale");
 		String ville=request.getParameter("ville");
 		String motDePasse=request.getParameter("motdepasse");
 		
 		
 		/*
          * recuperation de l'email de l'utilisateur courant 
          * pour verifier dans UtilisateurManager si l'email à été modifié
          * si il a été modifié alors il faudra le valider sinon rien 
          */
 		String emailCourant = u.getMail();
 		
 		//mise à jour de l'utilisateur courant
 		u.setNom(nom);
 		u.setPrenom(prenom);
 		u.setMail(mail);
 		u.setTelephone(telephone);
 	    u.setRue(rue);
 		u.setCodePostal(codepostale);
 		u.setVille(ville);
 		u.setMotDePasse(motDePasse);

 		request.setCharacterEncoding("UTF-8");
 		
 		UtilisateurManager utilisateurManager = new UtilisateurManager();
 		
 		try {
 			utilisateurManager.update(u);
 			request.getSession().setAttribute("sessionUtilisateur", u);
 			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/accueil.jsp");
 			rd.forward(request, response);
 		} catch (BusinessException e) {
 			e.printStackTrace();
 			request.setAttribute("listeCodesErreur",e.getListeCodesErreur());
 			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ModifierProfil.jsp");
 			rd.forward(request, response);
 		}
 		
 	
 	}

 }
