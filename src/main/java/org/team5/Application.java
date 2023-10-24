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
                faker.date().between(new Date(115, 1, 1), new Date(124, 4, 1)));



       /* Location l1 = locDAO.findById(UUID.fromString("231d11a0-aed6-456e-a886-5e77ebf23d34"));
      Location l2 = locDAO.findById(UUID.fromString("24fc9374-5e1d-4825-9d55-94d4782c414c"));
       Location l3 = locDAO.findById(UUID.fromString("2d72a2ae-550e-4833-a054-e0e7a89d79e2"));
       Location l4 = locDAO.findById(UUID.fromString("4c26a837-52e2-4129-a19d-f2979be2e694"));*/

      /*  Route route1 = new Route(l1, l2, 44.5);
        Route route2 = new Route(l3, l4, 36.5);

        routeDAO.save(route1);
        routeDAO.save(route2);*/

       /* PublicTransport publicTransport = new PublicTransport(TransportStatus.INSERVICE, LocalDate.of(2023, 1, 1),
                LocalDate.of(2023, 2, 2), 48, TypeOfTransport.BUS);

        PublicTransport publicTransport2 = new PublicTransport(TransportStatus.OUT_OF_SERVICE, LocalDate.of(2022, 3, 5),
                LocalDate.of(2023, 6, 2), 52, TypeOfTransport.TRAM);

        Route foundRoute1 = routeDAO.findById(UUID.fromString("15703002-5eeb-4fb6-8bc5-ad524fc8c3d7"));
        Route foundRoute2 = routeDAO.findById(UUID.fromString("7f952af9-4f49-42a1-aeba-7c6ba0dd7c3a"));

        PublicTransport found = publicTransportDao.searchById(UUID.fromString("e04595e7-20bb-4f31-85e1-35b430533928"));

        PublicTransport found2 = publicTransportDao.searchById(UUID.fromString("ffc89f45-5eb8-4ebe-ab34-da058d15d6c2"));*/

        //station
        //Station station1 = new Station(l1);
        //stationDAO.save(station1);

        //Station stationFound = stationDAO.findStationById(UUID.fromString("f87326e2-e513-43bb-9d48-f62753428da8"));
        //publicTransportDao.setStation(found, stationFound);
        //publicTransportDao.setStation(found2, stationFound);



       /* TicketMachine ticketVendor = new TicketMachine(l2, MachineStatus.OUT_OF_ORDER);
        ticketVendorDao.saveNewTicketVendor(ticketVendor);*/

       TicketVendor oneTicket = ticketVendorDao.searchById(UUID.fromString("d02e33f5-0e2d-4c15-91cd-b967f31c1a88"));

        Ticket ticket = new Ticket(LocalDate.now(), oneTicket);

        ticketDAO.save(ticket);


        //User Card


        for (int i = 0; i < 50; i++) {
            //userCardDAO.save(user.get());
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
