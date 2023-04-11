package bibliotheque.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bibliotheque.entities.Adherent;
import bibliotheque.entities.Emprunt;
import bibliotheque.entities.Livre;
import bibliotheque.exceptions.EmpruntException;
import bibliotheque.repositories.EmpruntRepository;

@Service
public class EmpruntService {
	
	@Autowired
	private EmpruntRepository empruntRepo;
	
	public List<Emprunt> getAll(){
		return empruntRepo.findAll();
	}
	
	public List<Emprunt> getByLivre(Livre livre){
		return empruntRepo.findByLivre(livre);
	}
	
	public List<Emprunt> getByDateFinDepassee() {
		return empruntRepo.findByDateFinDepassee();
	}
	
	public List<Emprunt> getByEmprunteur(Adherent emprunteur) {
		if (emprunteur == null) {
			throw new EmpruntException("emprunteur obligatoire");
		}
		return empruntRepo.findByEmprunteur(emprunteur);
	}
	
	public List<Emprunt> getByArchive(LocalDate date) {
		if (date == null) {
			throw new EmpruntException("date obligatoire");
		}
		return empruntRepo.findByArchive(date);
	}
	
	public List<Emprunt> getByRendu(boolean rendu){
		return empruntRepo.findByRendu(rendu);
	}
	
	public Emprunt getById(Long id) {
		if (id == null) {
			throw new EmpruntException("Id obligatoire");
		}
		return empruntRepo.findById(id).orElseThrow(() -> {
			throw new EmpruntException("Id d'emprunt inconnu");
		});
	}
	
	public void delete(Emprunt emprunt) {
		deleteById(emprunt.getId());
	}
	
	public void deleteById (Long id) {
		empruntRepo.delete(getById(id));
	}
	
	
	public void createOrUpdate(Emprunt emprunt) {
		if (emprunt.getLivre()==null) {
			throw new EmpruntException("Un livre doit être renseigné pour créer l'emprunt");
		}
		if (emprunt.getEmprunteur()==null) {
			throw new EmpruntException("Un emprunteur doit être renseigné pour créer l'emprunt");
		}
		if (emprunt.getDateDebut()!=LocalDate.now()) {
			throw new EmpruntException("La date date du début d'emprunt doit être aujourd'hui");
		}
		if (emprunt.getDateDebut()!=(LocalDate.now().plusDays(21))) {
			throw new EmpruntException("La date date de retour ne peut pas excéder 3 semaines");
		}
		empruntRepo.save(emprunt);
	}
	
}
