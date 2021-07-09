package fr.eni.projetenchereeni.bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetenchereeni.bo.Retrait;
import fr.eni.projetenchereeni.dal.DAOFactory;
import fr.eni.projetenchereeni.dal.RetraitDAO;


public class RetraitManager {

	private RetraitDAO retraitDAO;

public RetraitManager() {
		
		this.retraitDAO = DAOFactory.getRetraitDAO();
	}

	public Retrait insert(Retrait retrait) throws BusinessException {
		BusinessException businessException = new BusinessException(null);
		this.validerRetrait(retrait, businessException);
		if (!businessException.hasErreurs()) {
			retrait = this.retraitDAO.insert(retrait);
		}
		return retrait;
	}


	public Retrait selectId(int id) throws BusinessException {
		Retrait retrait = this.retraitDAO.selectId(id);
		return retrait;
	}
	public void update(Retrait retrait, int id) throws BusinessException, SQLException {
		BusinessException businessException = new BusinessException(null);
		this.validerRetrait(retrait, businessException);
		if (!businessException.hasErreurs()) {
			this.retraitDAO.update(retrait, id);
		}
	}

	public void delete(int id) throws BusinessException {

		this.retraitDAO.delete(id);
	}
	public List<Retrait> selectAll() throws BusinessException {
		List<Retrait> retraits = new ArrayList<Retrait>();
		retraits = this.retraitDAO.SELECT_ALL();
		return retraits;
	}

	

	/**
	 * Méthode en charge de valider le retrait
	 */
	private void validerRetrait(Retrait retrait, BusinessException businessException) {
		this.validerRue(retrait, businessException);
		this.validerCodePostal(retrait, businessException);
		this.validerVille(retrait, businessException);
	}

	/**
	 * Méthode en charge de valider que l'attribut rue n'est pas null et qu'il ne
	 * fait pas plus de 30 lettres
	 */
	private void validerRue(Retrait retrait, BusinessException businessException) {
		if (retrait.getRue() == null || retrait.getRue().length() > 30) {
			businessException.ajouterErreur(CodeResultatBll.RUE_INVALIDE);
		}
	}

	/**
	 * Méthode en charge de verifier que le code postal est composé de 5 chiffres
	 */
	private void validerCodePostal(Retrait retrait, BusinessException businessException) {
		if (retrait.getCodePostal() == null || !(retrait.getCodePostal().length() == 5)
				|| !retrait.getCodePostal().matches("-?\\d+(\\.\\d+)?")) {
			businessException.ajouterErreur(CodeResultatBll.CODE_POSTAL_INVALIDE);
		}
	}

	/**
	 * Méthode en charge de verifier que la ville
	 */
	private void validerVille(Retrait retrait, BusinessException businessException) {
		if (retrait.getVille() == null || retrait.getVille().length() > 30) {
			businessException.ajouterErreur(CodeResultatBll.VILLE_INVALIDE);
		}
	}
}


