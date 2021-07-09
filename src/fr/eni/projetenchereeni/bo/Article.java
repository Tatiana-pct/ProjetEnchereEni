/**
 * 
 */
package fr.eni.projetenchereeni.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/** Classe pour Article
 * @author Jm
 *
 */

public class Article implements Serializable{

	private static final long serialVersionUID = -8029870420901422359L;
	
	
	private int numArticle;
    private String nomArticle;
    private String description;
    private Date dateDebutEnchere;
    private Date dateFinEnchere;
    private int prixInitial;
    private int prixVente;
    private Categorie numCategorie; 
    private Utilisateur numVendeur;
    private Retrait retrait;
    
        
	/** Constructeur sans parametres
	 * 
	 */
	public Article() {
		super();
	}


	/** Constructeur Complet
	 * @param numArticle
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEnchere
	 * @param dateFinEnchere
	 * @param prixInitial
	 * @param prixVente
	 * @param numCategorie
	 * @param numVendeur
	 * @param retrait
	 */
	public Article(int numArticle, String nomArticle, String description, Date dateDebutEnchere, Date dateFinEnchere,
			int prixInitial, int prixVente, Categorie numCategorie, Utilisateur numVendeur, Retrait retrait) {
		super();
		this.numArticle = numArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.numCategorie = numCategorie;
		this.numVendeur = numVendeur;
		this.retrait = retrait;
	}
	

	/** Constructeur sans id (numArticle)
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEnchere
	 * @param dateFinEnchere
	 * @param prixInitial
	 * @param prixVente
	 * @param numCategorie
	 * @param numVendeur
	 * @param retrait
	 */
	public Article(String nomArticle, String description, Date dateDebutEnchere, Date dateFinEnchere, int prixInitial,
			int prixVente, Categorie numCategorie, Utilisateur numVendeur, Retrait retrait) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.numCategorie = numCategorie;
		this.numVendeur = numVendeur;
		this.retrait = retrait;
	}

	

	/** Constructeur sans id et Retrait
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEnchere
	 * @param dateFinEnchere
	 * @param prixInitial
	 * @param prixVente
	 * @param numCategorie
	 * @param numVendeur
	 */
	public Article(String nomArticle, String description, Date dateDebutEnchere, Date dateFinEnchere, int prixInitial,
			int prixVente, Categorie numCategorie, Utilisateur numVendeur) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.numCategorie = numCategorie;
		this.numVendeur = numVendeur;
	}


	//TODO COnstructeurs
	

	/**
	 * @return the numArticle
	 */
	public int getNumArticle() {
		return numArticle;
	}


	/**
	 * @param numArticle the numArticle to set
	 */
	public void setNumArticle(int numArticle) {
		this.numArticle = numArticle;
	}


	/**
	 * @return the nomArticle
	 */
	public String getNomArticle() {
		return nomArticle;
	}


	/**
	 * @param nomArticle the nomArticle to set
	 */
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the dateDebutEnchere
	 */
	public Date getDateDebutEnchere() {
		return dateDebutEnchere;
	}


	/**
	 * @param dateDebutEnchere the dateDebutEnchere to set
	 */
	public void setDateDebutEnchere(Date dateDebutEnchere) {
		this.dateDebutEnchere = dateDebutEnchere;
	}


	/**
	 * @return the dateFinEnchere
	 */
	public Date getDateFinEnchere() {
		return dateFinEnchere;
	}


	/**
	 * @param dateFinEnchere the dateFinEnchere to set
	 */
	public void setDateFinEnchere(Date dateFinEnchere) {
		this.dateFinEnchere = dateFinEnchere;
	}


	/**
	 * @return the prixInitial
	 */
	public int getPrixInitial() {
		return prixInitial;
	}


	/**
	 * @param prixInitial the prixInitial to set
	 */
	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}


	/**
	 * @return the prixVente
	 */
	public int getPrixVente() {
		return prixVente;
	}


	/**
	 * @param prixVente the prixVente to set
	 */
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}


	/**
	 * @return the numCategorie
	 */
	public Categorie getNumCategorie() {
		return numCategorie;
	}


	/**
	 * @param numCategorie the numCategorie to set
	 */
	public void setNumCategorie(Categorie numCategorie) {
		this.numCategorie = numCategorie;
	}


	/**
	 * @return the vendeur
	 */
	public Utilisateur getNumVendeur() {
		return numVendeur;
	}


	/**
	 * @param vendeur the vendeur to set
	 */
	public void setNumVendeur(Utilisateur vendeur) {
		this.numVendeur = vendeur;
	}


	/**
	 * @return the retrait
	 */
	public Retrait getRetrait() {
		return retrait;
	}


	/**
	 * @param retrait the retrait to set
	 */
	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Article [numArticle=");
		builder.append(numArticle);
		builder.append(", nomArticle=");
		builder.append(nomArticle);
		builder.append(", description=");
		builder.append(description);
		builder.append(", dateDebutEnchere=");
		builder.append(dateDebutEnchere);
		builder.append(", dateFinEnchere=");
		builder.append(dateFinEnchere);
		builder.append(", prixInitial=");
		builder.append(prixInitial);
		builder.append(", prixVente=");
		builder.append(prixVente);
		builder.append(", numCategorie=");
		builder.append(numCategorie);
		builder.append(", numVendeur=");
		builder.append(numVendeur);
		builder.append(", retrait=");
		builder.append(retrait);
		builder.append("]");
		return builder.toString();
	}


	@Override
	public int hashCode() {
		return Objects.hash(dateDebutEnchere, dateFinEnchere, description, nomArticle, numArticle, numCategorie,
				numVendeur, prixInitial, prixVente, retrait);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		return Objects.equals(dateDebutEnchere, other.dateDebutEnchere)
				&& Objects.equals(dateFinEnchere, other.dateFinEnchere)
				&& Objects.equals(description, other.description) && Objects.equals(nomArticle, other.nomArticle)
				&& numArticle == other.numArticle && Objects.equals(numCategorie, other.numCategorie)
				&& Objects.equals(numVendeur, other.numVendeur) && prixInitial == other.prixInitial
				&& prixVente == other.prixVente && Objects.equals(retrait, other.retrait);
	}

}
    
    