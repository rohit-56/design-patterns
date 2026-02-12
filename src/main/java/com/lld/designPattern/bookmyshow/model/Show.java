package com.lld.designPattern.bookmyshow.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Show {

    public int showId;
    public List<Integer> bookedSeats=new ArrayList<>();
    public Movie movie;
    public LocalDate showDate;
    public LocalTime showTime;


    public Show(int showId, Movie movie, LocalDate showDate, LocalTime showTime) {
        this.showId = showId;
        this.movie = movie;
        this.showDate = showDate;
        this.showTime = showTime;
    }

    public int getShowId() {
        return showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalTime showTime) {
        this.showTime = showTime;
    }
}
