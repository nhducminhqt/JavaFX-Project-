package org.example.hsf301.pojo;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;
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

 @OneToMany(mappedBy = "koiFarms", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},fetch = FetchType.LAZY)
 private Set<BookingKoiDetail> bookingKoiDetails;

    @OneToMany(mappedBy = "farm", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},fetch = FetchType.LAZY)
    private Set<TourDetail> tourDetails;

    @OneToMany(mappedBy = "koiFarms", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},fetch = FetchType.LAZY)
    private Set<KoiOfFarm> koiOfFarms;

    @Override
    public String toString() {
        return "KoiFarms{" +
                "id=" + id +
                ", farmName='" + farmName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KoiFarms koiFarms = (KoiFarms) o;
        return isActive == koiFarms.isActive && Objects.equals(id, koiFarms.id) && Objects.equals(farmName, koiFarms.farmName) && Objects.equals(farmPhoneNumber, koiFarms.farmPhoneNumber) && Objects.equals(farmEmail, koiFarms.farmEmail) && Objects.equals(image, koiFarms.image) && Objects.equals(description, koiFarms.description) && Objects.equals(farmAddress, koiFarms.farmAddress) && Objects.equals(website, koiFarms.website) && Objects.equals(bookingKoiDetails, koiFarms.bookingKoiDetails) && Objects.equals(tourDetails, koiFarms.tourDetails) && Objects.equals(koiOfFarms, koiFarms.koiOfFarms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, farmName, farmPhoneNumber, farmEmail, image, description, farmAddress, website, isActive, bookingKoiDetails, tourDetails, koiOfFarms);
    }
}
