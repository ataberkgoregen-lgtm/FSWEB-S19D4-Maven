package com.workintech.s19d1.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull(message = "Film adı null olamaz")
    private String name;

    @Column(name = "director_name")
    @NotNull(message = "yönetmen adı null olamaz")
    private String directorName;

    @Column(name = "rating")
    private Integer rating;

    @Column(name="release_date")
    private LocalDate releaseDate;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(
            name="movie_actors",
            joinColumns = @JoinColumn(name="movie_id"),
            inverseJoinColumns = @JoinColumn(name="actor_id")
    )
    private List<Actor> actors = new ArrayList<>();

    public void addActor(Actor actor) {
        this.actors.add(actor);
        actor.getMovies().add(this);
    }


}
