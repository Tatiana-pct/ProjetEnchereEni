/**
 * 
 */
package fr.eni.projetenchereeni.bo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/** Classe par enchère
 * @author Jm
 *
 */


public class Enchere implements Serializable {

	private static final long serialVersionUID = 7151174113111632178L;
	
	private int numEnchere;
	private Utilisateur numUtil;
	private Article Article;
	private LocalDateTime dateEnchere;
	private int prixEnchere;
	private int prixInitial;
	
	
	/** Constructeur sans parametre
	 * 
	 */
	public Enchere() {
		super();
	}


	/** Constructeur complet
	 * @param numEnchere
	 * @param numUtil
	 * @param article
	 * @param dateEnchere
	 * @param prixEnchere
	 * @param prixInitial
	 */
	public Enchere(int numEnchere, Utilisateur numUtil, Article article, LocalDateTime dateEnchere,
			int prixEnchere, int prixInitial) {
		super();
		this.numEnchere = numEnchere;
		this.numUtil = numUtil;
		Article = article;
		this.dateEnchere = dateEnchere;
		this.prixEnchere = prixEnchere;
		this.prixInitial = prixInitial;
	}


	/** Constructeur sans Id (NumEnchere)
	 * @param numUtil
	 * @param article
	 * @param dateEnchere
	 * @param prixEnchere
	 * @param prixInitial
	 */
	public Enchere(Utilisateur numUtil, Article article, LocalDateTime dateEnchere, int prixEnchere,
			int prixInitial) {
		super();
		this.numUtil = numUtil;
		Article = article;
		this.dateEnchere = dateEnchere;
		this.prixEnchere = prixEnchere;
		this.prixInitial = prixInitial;
	}


	public int getNumEnchere() {
		return numEnchere;
	}


	public void setNumEnchere(int numEnchere) {
		this.numEnchere = numEnchere;
	}


	public Utilisateur getNumUtil() {
		return numUtil;
	}


	public void setNumUtil(Utilisateur numUtil) {
		this.numUtil = numUtil;
	}


	public Article getArticle() {
		return Article;
	}


	public void setArticle(Article article) {
		Article = article;
	}


	public LocalDateTime getDateEnchere() {
		return dateEnchere;
	}


	public void setDateEnchere(LocalDateTime date) {
		this.dateEnchere = date;
	}


	public int getPrixEnchere() {
		return prixEnchere;
	}


	public void setPrixEnchere(int prixEnchere) {
		this.prixEnchere = prixEnchere;
	}


	public int getPrixInitial() {
		return prixInitial;
	}


	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Article == null) ? 0 : Article.hashCode());
		result = prime * result + ((dateEnchere == null) ? 0 : dateEnchere.hashCode());
		result = prime * result + numEnchere;
		result = prime * result + ((numUtil == null) ? 0 : numUtil.hashCode());
		result = prime * result + prixEnchere;
		result = prime * result + prixInitial;
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
		Enchere other = (Enchere) obj;
		if (Article == null) {
			if (other.Article != null)
				return false;
		} else if (!Article.equals(other.Article))
			return false;
		if (dateEnchere == null) {
			if (other.dateEnchere != null)
				return false;
		} else if (!dateEnchere.equals(other.dateEnchere))
			return false;
		if (numEnchere != other.numEnchere)
			return false;
		if (numUtil == null) {
			if (other.numUtil != null)
				return false;
		} else if (!numUtil.equals(other.numUtil))
			return false;
		if (prixEnchere != other.prixEnchere)
			return false;
		if (prixInitial != other.prixInitial)
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Enchere [numEnchere=");
		builder.append(numEnchere);
		builder.append(", numUtil=");
		builder.append(numUtil);
		builder.append(", Article=");
		builder.append(Article);
		builder.append(", dateEnchere=");
		builder.append(dateEnchere);
		builder.append(", prixEnchere=");
		builder.append(prixEnchere);
		builder.append(", prixInitial=");
		builder.append(prixInitial);
		builder.append("]");
		return builder.toString();
	}

}
