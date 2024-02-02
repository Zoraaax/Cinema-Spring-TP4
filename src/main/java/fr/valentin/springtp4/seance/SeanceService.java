package fr.valentin.springtp4.seance;

import fr.valentin.springtp4.exception.BadRequestException;
import fr.valentin.springtp4.salle.Salle;
import fr.valentin.springtp4.salle.SalleService;
import fr.valentin.springtp4.seance.exception.SeanceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SeanceService {
    private final SeanceRepository seanceRepository;
    private final SalleService salleService;

    public SeanceService(SeanceRepository seanceRepository, SalleService salleService) {
        this.seanceRepository = seanceRepository;
        this.salleService = salleService;
    }

    public List<Seance> findAll() {
        return seanceRepository.findAll();
    }

    public Seance findById(Long id) {
        return seanceRepository.findById(id)
                .orElseThrow(
                        () -> new SeanceNotFoundException(
                                "Seance not found"
                        )
                );
    }

    public Seance save(Seance seance) {
        List<String> erreurs = new ArrayList<>();

        if (seance.getSalle() == null) {
            erreurs.add("La salle de la séance est obligatoire");
        }

        if (seance.getFilm() == null) {
            erreurs.add("Le film de la séance est obligatoire");
        }

        if (seance.getDate() == null || seance.getDate().isBefore(LocalDate.now())) {
            erreurs.add("La date de la séance est obligatoire ou doit être dans le futur");
        }

        if (!erreurs.isEmpty()) {
            throw new BadRequestException(erreurs);
        }

        Salle salleId = salleService.findById(seance.getSalle().getId());

        seance.setPlacesDisponibles(salleId.getNbPlaces());

        return seanceRepository.save(seance);
    }

    public void deleteById(Long id) {
        seanceRepository.deleteById(id);
    }

    public Seance update(Seance seance) {
        return seanceRepository.save(seance);
    }

    public Seance updatePlacesDisponibles(Long id, Integer placesDispo) {
        Seance seance = findById(id);
        seance.setPlacesDisponibles(placesDispo);
        return seanceRepository.save(seance);
    }
}
