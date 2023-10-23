package org.team5.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserCard {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private LocalDate dateRenewed;
    private LocalDate cardExpiryDate;

    @OneToOne(mappedBy = "user")
    private TicketSubscription ticketSubscription;

    public UserCard() {
    }

    public UserCard(String name, String surname, LocalDate dateOfBirth, LocalDate dateRenewed, LocalDate cardExpiryDate) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.dateRenewed = dateRenewed;
        this.cardExpiryDate = cardExpiryDate;
    }

    @Override
    public String toString() {
        return "UserCard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateRenewed=" + dateRenewed +
                ", cardExpiryDate=" + cardExpiryDate +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateRenewed() {
        return dateRenewed;
    }

    public void setDateRenewed(LocalDate dateRenewed) {
        this.dateRenewed = dateRenewed;
    }

    public LocalDate getCardExpiryDate() {
        return cardExpiryDate;
    }

    public void setCardExpiryDate(LocalDate cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }
}
