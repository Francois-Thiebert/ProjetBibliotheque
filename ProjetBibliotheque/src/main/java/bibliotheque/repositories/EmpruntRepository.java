package bibliotheque.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bibliotheque.entities.Adherent;
import bibliotheque.entities.Emprunt;
import bibliotheque.entities.Livre;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {
	
	List<Emprunt> findByEmprunteur (Adherent emprunteur);
	
	List<Emprunt> findByLivre (Livre livre);
	
	@Query("select e from Emprunt e where e.dateFin<=LocalDate.now() and e.rendu=false")
	Optional<Emprunt> findByDateFinDepassee();
	
	@Query("select e from Emprunt e where e.dateFin=:date and e.rendu=true")
	Optional<Emprunt> findByArchive(@Param("date") LocalDate date);
	
	List<Emprunt> findByRendu (boolean rendu);
	
	@Transactional
	@Modifying
	void deleteByEmprunteur (Adherent emprunteur);
	
	@Transactional
	@Modifying
	void deleteByLivre (Livre livre);
	
	
	@Transactional
	@Modifying
	void deleteByRendu (boolean rendu);
}