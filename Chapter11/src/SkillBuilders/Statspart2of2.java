package SkillBuilders;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Statspart2of2 {

	private JFrame frame;
	StudentData inputDialog = new StudentData();
	private JTextField fileNameField;
	private JTextField numStudentsField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Statspart2of2 window = new Statspart2of2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Statspart2of2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 628, 506);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 612, 456);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		fileNameField = new JTextField();
		fileNameField.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent e) 
			{
				if(fileNameField.getText().equals("Enter File Name Here:"))
					fileNameField.setText("");
			}
		});
		fileNameField.setFont(new Font("Tahoma", Font.BOLD, 15));
		fileNameField.setForeground(new Color(128, 128, 128));
		fileNameField.setText("Enter File Name Here:");
		fileNameField.setBounds(10, 41, 414, 46);
		panel.add(fileNameField);
		fileNameField.setColumns(10);
		
		numStudentsField = new JTextField();
		numStudentsField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{
				if(numStudentsField.getText().equals("Enter Number of Students Here:"))
					numStudentsField.setText("");
				
			}
		});
		numStudentsField.setFont(new Font("Tahoma", Font.BOLD, 15));
		numStudentsField.setForeground(new Color(128, 128, 128));
		numStudentsField.setText("Enter Number of Students Here:");
		numStudentsField.setBounds(10, 98, 414, 51);
		panel.add(numStudentsField);
		numStudentsField.setColumns(10);
		
		
		JTextArea resultArea = new JTextArea();
		resultArea.setForeground(new Color(128, 0, 64));
		resultArea.setDisabledTextColor(new Color(128, 0, 0));
		resultArea.setColumns(40);
		resultArea.setRows(15);
		resultArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		resultArea.setBackground(new Color(240, 240, 240));
		resultArea.setBounds(10, 195, 592, 250);
		panel.add(resultArea);
		
		
		
		JButton btnNewButton = new JButton("Create Data File");
		btnNewButton.setBackground(new Color(181, 214, 251));
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String fileName = fileNameField.getText().trim();
		        String numStudentsText = numStudentsField.getText().trim();
		        
		        if (fileName.isEmpty() || numStudentsText.isEmpty()) 
		        {
		            JOptionPane.showMessageDialog(null,"Please enter both file name and number of students.", 
		                "Input Error", 
		                JOptionPane.WARNING_MESSAGE);
		         
		        }
		        
		        
		        try
		        {
		        	 int numStu = Integer.parseInt(numStudentsText);
		        	 
		        	// Create dialog for student data input
		             StringBuilder studentData = new StringBuilder();
		             
		        	for (int i = 0; i < numStu; i++) 
		        	{	
		        		
		        		
		        		int result = JOptionPane.showConfirmDialog(null, inputDialog, 
		                        "Enter data for Student " + (i + 1), 
		                        JOptionPane.OK_CANCEL_OPTION);
		        		
		        		if (result != JOptionPane.OK_OPTION) 
		        		{
		                    break; // User cancelled
		                }
		        		
		        		String stuName = inputDialog.getNameField().getText().trim();
		                String score = inputDialog.getScoreField().getText().trim();
		                
		                if (stuName.isEmpty() || score.isEmpty()) 
		                {
		                    JOptionPane.showMessageDialog(null, 
		                        "Please enter both name and score for student " + (i + 1), 
		                        "Input Error", 
		                        JOptionPane.WARNING_MESSAGE);
		                    
		                    i--; // Retry this student
		                    continue;
		                }
		                // Validate score is a number
		                try 
		                {
		                    Double.parseDouble(score);
		                } 
		                catch (NumberFormatException er) 
		                {
		                    JOptionPane.showMessageDialog(null, 
		                        "Please enter a valid number for the score.", 
		                        "Input Error", 
		                        JOptionPane.WARNING_MESSAGE);
		                    i--; // Retry this student
		                    continue;
		                }
		                
		                studentData.append(stuName).append(": ").append(score).append("\n");
		                
		             // Write to file
		                File dataFile = new File(fileName);
		                FileWriter out = new FileWriter(dataFile, true); // append mode
		                BufferedWriter writeFile = new BufferedWriter(out);
		                
		                writeFile.write(stuName);
		                writeFile.newLine();
		                writeFile.write(score);
		                writeFile.newLine();
		                
		                writeFile.close();
		                out.close();
		        	}
		        	
		        	resultArea.setText("Data written to file: " + fileName + "\n\n");
		            resultArea.append("STUDENTS ENTERED:\n");
		            resultArea.append("----------------\n");
		            resultArea.append(studentData.toString());
		            resultArea.append("\nFile created successfully!");
		        	
		        	
		        	
		        }
		        catch (IOException ex) 
		        {
		            JOptionPane.showMessageDialog(null, 
		                "File could not be created: " + ex.getMessage(), 
		                "File Error", 
		                JOptionPane.ERROR_MESSAGE);
		        }
		        catch (NumberFormatException ex) 
		        {
		            JOptionPane.showMessageDialog(null, 
		                "Please enter a valid number for students.", 
		                "Input Error", 
		                JOptionPane.ERROR_MESSAGE);
		        } 
		        
			}
		});
		btnNewButton.setBounds(434, 41, 168, 59);
		panel.add(btnNewButton);
		
		
		JButton btnAnalyzeScores = new JButton("Analyze Scores");
		btnAnalyzeScores.setBackground(new Color(189, 242, 231));
		btnAnalyzeScores.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String fileName = fileNameField.getText().trim();	
				
				if (fileName.isEmpty()) {
		            JOptionPane.showMessageDialog(null, 
		                "Please enter a file name first.", 
		                "Input Error", 
		                JOptionPane.WARNING_MESSAGE);
		            return;
		        }
				
				
				// Clear previous results
		        resultArea.setText("");
		        
		        File dataFile = new File(fileName);
		        FileReader in;
		        BufferedReader readFile;
		        String stuName, score;
		        double scoreValue;
		        double lowScore = 100;
		        double highScore = 0;
		        double avgScore;
		        double totalScore = 0;
		        int numScores = 0;

		        NumberFormat percent = NumberFormat.getPercentInstance();
		        
		        StringBuilder output = new StringBuilder();
				
				 try {
			            in = new FileReader(dataFile);
			            readFile = new BufferedReader(in);
			            
			            output.append("STUDENT SCORES:\n");
			            output.append("---------------\n");
			            
			            while ((stuName = readFile.readLine()) != null) {
			                score = readFile.readLine();
			                
			                numScores += 1;
			                scoreValue = Double.parseDouble(score);
			                output.append(stuName + " " + percent.format(scoreValue/100) + "\n");
			                totalScore += scoreValue;
			                
			                if (scoreValue < lowScore) {
			                    lowScore = scoreValue;
			                }
			                if (scoreValue > highScore) {
			                    highScore = scoreValue;
			                }
			            }
			            
			            avgScore = totalScore / numScores;
			            
			            output.append("\nSTATISTICS:\n");
			            output.append("-----------\n");
			            output.append("Low score: " + percent.format(lowScore/100) + "\n");
			            output.append("High score: " + percent.format(highScore/100) + "\n");
			            output.append("Average score: " + percent.format(avgScore/100) + "\n");
			            output.append("Total students: " + numScores + "\n");
			            
			            resultArea.setText(output.toString());
			            
			            readFile.close();
			            in.close();
			            
			        } catch (FileNotFoundException ex) {
			            JOptionPane.showMessageDialog(null, 
			                "File does not exist or could not be found.\n" +
			                "Please check the file path: " + dataFile.getPath(), 
			                "File Not Found", 
			                JOptionPane.ERROR_MESSAGE);
			        } catch (IOException ex) {
			            JOptionPane.showMessageDialog(null, 
			                "Problem reading file: " + ex.getMessage(), 
			                "Read Error", 
			                JOptionPane.ERROR_MESSAGE);
			        } catch (NumberFormatException ex) {
			            JOptionPane.showMessageDialog(null, 
			                "Error parsing score data: " + ex.getMessage(), 
			                "Data Format Error", 
			                JOptionPane.ERROR_MESSAGE);
			        }
				
				
			}
		});
		btnAnalyzeScores.setBounds(434, 111, 168, 59);
		panel.add(btnAnalyzeScores);
		
		
	}
}
