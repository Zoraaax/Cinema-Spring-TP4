package fr.valentin.springtp4.realisateur;

import fr.valentin.springtp4.film.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class RealisateurService {
    private final RealisateurRepository realisateurRepository;
    private final FilmService filmService;

    public RealisateurService(RealisateurRepository realisateurRepository, FilmService filmService) {
        this.realisateurRepository = realisateurRepository;
        this.filmService = filmService;
    }

    /**
     * Ajoute un realisateur
     * @param realisateur
     * @return le realisateur ajouté
     */
    public Realisateur saveRealisateur(Realisateur realisateur) {
        return realisateurRepository.save(realisateur);
    }

    /**
     * Trouve un realisateur par son id
     * @param id
     * @return le realisateur avec l'id
     */
    public Realisateur findRealisateurById(Integer id) {
        return realisateurRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Realisateur Non trouvé"
                        )
                );
    }

    /**
     * Supprime un realisateur
     * @param id
     */
    public void deleteRealisateurById(Integer id) {
        Realisateur realisateur = this.findRealisateurById(id);
        realisateurRepository.delete(realisateur);
    }

    /**
     * Met à jour un realisateur
     * @param realisateur
     * @return le realisateur mis à jour
     */
    public Realisateur updateRealisateur(Realisateur realisateur) {
        return realisateurRepository.save(realisateur);
    }

    /**
     * Trouve un realisateur par son nom
     * @param nom
     * @return le realisateur avec le nom
     */
    public Realisateur findRealisateurByNom(String nom) {
        return realisateurRepository.findByNom(nom)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Aucun réalisateur avec le nom : " + nom
                        )
                );
    }

    /**
     * Trouve tous les realisateurs
     * @return tous les realisateurs
     */
    public List<Realisateur> findAllRealisateur() {
        return realisateurRepository.findAll();
    }
}
