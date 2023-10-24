package org.team5.dao;


import org.team5.entities.Location;
import org.team5.entities.Route;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class RouteDAO {
    private final EntityManager em;

    public RouteDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Route route) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(route);

        transaction.commit();
        System.out.println("New Location Added");
    }
    public Route findById(UUID id) {
        return em.find(Route.class, id);
    }
    public void deleteById(UUID id) {
        Route found = em.find(Route.class, id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Route Removed");
        } else {
            System.out.println("Error: Route Not Found");
        }
    }

public List<Route> findByTakeOff(Location location) {
    TypedQuery<Route> getRoute = em.createQuery("SELECT r FROM Route r WHERE r.takeOffLocation = :takeOffLocation", Route.class);
    getRoute.setParameter("takeOffLocation", location);
    return getRoute.getResultList();
}
    public List<Route> findByDestination(Location location) {
        TypedQuery<Route> getRoute = em.createQuery("SELECT r FROM Route r WHERE r.destination = :destination", Route.class);
        getRoute.setParameter("destination", location);
        return getRoute.getResultList();
    }

}
