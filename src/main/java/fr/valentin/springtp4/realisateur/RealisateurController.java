package fr.valentin.springtp4.realisateur;

import fr.valentin.springtp4.realisateur.dto.FilmParRealisateurDto;
import fr.valentin.springtp4.realisateur.dto.RealisateurAvecFilmDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/realisateurs")
public class RealisateurController {
    private final RealisateurService realisateurService;
    private final ObjectMapper objectMapper;

    public RealisateurController(RealisateurService realisateurService, ObjectMapper objectMapper) {
        this.realisateurService = realisateurService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public List<Realisateur> findAllrealisateur() {
        return realisateurService.findAllRealisateur();
    }

    @PostMapping
    public Realisateur saveRealisateur(@RequestBody Realisateur realisateur) {
        return realisateurService.saveRealisateur(realisateur);
    }

    @DeleteMapping("/{id}")
    public void deleteRealisateurById(@PathVariable Integer id) {
        realisateurService.deleteRealisateurById(id);
    }

    @PutMapping
    public Realisateur updateRealisateur(@RequestBody Realisateur realisateur) {
        return realisateurService.updateRealisateur(realisateur);
    }

    @GetMapping("/search")
    public Realisateur findRealisateurByNom(@RequestParam String nom) {
        return realisateurService.findRealisateurByNom(nom);
    }

    @GetMapping("/{id}")
    public RealisateurAvecFilmDto findRealisateurById(@PathVariable Integer id) {
        Realisateur realisateur = realisateurService.findRealisateurById(id);
        return objectMapper.convertValue(realisateur, RealisateurAvecFilmDto.class);
    }

    @GetMapping("/{id}/films")
    public FilmParRealisateurDto findRealisateurByIdWithFilms(@PathVariable Integer id) {
        Realisateur realisateur = realisateurService.findRealisateurById(id);
        return objectMapper.convertValue(realisateur, FilmParRealisateurDto.class);
    }
}


