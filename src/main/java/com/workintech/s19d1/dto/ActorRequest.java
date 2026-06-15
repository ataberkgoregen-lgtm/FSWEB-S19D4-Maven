package com.workintech.s19d1.dto;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import lombok.Data;

import java.util.List;

// Request Payload hazırlıyoruz bu şekilde ! İstekler bu şekilde yapılabiliyor
@Data
public class ActorRequest {

    private List<Movie> movies;
    private Actor actor;

}
