package org.team5.entities;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ticket_vendors")
@DiscriminatorColumn(name = "vendor_type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("authorized_vendor")
public class TicketVendor {

    @Id
    @GeneratedValue
    private UUID id;
    @OneToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @OneToMany(mappedBy = "ticketVendor")
    private List<Ticket> ticket;

    public TicketVendor() {
    }

    public TicketVendor(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "TicketVendor{" +
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
