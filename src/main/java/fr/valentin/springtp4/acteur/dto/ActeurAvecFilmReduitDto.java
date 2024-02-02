package fr.valentin.springtp4.acteur.dto;

import fr.valentin.springtp4.film.dto.FilmReduitAvecRealisateurDto;
import lombok.Data;
import java.util.List;

@Data
public class ActeurAvecFilmReduitDto {
    private String nom;
    private String prenom;
    private List<FilmReduitAvecRealisateurDto> films;
}

