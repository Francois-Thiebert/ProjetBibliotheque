package bibliotheque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bibliotheque.entities.Adherent;
import bibliotheque.exceptions.AdherentException;
import bibliotheque.exceptions.AdministrateurException;
import bibliotheque.repositories.AdherentRepository;
// import bibliotheque.repositories.LivreRepository;


@Service
public class AdherentService {
	
	@Autowired
	private AdherentRepository adherentRepo;

	
	public List<Adherent> getAll() {
		return adherentRepo.findAll();
	}

	public Adherent getById(Long id) {
		if (id == null) {
			throw new AdherentException("id obligatoire");
		}
		return adherentRepo.findById(id).orElseThrow(() -> {
			throw new AdherentException("id inconnu");
		});
	}


	public void delete(Adherent adherent) {
		deleteById(adherent.getId());
	}

	public void deleteById(Long id) {
		@SuppressWarnings("unused")
		Adherent adherent = getById(id);
		adherentRepo.deleteById(id);
	}

	public void createOrUpdate(Adherent adherent) {
		if (adherent.getNom() == null || adherent.getNom().isBlank()) {
			throw new AdherentException("nom obligatoire");
		}
		if (adherent.getPrenom() == null || adherent.getPrenom().isBlank()) {
			throw new AdministrateurException("prénom obligatoire");
		}
		if (adherent.getLogin() == null || adherent.getLogin().isBlank()) {
			throw new AdministrateurException("login obligatoire");
		}
		if (adherent.getPassword() == null || adherent.getPassword().isBlank()) {
			throw new AdministrateurException("mot de passe obligatoire");
		}
		adherentRepo.save(adherent);
	}

	
	
	public void emprunterLivre() {
		
	}
	
	
	public void retournerLivre() {
		
	}
	
	
	public void ajouterFavori() {
		
	}
	
	public void retirerFavori() {
		
	}
	
	
	public void avisLivre() {
		// commentaire + note
	}
	
}
