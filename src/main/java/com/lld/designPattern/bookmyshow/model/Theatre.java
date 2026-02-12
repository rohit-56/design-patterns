package com.lld.designPattern.bookmyshow.model;

import com.lld.designPattern.bookmyshow.enums.City;

import java.util.ArrayList;
import java.util.List;

public class Theatre {

    public int theatreId;
    public String theatreName;
    public List<Screen> screenList=new ArrayList<Screen>();
    public City city;

    public Theatre(int theatreId, String theatreName, City city) {
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.city = city;
    }
    public void addScreen(Screen screen){
        screenList.add(screen);
    }

    public List<Screen> getScreenList(){
        return screenList;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public City getCity() {
        return city;
    }
}
