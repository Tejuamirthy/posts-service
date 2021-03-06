package com.tripshots.postsservice.controllers;

import com.tripshots.postsservice.exceptions.ItineraryNotFound;
import com.tripshots.postsservice.model.ItineraryDTO;
import com.tripshots.postsservice.model.ItineraryDayPlanDTO;
import com.tripshots.postsservice.services.ItineraryService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        when(itineraryService.getItineraryById(itineraryDTO.getId())).thenReturn(itineraryDTO);
        ItineraryDTO resItineraryDTO = itineraryController.getItinerary(itineraryDTO.getId());
        assertEquals(itineraryDTO, resItineraryDTO);
    }

    @Test
    public void testCreateItinerary() {
        ItineraryDTO itineraryDTO = getNewItineraryDTO();
        when(itineraryService.createItinerary(itineraryDTO)).thenReturn(itineraryDTO);
        ItineraryDTO resItineraryDTO = itineraryController.createItinerary(itineraryDTO);
        assertEquals(itineraryDTO, resItineraryDTO);
    }

    @Test
    public void testUpdateItinerary() throws ItineraryNotFound{
        ItineraryDTO itineraryDTO = getNewItineraryDTO();
        List<ItineraryDayPlanDTO> list = new ArrayList<>();
        List<List<ItineraryDayPlanDTO>> resList = new ArrayList<>();
        resList.add(list);
        itineraryDTO.setItineraryPlan(resList);
        when(itineraryService.updateItinerary(itineraryDTO)).thenReturn(itineraryDTO);
        ItineraryDTO resItineraryDTO = itineraryController.updateItinerary(itineraryDTO);
        assertEquals(itineraryDTO, resItineraryDTO);
        assertEquals(1, itineraryDTO.getItineraryPlan().size());
    }

    @Test
    public void testDeleteItinerary() throws ItineraryNotFound {
        ItineraryDTO itineraryDTO = getNewItineraryDTO();
        when(itineraryService.deleteItinerary(itineraryDTO)).thenReturn(itineraryDTO);
        ItineraryDTO resItineraryDTO = itineraryController.deleteItinerary(itineraryDTO);
        assertEquals(itineraryDTO, resItineraryDTO);
    }


    private ItineraryDTO getNewItineraryDTO() {
        ItineraryDTO itineraryDTO = new ItineraryDTO();
        itineraryDTO.setId("1");
        return itineraryDTO;
    }
}
