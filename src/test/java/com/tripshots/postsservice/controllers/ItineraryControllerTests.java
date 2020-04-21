package com.tripshots.postsservice.controllers;

import com.tripshots.postsservice.exceptions.ItineraryNotFound;
import com.tripshots.postsservice.model.ItineraryDTO;
import com.tripshots.postsservice.services.ItineraryService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ItineraryControllerTests {

    @Mock
    @Autowired
    private ItineraryService itineraryService;

    @InjectMocks
    private ItineraryController itineraryController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetItinerary() throws ItineraryNotFound {
        ItineraryDTO itineraryDTO = getNewItineraryDTO();
        Mockito.when(itineraryService.getItineraryById(itineraryDTO.getId())).thenReturn(itineraryDTO);
        ItineraryDTO resItineraryDTO = itineraryController.getItinerary(itineraryDTO.getId());
        Assertions.assertEquals(itineraryDTO, resItineraryDTO);
    }

    @Test
    public void testCreateItinerary() {
        ItineraryDTO itineraryDTO = getNewItineraryDTO();
        Mockito.when(itineraryService.createItinerary(itineraryDTO)).thenReturn(itineraryDTO);
        ItineraryDTO resItineraryDTO = itineraryController.createItinerary(itineraryDTO);
        Assertions.assertEquals(itineraryDTO, resItineraryDTO);
    }

    private ItineraryDTO getNewItineraryDTO() {
        ItineraryDTO itineraryDTO = new ItineraryDTO();
        itineraryDTO.setId("1");
        return itineraryDTO;
    }
}
