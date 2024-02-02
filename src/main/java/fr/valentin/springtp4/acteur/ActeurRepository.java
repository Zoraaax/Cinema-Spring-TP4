package fr.valentin.springtp4.acteur;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ActeurRepository extends  JpaRepository<Acteur, Integer>{

    Optional<Object> findActeurById(Integer id);

    Optional<Object> findActeurByPrenom(String prenom);

    Optional<Acteur> findActeurByNom(String nom);
}

