package com.lld.designPattern.bookmyshow.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Screen {

    public int screenId;
    public List<Seat> seats=new ArrayList<Seat>();
    public Map<LocalDate,List<Show>> showsByDate=new HashMap<LocalDate,List<Show>>();

    public Screen(int screenId) {
        this.screenId=screenId;
        for(int i=1;i<=10;i++){
            seats.add(new Seat(i,1,SeatCategory.SILVER,100));
        }
        for(int i=11;i<=20;i++){
            seats.add(new Seat(i,2,SeatCategory.GOLD,200));
        }
    }

    public void addShow(LocalDate date,Show show){
        if(showsByDate.get(date)==null){
            showsByDate.put(date,List.of(show));
        }
        else{
            showsByDate.get(date).add(show);
        }
    }

    public List<Show> getShowsByDate(LocalDate date){
        return showsByDate.get(date);
    }

    public Map<LocalDate, List<Show>> getShowsByDate() {
        return showsByDate;
    }
}
