package org.team5.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue
    private UUID id;
    private String city;
    private String street;

    @OneToOne(mappedBy = "location")
    private TicketVendor ticketVendor;

    @OneToOne(mappedBy = "location")
    private Station station;

    @OneToOne(mappedBy = "takeOffLocation")
    private Route startRoute;

    @OneToOne(mappedBy = "destination")
    private Route destinationRoute;



    public Location(){}

    public Location(String city, String street) {
        this.city = city;
        this.street = street;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

    public UUID getId() {
        return id;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
