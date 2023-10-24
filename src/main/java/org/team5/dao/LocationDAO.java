package org.team5.dao;

import org.team5.entities.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class LocationDAO {
private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);

        transaction.commit();
        System.out.println("New Location Added");
    }
    public Location findById(UUID id) {
        return em.find(Location.class, id);
    }

    public void deleteById(UUID id) {
        Location found = em.find(Location.class, id);

        if (found != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Location Removed");
        } else {
            System.out.println("Error: Location Not Found");
        }

    }

public List<Location> findByCity(String city)    {
    TypedQuery<Location> getLocation = em.createQuery("SELECT l FROM Location l WHERE l.city = :city", Location.class);
    getLocation.setParameter("city" , city);
    return getLocation.getResultList();
}
    public List<Location> findByStreet(String street) {
        TypedQuery<Location> getLocation = em.createQuery("SELECT l FROM Location l WHERE LOWER(l.street) LIKE LOWER(CONCAT(:street, '%'))", Location.class);
        getLocation.setParameter("street" , street);
        return getLocation.getResultList();
    }

}
