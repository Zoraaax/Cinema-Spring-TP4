package fr.valentin.springtp4.realisateur.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FilmParRealisateurDto {
    private String titre;
    private LocalDate dateSortie;
    private int duree;
}

