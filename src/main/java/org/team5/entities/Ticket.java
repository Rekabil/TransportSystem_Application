package org.team5.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tickets")
@DiscriminatorColumn(name = "tickets_type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("single_use")
public class Ticket {

    @Id
    @GeneratedValue
    private UUID id;
    private int validity;
    private LocalDate dateIssued;

    @ManyToOne
    @JoinColumn(name = "ticketVendor_id", nullable = false)
    private TicketVendor ticketVendor;

    public Ticket() {
    }

    public Ticket(int validity, LocalDate dateIssued, TicketVendor ticketVendor) {
        this.validity = validity;
        this.dateIssued = dateIssued;
        this.ticketVendor = ticketVendor;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "validity=" + validity +
                ", dateIssued=" + dateIssued +
                ", ticketVendor=" + ticketVendor +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public int getValidity() {
        return validity;
    }

    public void setValidity(int validity) {
        this.validity = validity;
    }

    public LocalDate getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(LocalDate dateIssued) {
        this.dateIssued = dateIssued;
    }

    public TicketVendor getTicketVendor() {
        return ticketVendor;
    }

    public void setTicketVendor(TicketVendor ticketVendor) {
        this.ticketVendor = ticketVendor;
    }
}
