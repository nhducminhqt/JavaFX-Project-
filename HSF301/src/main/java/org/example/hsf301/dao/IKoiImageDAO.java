package org.example.hsf301.dao;

import org.example.hsf301.pojo.KoiImage;

import java.util.List;

/**
 * @author IKoiImageDAO
 */
public interface IKoiImageDAO {
    void save(KoiImage koiImage);

    void delete(Long id);
    void deleteByKois(Long koiId);
    List<KoiImage> findByKoiId(Long koiId);
}