package org.team5.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "stations")
public class Station {
    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;


    @OneToMany(mappedBy = "station")
    private List<PublicTransport> publicTransport;

    public Station() {
    }

    public Station(Location location) {
        this.location = location;

    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", location=" + location +
                '}';
    }

    public UUID getId() {
        return id;
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }




}
