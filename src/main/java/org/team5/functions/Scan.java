package org.team5.functions;


import org.team5.dao.*;
import org.team5.entities.Period;
import org.team5.entities.Ticket;
import org.team5.entities.TicketSubscription;
import org.team5.entities.UserCard;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class Scan {

    public static void start() {

        int choice = 1;
        app:
        while  (true) {

            System.out.println("Are you a User Or Administrator");
            System.out.println("Press 1 for User or 9 For Administrator..... Press 0 to SHUTDOWN");
            Scanner input = new Scanner(System.in);
            choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 0:
                    System.out.println("SHUTTING DOWN...");
                    break app;
                case 1:
                    user();
                    break;

                case 9:
                    System.out.println("Insert Administrator Password");
                    String password = "admin";
                    String inputpassword = input.nextLine();
                    if (password.equals(inputpassword)) {
                        administrator();
                    } else {
                        System.out.println("WROND PASSWORD..... RESTARTING...");
                        start();
                    }
                    break;
            }

        }
    }

    public static void user() {
        EntityManagerFactory emf = JpaUtils.getEntityManagerFactory();

        EntityManager em = emf.createEntityManager();
        UserCardDAO userCardDAO = new UserCardDAO(em);
        TicketDAO ticketDAO = new TicketDAO(em);
        TicketVendorDao ticketVendorDao = new TicketVendorDao(em);
        PublicTransportDao publicTransportDao = new PublicTransportDao(em);
        StationDAO stationDAO = new StationDAO(em);


        Scanner input = new Scanner(System.in);
        int choice = 1;
        user:
        while (choice != 0) {
            System.out.println("Welcome User");
            System.out.println("What Would You Like To Do Today?");
            System.out.println("1. Buy new Ticket");
            System.out.println("2. Validate Ticket");
            System.out.println("3. Buy a User Card");
            System.out.println("4. Buy a Weakly Subscription");
            System.out.println("5. Buy a Monthly Subscription");
            System.out.println("0. Return");

            choice= Integer.parseInt(input.nextLine());

            try {
                if (choice < 0 || choice > 5) throw new RuntimeException("Choice Dosen't Exist!");

                switch (choice){
                    case 1:
                        while (true) {
                            try {
                                System.out.println("Insert il'UUID del Vendor!");
                                UUID id = UUID.fromString(input.nextLine());
                                Ticket ticket = new Ticket(LocalDate.now(), ticketVendorDao.searchById(id));
                                ticketDAO.save(ticket);
                                System.out.println(ticket.toString());
                                break;
                            }catch (Exception e) {
                                System.err.println(e.getMessage());
                            }
                        }
                        break;
                    case 2:
                        while (true) {
                            try {
                                System.out.println("Insert Ticket UUID!");
                                UUID id = UUID.fromString(input.nextLine());
                                System.out.println("Where was the ticket validated?");
                                UUID transId = UUID.fromString(input.nextLine());
                                ticketDAO.validateTicket(id , transId);
                                break;
                            }catch (Exception e) {
                                System.err.println(e.getMessage());
                            }
                        }
                        break;
                    case 3:
                        while (true) {
                            try {
                                System.out.println("Insert Name!");
                                String name = input.nextLine();
                                System.out.println("Insert Surname!");
                                String surname = input.nextLine();
                                System.out.println("Insert Day of Birth!");
                                int dayOfBirth = Integer.parseInt(input.nextLine());
                                System.out.println("Insert Month of Birth!");
                                int monthOfBirth = Integer.parseInt(input.nextLine());
                                System.out.println("Insert Year of Birth!");
                                int yearOfBirth = Integer.parseInt(input.nextLine());

                                UserCard userCard = new UserCard(name , surname , LocalDate.of(yearOfBirth,monthOfBirth,dayOfBirth), LocalDate.now());
                                userCardDAO.save(userCard);
                                System.out.println(userCard.toString());
                                break;

                            }catch (Exception e) {
                                System.err.println(e.getMessage());
                            }
                        }
                        break;
                    case 4:
                        while (true) {
                            try {
                                System.out.println("Insert il'UUID del Vendor!");
                                UUID id = UUID.fromString(input.nextLine());
                                System.out.println("Insert il'UUID del Tuo UserCard");
                                UUID userId = UUID.fromString(input.nextLine());
                                TicketSubscription ticket = new TicketSubscription(LocalDate.now(), ticketVendorDao.searchById(id), Period.WEEKLY, userCardDAO.findElementById(userId) );
                                ticketDAO.save(ticket);
                                System.out.println(ticket.toString());
                                break;
                            }catch (Exception e) {
                                System.err.println(e.getMessage());
                            }
                        }
                        break;
                    case 5:
                        while (true) {
                            try {
                                System.out.println("Insert il'UUID del Vendor!");
                                UUID id = UUID.fromString(input.nextLine());
                                System.out.println("Insert il'UUID del Tuo UserCard");
                                UUID userId = UUID.fromString(input.nextLine());
                                TicketSubscription ticket = new TicketSubscription(LocalDate.now(), ticketVendorDao.searchById(id), Period.MONTHLY, userCardDAO.findElementById(userId) );
                                ticketDAO.save(ticket);
                                System.out.println(ticket.toString());
                                break;
                            }catch (Exception e) {
                                System.err.println(e.getMessage());
                            }

                        }
                        break;
                    case 0:
                       break user;
                }



            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }


    }

    public static void administrator() {
        EntityManagerFactory emf = JpaUtils.getEntityManagerFactory();

        EntityManager em = emf.createEntityManager();
        UserCardDAO userCardDAO = new UserCardDAO(em);
        TicketDAO ticketDAO = new TicketDAO(em);
        TicketVendorDao ticketVendorDao = new TicketVendorDao(em);
        PublicTransportDao publicTransportDao = new PublicTransportDao(em);
        StationDAO stationDAO = new StationDAO(em);


Scanner input = new Scanner(System.in);
int choice = 1;

admin:
while (choice != 0) {
    System.out.println("Welcome Admin");
    System.out.println("What Would You Like To Do Today?");
    System.out.println("1. Check Tickets Sold In The Last 6 Months For Each Vendor.");
    System.out.println("2. Control Subscription Validity.");
    System.out.println("3. Validate Ticket.");
    System.out.println("4. Check Tickets Validated In The Last 6 Months On Specific Bus/Tram.");
    System.out.println("5. Vehicle Info.");
    System.out.println("6. Maintanence List for Vehicles/Automatic Vendors.");
    System.out.println("7. Get Full List Of: Vehicles/UserCards/Vendors/Stations/Tickets ");
    System.out.println("0. Return.");

    choice= Integer.parseInt(input.nextLine());

    try {
        if (choice < 0 || choice > 7) throw new RuntimeException("Choice Dosen't Exist!");
        switch (choice) {
            case 1:


                System.out.println("**************Sold In The Last 6 Months For Each Vendor***************");

                ticketVendorDao.getTicketsByRangeDate(LocalDate.now().minusMonths(6), LocalDate.now()).forEach((map, help) -> System.out.println(map + " " + help));
                break;
//71b06e89f457d31f4b2bda07131d59abbd706d6b
            case 2:
                while (true) {
                    try {
                System.out.println("Insert User UUID!");
                UUID id = UUID.fromString(input.nextLine());
                System.out.println(userCardDAO.isSubscritionValid(id));

                break;
                    }catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                }
                break ;
            case 3:
                while (true) {
                    try {
                        System.out.println("Insert User UUID for validate his ticket!");
                        UUID id = UUID.fromString(input.nextLine());
                        System.out.println("Where was the ticket validated?");
                        UUID transId = UUID.fromString(input.nextLine());
                        ticketDAO.validateTicket(id , transId);

                        break;
                    }catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                }
                break ;
            case 4:
                System.out.println("**************Validated In The Last 6 Months******************");
                publicTransportDao.getTicketsByRangeDate(LocalDate.now().minusMonths(6), LocalDate.now()).forEach((map, help) -> System.out.println(map + " " + help));
                break;
            case 5:
                while (true) {
                    try {
                        System.out.println("Insert Public Transport UUID!");
                        UUID id = UUID.fromString(input.nextLine());
                    System.out.println(publicTransportDao.searchById(id));
                        break;
                    }catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                }
break ;
            case 6:
                System.out.println("******************OUT OF SERVICE TRANSPORTS*************************");
publicTransportDao.getOutOfServiceTransports().forEach(System.out::println);
                System.out.println("**********************OUT OF SERVICE MACHINES*********************");
                ticketVendorDao.getOutOfServiceMachines().forEach(System.out::println);
                break;
            case 7:
                System.out.println("*****************************VEHICLES**********************************");
                publicTransportDao.showListPublicTransport().forEach(System.out::println);
                System.out.println("*****************************USER CARDS**********************************");
                userCardDAO.printUserCards().forEach(System.out::println);
                System.out.println("*****************************TICKETS**********************************");
                ticketDAO.printTickets().forEach(System.out::println);
                System.out.println("*****************************TICKET VENDORS**********************************");
                ticketVendorDao.showListTicketVendor().forEach(System.out::println);
                System.out.println("*****************************STATIONS**********************************");
                stationDAO.showListStation().forEach(System.out::println);
                break;
            case 0:
break admin;
        }
    } catch (Exception e) {
        System.err.println(e.getMessage());
    }


}


    }


}
