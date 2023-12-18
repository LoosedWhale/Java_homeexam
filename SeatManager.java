package Trainwagon;

import java.util.*;

public class SeatManager {
	private static final int NUM_SEATS = 10;
	private static final String INVALID_SEAT_NUMBER_MESSAGE = "Invalid seat number. Please enter a valid seat number.";
	private static final String INVALID_INPUT_MESSAGE = "Invalid input. Please enter a valid seat number.";
	
	
	// Creates the seats makes it so that seat 3,9,10 does not exist as they where not in the  assignment, they have malfunctioned  
    protected static List<Seat> initializeSeats() {
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i < NUM_SEATS + 1; i++) {
             seats.add(new Seat(String.valueOf(i)));
        }
        return seats;
    }
    


    // Prints the seats depending on if; someone is sitting there, the seat is empty and if it's broken
    protected static void printSeats(List<Seat> seats) {
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber() + " : " + (seat.isOccupied() ? seat.getOccupant() : "Empty") + (seat.isBroken() ? " (Broken)" : ""));
        }
    }
    
    
    // For the user to add a passenger to a  sit it meets the requirements  
    protected static void addPassenger(Scanner sc, List<Seat> seats, List<String> passengerList) {
        System.out.println("Enter passenger's last name:");
        String lastName = sc.nextLine();

        try {
            System.out.println("Enter seat number (e.g., 1):");
            int seatNumber = Integer.parseInt(sc.nextLine());

            Seat seat = getSeatByNumber(seats, seatNumber);

            if (seat != null) {
                if (!seat.isOccupied() && !seat.isBroken()) {
                    seat.assignSeat(lastName);
                    passengerList.add(lastName);
                    System.out.println("Passenger " + lastName + " assigned to seat " + seat.getSeatNumber());
                } else if (seat.isBroken()) {
                    System.out.println("Seat " + seat.getSeatNumber() + " is broken. Please choose another seat.");
                } else {
                    System.out.println("Seat " + seat.getSeatNumber() + " is occupied. Please choose another seat.");
                }
            } else {
                System.out.println(INVALID_SEAT_NUMBER_MESSAGE);
            }
        } catch (NumberFormatException e) {
            System.out.println(INVALID_INPUT_MESSAGE);
        }
    }




    // Randomly fills the seats 
    protected static void fillSeatsRandomly(List<Seat> seats, List<String> passengerList) {
        Random random = new Random();
        String[] names = {"Foughtsson", "Thysellsson", "Wilsonsson", "Carlevågsson", "Holthsson", "Åslundsson", "Bauersson"};

        for (String lastName : names) {
            Seat seat = getRandomAvailableSeat(seats, random);

            if (seat != null) {
                seat.assignSeat(lastName);
                passengerList.add(lastName);
            } else {
                System.out.println("No more available seats. The train is fully booked.");
                break; 
            }
        }
    }

    // Method to get a random available seat
    protected static Seat getRandomAvailableSeat(List<Seat> seats, Random random) {
        List<Seat> availableSeats = new ArrayList<>();

        for (Seat seat : seats) {
            if (!seat.isOccupied() && !seat.isBroken()) {
                availableSeats.add(seat);
            }
        }

        if (!availableSeats.isEmpty()) {
            int randomIndex = random.nextInt(availableSeats.size());
            return availableSeats.get(randomIndex);
        } else {
            return null; 
        }
    }
    

    // Checks if the seat has a passenger on it, it's empty, or it's broken
    protected static void checkSeatStatus(Scanner sc, List<Seat> seats) {
        System.out.println("Enter seat number (e.g., 1) to check if it's Empty, occupied, or broken:");

        try {
            int seatNumber = Integer.parseInt(sc.nextLine());

            Seat seat = getSeatByNumber(seats, seatNumber);

            if (seat != null) {
                if (!seat.isOccupied() && !seat.isBroken()) {
                    System.out.println("Seat " + seat.getSeatNumber() + " is Empty.");
                } else if (seat.isOccupied()) {
                    System.out.println("Seat " + seat.getSeatNumber() + " is occupied by " + seat.getOccupant());
                } else {
                    System.out.println("Seat " + seat.getSeatNumber() + " is broken.");
                }
            } else {
                System.out.println(INVALID_SEAT_NUMBER_MESSAGE);
            }
        } catch (NumberFormatException e) {
            System.out.println(INVALID_INPUT_MESSAGE);
        }
    }
    
    // Function for searching after a passenger
    protected static void searchPassenger(Scanner sc, List<Seat> seats) {
        System.out.println("Enter passenger's last name to search:");
        String searchLastName = sc.nextLine();
        boolean passengerFound = false;

        for (Seat seat : seats) {
            if (seat.isOccupied() && seat.getOccupant().equals(searchLastName)) {
                System.out.println(searchLastName + " is seated at seat " + seat.getSeatNumber());
                passengerFound = true;
            }
        }

        if (!passengerFound) {
            System.out.println(searchLastName + " not found on board.");
        }
    }

    // Does exactly that returns the seat by number
    protected static Seat getSeatByNumber(List<Seat> seats, int seatNumber) {
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(String.valueOf(seatNumber))) {
                return seat;
            }
        }
        return null;
    }

}
