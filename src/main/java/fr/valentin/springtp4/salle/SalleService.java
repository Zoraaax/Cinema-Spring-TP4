package fr.valentin.springtp4.salle;

import fr.valentin.springtp4.exception.BadRequestException;
import fr.valentin.springtp4.salle.exception.SalleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalleService {
    private final SalleRepository salleRepository;

    public SalleService(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    /**
     * Récupère toutes les salles
     * @return L'ensemble des salles
     */
    public List<Salle> findAll() {
        return salleRepository.findAll();
    }

    /**
     * Récupère une salle par son id
     * @param id
     * @return La salle correspondante
     * @throws SalleNotFoundException
     */
    public Salle findById(Long id) {
        return salleRepository.findById(id)
                .orElseThrow(
                        () -> new SalleNotFoundException(
                                "Aucune Salle trouvée"
                        )
                );
    }

    /**
     * Ajoute une salle
     * @param salle
     * @return La salle ajoutée
     * @throws BadRequestException
     */
    public Salle save(Salle salle) {
        List<String> erreurs = new ArrayList<>();

        if (salle.getNumero() == null) {
            erreurs.add("Le numéro de la salle est obligatoire");
        }

        if (salle.getNbPlaces() == null) {
            erreurs.add("Le nombre de places de la salle est obligatoire");
        }

        if (salle.getEquipements() == null) {
            erreurs.add("Les équipements de la salle sont obligatoires");
        }

        if (!erreurs.isEmpty()) {
            throw new BadRequestException(erreurs);
        }

        return salleRepository.save(salle);
    }

    /**
     * Supprime une salle par son id
     * @param id
     */
    public void deleteById(Long id) {
        salleRepository.deleteById(id);
    }

    /**
     * Met à jour une salle
     * @param salle
     * @return La salle mise à jour
     */
    public Salle update(Salle salle) {
        this.findById(salle.getId());

        return salleRepository.save(salle);
    }
}
