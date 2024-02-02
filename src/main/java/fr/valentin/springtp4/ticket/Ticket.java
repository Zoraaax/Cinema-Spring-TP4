package fr.valentin.springtp4.ticket;

import fr.valentin.springtp4.seance.Seance;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seance_id", nullable = false)
    private Seance seance;

    @Column(nullable = false, length = 50)
    private String nomClient;

    @Column(nullable = false)
    private Integer nbPlaces;
}

