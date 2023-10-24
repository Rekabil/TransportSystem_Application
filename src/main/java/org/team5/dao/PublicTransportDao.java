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


    public void saveNewPublicTransport(PublicTransport p) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(p);
        transaction.commit();
        System.out.println("New public transport add in Database");
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
            System.out.println("public transport removed");
        }catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.err.println("public transport with id " + id + " don't exist");
        }
    }
    public List<PublicTransport> showListPublicTransport(){
        TypedQuery<PublicTransport> getListQuery = em.createQuery("SELECT p FROM PublicTransport p", PublicTransport.class);
        return getListQuery.getResultList();
    }
}
