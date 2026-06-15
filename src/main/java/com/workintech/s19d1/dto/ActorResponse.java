package com.workintech.s19d1.dto;

import com.workintech.s19d1.entity.Movie;

import java.time.LocalDate;
import java.util.List;


// Burada movies dönmek bize circler dependency hatası verebilir !
public record ActorResponse(Long id, String firstName, String lastName, LocalDate birthDate, List<Movie> movies) {


}
