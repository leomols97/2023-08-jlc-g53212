package be.esi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Skill {

    @Id
    @SequenceGenerator(name = "SKILL_SEQ", sequenceName = "skill_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SKILL_SEQ")
    private int id;

    @NotBlank(message = "Le nom ne peut pas être vide !")
    private String name;

    @NotBlank(message = "La description ne peut pas être vide !")
    private String description;

    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Training> trainings;

}
