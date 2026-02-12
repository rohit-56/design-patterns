package com.lld.designPattern.bookmyshow;

import com.lld.designPattern.bookmyshow.controller.TheatreController;
import com.lld.designPattern.bookmyshow.enums.City;
import com.lld.designPattern.bookmyshow.model.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class BookMyShow {

    private static TheatreController theatreController;

    public BookMyShow() {
        theatreController=new TheatreController();
        initialize();
        userBooking();
    }

    public void initialize() {

        //Create Movies

        Movie saaho = new Movie(1,"Saaho","XYZ",135, LocalDate.now().minusMonths(1));
        Movie ironman = new Movie(2,"Ironman","ABC",120, LocalDate.now().minusDays(10));
        Movie batman = new Movie(3,"Batman","LLO",105, LocalDate.now().minusDays(5));


        //Create Screen

        Screen s1=new Screen(1);
        Screen s2=new Screen(2);
        Screen s3=new Screen(3);
        Screen s4=new Screen(4);
        Screen s5=new Screen(5);

        //Create Shows

        Show show1=new Show(1,saaho,LocalDate.now(),LocalTime.of(8,0));
        Show show2=new Show(2,ironman,LocalDate.now(),LocalTime.of(10,0));
        Show show3=new Show(3,ironman,LocalDate.now().plusDays(1),LocalTime.of(12,0));
        Show show4=new Show(4,batman,LocalDate.now(),LocalTime.of(6,0));
        Show show5=new Show(5,batman,LocalDate.now().plusDays(1),LocalTime.of(7,0));

        //Add shows to Screen
        s1.addShow(show1.getShowDate(),show1);
        s2.addShow(show2.getShowDate(),show2);
        s3.addShow(show3.getShowDate(),show3);
        s4.addShow(show4.getShowDate(),show4);
        s5.addShow(show5.getShowDate(),show5);

        //Create Theatre
        Theatre inoxNoida = new Theatre(1,"INOX", City.NOIDA);
        inoxNoida.addScreen(s1);
        inoxNoida.addScreen(s2);
        inoxNoida.addScreen(s3);

        Theatre inoxPune = new Theatre(2,"INOX", City.PUNE);
        inoxPune.addScreen(s4);
        inoxPune.addScreen(s5);

        theatreController.addTheatre(inoxNoida);
        theatreController.addTheatre(inoxPune);



    }

    public void userBooking() {

        UserEntity rohit = new UserEntity(1,"rohit","test101@gmail.com");

        //Select City and date
        City selectedCity = City.NOIDA;
        LocalDate selectedDate = LocalDate.now();

        //Display Movies
        List<Movie> movieList = theatreController.getAllMovies(selectedCity,selectedDate);

        System.out.println("---------------------------------------------------");
        System.out.println("Movies in "+selectedCity+":");
        for(Movie movie:movieList){
            System.out.println(movie.getMovieId()+" "+movie.getMovieName()+" "+ movie.getDuration()+" "+movie.getDirector()+" "+movie.getReleaseDate());
        }
        System.out.println("----------------------------------------------------");
        //Select Movie
        Movie selectedMovie = movieList.get(1);

        //Display Theatre and shows

        System.out.println("All Theatre with movie "+selectedMovie.getMovieName());
        List<Theatre> theatreList=theatreController.getAllTheatre(selectedCity,selectedDate,selectedMovie);
        for(Theatre theatre:theatreList){
            System.out.println(theatre.getTheatreId()+" "+theatre.getTheatreName()+" "+theatre.city);
        }
        System.out.println("------------------------------------------------------");
        System.out.println(selectedMovie.getMovieName()+" shows in theatre ");
        List<Show> allShowsForSelectedMovie = theatreController.getAllShows(selectedCity,selectedDate,selectedMovie);
        for(Show show:allShowsForSelectedMovie){
            System.out.println(show.showId+" "+show.getMovie().getMovieName()+" "+show.getShowDate()+" "+show.getShowTime());
        }

        System.out.println("------------------------------------------------------");


    }


}
