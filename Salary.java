package Salary;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Salary extends EmployCreator {

    public Salary(List<EmployCreator> employCreatorsList) {
		super(employCreatorsList);
	}


	private static List<EmployCreator> employCreatorsList = new ArrayList<>();
    private static JFrame frame;
    private static double totalSalary = 0.0;

    public static void main(String[] args) {

        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(0, 100, 255));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Create a button to create instances of EmployCreator
        JButton createEmployeeButton = new JButton("Create Employee");
        createEmployeeButton.setBounds(10, 10, 150, 25);

        createEmployeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createEmployCreatorInstance();
            }
        });
        frame.add(createEmployeeButton);

        // Create a Total Salary label and input field
        JLabel totalSalaryLabel = new JLabel("Total Salary:");
        totalSalaryLabel.setBounds(300, employCreatorsList.size() * (25 + 2), 80, 20);
        frame.add(totalSalaryLabel);

        JTextField totalSalaryField = new JTextField();
        totalSalaryField.setBounds(300+100, employCreatorsList.size() * (25 + 2), 150, 20);
        frame.add(totalSalaryField);

        // Create a button to calculate and display the results
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(10,40 + employCreatorsList.size() * (25 + 2), 150, 25);
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

        frame.setSize(925, 500);
        frame.setVisible(true);
    }

    private static void createEmployCreatorInstance() {
    	EmployCreator employCreator = new EmployCreator(employCreatorsList);
        int yPos = employCreatorsList.size() * (25 + 2); // Adjust the y-position
        employCreator.setBounds(10, yPos + 80, 890, 25);
        employCreatorsList.add(employCreator);

        frame.add(employCreator);
        
        // Enable the "Calculate" button when at least one instance is created
        frame.revalidate();
        frame.repaint();
    }
    
    
    private static void calculateResults() {
        // Separate employees with an inputted salary from those without
        List<Employee> employeesWithSalary = new ArrayList<>();
        List<Employee> employeesWithoutSalary = new ArrayList<>();

        for (EmployCreator employCreator : employCreatorsList) {
            Employee employ = employCreator.saveAndCalculateEmployee(totalSalary);

            if (employ.getMonthlySalary() > 0) {
                // Employee with an inputted salary
                employeesWithSalary.add(employ);
            } else {
                // Employee without an inputted salary
                employeesWithoutSalary.add(employ);
            }
        }

        // Calculate the total remaining salary for employees without an inputted salary
        double totalSalaryForRemaining = totalSalary - getTotalSalaryForEmployeesWithSalary(employeesWithSalary);

        // Split the remaining total salary among employees without an inputted salary
        if (!employeesWithoutSalary.isEmpty()) {
            double salaryPerEmployee = totalSalaryForRemaining / employeesWithoutSalary.size();
            for (Employee employ : employeesWithoutSalary) {
                employ.setYearlySalary(salaryPerEmployee);
            }
        }

        // Display results for employees with an inputted salary
        for (Employee employ : employeesWithSalary) {
            employ.displayResults();
        }

        // Display results for employees without an inputted salary	
        for (Employee employ : employeesWithoutSalary) {
            employ.displayResults();
        }
    }

    // Helper method to calculate the total salary for employees with an inputted salary
    private static double getTotalSalaryForEmployeesWithSalary(List<Employee> employeesWithSalary) {
        double totalSalaryForEmployeesWithSalary = 0;
        for (Employee employ : employeesWithSalary) {
            totalSalaryForEmployeesWithSalary += employ.getYearlySalary();
        }
        return totalSalaryForEmployeesWithSalary;
    }





}
