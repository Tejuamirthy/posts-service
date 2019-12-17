package com.tripshots.postsservice.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "itinerary")
public class Itinerary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private List<List<ItineraryDayPlan>> itineraryPlan;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<List<ItineraryDayPlan>> getItineraryPlan() {
        return itineraryPlan;
    }

//    public List<ItineraryDayPlan> getItineraryPlanByDay(int day) {
//        if (itineraryPlan == null || day >= itineraryPlan.size())
//            return null;
//        return itineraryPlan.get(day+1);
//    }

    public void setItineraryPlan(List<List<ItineraryDayPlan>> itineraryPlan) {
        this.itineraryPlan = itineraryPlan;
    }
}
