package fr.valentin.springtp4.acteur;

import fr.valentin.springtp4.acteur.dto.ActeurAvecFilmReduitDto;
import fr.valentin.springtp4.film.dto.ActeurSansFilmDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/acteurs")
public class ActeurController {
    private final ActeurService acteurService;
    private final ObjectMapper objectMapper;

    public ActeurController(ActeurService acteurService, ObjectMapper objectMapper) {
        this.acteurService = acteurService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public List<ActeurSansFilmDto> findAllActeur() {
        return acteurService.findAllActeur().stream().map(
                acteur -> objectMapper.convertValue(acteur, ActeurSansFilmDto.class)
        ).toList();
    }

    @PostMapping
    public Acteur saveActeur(@RequestBody Acteur acteur) {
        return acteurService.saveActeur(acteur);
    }

    @GetMapping("/{id}")
    public ActeurAvecFilmReduitDto findActeurById(@PathVariable Integer id) {
        Acteur acteur = acteurService.findActeurById(id);

        return objectMapper.convertValue(acteur, ActeurAvecFilmReduitDto.class);
    }

    @DeleteMapping("/{id}")
    public void deleteActeurById(@PathVariable Integer id) {
        acteurService.deleteActeurById(id);
    }

    @PutMapping
    public Acteur updateActeur(@RequestBody Acteur acteur) {
        return acteurService.updateActeur(acteur);
    }

    @GetMapping("/search")
    public Acteur findActeurByNom(@RequestParam String nom) {
        return acteurService.findActeurByNom(nom);
    }

}