package org.team5.dao;


import org.team5.entities.Ticket;
import org.team5.entities.TicketVendor;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        System.out.println("New ticket vendor add in Database");
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
            System.out.println("ticket vendor removed");
        }catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.err.println("ticket vendor with id " + id + " don't exist");
        }
    }
    public List<TicketVendor> showListTicketVendor(){
        TypedQuery<TicketVendor> getListQuery = em.createQuery("SELECT t FROM TicketVendor t", TicketVendor.class);
        return getListQuery.getResultList();
    }

    public Map<TicketVendor, List<Ticket>> getTicketsByRangeDate(LocalDate d1, LocalDate d2) {
        TypedQuery<TicketVendor> vendorQuery = em.createQuery("SELECT tv FROM TicketVendor tv", TicketVendor.class);
        List<TicketVendor> vendors = vendorQuery.getResultList();

        Map<TicketVendor, List<Ticket>> ticketVendorMap = new HashMap<>();

        for (TicketVendor vendor : vendors) {
            TypedQuery<Ticket> getTicketsQuery = em.createQuery(
                    "SELECT t FROM Ticket t WHERE t.dateIssued BETWEEN :d1 AND :d2 AND t.ticketVendor = :vendor",
                    Ticket.class
            );
            getTicketsQuery.setParameter("d1", d1);
            getTicketsQuery.setParameter("d2", d2);
            getTicketsQuery.setParameter("vendor", vendor);

            List<Ticket> tickets = getTicketsQuery.getResultList();
            ticketVendorMap.put(vendor, tickets);
        }

        return ticketVendorMap;
    }
}
