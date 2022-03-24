package pechkovnikita.sigma.dto;

import javax.persistence.*;

public class RequestParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String place;

    public RequestParkingLot() {
    }

    public RequestParkingLot(String place) {
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
