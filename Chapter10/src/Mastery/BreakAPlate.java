package Mastery;

import java.awt.EventQueue;
import java.awt.Color;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class BreakAPlate {

    private JFrame frame;
    private JLabel plates;
    private JLabel prize;
    private JButton playBtn;

    // Image references
    private ImageIcon newPlates;
    private ImageIcon brokenPlates;
    private ImageIcon twoPlates;
    private ImageIcon tigerPlush;
    private ImageIcon sticker;
    private ImageIcon placeholder;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                BreakAPlate window = new BreakAPlate();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the application.
     */
    public BreakAPlate() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        // Load images
        newPlates = new ImageIcon("../Chapter10/src/Mastery/plates1.gif");
        brokenPlates = new ImageIcon("../Chapter10/src/Mastery/plates_all_broken.gif");
        twoPlates = new ImageIcon("../Chapter10/src/Mastery/plates_two_broken.gif");
        tigerPlush = new ImageIcon("../Chapter10/src/Mastery/tiger_plush.gif");
        sticker = new ImageIcon("../Chapter10/src/Mastery/sticker.gif");
        placeholder = new ImageIcon("../Chapter10/src/Mastery/placeholder.gif");

        frame = new JFrame("BreakAPlate");
        frame.setBounds(100, 100, 495, 425);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.WHITE); // background white

        // Plates label
        plates = new JLabel(newPlates);
        plates.setBounds(25, 30, 425, 125);
        plates.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(plates);

        // Prize label
        prize = new JLabel(placeholder);
        prize.setBounds(25, 250, 425, 100);
        prize.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(prize);

        // Play button
        playBtn = new JButton("Play");
        playBtn.setBounds(175, 175, 125, 30);
        playBtn.addActionListener(e -> handleButtonClick());
        frame.getContentPane().add(playBtn);
    }

    /**
     * Handle Play / Play Again button
     */
    private void handleButtonClick() {
        if (playBtn.getText().equals("Play")) {
            playGame();
            playBtn.setText("Play Again");
        } 
        else {
            resetGame();
            playBtn.setText("Play");
        }
    }

    /**
     * Logic for playing the game
     */
    private void playGame() {
        Random rand = new Random();
        int result = rand.nextInt(2); // 0 or 1

        if (result == 0) {
            // Small prize
            plates.setIcon(twoPlates);
            prize.setIcon(sticker);
        } 
        else {
            // Big prize
            plates.setIcon(brokenPlates);
            prize.setIcon(tigerPlush);
        }
    }

    /**
     * Reset the game back to original state
     */
    private void resetGame() {
        plates.setIcon(newPlates);
        prize.setIcon(placeholder);
    }
}