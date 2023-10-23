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
    private Location location;
    private Set<PublicTransport> pubTransList;

    @OneToMany(mappedBy = "station")
    private List<PublicTransport> publicTransport;

    public Station() {
    }

    public Station(Location location, Set<PublicTransport> pubTransList) {
        this.location = location;
        this.pubTransList = pubTransList;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", location=" + location +
                ", pubTransList=" + pubTransList +
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

    public Set<PublicTransport> getPubTransList() {
        return pubTransList;
    }

    public void setPubTransList(Set<PublicTransport> pubTransList) {
        this.pubTransList = pubTransList;
    }
}
