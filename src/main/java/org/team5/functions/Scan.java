package org.team5.functions;


import org.team5.dao.JpaUtils;
import org.team5.dao.TicketDAO;
import org.team5.dao.UserCardDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Scanner;
import java.util.UUID;

public class Scan {

    public static void start() {

        int choice = 1;
        app:
        while  (choice != 0) {

            System.out.println("Are you a User Or Administrator");
            System.out.println("Press 1 for User or 9 For Administrator");
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
        System.out.println("Welcome User");
    }

    public static void administrator() {
        EntityManagerFactory emf = JpaUtils.getEntityManagerFactory();

        EntityManager em = emf.createEntityManager();
        UserCardDAO userCardDAO = new UserCardDAO(em);
        TicketDAO ticketDAO = new TicketDAO(em);



Scanner input = new Scanner(System.in);
int choice = 1;

while (choice != 0) {
    System.out.println("Welcome Admin");
    System.out.println("What Would You Like To Do Today?");
    System.out.println("1. Check Tickets Sold In The Last 6 Months Or Specific Vendor.");
    System.out.println("2. Control Subscription Validity.");
    System.out.println("3. Validate Ticket.");
    System.out.println("4. Check Tickets Validated In The Last 6 Months Or On a Specific Bus/Tram.");
    System.out.println("5. Vehicle Info.");
    System.out.println("6. Maintanence List for Vehicles/Automatic Vendors.");
    System.out.println("7. Get Full List Of: Vehicles/UserCards/Vendors/Stations/Tickets ");
    System.out.println("0. Return.");

    choice= Integer.parseInt(input.nextLine());

    try {
        if (choice < 0 || choice > 7) throw new RuntimeException("Choice Dosen't Exist!");
        switch (choice) {
            case 1:
TicketsSold.TicketSold();
            case 2:
                while (true) {
                    try {
                System.out.println("Insert UUID!");
                UUID id = UUID.fromString(input.nextLine());
                System.out.println(userCardDAO.isSubscritionValid(id));

                break;
                    }catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                }
            case 3:
                while (true) {
                    try {
                        System.out.println("Insert UUID!");
                        UUID id = UUID.fromString(input.nextLine());
                        System.out.println("Where was the ticket validated?");
                        UUID transId = UUID.fromString(input.nextLine());
                        ticketDAO.validateTicket(id , transId);

                        break;
                    }catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                }
            case 4:
            case 5:
            case 6:
            case 7:
            case 0:

        }
    } catch (Exception e) {
        System.err.println(e.getMessage());
    }


}


    }


}
