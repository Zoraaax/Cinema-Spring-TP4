package fr.valentin.springtp4.ticket.dto;

import fr.valentin.springtp4.seance.dto.SeanceIdDto;
import lombok.Data;

@Data
public class TicketReduitDto {
    private Long id;
    private SeanceIdDto seance;
    private String nomClient;
    private Integer nbPlaces;
}
