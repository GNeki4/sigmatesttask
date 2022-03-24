package pechkovnikita.sigma.dto;

import javax.persistence.*;

public class RequestCar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String owner;
    private String mark;

    public RequestCar(String owner, String mark) {
        this.owner = owner;
        this.mark = mark;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
