package bibliotheque.entities;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "etiquette")
@Entity
public class Etiquette {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int etiquetteId;
	@Transient
	private String nom;
	
	@ManyToMany(mappedBy = "etiquettes")
	private Set<Livre> livres = new HashSet();
	
	public int getEtiquetteId() {
		return etiquetteId;
	}
	public void setEtiquetteId(int etiquetteId) {
		this.etiquetteId = etiquetteId;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(etiquetteId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etiquette other = (Etiquette) obj;
		return etiquetteId == other.etiquetteId;
	}
	
	
	
	
	
}
