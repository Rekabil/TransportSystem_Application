package org.team5.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "public transport")

public class PublicTransport {
    @Id
    @GeneratedValue
    private UUID id;
    private TransportStatus status;
    private LocalDate startDateStatus;
    private LocalDate endDateStatus;
    private TypeOfTransport transportType;

    /*private Route route;*/

    public PublicTransport() {
    }

    public PublicTransport(TransportStatus status, LocalDate startDateStatus, LocalDate endDateStatus,
                           TypeOfTransport transportType) {
        this.status = status;
        this.startDateStatus = startDateStatus;
        this.endDateStatus = endDateStatus;
        this.transportType = transportType;
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
}
