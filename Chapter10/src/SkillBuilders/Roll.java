package SkillBuilders;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Roll {

    private JFrame frame;
    private JButton rollButton;
    private JLabel dieLabel1, dieLabel2;
    private Random random;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Roll window = new Roll();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Roll() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Dice Roller");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 400);
        frame.setLocationRelativeTo(null); // center on screen
        frame.getContentPane().setBackground(Color.WHITE);
        frame.getContentPane().setLayout(new BorderLayout(10, 10));

        random = new Random();

        // === Dice panel (side by side) ===
        JPanel dicePanel = new JPanel();
        dicePanel.setBackground(Color.WHITE);
        dicePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));

        dieLabel1 = new JLabel();
        dieLabel2 = new JLabel();

        // Set initial dice images
        updateDiceImages(1, 1);

        dicePanel.add(dieLabel1);
        dicePanel.add(dieLabel2);
        frame.getContentPane().add(dicePanel, BorderLayout.CENTER);

        // === Button Panel (bottom centered) ===
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);

        rollButton = new JButton("Roll Dice");
        rollButton.setFont(new Font("Arial", Font.BOLD, 18));
        rollButton.addActionListener(e -> rollDice());
        buttonPanel.add(rollButton);

        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    private void rollDice() {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        updateDiceImages(die1, die2);
    }

    private void updateDiceImages(int die1, int die2) {
        ImageIcon icon1 = loadImageIcon("die" + die1 + ".png", 120, 120);
        ImageIcon icon2 = loadImageIcon("die" + die2 + ".png", 120, 120);

        if (icon1 != null) {
            dieLabel1.setIcon(icon1);
            dieLabel1.setText("");
        } else {
            dieLabel1.setIcon(null);
            dieLabel1.setText("Die " + die1);
        }

        if (icon2 != null) {
            dieLabel2.setIcon(icon2);
            dieLabel2.setText("");
        } else {
            dieLabel2.setIcon(null);
            dieLabel2.setText("Die " + die2);
        }

        frame.revalidate();
        frame.repaint();
    }

    /** Load and resize image from same folder (package) as this class */
    private ImageIcon loadImageIcon(String fileName, int width, int height) {
        try {
            java.net.URL imgURL = getClass().getResource(fileName);
            if (imgURL != null) {
                ImageIcon icon = new ImageIcon(imgURL);
                Image scaled = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                return new ImageIcon(scaled);
            } else {
                System.err.println("Could not find image: " + fileName);
            }
        } catch (Exception e) {
            System.err.println("Error loading image: " + fileName);
        }
        return null;
    }
}