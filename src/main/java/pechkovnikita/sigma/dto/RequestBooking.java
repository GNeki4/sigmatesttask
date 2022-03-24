package pechkovnikita.sigma.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class RequestBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String owner;
    private String place;
    private String price;
    private String time;

    public RequestBooking(String owner, String place, String time, String price) {
        this.owner = owner;
        this.place = place;
        this.time = time;
        this.price = price;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
