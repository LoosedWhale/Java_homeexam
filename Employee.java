package Salary;

public class Employee {
	private String name;
    private double monthlySalary;
    private int defaultLunchDays;
    private int luxuryLunchDays;
    
 // Update the constructor
    public Employee(String name, double salary, int defaultLunchDays, int luxuryLunchDays) {
        this.name = name;
        this.monthlySalary = salary;
        this.defaultLunchDays = defaultLunchDays;
        this.luxuryLunchDays = luxuryLunchDays;
    }

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

	private double calculateLunchCost() {
	    // Example: You can have a predefined cost for each lunch day
	    double defaultLunchCost = 75.0;
	    double luxuryLunchCost = 125.0;

	    return defaultLunchDays * defaultLunchCost + luxuryLunchDays * luxuryLunchCost;
	}
	
	
	 public double getMonthlySalary() {
	        return monthlySalary;
	    }
	 
	 public double getYearlySalary() {
		    return monthlySalary * 12;
		}

	 
	 public void setYearlySalary(double yearlySalary) {
		    this.monthlySalary = yearlySalary / 12;
		}

	public String getName() {
		return name;
	}


	
	
}
