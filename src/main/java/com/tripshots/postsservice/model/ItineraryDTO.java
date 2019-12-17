package com.tripshots.postsservice.model;

import com.tripshots.postsservice.entity.ItineraryDayPlan;

import java.util.List;

public class ItineraryDTO {
    private String id;
    private List<List<ItineraryDayPlanDTO>> itineraryPlan;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<List<ItineraryDayPlanDTO>> getItineraryPlan() {
        return itineraryPlan;
    }

    public void setItineraryPlan(List<List<ItineraryDayPlanDTO>> itineraryPlan) {
        this.itineraryPlan = itineraryPlan;
    }
}
