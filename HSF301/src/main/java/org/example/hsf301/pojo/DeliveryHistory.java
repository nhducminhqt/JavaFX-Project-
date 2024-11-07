package org.example.hsf301.pojo;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "delivery_history")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "route")
    private String route;

    @Column(name = "health_koi_description")
    private String healthKoiDescription;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "booking_id")
    private Bookings booking;

    @Column(name = "created_at")
    private LocalDate createdDate;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "delivery_staff_id")
    private Account deliveryStaff;

    @PrePersist
    protected void onCreate(){
        createdDate = LocalDate.now();
    }
}

