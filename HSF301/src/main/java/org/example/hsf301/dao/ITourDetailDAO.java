package org.example.hsf301.dao;

import org.example.hsf301.pojo.TourDetail;
import org.example.hsf301.pojo.Tours;

import java.util.List;

public interface ITourDetailDAO {
    void save(TourDetail tourDetail);
    List<TourDetail> findAll();
    void delete(Long id);
    TourDetail findById(Long id);
    void update(TourDetail tourDetail);

}
