package fr.valentin.springtp4.film;

import fr.valentin.springtp4.realisateur.Realisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface FilmRepository extends  JpaRepository<Film, Integer>{
    Optional<Film> findByTitre(String titre);
    Optional<Film> findByDateSortieAfter(LocalDate date);
    Optional<Film> findByRealisateurId(Integer id);
}

