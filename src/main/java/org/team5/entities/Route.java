package org.team5.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue
    private UUID id;
    /*private Location takeOffLocation;
    private Location destination; */
    private double averageArrivalTime;

    public Route() {
    }

    public Route(double averageArrivalTime) {
        this.averageArrivalTime = averageArrivalTime;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getAverageArrivalTime() {
        return averageArrivalTime;
    }

    public void setAverageArrivalTime(double averageArrivalTime) {
        this.averageArrivalTime = averageArrivalTime;
    }
}
