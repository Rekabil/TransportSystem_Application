package org.team5.dao;

import org.team5.entities.PublicTransport;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class PublicTransportDao {
    private final EntityManager em;

    public PublicTransportDao(EntityManager em){
        this.em = em;
    }


    public void saveNewPublicTransport(PublicTransport e) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(e);
        transaction.commit();
        System.out.println("Nuovo mezzo pubblico aggiunto a database");
    }
    public PublicTransport searchById(UUID id) {
        return em.find(PublicTransport.class,id);
    }

    public void removeById(UUID id){
        PublicTransport a = em.find(PublicTransport.class, id);
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(a);
            transaction.commit();
            System.out.println("Mezzo pubblico rimosso con successo");
        }catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.err.println("Il mezzo con id " + id + " non esiste");
        }
    }
    public List<PublicTransport> showListPublicTransport(){
        TypedQuery<PublicTransport> getListQuery = em.createQuery("SELECT p FROM PubblicTransport p", PublicTransport.class);
        return getListQuery.getResultList();
    }
}
