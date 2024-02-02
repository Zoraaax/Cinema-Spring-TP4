package fr.valentin.springtp4.film.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FilmReduitPourRealisateurDto {
    private String titre;
    private LocalDate dateSortie;
}

