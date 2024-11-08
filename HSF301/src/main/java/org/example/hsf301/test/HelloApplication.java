package org.example.hsf301.test;


import org.example.hsf301.model.request.QuotationRequest;
import org.example.hsf301.pojo.BookingTourDetail;
import org.example.hsf301.pojo.Bookings;
import org.example.hsf301.pojo.Quotations;
import org.example.hsf301.service.*;
import org.example.hsf301.views.LoginView;

import java.util.List;


public class HelloApplication extends LoginView {

    public static void main(String[] args) {


        KoiService koiService = new KoiService("hibernate.cfg.xml");
        KoiOfFarmService koiOfFarmService = new KoiOfFarmService("hibernate.cfg.xml");
        KoiFarmService koiFarmService = new KoiFarmService("hibernate.cfg.xml");
        QuotationService quotationService = new QuotationService("hibernate.cfg.xml");
        BookingService bookingService = new BookingService("hibernate.cfg.xml");
        // Add these to a list
        BookingTourService bookingTourService = new BookingTourService("hibernate.cfg.xml");


        // Create a KoiRequest object with all fields populated
//        KoiRequest koiRequest = new KoiRequest();
//        koiRequest.setKoiName("Kohaku");
//        koiRequest.setImage("aans.jpg");
//        koiRequest.setDescription("A beautiful Kohaku Koi fish with vibrant red patterns.");
//        koiRequest.setColor("Red and White");
//        koiRequest.setOrigin("Japan");
//        koiService.addKoi(koiRequest);
//        Koi findKoi = koiService.findByKoiId(19L);
//       // koiService.delete(Long.valueOf(1));
//        System.out.println(findKoi);
//        System.out.println(koiService);
//        koiService.updateKoi(3L,koiRequest);



//        KoiFarmRequest koiFarmRequest = new KoiFarmRequest();
//        koiFarmRequest.setFarmName("Golden Koi Farm");
//        koiFarmRequest.setFarmPhoneNumber("+4234234234");
//        koiFarmRequest.setFarmEmail("info@goldenkoi.com");
//        koiFarmRequest.setFarmAddress("123 Koi Lane, Nishikigoi City");
//        koiFarmRequest.setWebsite("www.goldenkoi.com");
//        koiFarmRequest.setDescription("The finest Koi farm specializing in Kohaku and Sanke varieties.");
//        koiFarmRequest.setActive(true);
//        koiFarmRequest.setImages("goldenkoi.jpg, koi_image2.jpg");
//        koiFarmService.addKoiFarm(koiFarmRequest);
//        // Print the KoiFarmRequest object
//        System.out.println(koiFarmRequest);
//        List<KoiFarms> list =  koiFarmService.findByFarmName("golden");
//        for (KoiFarms koiFarms : list)
//        {
//            System.out.println(koiFarms);
//        }
//       // KoiFarms koiFarms = koiFarmService.findById(1L);
//       // System.out.println(koiFarms);
//       // koiFarmService.delete(1L);
//        koiFarmService.updateKoiFarm(2L,koiFarmRequest);


        QuotationRequest request = new QuotationRequest();
        request.setBookingId(1L);  // ID giả định của booking
        request.setAmount(2500.75f); // Số tiền mẫu
        request.setDescription("This is a sample quotation description."); // Mô tả mẫu

       try {
           Quotations quotations = quotationService.createQuotations(request,null);
           System.out.println(quotations);
       }
       catch (Exception e)
       {

       }
//        List<Bookings> list = bookingTourService.getAllTourBookings();
//        for (Bookings bookings : list)
//        {
//            System.out.println(bookings);
//        }
    }

}