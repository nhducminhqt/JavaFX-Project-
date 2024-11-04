package org.example.hsf301.repo;

import org.example.hsf301.dao.IKoiFarmsDAO;
import org.example.hsf301.dao.KoiFarmsDAO;
import org.example.hsf301.pojo.KoiFarms;

import java.util.List;

/**
 * @author KoiFarmsRepository
 */
public class KoiFarmsRepository implements IKoiFarmsRepository{
    private IKoiFarmsDAO iKoiFarmsDAO;

    public  KoiFarmsRepository (String name)
    {
        iKoiFarmsDAO = new KoiFarmsDAO(name);
    }
    @Override
    public void save(KoiFarms koiFarms) {
        iKoiFarmsDAO.save(koiFarms);
    }

    @Override
    public List<KoiFarms> findAll() {
        return iKoiFarmsDAO.findAll();
    }

    @Override
    public void delete(Long id) {
    iKoiFarmsDAO.delete(id);
    }

    @Override
    public KoiFarms findById(Long id) {
        return iKoiFarmsDAO.findById(id);
    }

    @Override
    public void update(KoiFarms koiFarms) {
            iKoiFarmsDAO.update(koiFarms);
    }

    @Override
    public List<KoiFarms> findByFarmName(String farmName) {
        return iKoiFarmsDAO.findByFarmName(farmName);
    }

    @Override
    public List<KoiFarms> findActiveFarms() {
        return iKoiFarmsDAO.findActiveFarms();
    }
}
