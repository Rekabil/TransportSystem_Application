package org.team5.dao;

import javax.persistence.EntityManager;

public class TicketVendorDao {
    private final EntityManager em;

    public TicketVendorDao(EntityManager em){
        this.em = em;
    }

}
