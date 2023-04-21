package bibliotheque.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="adherent")
public class Administrateur extends Utilisateur{
	
	
	@Column(name="adresse_electronique")
	private String mail;
	
	
	public Administrateur() {		
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}