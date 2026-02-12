package com.lld.designPattern.bookmyshow.model;

import java.time.LocalDate;

public class Movie {

    public int movieId;
    public String movieName;
    public String director;
    public int duration;
    public LocalDate releaseDate;

    public Movie(int movieId, String movieName, String director, int duration, LocalDate releaseDate) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.director = director;
        this.duration = duration;
        this.releaseDate = releaseDate;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
