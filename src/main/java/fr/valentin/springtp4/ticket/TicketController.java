package fr.valentin.springtp4.ticket;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.valentin.springtp4.ticket.dto.TicketReduitDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;
    private final ObjectMapper objectMapper;

    public TicketController(TicketService ticketService, ObjectMapper objectMapper) {
        this.ticketService = ticketService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public List<TicketReduitDto> findAll() {
        return ticketService.findAll().stream().map(
                ticket -> objectMapper.convertValue(ticket, TicketReduitDto.class)
        ).toList();
    }

    @GetMapping("/{id}")
    public Ticket findById(@PathVariable Long id) {
        return ticketService.findById(id);
    }

    @PostMapping
    public Ticket save(@RequestBody Ticket ticket) {
        return ticketService.save(ticket);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        ticketService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Ticket update(@RequestBody Ticket ticket) {
        return ticketService.update(ticket);
    }
}
