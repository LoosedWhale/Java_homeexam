package Trainwagon;

import java.util.*;

public class Wagon extends SeatManager {
	
	private final static CityManager cityManager = new CityManager();
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize seats with constraints | some are broken some are not
        List<Seat> seats = initializeSeats();

        // List with cities
        List<String> cities = Arrays.asList("Malmö", "Nässjö", "Linköping", "Stockholm");

        // Select departure and destination cities
        String departureCity = cityManager.selectDepartureCity(sc, cities);

        // Filter remaining cities
        List<String> remainingCities = cityManager.filterRemainingCities(departureCity, cities);

        // Select destination city
        String destinationCity = cityManager.selectDestinationCity(sc, remainingCities);

        System.out.println("Departure city: " + departureCity);
        System.out.println("Destination city: " + destinationCity);

        List<String> passengerList = new ArrayList<>();
        
        // Loop for the different operations the user can do 
        while (true) {
            System.out.println("Choose an operation:" +
                    "\n1. Print seats" +
                    "\n2. Fill seats randomly" +
                    "\n3. Add passenger" +
                    "\n4. Check seat status" +
                    "\n5. Search for passenger" +
                    "\n6. End the journey");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    printSeats(seats);
                    break;
                case "2":
                    fillSeatsRandomly(seats, passengerList);
                    printSeats(seats);
                    break;
                case "3":
                    addPassenger(sc, seats, passengerList);
                    printSeats(seats);
                    break;
                case "4":
                    checkSeatStatus(sc, seats);
                    break;
                case "5":
                    searchPassenger(sc, seats);
                    break;
                case "6":
                    endJourney(sc);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    // Kills the switch 
    private static void endJourney(Scanner sc) {
        System.out.println("Ending the journey. Thank you for traveling with us!");
        sc.close();
        System.exit(0);
    }

}
