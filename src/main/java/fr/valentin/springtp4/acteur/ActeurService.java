package fr.valentin.springtp4.acteur;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class ActeurService {
    private final ActeurRepository acteurRepository;

    public ActeurService(ActeurRepository acteurRepository) {
        this.acteurRepository = (ActeurRepository) acteurRepository;
    }

    /**
     * Trouve tous les acteurs
     * @return tous les acteurs
     */
    public List<Acteur> findAllActeur() {
        return acteurRepository.findAll();
    }

    /**
     * Ajoute un acteur
     * @param acteur
     * @return l'acteur ajouté
     */
    public Acteur saveActeur(Acteur acteur) {
        return acteurRepository.save(acteur);
    }

    /**
     * Supprime un acteur
     * @param id
     */
    public void deleteActeurById(Integer id) {
        Acteur acteur = this.findActeurById(id);
        acteurRepository.delete(acteur);
    }

    /**
     * Trouve un acteur par son id
     * @param id
     * @return l'acteur avec l'id
     */
    public Acteur findActeurById(Integer id) {
        return (Acteur) acteurRepository.findActeurById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Acteur non trouvé"
                        )
                );
    }

    /**
     * Met à jour un acteur
     * @param acteur
     * @return l'acteur mis à jour
     */
    public Acteur updateActeur(Acteur acteur) {
        return acteurRepository.save(acteur);
    }

    /**
     * Trouve un acteur par son nom
     * @param nom
     * @return l'acteur avec le nom
     */
    public Acteur findActeurByNom(String nom) {
        return acteurRepository.findActeurByNom(nom)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Aucun acteur avec le nom : " + nom
                        )
                );
    }
}


