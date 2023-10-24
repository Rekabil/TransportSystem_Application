package org.team5.dao;

import org.team5.entities.Location;
import org.team5.entities.Route;
import org.team5.entities.Station;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class StationDAO {

    private final EntityManager em;

    public StationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Station station)
    {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(station);

        transaction.commit();
        System.out.println("New Station: " + station + " saved");
    }

    public Station findStationById(UUID id)
    {
        return em.find(Station.class, id);
    }

    public void findStationByIdAndDelete(UUID id)
    {
        Station found = em.find(Station.class, id);

        if(found != null)
        {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Station Deleted");
        }else{
            System.out.println("This Station was not found");
        }
    }

    public List<Station> filterStationByLocation(Location location)
    {
        TypedQuery<Station> getNames = em.createNamedQuery("SELECT s.location FROM Station s", Station.class);
        return getNames.getResultList();
    }
}
