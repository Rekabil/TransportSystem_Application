package org.team5.functions;


import java.util.Scanner;

public class Scan {

    public void start() {

        int choice = 1;
        while (choice != 0) {

            System.out.println("Are you a User Or Administrator");
            System.out.println("Press 1 for User or 9 For Administrator");
            Scanner input = new Scanner(System.in);
            choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1:
                    user();
                    break;

                case 9:
                    administrator();
                    break;
            }

        }
    }

    public void user() {
        System.out.println("Welcome User");
    }

    public void administrator() {
        System.out.println("Welcome Admin");
    }


}
