package bibliotheque.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name ="livre")
public class Livre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int livreId;
	@Column(name = "titre", nullable = false, length = 255)
	private String titre;
	@Column(name = "statut", nullable = false)
	private StatutLivre statut;
	
	@ManyToMany
	@JoinTable(
			name = "etiquette_livre",
			joinColumns = @JoinColumn(name  ="livre_id"),
			inverseJoinColumns = @JoinColumn(name = "etiquette_id"))
	Set<Etiquette> EtiquettesLivre;
	
	
	
	//relation favori
	//relation avis
	//relation emprunt
	
	
	
	
}