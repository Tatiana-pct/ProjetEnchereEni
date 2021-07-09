package fr.eni.projetenchereeni.bll;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.projetenchereeni.bo.Utilisateur;
import fr.eni.projetenchereeni.dal.DALException;
import fr.eni.projetenchereeni.dal.DAOFactory;
import fr.eni.projetenchereeni.dal.UtilisateurDAO;

public class UtilisateurManager {


	private static UtilisateurManager instance;
	
	private UtilisateurDAO utilisateursDAO;
	
	public UtilisateurManager() {
		
		this.utilisateursDAO = DAOFactory.getUtilisateurDAO();
	}
	
	public Utilisateur insertUser(String pseudo, String nom, String prenom, String mail, String telephone,
			String rue, String codePostale, String ville, String motDePasse, String credit,
			String administrateur) throws BusinessException, DALException {
		
		Utilisateur utilisateur = new Utilisateur();
	
		utilisateur.setPseudo(pseudo);
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		utilisateur.setMail(mail);
		utilisateur.setTelephone(telephone);
		utilisateur.setRue(rue);
		utilisateur.setCodePostal(codePostale);
		utilisateur.setVille(ville);
		utilisateur.setMotDePasse(motDePasse);
		utilisateur.setCredit(0);
		utilisateur.setAdministrateur(false);
		
		if(verifMail(mail) == true && verifPseudo(pseudo) == true) {
			this.utilisateursDAO.insertUser(utilisateur); 
			System.out.println("CPALAMERDE");
			
		}else {
			//throw new BusinessException("L'email est déjà utilisé, veuillez en utiliser un autre.");
			
			System.out.println("CLAMERDE");
		}
		return utilisateur;
		
	}

	public Boolean verifMail (String mail) {
		
		ArrayList<String> listMail = utilisateursDAO.selectAllEmail();
		
		for (String email : listMail) {
			
			if(mail.equals(email)) return false;
				
		}
		
		return true;
		
	}
	
	public Boolean verifPseudo (String pseudo2) {
		
		ArrayList<String> listPseudo = utilisateursDAO.selectAllPseudo();
		
		for (String pseudo : listPseudo) {
			
			if(pseudo2.equals(pseudo)) return false;
				
		}
		
		return true;
		
	}
	
	public Utilisateur getUtilisateursLogin(String EmailouPseudo, String motDePasse) {
		
		Utilisateur utilisateur = null;
		
		
		try {
			
			utilisateur = utilisateursDAO.selectLogin(EmailouPseudo, motDePasse);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		return utilisateur;
			
	}
		
	

	public boolean verifUtilisateurLogin(String EmailouPseudo) {
	    
		boolean utilisateurExist= false;
	
		boolean verifEmail;
		boolean verifPseudo;
		
	    try {
	    	
	    	verifEmail = utilisateursDAO.verifEmail(EmailouPseudo, 0);
	        verifPseudo = utilisateursDAO.verifPseudo(EmailouPseudo, 0);
	    	
	        if((verifEmail & !verifPseudo)||(!verifEmail & verifPseudo)){
	           
	        	utilisateurExist= true;
	         
	        }
	
	    } catch (Exception e) {
	    	
	        e.printStackTrace();
	        
	    }
	    
	    return utilisateurExist;
	    
	}
	
	public Utilisateur selectId(int id) throws BusinessException {
		Utilisateur utilisateur = null;
		utilisateur = this.utilisateursDAO.selectId(id);
		return utilisateur;
	}
		
		public Utilisateur VerifConnexion(String pseudo, String mdp) throws BusinessException {
			Utilisateur utilisateur = null;
			BusinessException businessException = new BusinessException(pseudo);
			boolean connexion = false;
			utilisateur = this.selectPseudo(pseudo);
			if (!utilisateur.getPseudo().isEmpty()) {
				if (utilisateur.getMotDePasse().equals(mdp)) {
					connexion = true;

				}
			} else {
				businessException.ajouterErreur(CodeResultatBll.PSEUDO_INEXISTANT);
			}
			if (!connexion) {
				businessException.ajouterErreur(CodeResultatBll.ECHEC_CONNEXION_MDP_INCORRECT);
				utilisateur = null;
				return null;
			} else {
				return utilisateur;
			}
		}
		
		public Utilisateur selectPseudo(String pseudo) throws BusinessException {
			Utilisateur utilisateur = null;
			utilisateur = this.utilisateursDAO.selectPseudo(pseudo);
			return utilisateur;
		}
		
		public void AjouterCredit(Utilisateur utilisateur, int debit) throws BusinessException, SQLException {
			BusinessException businessException = new BusinessException(null);
			int credit = utilisateur.getCredit() + debit;
			utilisateur.setCredit(credit);
			this.validerCredit(utilisateur, businessException);

			if (!businessException.hasErreurs()) {

				this.utilisateursDAO.updateCredit(utilisateur);

			} else {
				throw businessException;
			}

		}
		
		private void validerCredit(Utilisateur utilisateur, BusinessException businessException) {
			if (utilisateur.getCredit() < 0) {
				businessException.ajouterErreur(CodeResultatBll.CREDIT_INVALIDE);
			}
		}

		public static UtilisateurManager getInstance() {
			if (instance == null) {
	            return new UtilisateurManager();
	        }
	        return instance;
		}
		
		public Utilisateur update(Utilisateur utilisateur) throws Exception {
	        
			Utilisateur utilisateurReturn = null;
	        
	        boolean verifEmail = utilisateursDAO.verifEmail(utilisateur.getMail(), utilisateur.getNumUtilisateur());
	        boolean verifPseudo = utilisateursDAO.verifPseudo(utilisateur.getPseudo(), utilisateur.getNumUtilisateur());
	        
	        if ((verifEmail) & (verifPseudo)) {
	            throw new Exception("L'email et le pseudo sont déjà présent en base");
	        } else if ((verifEmail) & (!verifPseudo)) {
	            throw new Exception("L'email saisi est déjà utilisé");
	        } else if ((!verifEmail) & (verifPseudo)) {
	            throw new Exception("Le pseudo est déjà pris");
	        } else {
	            try {
	            	
	                utilisateurReturn = utilisateursDAO.updateUser(utilisateur);
	                
	            } catch (Exception e) {
	            	
	            	e.printStackTrace();
	            	
	            }
	        }
	        return utilisateurReturn;
	    }

		public boolean deleteUser(int noUtilisateur) {
			
			boolean verifDelete = false;
			try {
				System.out.println("UtilisateurManger DeleteUser");
				verifDelete = utilisateursDAO.deleteUser(noUtilisateur);
			} catch (Exception e) {

				e.printStackTrace();
				
			}
			if(verifDelete == true) {
				System.out.println("CPASLAMERDE");
			}
			return verifDelete;
		}

		public static Object getUtilisateurManager() {
			// TODO Auto-generated method stub
			return null;
		}

		 

		

		
		}

	
		
		

