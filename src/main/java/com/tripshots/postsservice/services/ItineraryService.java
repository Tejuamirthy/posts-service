package com.tripshots.postsservice.services;

import com.tripshots.postsservice.exceptions.ItineraryNotFound;
import com.tripshots.postsservice.model.ItineraryDTO;

public interface ItineraryService {

    ItineraryDTO getItineraryById(String id) throws ItineraryNotFound;
    ItineraryDTO createItinerary(ItineraryDTO itineraryDTO);
    ItineraryDTO deleteItinerary(ItineraryDTO itineraryDTO) throws ItineraryNotFound;
    ItineraryDTO updateItinerary(ItineraryDTO itineraryDTO) throws ItineraryNotFound;
}
