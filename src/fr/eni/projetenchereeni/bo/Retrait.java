/**
 * 
 */
package fr.eni.projetenchereeni.bo;

import java.io.Serializable;

/** Classe pour le retrait de l'article
 * @author Jm
 *
 */


public class Retrait implements Serializable {

	private static final long serialVersionUID = 5232004013211383565L;


	private Article numArticle;
	private String rue;
	private String codePostal;
	private String ville;
	Integer noRetrait;



	/** Constructeur sans parametres 
	 * 
	 */
	public Retrait() {
		super();
	}



	/** Constructeur sans id(numArticle)
	 * @param rue
	 * @param codePostal
	 * @param ville
	 */
	public Retrait(String rue, String codePostal, String ville,int noRetrait) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.noRetrait = noRetrait;
	}



	/** Constructeur complet
	 * @param numArticle
	 * @param rue
	 * @param codePostal
	 * @param ville
	 */
	public Retrait(Article numArticle, String rue, String codePostal, String ville) {
		super();
		this.numArticle = numArticle;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}



	/**
	 * @return the numArticle
	 */
	public Article getNumArticle() {
		return numArticle;
	}

	/**
	 * @param numArticle the numArticle to set
	 */
	public void setNumArticle(Article numArticle) {
		this.numArticle = numArticle;
	}

	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	public Integer getNoRetrait() {
		return noRetrait;
	}

	public void setNoRetrait(int noRetrait) {
		this.noRetrait = noRetrait;
	}








	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Retrait [numArticle=");
		builder.append(numArticle);
		builder.append(", rue=");
		builder.append(rue);
		builder.append(", codePostal=");
		builder.append(codePostal);
		builder.append(", ville=");
		builder.append(ville);
		builder.append(", noRetrait=");
		builder.append(noRetrait);
		builder.append("]");
		return builder.toString();
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codePostal == null) ? 0 : codePostal.hashCode());
		result = prime * result + ((numArticle == null) ? 0 : numArticle.hashCode());
		result = prime * result + ((rue == null) ? 0 : rue.hashCode());
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
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
		Retrait other = (Retrait) obj;
		if (codePostal == null) {
			if (other.codePostal != null)
				return false;
		} else if (!codePostal.equals(other.codePostal))
			return false;
		if (numArticle == null) {
			if (other.numArticle != null)
				return false;
		} else if (!numArticle.equals(other.numArticle))
			return false;
		if (rue == null) {
			if (other.rue != null)
				return false;
		} else if (!rue.equals(other.rue))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}




}
