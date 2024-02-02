package fr.valentin.springtp4.film.dto;

import fr.valentin.springtp4.realisateur.Realisateur;

import java.time.LocalDate;

public class FilmReduitAvecRealisateurDto {
    private String titre;
    private LocalDate dateSortie;
    private Realisateur realisateur;
}
