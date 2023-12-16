package Salary;
import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

public class EmployeePanel extends JPanel {
	
	
	    private JTextField nameField;
	    private JTextField salaryField;
	    private JTextField defaultLunchField;
	    private JTextField luxuryLunchField;
	
	    private List<Employee> employees = new ArrayList<>();


	    public EmployeePanel(List<EmployeePanel> employeePanels) {
	        setLayout(null);
	        pannelGui();
	        this.employees.addAll(employees);
	    }

	    	
	    private void pannelGui() {

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
	        double monthlySalary = getValidatedDouble(salaryField);
	        double yearlySalary;

	        int defaultLunchDays = getValidatedInt(defaultLunchField);
	        int luxuryLunchDays = getValidatedInt(luxuryLunchField);

	        if (monthlySalary == 0 && totalSalary != 0) {
	            // Calculate yearly salary for employees without a monthly salary
	            List<Employee> employeesWithoutSalary = getEmployeesWithoutSalary(employees);
	            int employeesWithoutSalaryCount = employeesWithoutSalary.size();
	            
	            if (employeesWithoutSalaryCount > 0) {
	                yearlySalary = totalSalary / employeesWithoutSalaryCount;
	                monthlySalary = yearlySalary / 12;
	            } else {
	                // No employees without salary, set to zero
	                yearlySalary = 0;
	                monthlySalary = 0;
	            }
	        } else {
	            yearlySalary = monthlySalary * 12;
	        }

	        Employee newEmployee = new Employee(name, monthlySalary, defaultLunchDays, luxuryLunchDays);
	        employees.add(newEmployee);

	        return newEmployee;
	    }


	    // Helper method to get employees without a monthly salary
	    private List<Employee> getEmployeesWithoutSalary(List<Employee> allEmployees) {
	        List<Employee> employeesWithoutSalary = new ArrayList<>();
	        for (Employee employee : allEmployees) {
	            if (employee.getMonthlySalary() == 0) {
	                employeesWithoutSalary.add(employee);
	            }
	        }
	        return employeesWithoutSalary;
	    }



	    private int getValidatedInt(JTextField textField) {
	        try {
	            return Integer.parseInt(textField.getText());
	        } catch (NumberFormatException e) {
	            return 0;
	        }
	    }

	    private double getValidatedDouble(JTextField textField) {
	        try {
	            String input = textField.getText();
	            return input.isEmpty() ? 0 : Double.parseDouble(input);
	        } catch (NumberFormatException e) {
	            return 0;
	        }
	    }

	    

}

