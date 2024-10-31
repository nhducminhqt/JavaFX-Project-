package org.example.hsf301.dao;

import org.example.hsf301.pojo.KoiFarms;

import java.util.List;

/**
 * @author IKoiFarmsDAO
 */
public interface IKoiFarmsDAO {
    void save(KoiFarms koiFarms);
    List<KoiFarms> findAll();
    void delete(Long id);
    KoiFarms findById(Long id);
    void update(KoiFarms koiFarms);
    List<KoiFarms> findByFarmName(String farmName);
    List<KoiFarms> findActiveFarms();
}