package fr.valentin.springtp4.seance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface SeanceRepository extends JpaRepository<Seance, Long> {
    Optional<Seance> findSeanceByDate(LocalDate date);
}
