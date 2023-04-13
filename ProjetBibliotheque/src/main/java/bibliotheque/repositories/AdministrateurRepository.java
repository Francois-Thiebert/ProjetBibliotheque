package bibliotheque.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bibliotheque.entities.Administrateur;


public interface AdministrateurRepository extends JpaRepository<Administrateur, Long>{
	@Query("select f from Administrateur f where f.id=:id")
	Optional<Administrateur> findById(@Param("id") Long id);
	
	@Query("select f from Administrateur f where f.nomUtilisateur=:nomUtilisateur")
	Optional<Administrateur> findByNomUtilisateur(@Param("nomUtilisateur") String nomUtilisateur);
}