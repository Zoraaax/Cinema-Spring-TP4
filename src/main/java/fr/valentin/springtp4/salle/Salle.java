package fr.valentin.springtp4.salle;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "salle")
public class Salle {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false)
    private Integer nbPlaces;

    @ElementCollection
    private List<String> equipements;
}
