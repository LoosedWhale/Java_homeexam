package Salary;

import javax.swing.*;
import java.util.List;

@SuppressWarnings("serial")
public class ResultPanel extends JPanel {

    public ResultPanel(List<Employee> employees) {
        setLayout(null);
        resultsPanelGui(employees);
    }

    // Method to set up the graphical user interface in a panel based layout
    private void resultsPanelGui(List<Employee> employees) {
        // Set positions manually
        int x = 10;
        int y = 2;
        int labelWidth = 80;
        int textFieldWidth = 100;
        int defaultHeight = 20;

        int yPos = y;
        for (Employee employee : employees) {
            // Label and text field for "Name"
            JLabel nameLabel = new JLabel("Name:" + employee.getName());
            nameLabel.setBounds(x, yPos, 40 + labelWidth, 20);
            add(nameLabel);

            // Label and text field for "Salary / year"
            JLabel yearlySalaryLabel = new JLabel("Salary /yr: " + employee.getYearlySalary());
            yearlySalaryLabel.setBounds(x + 50 + textFieldWidth, yPos, labelWidth + textFieldWidth, defaultHeight);
            add(yearlySalaryLabel);

            // Label and text field for "Salary /year * 1.05"
            JLabel nextYearSalaryLabel = new JLabel("Next Year's Salary: " + (employee.getYearlySalary() * 1.05));
            nextYearSalaryLabel.setBounds(x + textFieldWidth + textFieldWidth + textFieldWidth, yPos, textFieldWidth + textFieldWidth, defaultHeight);
            add(nextYearSalaryLabel);

            // Label and text field for "lunchLabel "
            JLabel lunchLabel = new JLabel("Lunch: " + employee.calculateLunchCostAndDays());
            lunchLabel.setBounds(x + 2 * labelWidth + textFieldWidth + textFieldWidth + textFieldWidth+ textFieldWidth, yPos, labelWidth + textFieldWidth + textFieldWidth + textFieldWidth + textFieldWidth+ textFieldWidth + textFieldWidth, defaultHeight);
            add(lunchLabel);

            yPos += 25; // Adjust the vertical gap between result panels
        }
    }
}
