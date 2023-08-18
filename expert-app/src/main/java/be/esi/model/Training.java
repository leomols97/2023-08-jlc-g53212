package be.esi.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Training {

    @Id
    @SequenceGenerator(name = "TRAINING_SEQ", sequenceName = "training_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRAINING_SEQ")
    private Integer id;

    @NotNull(message = "La date de formation ne peut pas être vide !")
    @Future(message = "La date de la formation doit être dans le futur !")
    private LocalDate scheduled;

    @ManyToOne(optional = false)
    @JsonManagedReference
    private Employee employee;

    @ManyToOne(optional = false)
    @JsonManagedReference
    private Skill skill;

    @Override
    public String toString() {
        return "Training [id=" + id + ", scheduled=" + scheduled + "]";
    }

}
