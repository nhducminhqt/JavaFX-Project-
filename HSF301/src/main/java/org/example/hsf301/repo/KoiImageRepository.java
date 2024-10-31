package org.example.hsf301.repo;

import org.example.hsf301.dao.IKoiImageDAO;
import org.example.hsf301.dao.KoiImageDAO;
import org.example.hsf301.pojo.KoiImage;

import java.util.List;

/**
 * @author KoiImageRepository
 */
public class KoiImageRepository implements IKoiImageRepository{
    private IKoiImageDAO iKoiImageDAO;
    public KoiImageRepository (String name)
    {
        iKoiImageDAO = new KoiImageDAO(name);

    }
    @Override
    public void save(KoiImage koiImage) {
    iKoiImageDAO.save(koiImage);
    }

    @Override
    public void delete(Long id) {
    iKoiImageDAO.delete(id);
    }

    @Override
    public void deleteByKois(Long koiId) {
iKoiImageDAO.deleteByKois(koiId);
    }

    @Override
    public List<KoiImage> findByKoiId(Long koiId) {
        return List.of();
    }
}
