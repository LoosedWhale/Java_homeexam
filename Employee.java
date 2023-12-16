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

    
    // Method to display employee results
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

    // Method to calculate lunch cost based on predefined costs
	private double calculateLunchCost() {
	    double defaultLunchCost = 75.0;
	    double luxuryLunchCost = 125.0;

	    return defaultLunchDays * defaultLunchCost + luxuryLunchDays * luxuryLunchCost;
	}
	
	 // Getter method to retrieve the monthly salary
	 public double getMonthlySalary() {
	        return monthlySalary;
	    }
	 
	 // Setter method to set the yearly salary
	 public double getYearlySalary() {
		    return monthlySalary * 12;
		}

	 // Getter method to retrieve the employee's name
	 public void setYearlySalary(double yearlySalary) {
		    this.monthlySalary = yearlySalary / 12;
		}

	public String getName() {
		return name;
	}


	
	
}

