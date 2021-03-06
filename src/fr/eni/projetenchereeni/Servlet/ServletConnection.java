
package fr.eni.projetenchereeni.Servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetenchereeni.bll.UtilisateurManager;
import fr.eni.projetenchereeni.bo.Utilisateur;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/ServletConnection")
public class ServletConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager utilisateurManager = null;
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			
			for(Cookie cookie : cookies) {
				
				if (cookie.getName().equals("EmailouPseudo")) {
                    request.setAttribute("EmailouPseudo", cookie.getValue());
				}
				
				if (cookie.getName().equals("motDePasse")) {
                    request.setAttribute("motDePasse", cookie.getValue());
				}
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Connection.jsp");
		rd.forward(request, response);
				
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
UtilisateurManager newUser = new UtilisateurManager();
		
		String EmailouPseudo = null;
		String motDePasse = null;
		String save = null;
		Utilisateur utilisateur = null;
		
		EmailouPseudo = request.getParameter("EmailouPseudo");
		motDePasse = request.getParameter("motDePasse");
		save = request.getParameter("save");
		
		if(save != null) {
			
			Cookie cookie = new Cookie("EmailouPseudo", EmailouPseudo);
			cookie.setMaxAge(60 * 60 * 24 * 30);
			response.addCookie(cookie);
			
			Cookie cookie2 = new Cookie("motDePasse", motDePasse);
			cookie2.setMaxAge(60 * 60 * 24 * 30);
			response.addCookie(cookie2);
			
		}
		
		
		
		
		try {
	           utilisateur = newUser.getUtilisateursLogin(EmailouPseudo, motDePasse);
	           System.out.println(EmailouPseudo);
	           System.out.println(motDePasse);
	           if(utilisateur == null) {
	                String error = "Mot de passe ou Pseudo incorrect";
	                request.setAttribute("message", error);
	                request.getRequestDispatcher("/WEB-INF/jsp/Connexion.jsp").forward(request,response);
	                
	            } else {
	                HttpSession session = request.getSession();
	                session.setMaxInactiveInterval(5*60);
	                session.setAttribute("utilisateur", utilisateur);
	                response.sendRedirect("/WEB-INF/jsp/AcceuilConnecte.jsp");
	                request.getRequestDispatcher("/WEB-INF/jsp/AcceuilConnecte.jsp").forward(request, response);
	                
	                
	                
	            }
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	}

}