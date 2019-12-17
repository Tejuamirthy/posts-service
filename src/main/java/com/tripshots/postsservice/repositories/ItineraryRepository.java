package com.tripshots.postsservice.repositories;

import com.tripshots.postsservice.entity.Itinerary;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItineraryRepository extends MongoRepository<Itinerary, String> {
}
