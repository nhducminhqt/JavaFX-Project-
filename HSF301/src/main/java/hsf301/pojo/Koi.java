package hsf301.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "kois")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Koi {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

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

        @OneToMany(mappedBy = "kois", cascade = {CascadeType.ALL})
        private Set<KoiOfFarm> koiOfFarmList;

        @OneToMany(mappedBy = "koi", cascade = {CascadeType.ALL})
        private Set<BookingKoiDetail> bookingKoiDetails;
}
