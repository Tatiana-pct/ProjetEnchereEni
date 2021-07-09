package fr.eni.projetenchereeni.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.projetenchereeni.bll.BusinessException;
import fr.eni.projetenchereeni.bo.Retrait;

/**
 * @author "niic0las"
 *
 */

public interface RetraitDAO {
	
	public List<Retrait> SELECT_ALL() throws BusinessException;
	public Retrait insert(Retrait retrait) throws BusinessException;
	public Retrait selectId(int id) throws BusinessException;
	public void update(Retrait retrait, int id) throws BusinessException, SQLException;
	public Retrait delete(int id) throws BusinessException;
	
}