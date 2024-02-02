package fr.valentin.springtp4.realisateur;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RealisateurRepository extends  JpaRepository<Realisateur, Integer>{
    Optional<Realisateur> findById(int id);
    Optional<Realisateur> findByNom(String nom);
}

