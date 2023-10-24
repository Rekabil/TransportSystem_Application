package org.team5.entities;

import net.bytebuddy.asm.Advice;

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
    @Enumerated(EnumType.STRING)
    public TicketValidity validity;
    private LocalDate dateIssued;

    @ManyToOne
    @JoinColumn(name = "ticketVendor_id")
    private TicketVendor ticketVendor;

    public Ticket() {
    }

    public Ticket(LocalDate dateIssued, TicketVendor ticketVendor) {
        this.dateIssued = dateIssued;
        setValidity();
        this.ticketVendor = ticketVendor;
    }

    private void setValidity() {
        this.validity = TicketValidity.VALID;
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
