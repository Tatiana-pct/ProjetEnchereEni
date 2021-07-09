/**
 * 
 */
package fr.eni.projetenchereeni.bo;

import java.io.Serializable;



/** Classe pour catégorie
 * @author Jm
 *
 */


public class Categorie implements Serializable {

	private static final long serialVersionUID = 8369803414266445922L;
	
	
	private int numCategorie;
	private String libelle;

	
	/** Constructeur par défaut
	 * 
	 */
	public Categorie() {
		super();
	}
	
	
	/** Constructeur sans id(numCategorie)
	 * @param libelle
	 */
	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
	}


	/** Constructeur complet
	 * @param numCategorie
	 * @param libelle
	 */
	public Categorie(int numCategorie, String libelle) {
		super();
		this.numCategorie = numCategorie;
		this.libelle = libelle;
	}
	
	
	/** 
	 * @return the numCategorie
	 */
	public int getNumCategorie() {
		return numCategorie;
	}
	

	
	/**
	 * @param numCategorie the numCategorie to set
	 */
	public void setNumCategorie(int numCategorie) {
		this.numCategorie = numCategorie;
	}
	
	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	
	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Categorie [numCategorie=");
		builder.append(numCategorie);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append("]");
		return builder.toString();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result + numCategorie;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categorie other = (Categorie) obj;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (numCategorie != other.numCategorie)
			return false;
		return true;
	}
	
	
	
}
