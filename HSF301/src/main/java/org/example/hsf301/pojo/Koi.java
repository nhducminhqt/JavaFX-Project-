package org.example.hsf301.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "kois")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"koiOfFarmList", "bookingKoiDetails"})
public class Koi {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        Long id;

        @Column(name = "koi_name")
        private String koiName;

        @Column(name = "origin")
        private String origin;

        @Column(name = "color")
        private String color;

        @Column(name = "description")
        private String description;

        @Column(name = "koi_image")
        private String koiImage;

        @Column(name = "is_active")
        private boolean isActive;

        @OneToMany(mappedBy = "koi", cascade = {CascadeType.ALL})
        @JsonIgnore
        private Set<KoiOfFarm> koiOfFarmList;

        @OneToMany(mappedBy = "koi", cascade = {CascadeType.ALL})
        @JsonIgnore
        private Set<BookingKoiDetail> bookingKoiDetails;


}
