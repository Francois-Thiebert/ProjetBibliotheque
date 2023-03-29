package bibliotheque.entities;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import bibliotheque.entities.Utilisateur;

@Entity
@Table(name="adherent")
@AttributeOverride(name = "id", column = @Column(name="adherent_id"))
@AttributeOverride(name = "nomutilisateur", column = @Column(name="adherent_nomutilisateur", nullable=false))
@AttributeOverride(name = "motdepasse", column = @Column(name="adherent_motdepasse", nullable=false))
public class Adherent extends Utilisateur{
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	
	@Transient
	@OneToMany(mappedBy = "adherent")
	private List<Emprunt> emprunts;
	@Transient
	@OneToMany(mappedBy = "adherent")
	private List<Livre> favoris;
	
	@Transient
	@OneToMany(mappedBy = "adherent")
	private List<Avis> listeAvis;
	
	
	public Adherent() {
		
	}
	
	public Adherent(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
}
