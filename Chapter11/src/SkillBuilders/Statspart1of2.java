package SkillBuilders;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;

public class Statspart1of2 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Statspart1of2 window = new Statspart1of2();
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
	public Statspart1of2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 506, 395);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 490, 356);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel titleLabel = new JLabel("Student Test Score Analysis");
		titleLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(new Color(128, 128, 255));
		titleLabel.setBounds(0, 11, 489, 38);
		panel.add(titleLabel);
		
		JTextArea resultArea = new JTextArea();
		resultArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		resultArea.setEditable(false);
		resultArea.setRows(15);
		resultArea.setColumns(40);
		resultArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		resultArea.setBackground(new Color(240, 240, 240));
		resultArea.setBounds(59, 60, 379, 216);
		panel.add(resultArea);
		
		JButton analyzeBtn = new JButton("Analyze Scores");
		analyzeBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//Clear previous results
				resultArea.setText("");
				
				File dataFile = new File("..\\Chapter11\\src\\SkillBuilders\\TE.txt");
				FileReader in;
				BufferedReader readFile;
				
				String stuName, score;
				
				double scoreValue;
				double lowScore = 100;
				double highScore = 0;
				double avgScore = 0;
				double totalScore = 0;
				int numScores = 0;
				
				NumberFormat percent = NumberFormat.getPercentInstance();
				
				StringBuilder output = new StringBuilder();
				
				try
				{
					in = new FileReader(dataFile);
					readFile = new BufferedReader(in);
					
					output.append("STUDENT SCORES \n");
					output.append("--------------------\n");
					
					while((stuName = readFile.readLine()) != null)
					{
						score = readFile.readLine();
						
						numScores += 1;
						
						scoreValue = Double.parseDouble(score);
						
						output.append(stuName + " " + percent.format(scoreValue / 100) + "\n");
						
						totalScore += scoreValue;
						
						if(scoreValue < lowScore)
							lowScore = scoreValue;
						
						if(scoreValue > highScore)
							highScore = scoreValue;

					}
					
					avgScore = totalScore / numScores;
					
					output.append("\nSTATISTICS:\n");
					output.append("-----------------\n");
					
					output.append("Low Score: " + percent.format(lowScore / 100) + "\n");
					output.append("High Score: " + percent.format(highScore / 100) + "\n");
					output.append("Average Score: " + percent.format(avgScore / 100) + "\n");
					output.append("Total Students: " + numScores + "\n");

					resultArea.setText(output.toString());

					readFile.close();
					in.close();
				}
				catch (FileNotFoundException ex)
				{
					System.out.println("File could not be found.");
					System.err.println("FileNotFoundException: " + ex.getMessage());
				}
				catch (IOException ex)
				{
					System.out.println("Problem reading file.");
					System.err.println("IOException: " + ex.getMessage());
				}
			}
		});
		analyzeBtn.setFont(new Font("MS UI Gothic", Font.BOLD | Font.ITALIC, 14));
		analyzeBtn.setBounds(132, 290, 215, 55);
		panel.add(analyzeBtn);
	}
}
