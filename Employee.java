package Salary;

public class Employee {
	private String name;
    private double monthlySalary;
    private int defaultLunchDays;
    private int luxuryLunchDays;
    
    // Constructor to initialize Employee object with provided values
    public Employee(String name, double salary, int defaultLunchDays, int luxuryLunchDays) {
        this.name = name;
        this.monthlySalary = salary;
        this.defaultLunchDays = defaultLunchDays;
        this.luxuryLunchDays = luxuryLunchDays;
    }

    
    // Method to display employee results in console
    public void displayResults() {
        System.out.println("Employee Results:");
        System.out.println("Name: " + name);
        System.out.println("Yearly Salary: " + (monthlySalary * 12));
        System.out.println("Next Year's Salary: " + (monthlySalary * 12 * 1.05));
        
        // Display Chosen Lunch only if at least one lunch is chosen
        if (luxuryLunchDays > 0 || defaultLunchDays > 0) {
        	System.out.println("Chosen Lunch: " +
        	        (luxuryLunchDays > 0 ? luxuryLunchDays + " Luxury Lunch" : "") +
        	        (defaultLunchDays > 0 ? (luxuryLunchDays > 0 ? ", " : "") + defaultLunchDays + " Default Lunch" : ""));
            System.out.println("Lunch Cost: " + calculateLunchCost());
        } else {
            System.out.println("No Lunch Chosen");
        }

        System.out.println("---------------------------");
    }

 
    // Calculate Lunch cost originally used in both the GUI and Console currently only used in the console
    public double calculateLunchCost() {
        double defaultLunchCost = 75.0;
        double luxuryLunchCost = 125.0;

        return defaultLunchDays * defaultLunchCost + luxuryLunchDays * luxuryLunchCost;
    }
    
    
    // Method that returns the calculated lunch cost and the amount of days that lunch was choose
    public String calculateLunchCostAndDays() {
        StringBuilder lunchInfo = new StringBuilder();

        // Display Chosen Lunch only if at least one lunch is chosen
        if (luxuryLunchDays > 0 || defaultLunchDays > 0) {
            lunchInfo.append(" ")
                    .append(luxuryLunchDays > 0 ? luxuryLunchDays + " Luxury " : "")
                    .append(defaultLunchDays > 0 ? (luxuryLunchDays > 0 ? ", " : "") + defaultLunchDays + " Default " : "");
            lunchInfo.append("\nCost: ").append(calculateLunchCost());
        } else {
            lunchInfo.append("No Lunch Chosen");
        }

        return lunchInfo.toString();
    }

    // Gets the monthly salary of an employee
    public double getMonthlySalary() {
        return monthlySalary;
    }

    
    // Gets the yearly salary of an employee 
    public double getYearlySalary() {
        return monthlySalary * 12;
    }

    
    // Method to get the number of default lunch days
    public int getDefaultLunchDays() {
        return defaultLunchDays;
    }

    // Method to get the number of luxury lunch days
    public int getLuxuryLunchDays() {
        return luxuryLunchDays;
    }
    
    // Sets the yearly salary for those employees without a valid inputed salary
    public void setYearlySalary(double yearlySalary) {
        this.monthlySalary = yearlySalary / 12;
    }

    // Method to get the employees name
    public String getName() {
        return name;
    }
    
 
}
