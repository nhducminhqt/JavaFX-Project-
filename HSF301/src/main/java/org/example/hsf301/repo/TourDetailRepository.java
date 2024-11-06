package org.example.hsf301.repo;
import org.example.hsf301.dao.ITourDetailDAO;
import org.example.hsf301.dao.TourDetailDAO;
import org.example.hsf301.pojo.TourDetail;

import java.util.List;

public class TourDetailRepository implements ITourDetailRepository {
    private final ITourDetailDAO tourDetailDAO;

    public TourDetailRepository(String jpaName){
        tourDetailDAO = new TourDetailDAO(jpaName);
    }
    @Override
    public void save(TourDetail tourDetail) {
        tourDetailDAO.save(tourDetail);

    }

    @Override
    public List<TourDetail> findAll() {
        return tourDetailDAO.findAll();
    }

    @Override
    public void delete(Long id) {
        tourDetailDAO.delete(id);

    }

    @Override
    public TourDetail findById(Long id) {
        return tourDetailDAO.findById(id);
    }

    @Override
    public void update(TourDetail tourDetail) {
        tourDetailDAO.update(tourDetail);

    }
}
