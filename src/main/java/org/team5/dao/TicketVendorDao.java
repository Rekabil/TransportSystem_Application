package org.team5.dao;


import org.team5.entities.TicketVendor;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class TicketVendorDao {
    private final EntityManager em;

    public TicketVendorDao(EntityManager em){
        this.em = em;
    }

    public void saveNewTicketVendor(TicketVendor t) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(t);
        transaction.commit();
        System.out.println("Nuovo rivenditore aggiunto a database");
    }
    public TicketVendor searchById(UUID id) {
        return em.find(TicketVendor.class,id);
    }

    public void removeById(UUID id){
        TicketVendor a = em.find(TicketVendor.class, id);
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(a);
            transaction.commit();
            System.out.println("Rivenditore rimosso con successo");
        }catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.err.println("Il rivenditore con id " + id + " non esiste");
        }
    }
    public List<TicketVendor> showListTicketVendor(){
        TypedQuery<TicketVendor> getListQuery = em.createQuery("SELECT t FROM TicketVendor t", TicketVendor.class);
        return getListQuery.getResultList();
    }
}
