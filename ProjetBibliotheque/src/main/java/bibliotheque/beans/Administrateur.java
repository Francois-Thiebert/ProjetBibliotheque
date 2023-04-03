package bibliotheque.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="adherent")
@AttributeOverride(name = "id", column = @Column(name="adherent_id"))
@AttributeOverride(name = "nomutilisateur", column = @Column(name="adherent_nomutilisateur", nullable=false))
@AttributeOverride(name = "motdepasse", column = @Column(name="adherent_motdepasse", nullable=false))
public class Administrateur extends Utilisateur{
	@Column(name="mail")
	private String mail;
	
	
	public Administrateur() {
		
	}
	
	public Administrateur(String mail) {
		this.mail=mail;
	}
}