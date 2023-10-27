package org.team5;

import com.github.javafaker.Faker;
import org.team5.dao.*;
import org.team5.entities.*;
import org.team5.functions.Scan;

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
      //  Supplier<Location> location1 = () -> new Location(faker.address().cityName(), faker.address().streetName());
      //  Supplier<UserCard> user = () -> new UserCard(faker.name().firstName(), faker.name().lastName(), faker.date().birthday(),
//faker.date().between(new Date(115, 0, 1), new Date(124, 4, 1)));



//        TicketVendor oneTicket = ticketVendorDao.searchById(UUID.fromString("6409ccf7-7e00-4c33-b68f-bd80b0d639f3"));
//
//        Ticket ticket1 = new Ticket(LocalDate.now(), oneTicket);
//
//        ticketDAO.save(ticket1);

       /*Location l1 = locDAO.findById(UUID.fromString("06ea7cdf-9909-4a42-87d1-fa30ee07c44e"));
      Location l2 = locDAO.findById(UUID.fromString("abfc3810-d6c9-4c7b-842f-ec80ab9acf59"));
       Location l3 = locDAO.findById(UUID.fromString("402fa7cc-f158-47f8-acc4-82f3aeabbb15"));
       Location l4 = locDAO.findById(UUID.fromString("ebde4f5b-47d2-4594-ac65-d4821113bcb1"));*/



       //TicketSubscription ticket = new TicketSubscription(LocalDate.of(2020, 7, 2), oneTicket,
        //        Period.MONTHLY, userCardDAO.findElementById(UUID.fromString("05aae67e-c692-4034-91d8-b2158a332c01")));


       // ticketDAO.save(ticket);

        //System.out.println(userCardDAO.isSubscritionValid(UUID.fromString("6c92a86e-32d1-4278-bfb7-9370d828fb35")));

       /* System.out.println(publicTransportDao.getInServiceTransports());
        System.out.println("-----------------------");
        System.out.println(publicTransportDao.getInServiceTransports());*/

        //System.out.println(ticketDAO.getTicketsByRangeDate(LocalDate.now().minusMonths(6), LocalDate.now()));

        //User Card


       // for (int i = 0; i < 50; i++) {
           // locDAO.save(location1.get());
           // userCardDAO.save(user.get());
      //  }

       /* publicTransportDao.saveNewPublicTransport(publicTransport);
        publicTransportDao.saveNewPublicTransport(publicTransport2);*/



        /*publicTransportDao.setRoute(found, foundRoute1);
        publicTransportDao.setRoute(found2,foundRoute2);*/

    try{

        Scan.start();


        }catch (Exception ex)
        {
            System.err.println(ex.getMessage());
        }finally {
            em.close();
            emf.close();
        }



    }
}
