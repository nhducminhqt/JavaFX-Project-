package org.example.hsf301.repo;

import org.example.hsf301.pojo.KoiImage;

import java.util.List;

/**
 * @author IKoiImageRepository
 */
public interface IKoiImageRepository {
    void save(KoiImage koiImage);

    void delete(Long id);
    void deleteByKois(Long koiId);
    List<KoiImage> findByKoiId(Long koiId);
}
