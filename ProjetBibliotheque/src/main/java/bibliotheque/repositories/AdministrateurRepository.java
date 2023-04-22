package bibliotheque.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import bibliotheque.entities.Administrateur;


public interface AdministrateurRepository extends JpaRepository<Administrateur, Long>{
	Optional<Administrateur> findByLogin(String login);

}
