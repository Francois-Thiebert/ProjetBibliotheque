package bibliotheque.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bibliotheque.entities.Adherent;


public interface AdherentRepository extends JpaRepository<Adherent, Long>{
	@Query("select a from Adherent a.id=:id")
	Optional<Adherent> findById(@Param("id") Long id);
	
	@Query("select a from Adherent a.nomUtilisateur=:nomUtilisateur")
	Optional<Adherent> findByNomUtilisateur(@Param("nomUtilisateur") String nomUtilisateur);
}

