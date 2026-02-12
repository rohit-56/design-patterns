package com.lld.designPattern.bookmyshow.service;

import com.lld.designPattern.bookmyshow.enums.City;
import com.lld.designPattern.bookmyshow.model.Movie;
import com.lld.designPattern.bookmyshow.model.Screen;
import com.lld.designPattern.bookmyshow.model.Show;
import com.lld.designPattern.bookmyshow.model.Theatre;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreService {

    public Map<City, List<Theatre>> cityVsTheatreMap=new HashMap<City,List<Theatre>>();

  //  List<Theatre> theatreList=new ArrayList<Theatre>();

    public TheatreService(){

    }

    //add theatre
    public void addTheatre(Theatre theatre){
        if(cityVsTheatreMap.containsKey(theatre.city)){
            cityVsTheatreMap.get(theatre.city).add(theatre);
        }
        else{
            cityVsTheatreMap.put(theatre.city,List.of(theatre));
        }
    }

    //Function to get Movies using city and date
    public List<Movie> getMovies(City city, LocalDate date){
        List<Movie> movieList=new ArrayList<>();
        List<Theatre> theatreList=cityVsTheatreMap.get(city);
        for(Theatre theatre:theatreList){
            List<Screen> screenList=theatre.getScreenList();

            for(Screen screen:screenList){
                if(screen.getShowsByDate().containsKey(date)) {
                    List<Show> showList = screen.getShowsByDate(date);
                    for (Show show : showList) {
                        movieList.add(show.getMovie());
                    }
                }
            }
        }
        return movieList;
    }

    //Function to get all theatre list for particular movie,city and date
    public List<Theatre> getTheatreList(City city, LocalDate date,Movie movie){
        List<Theatre> theatreList=new ArrayList<>();

        List<Theatre> cityTheatre=cityVsTheatreMap.get(city);

        for(Theatre theatre:cityTheatre){
            List<Screen> screenList=theatre.getScreenList();
            for(Screen screen:screenList){
                List<Show> showList = screen.getShowsByDate(date);
                if(screen.getShowsByDate().containsKey(date)) {
                    for (Show show : showList) {
                        if (show.getMovie().equals(movie)) {
                            theatreList.add(theatre);
                        }
                    }
                }
            }
        }
        return theatreList;
    }

    //Function to get all shows for particular movie,theatre,date
    public List<Show> getAllShows(City city, LocalDate date,Movie movie){
        List<Theatre> theatreList=cityVsTheatreMap.get(city);

        List<Show> listByMovie=new ArrayList<>();

        for(Theatre theatre:theatreList){
            List<Screen> screenList=theatre.getScreenList();
            for(Screen screen:screenList){
                List<Show> showList = screen.getShowsByDate(date);
                if(screen.getShowsByDate().containsKey(date)) {
                    for (Show show : showList) {
                        if (show.getMovie().equals(movie)) {
                            listByMovie.add(show);
                        }
                    }
                }
            }
        }

        return listByMovie;

    }
}
