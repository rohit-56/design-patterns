package com.lld.designPattern.bookmyshow.controller;

import com.lld.designPattern.bookmyshow.enums.City;
import com.lld.designPattern.bookmyshow.model.Movie;
import com.lld.designPattern.bookmyshow.model.Show;
import com.lld.designPattern.bookmyshow.model.Theatre;
import com.lld.designPattern.bookmyshow.service.TheatreService;

import java.time.LocalDate;
import java.util.List;

public class TheatreController {

  private static TheatreService theatreService;

    public TheatreController(){
        this.theatreService = new TheatreService();
    }

    public void addTheatre(Theatre theatre){
        theatreService.addTheatre(theatre);
    }

    public List<Movie> getAllMovies(City city, LocalDate date){
        return theatreService.getMovies(city, date);
    }

    public List<Theatre> getAllTheatre(City city, LocalDate date, Movie movie){
        return theatreService.getTheatreList(city, date, movie);
    }

    public List<Show> getAllShows(City city, LocalDate date, Movie movie){
        return theatreService.getAllShows(city, date, movie);
    }



}
