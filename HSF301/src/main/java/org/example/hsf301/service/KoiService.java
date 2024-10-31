package org.example.hsf301.service;

import org.example.hsf301.model.request.KoiImageRequest;
import org.example.hsf301.model.request.KoiRequest;
import org.example.hsf301.pojo.Koi;
import org.example.hsf301.pojo.KoiImage;
import org.example.hsf301.repo.IKoiRepository;
import org.example.hsf301.repo.KoiRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KoiService
 */
public class KoiService  implements  IKoiService{
    private IKoiRepository koiRepository;
    public KoiService (String name)
    {
        koiRepository = new KoiRepository(name);
    }
    @Override
    public Koi addKoi(KoiRequest koiRequest) {
       Koi koi = convertToEntity(koiRequest);

        try {
            if (koiRequest == null) {
                throw new IllegalArgumentException("KoiRequest cannot be null");
            }
            // Convert KoiRequest to Koi entity
            List<KoiImageRequest> koiImageList = koiRequest.getKoiImageList();
            List<KoiImage> koiImages = new ArrayList<>();
            for (KoiImageRequest koiImageRequest : koiImageList) {
                KoiImage koiImage = new KoiImage();
                koiImage.setImageUrl(koiImageRequest.getImageUrl());
               // koiImage.setId(null);
                //koiImage.setKois(koi);
                koiImages.add(koiImage);
            }
            koi.setActive(true);
            koi.setKoiImageList(koiImages);
            koi.setOrigin(koiRequest.getOrigin());
            koiRepository.save(koi);
            return koi;
        } catch (Exception e) {
            throw new RuntimeException("Failed to save koi: " + e.getMessage());
        }
    }

    @Override
    public List<Koi> findAll() {
        return koiRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        koiRepository.delete(id);
    }

    @Override
    public Koi findById(Long id) {
        return koiRepository.findById(id);
    }

    @Override
    public Koi updateKoi(Long id,KoiRequest koiRequest) {
        Koi kois = koiRepository.findById(id);
        if (koiRequest==null)
        {
            throw new IllegalArgumentException("KoiRequest cannot be null");
        }
        kois = convertToEntity(koiRequest);


        kois.setKoiName(koiRequest.getKoiName());
        kois.setOrigin(koiRequest.getOrigin());
        kois.setColor(koiRequest.getColor());
        kois.setDescription(koiRequest.getDescription());
        List<KoiImageRequest> koiImageList = koiRequest.getKoiImageList();
        List<KoiImage> koiImages = new ArrayList<>();
        for (KoiImageRequest koiImageRequest : koiImageList) {
            KoiImage koiImage = new KoiImage();
            koiImage.setImageUrl(koiImageRequest.getImageUrl());
            koiImage.setId(null);
            koiImage.setKois(kois);
            koiImages.add(koiImage);
        }
        kois.setKoiImageList(koiImages);
        koiRepository.update(kois);
        return kois;
    }

    @Override
    public List<Koi> findByColor(String color) {
        return koiRepository.findByColor(color);
    }

    @Override
    public List<Koi> findByKoiName(String koiName) {
        return koiRepository.findByKoiName(koiName);
    }
    private Koi convertToEntity(KoiRequest koiRequest) {
        Koi koi = new Koi();
        if (koiRequest == null) {
            throw new IllegalArgumentException("KoiRequest cannot be null");
        }

        // Set basic properties
        koi.setKoiName(koiRequest.getKoiName());
        koi.setColor(koiRequest.getColor());
        //koi.setPattern(koiRequest.getPattern());
       // koi.setSize(koiRequest.getSize());
       // koi.setPrice(koiRequest.getPrice());
        koi.setDescription(koiRequest.getDescription());
       // koi.setKoiImage(koiRequest.getKoiImageList());
      //  koi.setAge(koiRequest.getAge());
       // koi.setGender(koiRequest.getGender());
//koi.setIsAvailable(koiRequest.getIsAvailable());

        // Set default values if needed
//        if (koi.set() == null) {
//            koi.setIsAvailable(true);
//        }
        return koi;
    }

}
