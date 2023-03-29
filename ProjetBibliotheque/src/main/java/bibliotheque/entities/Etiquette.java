package bibliotheque.entities;


import java.util.Objects;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

public class Etiquette {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int etiquetteId;
	@Transient
	private String nom;
	@Transient
	Etiquette parent;
	@ManyToMany(mappedBy = "EtiquettesLivre")
	Set<Etiquette> enfants;
	
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
	public Etiquette getParent() {
		return parent;
	}
	public void setParent(Etiquette parent) {
		this.parent = parent;
	}
	public Set<Etiquette> getEnfants() {
		return enfants;
	}
	public void setEnfants(Set<Etiquette> enfants) {
		this.enfants = enfants;
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
