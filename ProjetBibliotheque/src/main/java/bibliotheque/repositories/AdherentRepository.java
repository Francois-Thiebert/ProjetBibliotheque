package bibliotheque.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bibliotheque.entities.Adherent;


public interface AdherentRepository extends JpaRepository<Adherent, Long>{
	@Query("select f from Adherent f where f.id=:id")
	Optional<Adherent> findById(@Param("id") Long id);
	
	@Query("select f from Adherent f where f.nomUtilisateur=:nomUtilisateur")
	Optional<Adherent> findByNomUtilisateur(@Param("nomUtilisateur") String nomUtilisateur);
}

