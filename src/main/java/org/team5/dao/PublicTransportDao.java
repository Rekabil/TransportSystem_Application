package org.team5.dao;

import org.team5.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public void setRoute(PublicTransport pb, Route r)
    {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        pb.setRoute(r);
        transaction.commit();
        System.out.println("Route changed");

    } public void setStation(PublicTransport pb, Station s)
    {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        pb.setStation(s);
        transaction.commit();
        System.out.println("Station changed");

    }
    public List<PublicTransport> getInServiceTransports(){
        TypedQuery<PublicTransport> inserviceTransportQuery = em.createQuery("SELECT p FROM PublicTransport p WHERE p.status = 'INSERVICE'", PublicTransport.class);
        return inserviceTransportQuery.getResultList();
    }
    public List<PublicTransport> getOutOfServiceTransports(){
        TypedQuery<PublicTransport> outOfServiceTransportQuery = em.createQuery("SELECT p FROM PublicTransport p WHERE p.status = 'OUT_OF_SERVICE'", PublicTransport.class);
        return outOfServiceTransportQuery.getResultList();
    }

    public Map<PublicTransport, List<Ticket>> getTicketsByRangeDate(LocalDate d1, LocalDate d2) {
        TypedQuery<PublicTransport> vendorQuery = em.createQuery("SELECT pb FROM PublicTransport pb", PublicTransport.class);
        List<PublicTransport> publicTransports = vendorQuery.getResultList();

        Map<PublicTransport, List<Ticket>> publicTransportListMap = new HashMap<>();

        for (PublicTransport publicTransport : publicTransports) {
            TypedQuery<Ticket> getTicketsQuery = em.createQuery(
                    "SELECT t FROM Ticket t WHERE t.expiryDate BETWEEN :d1 AND :d2 AND t.publicTransport = :publicTransport",
                    Ticket.class
            );
            getTicketsQuery.setParameter("d1", d1);
            getTicketsQuery.setParameter("d2", d2);
            getTicketsQuery.setParameter("publicTransport", publicTransport);

            List<Ticket> tickets = getTicketsQuery.getResultList();
            publicTransportListMap.put(publicTransport, tickets);
        }

        return publicTransportListMap;
    }


}
