package org.team5;

import com.github.javafaker.Faker;
import org.team5.dao.*;
import org.team5.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.util.Date;
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
        PublicTransportDao publicTransportDao = new PublicTransportDao(em);
        TicketVendorDao ticketVendorDao = new TicketVendorDao(em);
        TicketDAO ticketDAO = new TicketDAO(em);
        UserCardDAO userCardDAO = new UserCardDAO(em);
        StationDAO stationDAO = new StationDAO(em);


        //Location location = new Location();
        Supplier<Location> location1 = () -> new Location(faker.address().cityName(), faker.address().streetName());
        Supplier<UserCard> user = () -> new UserCard(faker.name().firstName(), faker.name().lastName(), faker.date().birthday(),
                faker.date().between(new Date(115, 0, 1), new Date(124, 4, 1)));



       Location l1 = locDAO.findById(UUID.fromString("06ea7cdf-9909-4a42-87d1-fa30ee07c44e"));
      Location l2 = locDAO.findById(UUID.fromString("abfc3810-d6c9-4c7b-842f-ec80ab9acf59"));
       Location l3 = locDAO.findById(UUID.fromString("402fa7cc-f158-47f8-acc4-82f3aeabbb15"));
       Location l4 = locDAO.findById(UUID.fromString("ebde4f5b-47d2-4594-ac65-d4821113bcb1"));
//
//      Route route1 = new Route(l1, l2, 44.5);
//        Route route2 = new Route(l3, l4, 36.5);
//
//        routeDAO.save(route1);
//        routeDAO.save(route2);

//        PublicTransport publicTransport = new PublicTransport(TransportStatus.INSERVICE, LocalDate.of(2023, 1, 1),
//                LocalDate.of(2023, 2, 2), 48, TypeOfTransport.BUS);
//
//        PublicTransport publicTransport2 = new PublicTransport(TransportStatus.OUT_OF_SERVICE, LocalDate.of(2022, 3, 5),
//                LocalDate.of(2023, 6, 2), 52, TypeOfTransport.TRAM);
//
//publicTransportDao.saveNewPublicTransport(publicTransport);
//publicTransportDao.saveNewPublicTransport(publicTransport2);

//        Route foundRoute1 = routeDAO.findById(UUID.fromString("bab959ab-000a-45c8-a713-749ee5428be5"));
//        Route foundRoute2 = routeDAO.findById(UUID.fromString("b579531a-5d81-4d31-bd9a-a24bec8da2b7"));

       PublicTransport found = publicTransportDao.searchById(UUID.fromString("0c00aaaa-ddcd-4af1-b9b8-578d890c70ab"));
       PublicTransport found2 = publicTransportDao.searchById(UUID.fromString("ec37ed05-59f6-42a0-958d-b580bda970aa"));

//       publicTransportDao.setRoute(found2, foundRoute2);


//        Station station1 = new Station(l2);
//        stationDAO.save(station1);

//        Station stationFound = stationDAO.findStationById(UUID.fromString("b7f2ee61-7fc7-44ed-89de-ee79e3a0196d"));
//        publicTransportDao.setStation(found, stationFound);
//        publicTransportDao.setStation(found2, stationFound);



//       TicketVendor ticketVendor = new TicketVendor(l4);
//        ticketVendorDao.saveNewTicketVendor(ticketVendor);

//       TicketVendor oneTicket = ticketVendorDao.searchById(UUID.fromString("05e50b86-47a7-4e2f-8e87-3236d880bda2"));
//
//        Ticket ticket = new Ticket(LocalDate.now(), oneTicket);
//
//        ticketDAO.save(ticket);


        //User Card


        for (int i = 0; i < 50; i++) {
           // locDAO.save(location1.get());
           // userCardDAO.save(user.get());
        }










       /* publicTransportDao.saveNewPublicTransport(publicTransport);
        publicTransportDao.saveNewPublicTransport(publicTransport2);*/



        /*publicTransportDao.setRoute(found, foundRoute1);
        publicTransportDao.setRoute(found2,foundRoute2);*/




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
