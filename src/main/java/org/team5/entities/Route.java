package org.team5.entities;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue
    private UUID id;
    private Location takeOffLocation;
    private Location destination;
    private double averageArrivalTime;

    @OneToMany(mappedBy = "route")
    private List<PublicTransport> publicTransport;

    public Route() {
    }

    public Route(Location takeOffLocation, Location destination, double averageArrivalTime) {
        this.takeOffLocation = takeOffLocation;
        this.destination = destination;
        this.averageArrivalTime = averageArrivalTime;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", takeOffLocation=" + takeOffLocation +
                ", destination=" + destination +
                ", averageArrivalTime=" + averageArrivalTime +
                '}';
    }

    public UUID getId() {
        return id;
    }


    public Location getTakeOffLocation() {
        return takeOffLocation;
    }

    public void setTakeOffLocation(Location takeOffLocation) {
        this.takeOffLocation = takeOffLocation;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public double getAverageArrivalTime() {
        return averageArrivalTime;
    }

    public void setAverageArrivalTime(double averageArrivalTime) {
        this.averageArrivalTime = averageArrivalTime;
    }
}
