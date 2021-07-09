/**
 * 
 */
package fr.eni.projetenchereeni.dal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetenchereeni.bll.BusinessException;
import fr.eni.projetenchereeni.bo.Utilisateur;

/**
 * @author Jm
 *
 */
public interface UtilisateurDAO {


	public void insertUser(Utilisateur utilisateurs) throws BusinessException, DALException;
	public Utilisateur updateUser(Utilisateur utilisateurs);
	public boolean deleteUser(int noUtilisateur) throws BusinessException;
	public ArrayList<String> selectAllEmail();
	public ArrayList<String> selectAllPseudo();
	public Utilisateur selectLogin(String EmailouPseudo, String motDePasse);
	public boolean verifEmail(String email, int id);
	public boolean verifPseudo(String pseudo, int id);
	public void updateCredit(Utilisateur utilisateur) throws BusinessException, SQLException;
	public Utilisateur selectPseudo(String pseudo) throws BusinessException;
	public Utilisateur selectId(int id) throws BusinessException;
	
}
