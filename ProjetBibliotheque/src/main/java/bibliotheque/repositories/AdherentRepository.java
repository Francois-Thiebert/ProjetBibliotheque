package bibliotheque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bibliotheque.entities.Adherent;


public interface AdherentRepository extends JpaRepository<Adherent, Long>{

}
