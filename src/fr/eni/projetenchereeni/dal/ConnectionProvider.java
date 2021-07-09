/**
 * 
 */
package fr.eni.projetenchereeni.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


/**
 * @author Jm
 *
 */
public class ConnectionProvider {
	
	private static DataSource dataSource;
	
	
	/*
	 * Recherche de la data source et acces BDD
	 */
	static
	{
		Context context;
		try {
			context = new InitialContext();
			ConnectionProvider.dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("Impossible d'acceder à la base de donnees");
		}
	}
	
	/*
	 *  Méthode retourne une connection issu du pool de connections
	 */

	public static Connection getConnection() throws SQLException
	{
		return ConnectionProvider.dataSource.getConnection();
	}
	
}
