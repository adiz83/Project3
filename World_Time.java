package proj.files;

import java.util.Scanner;

public class World_Time {

    public static void main(String[] args) {
        // Display welcome message
        System.out.println("*************************** Welcome to World Clock *************************** ");
        System.out.println("This world clock converts the time from source city to destination city for you ");

        // Initialize scanner for user input
        Scanner sc = new Scanner(System.in);
        
        // Arrays for city names and time differences
        String World[] = {"Alexandria", "Bangkok", "Beijing", "Berlin", "Dubai", "London", "Mexico", "New York", "Rosario", "Tokyo"};
        int timeh[] = {2, 7, 8, 1, 4, 0, -6, -4, -3, 9};
        
        // Display available city options
        System.out.println("Countries available are:");
        for (int k = 0; k < 10; k++) {
            System.out.println(k + 1 + ". " + World[k]);
        }

        int pos = 7; // Default source city
        int topos = 7; // Default destination city
        int j;
        int i;
        int ci;
        int co;

        // Get source city from user
        outer1:
        for (j = 0; ; j++) {
            System.out.println("Enter the number of your source city(eg.enter 1 for Alexandria)  : ");
            ci = sc.nextInt();

            for (i = 1; i <= 10; i++) {
                if (ci == i) {
                    pos = i - 1; // Update source city position
                    break outer1;
                }
            }
            System.out.println("Enter valid city number(between 1 and 10)");
        }
        System.out.println("Source city you entered is " + World[pos]);
        System.out.println();

        // Get destination city from user
        outer2:
        for (j = 0; ; j++) {
            System.out.println("Enter the number of your destination city(eg. enter 2 for Bangkok) : ");
            co = sc.nextInt();

            for (i = 1; i <= 10; i++) {
                if (co == i) {
                    topos = i - 1; // Update destination city position
                    break outer2;
                }
            }
            System.out.println("Enter valid city number(between 1 and 10)");
        }
        System.out.println("Destination city you entered is " + World[topos]);
        System.out.println();

        int time;
        // Get hour time from user
        outer3:
        for (i = 0; ; i++) {
            System.out.println("Enter the hour time in 24 hour format(that is between 0 and 23) : ");
            time = sc.nextInt();
            if (time >= 0 && time <= 23) {
                break outer3;
            }
            System.out.println("Enter valid hour : ");
        }
        
        int minute;
        // Get minutes from user
        outer4:
        for (i = 0; ; i++) {
            System.out.println("Enter the minutes : ");
            minute = sc.nextInt();
            if (minute >= 0 && minute <= 59) {
                break outer4;
            }
            System.out.println("Enter valid minute : ");
        }
        
        int difference;
        int GMT;
        int A = time - timeh[pos];
        
        // Calculate GMT time
        if (A > 24) {
            GMT = A - 24;
        } else if (A < 0) {
            GMT = 24 + A;
        } else {
            GMT = A;
        }
        
        int destinationtime;
        int destination = GMT + timeh[topos];
        
        // Calculate destination time
        if (destination > 24) {
            destinationtime = destination - 24;
        } else if (destination < 0) {
            destinationtime = 24 + destination;
        } else {
            destinationtime = destination;
        }
        
        // Display converted time
        System.out.println("The 24 hour time at " + World[topos] + " is " + destinationtime + " hours and " + minute + " minutes");
    }
}
