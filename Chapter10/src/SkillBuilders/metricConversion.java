package SkillBuilders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class metricConversion extends JFrame {
    private JComboBox<String> conversionComboBox;
    private JLabel formulaLabel;
    
    // Conversion formulas
    private final String[] CONVERSION_TYPES = {
        "Select a conversion type:",
        "feet to meters",
        "inches to centimeters", 
        "gallons to liters",
        "pounds to kilograms"
    };
    
    private final String[] FORMULAS = {
        "",
        "1 foot = 0.3048 meters",
        "1 inch = 2.54 centimeters",
        "1 gallon = 4.5461 liters",
        "1 pound = 0.4536 kilograms"
    };
    
    public metricConversion() {
        setTitle("Metric Conversion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Change to BorderLayout for better component placement
        setLayout(new BorderLayout());
        
        // Create components
        conversionComboBox = new JComboBox<>(CONVERSION_TYPES);
        formulaLabel = new JLabel(" ");
        formulaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Set preferred sizes
        conversionComboBox.setPreferredSize(new Dimension(200, 25));
        
        // Add action listener to combo box
        conversionComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = conversionComboBox.getSelectedIndex();
                if (selectedIndex > 0) {
                    formulaLabel.setText(FORMULAS[selectedIndex]);
                } else {
                    formulaLabel.setText(" ");
                }
            }
        });
        
        // Create a panel for the combo box to center it
        JPanel comboPanel = new JPanel(new FlowLayout());
        comboPanel.add(conversionComboBox);
        
        // Create a panel for the label to center it
        JPanel labelPanel = new JPanel(new FlowLayout());
        labelPanel.add(formulaLabel);
        
        // Add components to frame using BorderLayout
        add(comboPanel, BorderLayout.NORTH);
        add(labelPanel, BorderLayout.CENTER);
        
        // Set frame properties
        pack();
        setLocationRelativeTo(null); // Center the window
        setResizable(false);
        setSize(300, 100); // Set a slightly larger window to better show the layout
    }
    
    public static void main(String[] args) {
        // Create and show GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new metricConversion().setVisible(true);
            }
        });
    }
}