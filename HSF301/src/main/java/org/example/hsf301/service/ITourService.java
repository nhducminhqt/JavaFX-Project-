package org.example.hsf301.service;


import org.example.hsf301.model.request.TourRequest;
import org.example.hsf301.pojo.Tours;

import java.util.List;

public interface ITourService {
    Tours addTour(TourRequest tourRequest, Long tourId);

    Tours updateTour(Long tourId, TourRequest tourRequest) throws Exception;

    void deleteTour(Long tourId);

    Tours getTour(Long tourId);

    List<Tours> findAll();
    List<Tours> findByName(String tourName);
    List<Tours> findByTourActive();
}
