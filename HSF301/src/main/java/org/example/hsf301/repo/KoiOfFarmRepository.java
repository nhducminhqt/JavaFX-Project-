package org.example.hsf301.repo;

import org.example.hsf301.dao.IKoiOfFarmDAO;
import org.example.hsf301.dao.KoiOfFarmDAO;
import org.example.hsf301.pojo.KoiOfFarm;

import java.util.List;

/**
 * @author KoiOfFarmRepository
 */
public class KoiOfFarmRepository implements IKoiOfFarmRepository {
    private IKoiOfFarmDAO iKoiOfFarmDAO;
    public  KoiOfFarmRepository (String name)
    {
        iKoiOfFarmDAO = new KoiOfFarmDAO(name);
    }
    @Override
    public void save(KoiOfFarm koiOfFarm) {
        iKoiOfFarmDAO.save(koiOfFarm);
    }

    @Override
    public List<KoiOfFarm> findAll() {
        return iKoiOfFarmDAO.findAll();
    }

    @Override
    public void delete(Long id) {
        iKoiOfFarmDAO.delete(id);
    }

    @Override
    public KoiOfFarm findById(Long id) {
        return iKoiOfFarmDAO.findById(id);
    }

    @Override
    public void update(KoiOfFarm koiOfFarm) {
        iKoiOfFarmDAO.update(koiOfFarm);
    }

    @Override
    public List<KoiOfFarm> findByFarmId(Long farmId) {
        return iKoiOfFarmDAO.findByFarmId(farmId);
    }

    @Override
    public List<KoiOfFarm> findByKoiId(Long koiId) {
        return iKoiOfFarmDAO.findByKoiId(koiId);
    }

    @Override
    public List<KoiOfFarm> findAvailable() {
        return iKoiOfFarmDAO.findAvailable();
    }
    @Override
    public KoiOfFarm findByFarmIdAndKoiId(Long farmId, Long koiId)
    {
        return iKoiOfFarmDAO.findByFarmIdAndKoiId(farmId,koiId);

    }
}