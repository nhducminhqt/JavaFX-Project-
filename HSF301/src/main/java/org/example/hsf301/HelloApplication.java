package org.example.hsf301;

import org.example.hsf301.constants.ResourcePaths;
import org.example.hsf301.model.request.KoiFarmRequest;

import org.example.hsf301.model.request.KoiRequest;
import org.example.hsf301.pojo.Koi;
import org.example.hsf301.pojo.KoiFarms;
import org.example.hsf301.pojo.KoiOfFarm;
import org.example.hsf301.repo.IKoiFarmsRepository;
import org.example.hsf301.repo.IKoiOfFarmRepository;
import org.example.hsf301.repo.IKoiRepository;
import org.example.hsf301.service.AccountService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.example.hsf301.service.KoiFarmService;
import org.example.hsf301.service.KoiOfFarmService;
import org.example.hsf301.service.KoiService;
import org.example.hsf301.utils.AudioUtils;
import org.example.hsf301.utils.LogsUtils;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/example/hsf301/fxml/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 830, 650);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        KoiService koiService = new KoiService("hibernate.cfg.xml");
        KoiOfFarmService koiOfFarmService = new KoiOfFarmService("hibernate.cfg.xml");
        KoiFarmService koiFarmService = new KoiFarmService("hibernate.cfg.xml");


        // Add these to a list


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



        KoiFarmRequest koiFarmRequest = new KoiFarmRequest();
        koiFarmRequest.setFarmName("Golden Koi Farm");
        koiFarmRequest.setFarmPhoneNumber("+4234234234");
        koiFarmRequest.setFarmEmail("info@goldenkoi.com");
        koiFarmRequest.setFarmAddress("123 Koi Lane, Nishikigoi City");
        koiFarmRequest.setWebsite("www.goldenkoi.com");
        koiFarmRequest.setDescription("The finest Koi farm specializing in Kohaku and Sanke varieties.");
        koiFarmRequest.setActive(true);
        koiFarmRequest.setImages("goldenkoi.jpg, koi_image2.jpg");
        koiFarmService.addKoiFarm(koiFarmRequest);
        // Print the KoiFarmRequest object
        System.out.println(koiFarmRequest);
        List<KoiFarms> list =  koiFarmService.findByFarmName("golden");
        for (KoiFarms koiFarms : list)
        {
            System.out.println(koiFarms);
        }
       // KoiFarms koiFarms = koiFarmService.findById(1L);
       // System.out.println(koiFarms);
       // koiFarmService.delete(1L);
        koiFarmService.updateKoiFarm(2L,koiFarmRequest);
    }
}