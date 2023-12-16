package Salary;
import javax.swing.*;
import java.util.List;

public class EmployCreator extends JPanel {
	

	//A box that is 800 wide and 20 pixels high it should also be placed under each other 
	//The box should be able to save the inputs the user makes
	//In the box there is A label for Name: and an input field
	//A label for Salary: and an input field, note that the inputed salary is what the employ makes a month 
	//A label for Lunch days: Input field for Default Lunch and an Input field for Luxury Lunch 
	//The input for the different lunches should be in an integer set in days 
	//The box should be modular so it can be created after each other via a Create Employ button located in the Salary.java
	
	
	//There should be a Calculate button in the Salary.java that removes all the boxes that where created above 
	//But for that to happen at least one employ most have filled in there information and a total yearly salary most have been inputed
	//The total salary is an input filled in Salaray.java
	//The information should still be saved so it can be used to calculate the following 
	//The total salary of all employs (there needs to be a way to save that info) 
	//For some employs when they have inputed the salary they do so with out an integer if that is the case it should calculate the left over salary 
	//With other words they split the rest of the total salary among each other (for those whom input something else then an integer)
	//Then it should output which lunch they choice and how much it was 
	
	//All of this should be placed as new information boxes 800 wide and 20 pixels high, like the other boxes these should be placed under each other
	//These should include The inputed name
	//How much they would make in a year so the monthly salary times 12 
	//How much they would make in the next year so the newly created yearly salary times 1.05%
	//Then it should output which lunch they choice and how much it was 

	
	    private JTextField nameField;
	    private JTextField salaryField;
	    private JTextField defaultLunchField;
	    private JTextField luxuryLunchField;
	    private List<EmployCreator> employCreatorsList;
	    


	    public EmployCreator(List<EmployCreator> employCreatorsList) {
	    	this.employCreatorsList = employCreatorsList;
	        setLayout(null);

	        // Set positions manually
	        int x = 10;
	        int y = 2;
	        int labelWidth = 80;
	        int textFieldWidth = 100;
	        int defaultheigth = 20;

	        JLabel nameLabel = new JLabel("Name:");
	        nameLabel.setBounds(x, y, 40, 20);//x, y, w, h
	        add(nameLabel);

	        nameField = new JTextField();
	        nameField.setBounds(x + 50, y, textFieldWidth, defaultheigth);
	        add(nameField);

	        JLabel salaryLabel = new JLabel("Salary /mo:");
	        salaryLabel.setBounds(x + labelWidth + textFieldWidth, y, labelWidth, defaultheigth);
	        add(salaryLabel);

	        salaryField = new JTextField();
	        salaryField.setBounds(x + 2 * labelWidth + textFieldWidth, y, textFieldWidth, defaultheigth);
	        add(salaryField);

	        JLabel defaultLunchLabel = new JLabel("Default Lunch:");
	        defaultLunchLabel.setBounds(x + 2 * (labelWidth + textFieldWidth) + 40, y, labelWidth + 2, defaultheigth);
	        add(defaultLunchLabel);

	        defaultLunchField = new JTextField();
	        defaultLunchField.setBounds(x + 3 * (labelWidth + textFieldWidth) - 30, y, textFieldWidth, defaultheigth);
	        add(defaultLunchField);

	        JLabel luxuryLunchLabel = new JLabel("Luxury Lunch:");
	        luxuryLunchLabel.setBounds(x + 4 * (labelWidth + textFieldWidth) - 50, y, labelWidth, defaultheigth);
	        add(luxuryLunchLabel);

	        luxuryLunchField = new JTextField();
	        luxuryLunchField.setBounds(x + 4 * (labelWidth + textFieldWidth) + 50, y, textFieldWidth, defaultheigth);
	        add(luxuryLunchField);
	        
	        
	    }
	    
	
	    public Employee saveAndCalculateEmployee(double totalSalary) {
	        String name = nameField.getText();

	        // Use a default monthly salary if the input is invalid or empty
	        double monthlySalary;
	        try {
	            String salaryInput = salaryField.getText();
	            if (salaryInput == null || salaryInput.trim().isEmpty()) {
	                monthlySalary = 0; // Default to 0 for employees without a valid monthly salary
	            } else {
	                monthlySalary = Double.parseDouble(salaryInput);
	            }
	        } catch (NumberFormatException e) {
	            monthlySalary = 0; // Default to 0 for employees without a valid monthly salary
	        }

	        double yearlySalary; // Declare the yearlySalary variable

	        // Use default values for lunch days if the input is invalid or empty
	        int defaultLunchDays;
	        try {
	            defaultLunchDays = Integer.parseInt(defaultLunchField.getText());
	        } catch (NumberFormatException e) {
	            defaultLunchDays = 0; // Default lunch for 365 days
	        }

	        int luxuryLunchDays;
	        try {
	            luxuryLunchDays = Integer.parseInt(luxuryLunchField.getText());
	        } catch (NumberFormatException e) {
	            luxuryLunchDays = 0; // No luxury lunch
	        }

	        // If the monthly salary is not provided, distribute the remaining total yearly salary equally
	        if (monthlySalary == 0 && totalSalary != 0) {
	            int employeesWithoutSalary = employCreatorsList.size();
	            yearlySalary = totalSalary / employeesWithoutSalary;
	            monthlySalary = yearlySalary / 12;
	        } else {
	            // Calculate yearly salary based on the provided monthly salary
	            yearlySalary = monthlySalary * 12;
	        }
	        


	        // Create an instance of the Employee class
	        Employee employee = new Employee(name, monthlySalary, defaultLunchDays, luxuryLunchDays);
	        
	        return employee;
	    }









	    

}

