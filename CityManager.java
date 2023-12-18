package Trainwagon;


import java.util.*;

public class CityManager {
	
	// Method to select where the user wants to depart from
	public String selectDepartureCity(Scanner sc, List<String> cities) {
	       System.out.println("Choose departure city:");
	       return selectCity(sc, cities);
	   }

	// Method to select where the user what's to travel to
	public String selectDestinationCity(Scanner sc, List<String> remainingCities) {
	        System.out.println("Choose destination city:");
	        return selectCity(sc, remainingCities);
	    }
	  
	  
	// Method to choose which city you are departing from and which city you will arrive at 
	public List<String> filterRemainingCities(String chosenCity, List<String> cities) {
	      List<String> remainingCities = new ArrayList<>(cities);
	      remainingCities.remove(chosenCity);
	      return remainingCities;
	  }    

	
	// Method to choose which city you are departing from and which city you will arrive at
	public String selectCity(Scanner sc, List<String> cities) {
        while (true) {
            for (int i = 0; i < cities.size(); i++) {
                System.out.println((i + 1) + ". " + cities.get(i));
            }

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            if (choice >= 1 && choice <= cities.size()) {
                return cities.get(choice - 1);
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
