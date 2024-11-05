package org.example.hsf301.pojo;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "koi_farms")
public class KoiFarms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "farmName")
    private String farmName;

    @Column(name = "farmPhoneNumber")
    private String farmPhoneNumber;

    @Column(name = "farmEmail")
    private String farmEmail;

    @Column(name="image")
    private String image;
    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    @Column(name = "farmAddress")
    private String farmAddress;

    @Column(name = "website")
    private String website;

    @Column(name = "isActive")
    private boolean isActive;

 @OneToMany(mappedBy = "koiFarms", cascade = {CascadeType.ALL})
 private Set<BookingKoiDetail> bookingKoiDetails;

    @OneToMany(mappedBy = "farm", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},fetch = FetchType.LAZY)
    private Set<TourDetail> tourDetails;

    @OneToMany(mappedBy = "koiFarms", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},fetch = FetchType.LAZY)
    private Set<KoiOfFarm> koiOfFarms;

//    @Override
//    public String toString() {
//        return "KoiFarms{" +
//                "id=" + id +
//                ", farmName='" + farmName + '\'' +
//                ", farmPhoneNumber='" + farmPhoneNumber + '\'' +
//                ", farmEmail='" + farmEmail + '\'' +
//                ", image='" + image + '\'' +
//                ", description='" + description + '\'' +
//                ", farmAddress='" + farmAddress + '\'' +
//                ", website='" + website + '\'' +
//                ", isActive=" + isActive +
//                '}';
//    }
}
