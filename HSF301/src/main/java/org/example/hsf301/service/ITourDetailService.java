package org.example.hsf301.service;

import org.example.hsf301.model.request.TourDetailRequest;
import org.example.hsf301.pojo.TourDetail;

import java.util.List;

public interface ITourDetailService {
    TourDetail addTourDetail(TourDetailRequest tourDetailRequest);

    TourDetail updateTourDetailHistory(Long tourDetailId, TourDetailRequest tourDetailRequest) throws Exception;

    void deleteTourDetail(Long tourDetailId);

    TourDetail getTourDetail(Long tourDetailId);

    List<TourDetail> getAllTourDetails();
}
