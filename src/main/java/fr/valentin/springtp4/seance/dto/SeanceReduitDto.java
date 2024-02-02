package fr.valentin.springtp4.seance.dto;

import fr.valentin.springtp4.film.Film;
import fr.valentin.springtp4.film.dto.FilmReduitPourRealisateurDto;
import fr.valentin.springtp4.salle.Salle;
import lombok.Data;

@Data
public class SeanceReduitDto {
    private FilmReduitPourRealisateurDto film;
    private Salle salle;
    private String date;
    private Integer placesDisponibles;
    private float prix;
}
