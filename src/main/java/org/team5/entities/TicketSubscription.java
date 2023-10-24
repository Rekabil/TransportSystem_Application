package org.team5.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("subscription")
public class TicketSubscription extends Ticket {

    @Enumerated(EnumType.STRING)
    private Period validation;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserCard userCard;
    private LocalDate expiryDate;


    public TicketSubscription() {
    }



    public TicketSubscription(int validity, LocalDate dateIssued, TicketVendor ticketVendor,
                              Period validation, UserCard userCard, LocalDate expiryDate) {
        super(validity, dateIssued, ticketVendor);
        this.validation = validation;
        this.userCard = userCard;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "TicketSubscription{" +
                "validation=" + validation +
                ", userCard=" + userCard +
                ", expiryDate=" + expiryDate +
                '}';
    }

    public Period getValidation() {
        return validation;
    }

    public void setValidation(Period validation) {
        this.validation = validation;
    }

    public UserCard getUserCard() {
        return userCard;
    }

    public void setUserCard(UserCard userCard) {
        this.userCard = userCard;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}