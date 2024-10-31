package org.example.hsf301.service;

import org.example.hsf301.model.request.KoiRequest;
import org.example.hsf301.pojo.Koi;

import java.util.List;

/**
 * @author IKoiService
 */
public interface IKoiService {
    // Save a new Koi record
    Koi addKoi(KoiRequest koi);

    // Find all Koi records
    List<Koi> findAll();

    // Delete a Koi record by ID
    void delete(Long id);

    // Find a Koi record by ID
    Koi findById(Long id);

    // Update an existing Koi record
    Koi updateKoi(Long id,KoiRequest koi);

    // Find Koi records by color
    List<Koi> findByColor(String color);

    // Find Koi records by koiName
    List<Koi> findByKoiName(String koiName);

    // Additional methods can be defined as needed
}
