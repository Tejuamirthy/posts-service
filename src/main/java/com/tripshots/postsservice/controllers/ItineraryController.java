package com.tripshots.postsservice.controllers;

import com.tripshots.postsservice.exceptions.ItineraryNotFound;
import com.tripshots.postsservice.model.ItineraryDTO;
import com.tripshots.postsservice.services.ItineraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/itinerary")
public class ItineraryController {

    @Autowired
    private ItineraryService itineraryService;

    @GetMapping(path = "/{id}")
    public ItineraryDTO getItinerary(@PathVariable String id) throws ItineraryNotFound {
        return itineraryService.getItineraryById(id);
    }

}
