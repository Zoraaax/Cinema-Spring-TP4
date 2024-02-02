package fr.valentin.springtp4.film;

import fr.valentin.springtp4.acteur.dto.ActeurReduitDto;
import fr.valentin.springtp4.film.dto.ActeurSansFilmDto;
import fr.valentin.springtp4.film.dto.FilmCompletDto;
import fr.valentin.springtp4.film.dto.FilmReduitDto;
import fr.valentin.springtp4.realisateur.Realisateur;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {
    private final FilmService filmService;

    private final ObjectMapper objectMapper;

    public FilmController(FilmService filmService, ObjectMapper objectMapper) {
        this.filmService = filmService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public List<FilmReduitDto> findAll() {
        return filmService.findAll().stream().map(
                film -> objectMapper.convertValue(film, FilmReduitDto.class)
        ).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Film save(@RequestBody Film film) {
        return filmService.save(film);

    }

    @GetMapping("/{id}")
    public FilmCompletDto findById(@PathVariable Integer id) {
        Film film = filmService.findById(id);

        return objectMapper.convertValue(film, FilmCompletDto.class);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        filmService.deleteById(id);
    }

    @PutMapping
    public Film update(@RequestBody Film film) {
        return filmService.update(film);
    }

    @GetMapping("/search") // /film/search?titre=toto
    public Film findByTitre(@RequestParam String titre) {
        return filmService.findByTitre(titre);
    }

    @GetMapping("/{id}/acteur")
    public List<ActeurReduitDto> findActeurByFilm(@PathVariable Integer id) {
        return filmService.findActeurByFilm(id).stream().map(
                acteur -> objectMapper.convertValue(acteur, ActeurReduitDto.class)
        ).toList();
    }

    @GetMapping("/{id}/realisateur")
    public Realisateur findRealisateurByFilm(@PathVariable Integer id) {
        return filmService.findRealisateurByFilm(id);
    }

    @PostMapping("/{id}/acteurs")
    public FilmCompletDto addActeurToFilm(@PathVariable Integer id, @RequestBody ActeurSansFilmDto acteur) {
        Film film = filmService.addActeurToFilm(id, acteur.getId());

        return objectMapper.convertValue(film, FilmCompletDto.class);
    }
}

