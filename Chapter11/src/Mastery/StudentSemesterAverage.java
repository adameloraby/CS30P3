package Mastery;

import java.awt.*;
import javax.swing.*;
import java.io.*;

public class StudentSemesterAverage {

    private JFrame frame;
    private JTextField fileField, studentField, gradeField, semesterField;
    private JTextField grade1, grade2, grade3, grade4;
    private JTextArea disp;
    private JLabel avgField;

    private final Color ERROR_COLOR = new Color(255, 200, 200); // light red
    private final Color NORMAL_COLOR = Color.WHITE;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                StudentSemesterAverage window = new StudentSemesterAverage();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the application.
     */
    public StudentSemesterAverage() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        frame = new JFrame();
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        addLabelsAndFields();
        addButtons();
    }

    private void addLabelsAndFields() {

        JLabel fileLabel = new JLabel("File name:");
        fileLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        fileLabel.setBounds(0, 0, 225, 20);
        frame.getContentPane().add(fileLabel);

        JLabel nameLabel = new JLabel("Student name:");
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        nameLabel.setBounds(0, 21, 225, 20);
        frame.getContentPane().add(nameLabel);

        JLabel gradeLabel = new JLabel("Grade level:");
        gradeLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        gradeLabel.setBounds(0, 42, 225, 20);
        frame.getContentPane().add(gradeLabel);

        JLabel semesterLabel = new JLabel("Semester:");
        semesterLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        semesterLabel.setBounds(0, 63, 225, 20);
        frame.getContentPane().add(semesterLabel);

        JLabel gr1 = new JLabel("Grade 1:");
        gr1.setFont(new Font("Tahoma", Font.BOLD, 12));
        gr1.setBounds(0, 84, 225, 20);
        frame.getContentPane().add(gr1);

        JLabel gr2 = new JLabel("Grade 2:");
        gr2.setFont(new Font("Tahoma", Font.BOLD, 12));
        gr2.setBounds(0, 105, 225, 20);
        frame.getContentPane().add(gr2);

        JLabel gr3 = new JLabel("Grade 3:");
        gr3.setFont(new Font("Tahoma", Font.BOLD, 12));
        gr3.setBounds(0, 127, 225, 20);
        frame.getContentPane().add(gr3);

        JLabel gr4 = new JLabel("Grade 4:");
        gr4.setFont(new Font("Tahoma", Font.BOLD, 12));
        gr4.setBounds(0, 148, 225, 20);
        frame.getContentPane().add(gr4);

        fileField = new JTextField();
        fileField.setBounds(259, 1, 225, 20);
        frame.getContentPane().add(fileField);

        studentField = new JTextField();
        studentField.setBounds(259, 22, 225, 20);
        frame.getContentPane().add(studentField);

        gradeField = new JTextField();
        gradeField.setBounds(259, 43, 225, 20);
        frame.getContentPane().add(gradeField);

        semesterField = new JTextField();
        semesterField.setBounds(259, 64, 225, 20);
        frame.getContentPane().add(semesterField);

        grade1 = new JTextField();
        grade1.setBounds(259, 85, 225, 20);
        frame.getContentPane().add(grade1);

        grade2 = new JTextField();
        grade2.setBounds(259, 106, 225, 20);
        frame.getContentPane().add(grade2);

        grade3 = new JTextField();
        grade3.setBounds(259, 128, 225, 20);
        frame.getContentPane().add(grade3);

        grade4 = new JTextField();
        grade4.setBounds(259, 149, 225, 20);
        frame.getContentPane().add(grade4);

        avgField = new JLabel("Average:");
        avgField.setFont(new Font("Tahoma", Font.BOLD, 12));
        avgField.setBounds(0, 169, 225, 20);
        frame.getContentPane().add(avgField);

        disp = new JTextArea();
        disp.setEditable(false);
        disp.setBackground(new Color(245, 245, 245));
        disp.setFont(new Font("Monospaced", Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(disp);
        scrollPane.setBounds(0, 200, 484, 220);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        frame.getContentPane().add(scrollPane);
    }

    private void addButtons() {

        JButton saveFile = new JButton("Save File");
        saveFile.setBounds(100, 430, 120, 28);
        frame.getContentPane().add(saveFile);

        JButton viewFile = new JButton("View File");
        viewFile.setBounds(260, 430, 120, 28);
        frame.getContentPane().add(viewFile);

        saveFile.addActionListener(a -> saveToFile());
        viewFile.addActionListener(a -> displayFileContents());
    }

    // =====================================================================
    // ✔ VALIDATE INPUT
    // =====================================================================
    private boolean validateFields() {

        JTextField[] fields = { studentField, gradeField, semesterField, grade1, grade2, grade3, grade4 };

        boolean ok = true;

        for (JTextField f : fields) {
            f.setBackground(NORMAL_COLOR);
            if (f.getText().trim().isEmpty()) {
                f.setBackground(ERROR_COLOR);
                ok = false;
            }
        }

        if (!ok) {
            JOptionPane.showMessageDialog(frame, "Please complete all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validate numeric grades
        JTextField[] gradeFields = { grade1, grade2, grade3, grade4 };

        for (JTextField g : gradeFields) {
            try {
                double val = Double.parseDouble(g.getText());
                if (val < 0 || val > 100) throw new Exception();
            } catch (Exception e) {
                g.setBackground(ERROR_COLOR);
                JOptionPane.showMessageDialog(frame,
                        "Grades must be numbers between 0 and 100.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        return true;
    }

    // =====================================================================
    // ✔ SAVE DATA TO FILE
    // =====================================================================
    private void saveToFile() {

        if (!validateFields()) return;

        String fileName = fileField.getText().trim();
        if (!fileName.endsWith(".txt")) fileName += ".txt";

        File file = new File("src/Mastery/" + fileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {

            double g1 = Double.parseDouble(grade1.getText());
            double g2 = Double.parseDouble(grade2.getText());
            double g3 = Double.parseDouble(grade3.getText());
            double g4 = Double.parseDouble(grade4.getText());

            double avg = (g1 + g2 + g3 + g4) / 4.0;

            // ⭐ Show formatted percentage
            String avgText = String.format("Average: %.2f%%", avg);
            avgField.setText(avgText);

            // Write to file
            writer.write(studentField.getText());
            writer.newLine();
            writer.write("Grade Level: " + gradeField.getText());
            writer.newLine();
            writer.write("Semester: " + semesterField.getText());
            writer.newLine();
            writer.write("Grades: " + g1 + ", " + g2 + ", " + g3 + ", " + g4);
            writer.newLine();
            writer.write(avgText);
            writer.newLine();
            writer.write("------------------------------");
            writer.newLine();

            // Show success popup
            JOptionPane.showMessageDialog(frame, "Data saved successfully!");

            // ⭐ AFTER user closes popup → reset average field
            avgField.setText("Average:");

            clearFields();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error saving file:\n" + ex.getMessage(),
                    "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // =====================================================================
    // ✔ DISPLAY FILE CONTENTS
    // =====================================================================
    private void displayFileContents() {

        disp.setText("");

        String name = fileField.getText().trim();
        if (!name.endsWith(".txt")) name += ".txt";

        File file = new File("src/Mastery/" + name);

        // Alternative fallback path
        if (!file.exists()) {
            String altPath = System.getProperty("user.dir") 
            		+ File.separator + "src"
                    + File.separator + "Mastery" 
            		+ File.separator + name;
            file = new File(altPath);
        }

        if (!file.exists()) {
            JOptionPane.showMessageDialog(frame, "File not found: " + file.getAbsolutePath(),
                    "File Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = reader.readLine()) != null)
                disp.append(line + "\n");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error reading file:\n" + e.getMessage(),
                    "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // =====================================================================
    // ✔ CLEAR FIELDS
    // =====================================================================
    private void clearFields() {

        JTextField[] fields = { studentField, gradeField, semesterField, grade1, grade2, grade3, grade4 };

        for (JTextField f : fields) {
            f.setText("");
            f.setBackground(NORMAL_COLOR);
        }

    }
}