package fr.valentin.springtp4.seance;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.valentin.springtp4.seance.dto.SeanceReduitDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seances")
public class SeanceController {
    private final SeanceService seanceService;
    private final ObjectMapper objectMapper;

    public SeanceController(SeanceService seanceService, ObjectMapper objectMapper) {
        this.seanceService = seanceService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public List<SeanceReduitDto> findAll() {
        return seanceService.findAll().stream().map(
                seance -> objectMapper.convertValue(seance, SeanceReduitDto.class)
        ).toList();
    }

    @GetMapping("/{id}")
    public Seance findById(@PathVariable Long id) {
        return seanceService.findById(id);
    }

    @PostMapping
    public Seance save(@RequestBody Seance seance) {
        return seanceService.save(seance);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        seanceService.deleteById(id);
    }

    @PutMapping
    public Seance update(@RequestBody Seance seance) {
        return seanceService.update(seance);
    }
}
