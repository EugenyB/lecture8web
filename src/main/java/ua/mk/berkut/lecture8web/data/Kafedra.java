package ua.mk.berkut.lecture8web.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "kafedra")
@NamedQueries({
        @NamedQuery(name = "Kafedra.findAll", query = "select k from Kafedra k")
})
public class Kafedra {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "name", length = 50)
    private String name;

    @OneToMany(mappedBy = "kafedra", orphanRemoval = true)
    private Set<Teacher> teachers = new LinkedHashSet<>();

}