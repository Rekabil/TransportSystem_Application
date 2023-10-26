package org.team5.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "public_transport")

public class PublicTransport {
    @Id
    @GeneratedValue
    private UUID id;
    @Enumerated(EnumType.STRING)
    private TransportStatus status;
    private LocalDate startDateStatus;
    private LocalDate endDateStatus;

    private int capacity;
    @Enumerated(EnumType.STRING)
    private TypeOfTransport transportType;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = true)
    private Route route;

    @ManyToOne
    @JoinColumn(name = "publicTrans_id", nullable = true)
    private Station station;

    @OneToMany(mappedBy = "publicTransport")
    private List<Ticket> ticketList;


    public PublicTransport() {
    }

    public PublicTransport(TransportStatus status, LocalDate startDateStatus, LocalDate endDateStatus, int capacity,
                           TypeOfTransport transportType) {
        this.status = status;
        this.startDateStatus = startDateStatus;
        this.endDateStatus = endDateStatus;
        this.transportType = transportType;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "PublicTransport{" +
                "id=" + id +
                ", status=" + status +
                ", startDateStatus=" + startDateStatus +
                ", endDateStatus=" + endDateStatus +
                ", capacity=" + capacity +
                ", transportType=" + transportType +
                ", route=" + route +
                ", station=" + station +
                '}';
    }


    public void setRoute(Route route) {
        this.route = route;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public UUID getId() {
        return id;
    }

    public TransportStatus getStatus() {
        return status;
    }

    public void setStatus(TransportStatus status) {
        this.status = status;
    }

    public LocalDate getStartDateStatus() {
        return startDateStatus;
    }

    public void setStartDateStatus(LocalDate startDateStatus) {
        this.startDateStatus = startDateStatus;
    }

    public LocalDate getEndDateStatus() {
        return endDateStatus;
    }

    public void setEndDateStatus(LocalDate endDateStatus) {
        this.endDateStatus = endDateStatus;
    }

    public TypeOfTransport getTransportType() {
        return transportType;
    }

    public void setTransportType(TypeOfTransport transportType) {
        this.transportType = transportType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }
}
