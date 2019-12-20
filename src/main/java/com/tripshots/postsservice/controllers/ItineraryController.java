package com.tripshots.postsservice.controllers;

import com.tripshots.postsservice.exceptions.ItineraryNotFound;
import com.tripshots.postsservice.model.ItineraryDTO;
import com.tripshots.postsservice.services.ItineraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/itinerary")
public class ItineraryController {

    @Autowired
    private ItineraryService itineraryService;

    @GetMapping(path = "/{id}")
    public ItineraryDTO getItinerary(@PathVariable String id) throws ItineraryNotFound {
        return itineraryService.getItineraryById(id);
    }

    @PostMapping(path = "/")
    public ItineraryDTO createItinerary(@RequestBody ItineraryDTO itineraryDTO) {
        return itineraryService.createItinerary(itineraryDTO);
    }

    @PutMapping(path = "/")
    public ItineraryDTO updateItinerary(@RequestBody ItineraryDTO itineraryDTO) throws ItineraryNotFound {
        return itineraryService.updateItinerary(itineraryDTO);
    }

    @DeleteMapping(path = "/")
    public ItineraryDTO deleteItinerary(@RequestBody ItineraryDTO itineraryDTO) throws ItineraryNotFound {
        return itineraryService.deleteItinerary(itineraryDTO);
    }

}
