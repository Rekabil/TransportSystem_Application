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


    public TicketSubscription() {
    }

    public TicketSubscription(LocalDate dateIssued, TicketVendor ticketVendor, Period validation, UserCard userCard) {
        super(dateIssued, ticketVendor);
        this.validation = validation;
        this.userCard = userCard;
        this.setExpiryDate();
    }
    public void setValidation(Period validation) {
        this.validation = validation;
    }

    @Override
    public String toString() {
        return "TicketSubscription{" +
                "validation=" + validation +
                ", userCard=" + userCard +
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

    @Override
    public void setExpiryDate() {
        if(this.validation == Period.WEEKLY ){
            this.expiryDate = getDateIssued().plusDays(7);
        }else{
            this.expiryDate = getDateIssued().plusMonths(1);
        }
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