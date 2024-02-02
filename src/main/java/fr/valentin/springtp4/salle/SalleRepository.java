package fr.valentin.springtp4.salle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SalleRepository extends JpaRepository<Salle, Long> {
}
