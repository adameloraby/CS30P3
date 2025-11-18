package SkillBuilders;

import javax.swing.*;
import java.awt.*;

public class StudentData extends JPanel {

    private JTextField nameField;
    private JTextField scoreField;

    public StudentData() {
        setLayout(new GridLayout(2, 2, 10, 10));

        JLabel nameLabel = new JLabel("Student Name:");
        nameField = new JTextField(15);

        JLabel scoreLabel = new JLabel("Score:");
        scoreField = new JTextField(5);

        add(nameLabel);
        add(nameField);
        add(scoreLabel);
        add(scoreField);
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getScoreField() {
        return scoreField;
    }
}
