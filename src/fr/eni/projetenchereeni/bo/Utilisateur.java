/**
 * 
 */
package fr.eni.projetenchereeni.bo;

import java.io.Serializable;

/** Classe pour les utilisateurs (clients et administrateurs)
 * @author Jm
 *
 */

//teste git
public class Utilisateur implements Serializable{

	private static final long serialVersionUID = 4131874910530192089L;


	private int numUtilisateur;
	private String nom;
	private String pseudo;
	private String prenom;
	private String mail;
	private String telephone;
	private String rue;
	private String ville;
	private String motDePasse;
	private String codePostal;
	private int credit;
	private boolean administrateur=false;
	



	/** Constructeur sans paramètres
	 * 
	 */
	public Utilisateur() {
		super();
	}



	/** Constructeur sans Id(numUtilisateur)
	 * @param nom
	 * @param pseudo
	 * @param prenom
	 * @param mail
	 * @param telephone
	 * @param rue
	 * @param ville
	 * @param motDePasse
	 * @param codePostal
	 * @param credit
	 * @param administrateur
	 */
	public Utilisateur(String nom, String pseudo, String prenom, String mail, String telephone, String rue,
			String ville, String motDePasse, String codePostal, int credit, boolean administrateur) {
		super();
		this.nom = nom;
		this.pseudo = pseudo;
		this.prenom = prenom;
		this.mail = mail;
		this.telephone = telephone;
		this.rue = rue;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.codePostal = codePostal;
		this.credit = credit;
		this.administrateur = administrateur;
	
	}



	/** Constructeur complet 
	 * @param numUtilisateur
	 * @param nom
	 * @param pseudo
	 * @param prenom
	 * @param mail
	 * @param telephone
	 * @param rue
	 * @param ville
	 * @param motDePasse
	 * @param codePostal
	 * @param credit
	 * @param administrateur
	 */
	public Utilisateur(int numUtilisateur, String nom, String pseudo, String prenom, String mail, String telephone,
			String rue, String ville, String motDePasse, String codePostal, int credit, boolean administrateur) {
		super();
		this.numUtilisateur = numUtilisateur;
		this.nom = nom;
		this.pseudo = pseudo;
		this.prenom = prenom;
		this.mail = mail;
		this.telephone = telephone;
		this.rue = rue;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.codePostal = codePostal;
		this.credit = credit;
		this.administrateur = administrateur;
		
	}



	/**
	 * @return the numUtilisateur
	 */
	public int getNumUtilisateur() {
		return numUtilisateur;
	}



	/**
	 * @param numUtilisateur the numUtilisateur to set
	 */
	public void setNumUtilisateur(int numUtilisateur) {
		this.numUtilisateur = numUtilisateur;
	}



	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}



	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}



	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}



	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}



	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}



	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}



	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}



	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}



	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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



	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}



	/**
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
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
	 * @return the credit
	 */
	public int getCredit() {
		return credit;
	}



	/**
	 * @param credit the credit to set
	 */
	public void setCredit(int credit) {
		this.credit = credit;
	}



	/**
	 * @return the administrateur
	 */
	public boolean isAdministrateur() {
		return administrateur;
	}



	/**
	 * @param administrateur the administrateur to set
	 */
	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (administrateur ? 1231 : 1237);
		result = prime * result + ((codePostal == null) ? 0 : codePostal.hashCode());
		result = prime * result + credit;
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((motDePasse == null) ? 0 : motDePasse.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + numUtilisateur;
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((pseudo == null) ? 0 : pseudo.hashCode());
		result = prime * result + ((rue == null) ? 0 : rue.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
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
		Utilisateur other = (Utilisateur) obj;
		if (administrateur != other.administrateur)
			return false;
		if (codePostal == null) {
			if (other.codePostal != null)
				return false;
		} else if (!codePostal.equals(other.codePostal))
			return false;
		if (credit != other.credit)
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (motDePasse == null) {
			if (other.motDePasse != null)
				return false;
		} else if (!motDePasse.equals(other.motDePasse))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (numUtilisateur != other.numUtilisateur)
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (pseudo == null) {
			if (other.pseudo != null)
				return false;
		} else if (!pseudo.equals(other.pseudo))
			return false;
		if (rue == null) {
			if (other.rue != null)
				return false;
		} else if (!rue.equals(other.rue))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}


	



	



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Utilisateur [numUtilisateur=");
		builder.append(numUtilisateur);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", pseudo=");
		builder.append(pseudo);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", mail=");
		builder.append(mail);
		builder.append(", telephone=");
		builder.append(telephone);
		builder.append(", rue=");
		builder.append(rue);
		builder.append(", ville=");
		builder.append(ville);
		builder.append(", motDePasse=");
		builder.append(motDePasse);
		builder.append(", codePostal=");
		builder.append(codePostal);
		builder.append(", credit=");
		builder.append(credit);
		builder.append(", administrateur=");
		builder.append(administrateur);
		builder.append(", LoginUtilisateur=");
		return builder.toString();
	}





}
