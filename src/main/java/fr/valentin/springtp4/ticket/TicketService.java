package fr.valentin.springtp4.ticket;

import fr.valentin.springtp4.exception.BadRequestException;
import fr.valentin.springtp4.seance.SeanceService;
import fr.valentin.springtp4.ticket.exception.TicketNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final SeanceService seanceService;

    public TicketService(TicketRepository ticketRepository, SeanceService seanceService) {
        this.ticketRepository = ticketRepository;
        this.seanceService = seanceService;
    }

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public Ticket findById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(
                        () -> new TicketNotFoundException(
                                "Ticket not found"
                        )
                );
    }

    public Ticket save(Ticket ticket) {

        int placesDispo = seanceService.findById(ticket.getSeance().getId()).getPlacesDisponibles();

        List<String> erreurs = new ArrayList<>();

        if (ticket.getSeance() == null) {
            erreurs.add("La séance est obligatoire");
        }

        if (ticket.getNomClient() == null) {
            erreurs.add("Le nom du client est obligatoire");
        }

        if (placesDispo < ticket.getNbPlaces()) {
            erreurs.add("Il n'y a pas assez de places disponibles pour cette séance");
        }

        if (ticket.getNbPlaces() <= 0) {
            erreurs.add("Le nombre de places doit être supérieur à 0");
        }

        if (!erreurs.isEmpty()) {
            throw new BadRequestException(erreurs);
        }

        seanceService.updatePlacesDisponibles(ticket.getSeance().getId(), placesDispo - ticket.getNbPlaces());

        return ticketRepository.save(ticket);
    }

    public void deleteById(Long id) {
        Ticket ticket = this.findById(id);

        seanceService.updatePlacesDisponibles(ticket.getSeance().getId(), ticket.getSeance().getPlacesDisponibles() + ticket.getNbPlaces());

        ticketRepository.deleteById(id);
    }

    public Ticket update(Ticket ticket) {
        this.findById(ticket.getId());

        return ticketRepository.save(ticket);
    }
}
