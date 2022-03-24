package pechkovnikita.sigma.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PARKING_LOTS")
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "parking_lot_id")
    private long id;

    @Column(name = "place")
    private String place;

    @OneToMany
    private List<Booking> bookings = new ArrayList<>();

    public ParkingLot() {

    }

    public ParkingLot(String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
