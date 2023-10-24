package org.team5.dao;

import org.team5.entities.Ticket;
import org.team5.entities.UserCard;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserCardDAO {
    private final EntityManager em;

    public UserCardDAO(EntityManager em) {

        this.em = em;
    }

    public void save(UserCard a) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();


        em.persist(a);


        transaction.commit();
        System.out.println("Nuovo abbonamento salvato correttamente");
    }

    public UserCard findElementById(long id) {
        if (em.find(UserCard.class, id) == null) throw new RuntimeException("id abbonamento non esistente");
        else return em.find(UserCard.class, id
        );
    }

    public void findByIdAndDelete(long id) {
        // 1. Faccio una find per cercare lo studente
        UserCard found = em.find(UserCard.class, id);

        if (found != null) {

            EntityTransaction transaction = em.getTransaction();

            transaction.begin();


            em.remove(found);

            transaction.commit();
            System.out.println("l'abbonamento  è stato eliminato correttamente");
        } else {

            System.err.println("Lo studente con l'id " + id + " non è stato trovato");
        }
    }

    public List<UserCard> printUserCards() {

        TypedQuery<UserCard> getAllQuery = em.createQuery("SELECT d FROM UserCard d", UserCard.class); // Query JPQL
        return getAllQuery.getResultList();
    }

}
