package com.tripshots.postsservice.services;

import com.tripshots.postsservice.entity.Itinerary;
import com.tripshots.postsservice.exceptions.ItineraryNotFound;
import com.tripshots.postsservice.model.ItineraryDTO;
import com.tripshots.postsservice.repositories.ItineraryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItineraryServiceImplementation implements ItineraryService {

    @Autowired
    private ItineraryRepository itineraryRepository;

    @Override
    public ItineraryDTO getItineraryById(String id) throws ItineraryNotFound {
        Optional<Itinerary> itinerary = itineraryRepository.findById(id);
        if(itinerary.isPresent()) {
            ItineraryDTO itineraryDTO = new ItineraryDTO();
            BeanUtils.copyProperties(itinerary.get(),itineraryDTO);
            return itineraryDTO;
        } else {
            System.out.println("Itinerary Not Present");
        }
        throw new ItineraryNotFound("Itinerary Not Found");
    }

    @Override
    public ItineraryDTO createItinerary(ItineraryDTO itineraryDTO) {
        if(itineraryRepository.existsById(itineraryDTO.getId()))
            return null;
        Itinerary itinerary = new Itinerary();
        BeanUtils.copyProperties(itineraryDTO, itinerary);
        itineraryRepository.save(itinerary);
        return itineraryDTO;
    }

    @Override
    public ItineraryDTO deleteItinerary(ItineraryDTO itineraryDTO) throws ItineraryNotFound {
        itineraryNotFound(itineraryDTO.getId(),"Failed to delete");
        itineraryRepository.deleteById(itineraryDTO.getId());
        return itineraryDTO;
    }

    @Override
    public ItineraryDTO updateItinerary(ItineraryDTO itineraryDTO)throws ItineraryNotFound {
        itineraryNotFound(itineraryDTO.getId(),"Failed to update");
        Itinerary itinerary = new Itinerary();
        BeanUtils.copyProperties(itineraryDTO,itinerary);
        itineraryRepository.save(itinerary);
        return itineraryDTO;
    }

    private void itineraryNotFound(String id, String message) throws ItineraryNotFound {
        if(!itineraryRepository.existsById(id))
            throw new ItineraryNotFound(message+": Itinerary not found");

    }

}
