package org.team5;

import com.github.javafaker.Faker;
import org.team5.dao.JpaUtils;
import org.team5.dao.LocationDAO;
import org.team5.dao.RouteDAO;
import org.team5.entities.Location;
import org.team5.entities.Route;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Locale;
import java.util.UUID;
import java.util.function.Supplier;

public class Application {

    public static void main(String[] args) {

        EntityManagerFactory emf = JpaUtils.getEntityManagerFactory();

        EntityManager em = emf.createEntityManager();

        Faker faker = new Faker(Locale.ITALY);
        LocationDAO locDAO = new LocationDAO(em);
        RouteDAO routeDAO = new RouteDAO(em);

        //Location location = new Location();
        Supplier<Location> location1 = () -> new Location(faker.address().cityName(), faker.address().streetName());



/*       Location l1 = locDAO.findById(UUID.fromString("231d11a0-aed6-456e-a886-5e77ebf23d34"));
       Location l2 = locDAO.findById(UUID.fromString("24fc9374-5e1d-4825-9d55-94d4782c414c"));
       Location l3 = locDAO.findById(UUID.fromString("2d72a2ae-550e-4833-a054-e0e7a89d79e2"));
       Location l4 = locDAO.findById(UUID.fromString("4c26a837-52e2-4129-a19d-f2979be2e694"));*/

      /*  Route route1 = new Route(l1, l2, 44.5);
        Route route2 = new Route(l3, l4, 36.5);

        routeDAO.save(route1);
        routeDAO.save(route2);*/



        try{

            for (int i = 0; i < 20; i++) {
                //locDAO.save(location1.get());
            }



        }catch (Exception ex)
        {
            System.err.println(ex.getMessage());
        }finally {
            em.close();
            emf.close();
        }



    }
}
