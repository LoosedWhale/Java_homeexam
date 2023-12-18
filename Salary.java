package Salary;

import javax.swing.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Salary extends EmployeePanel {

    private static List<EmployeePanel> employeePanels = new ArrayList<>();
    private static JFrame frame;
    private static double totalSalary = 0.0;

    public Salary(List<EmployeePanel> employeePanels) {
        super(employeePanels);
    }

    public static void main(String[] args) {
    	// Create the main frame
        frame = new JFrame("INSANE SALARY CALCUALATIONG PROGRAM");
        frame.getContentPane().setBackground(new Color(0, 100, 255));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Create a button to create instances of EmployeePanel
        JButton createEmployeeButton = new JButton("Create Employee");
        createEmployeeButton.setBounds(10, 10, 150, 25);

        createEmployeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createEmployeePanelInstance();
            }
        });
        frame.add(createEmployeeButton);

        // Create a Total Salary label and input field
        JLabel totalSalaryLabel = new JLabel("Total Salary:");
        totalSalaryLabel.setBounds(300, employeePanels.size() * (25 + 2), 80, 20);
        frame.add(totalSalaryLabel);

        JTextField totalSalaryField = new JTextField();
        totalSalaryField.setBounds(300 + 100, employeePanels.size() * (25 + 2), 150, 20);
        frame.add(totalSalaryField);
        
        // Create calcualteButton to display the results in both the console and GUI based
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(10, 40 + employeePanels.size() * (25 + 2), 150, 25);
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the total salary from the input field
                try {
                    totalSalary = Double.parseDouble(totalSalaryField.getText());
                } catch (NumberFormatException ex) {
                    // Handle invalid input, set a default total salary
                    totalSalary = 0.0;
                }

          
                calculateResults();
            }
        });
        frame.add(calculateButton);

        frame.setSize(925, 800);
        frame.setVisible(true);
    }
    
    
    // Method to display the result by calling on the class ResultsPanel
    private static void displayResultsPanels(List<Employee> employees) {
    	
    	// Adjust the starting y position for result panels so that there is a gap between that and the EmployeePanles
        int yPos = employeePanels.size() * (25 + 2) + 120; 
        // Create a new instance of ResultPanel
        ResultPanel resultPanel = new ResultPanel(employees);
        
        resultPanel.setBounds(10, yPos, 890, 25 * employees.size()); 
        frame.add(resultPanel);

        frame.revalidate();
        frame.repaint();
    }


    // Method for adding multiple instances of the EmployeePanel
    private static void createEmployeePanelInstance() {
    	// Create a new instance of EmployeePanel
    	EmployeePanel employeePanel = new EmployeePanel(new ArrayList<>(employeePanels));

        int yPos = employeePanels.size() * (25 + 2);
        employeePanel.setBounds(10, yPos + 80, 890, 25);
        employeePanels.add(employeePanel);
        frame.add(employeePanel);

        frame.revalidate();
        frame.repaint();
    }
    
    
    // Method for calculating the Salary and Lunch results
    private static void calculateResults() {
    	
    	// Clear the existing result panels
        clearResultPanels();
    	
        // Separate employees with an inputed salary from those without
        List<Employee> employeesWithSalary = new ArrayList<>();
        List<Employee> employeesWithoutSalary = new ArrayList<>();

        for (EmployeePanel employeePanel : employeePanels) {
            Employee employee = employeePanel.saveAndCalculateEmployee(totalSalary);

            if (employee.getMonthlySalary() > 0) {
                // Employee with an inputed salary
                employeesWithSalary.add(employee);
            } else {
                // Employee without an inputed salary
                employeesWithoutSalary.add(employee);
            }
        }

        // Combine both lists into a single list
        List<Employee> allEmployees = new ArrayList<>();
        allEmployees.addAll(employeesWithSalary);
        allEmployees.addAll(employeesWithoutSalary);

        // Calculate the total remaining salary for employees with an inputed salary
        double totalSalaryForEmployeesWithSalary = getTotalSalaryForEmployeesWithSalary(employeesWithSalary);

        // Calculate the total remaining salary for employees without an inputed salary
        double totalSalaryForRemaining = totalSalary - totalSalaryForEmployeesWithSalary;

        // Split the remaining total salary among employees without an inputed salary
        if (!employeesWithoutSalary.isEmpty()) {
            double salaryPerEmployee = totalSalaryForRemaining / employeesWithoutSalary.size();
            for (Employee employee : employeesWithoutSalary) {
                employee.setYearlySalary(salaryPerEmployee);
            }
        }

        // Display results for all employees console based
        for (Employee employee : allEmployees) {
            employee.displayResults();
        }

        // Display a single result panel for all employees GUI based
        displayResultsPanels(allEmployees);
        
    }
        
        // A method for clearing the results panel so that the user can make change and get the updated 
        private static void clearResultPanels() {
            for (Component component : frame.getContentPane().getComponents()) {
                if (component instanceof ResultPanel) {
                    frame.getContentPane().remove(component);
                }
            }
            
            frame.revalidate();
            frame.repaint();
    }



    // Helper method to calculate the total salary for employees with an inputed salary
    private static double getTotalSalaryForEmployeesWithSalary(List<Employee> employeesWithSalary) {
        double totalSalaryForEmployeesWithSalary = 0;
        for (Employee employ : employeesWithSalary) {
            totalSalaryForEmployeesWithSalary += employ.getYearlySalary();
        }
        return totalSalaryForEmployeesWithSalary;
    }
}
