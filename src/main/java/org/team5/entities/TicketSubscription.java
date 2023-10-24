package org.team5.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("subscription")
public class TicketSubscription extends Ticket {

    @Enumerated(EnumType.STRING)
    private Period validation;

    @OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "user_id")
    private UserCard userCard;
    private LocalDate expiryDate;


    public TicketSubscription() {
    }



    public TicketSubscription(LocalDate dateIssued, TicketVendor ticketVendor,
                              Period validation, UserCard userCard, LocalDate expiryDate) {
        super( dateIssued, ticketVendor);
        this.validation = validation;
        this.userCard = userCard;
        this.expiryDate = expiryDate;
    }

    public void setValidation(Period validation) {
        this.validation = validation;
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


    public void setValidity() {


        if(LocalDate.now().isAfter(this.getDateIssued()) || LocalDate.now().isEqual(this.getDateIssued()))
        {
            this.validity = TicketValidity.INVALID;
        }else{
            this.validity = TicketValidity.VALID;
        }
    }
}