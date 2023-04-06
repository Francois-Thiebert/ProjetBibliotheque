package bibliotheque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bibliotheque.beans.Administrateur;


public interface AdministrateurRepository extends JpaRepository<Administrateur, Long>{

}
