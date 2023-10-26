package org.team5.dao;

import org.team5.entities.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class TicketDAO {
    private final EntityManager em;

    public TicketDAO(EntityManager em) {

        this.em = em;
    }

    public void save(Ticket a) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(a);

        transaction.commit();
        System.out.println("Nuovo ticket salvato correttamente");
    }

    public Ticket findElementById(long id) {
        if (em.find(Ticket.class, id) == null) throw new RuntimeException("id ticket non esistente");
        else return em.find(Ticket.class, id
        );
    }

    public void findByIdAndDelete(long id) {
        // 1. Faccio una find per cercare lo studente
        Ticket found = em.find(Ticket.class, id);

        if (found != null) {

            EntityTransaction transaction = em.getTransaction();

            transaction.begin();


            em.remove(found);

            transaction.commit();
            System.out.println("Il ticket  è stato cancellato correttamente");
        } else {

            System.err.println("Lo studente con l'id " + id + " non è stato trovato");
        }
    }

    public List<Ticket> printTickets() {

        TypedQuery<Ticket> getAllQuery = em.createQuery("SELECT d FROM Ticket d", Ticket.class); // Query JPQL
        return getAllQuery.getResultList();
    }



}
