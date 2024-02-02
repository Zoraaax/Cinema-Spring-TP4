package fr.valentin.springtp4.realisateur.dto;

import fr.valentin.springtp4.film.dto.FilmReduitPourRealisateurDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RealisateurAvecFilmDto {
    private String nom;
    private String prenom;
    private List<FilmReduitPourRealisateurDto> films = new ArrayList<>();
}

