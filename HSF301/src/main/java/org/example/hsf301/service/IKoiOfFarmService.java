package org.example.hsf301.service;

import org.example.hsf301.model.request.KoiOfFarmRequest;
import org.example.hsf301.pojo.KoiOfFarm;
import java.util.List;

public interface IKoiOfFarmService {
    KoiOfFarm addKoiOfFarm(KoiOfFarmRequest request)throws Exception;
    List<KoiOfFarm> findAll();
    void delete(Long id);
    KoiOfFarm findById(Long id);
    KoiOfFarm updateKoiOfFarm(Long id, KoiOfFarmRequest request)throws Exception;
    List<KoiOfFarm> findByFarmId(Long farmId)throws Exception;
    List<KoiOfFarm> findByKoiId(Long koiId)throws Exception;
    List<KoiOfFarm> findAvailable();
    void updateQuantity(Long id, int quantity);
    void updateAvailability(Long id, boolean available);
}