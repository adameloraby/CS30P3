package SkillBuilders;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class semesterAvg {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField1;
	private JTextField textField2;
	private JButton btnAverage;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					semesterAvg window = new semesterAvg();
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
	public semesterAvg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 240, 240));
		frame.setBounds(100, 100, 472, 313);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Enter the first grade:");
		lblNewLabel.setBounds(24, 41, 179, 26);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblEnterTheSecond = new JLabel("Enter the second grade:");
		lblEnterTheSecond.setBounds(24, 90, 179, 26);
		lblEnterTheSecond.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblEnterTheThird = new JLabel("Enter the third grade:");
		lblEnterTheThird.setBounds(24, 140, 179, 26);
		lblEnterTheThird.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		textField = new JTextField();
		textField.setBounds(223, 35, 207, 42);
		textField.setColumns(10);
		
		textField1 = new JTextField();
		textField1.setBounds(223, 83, 207, 44);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(223, 133, 207, 44);
		textField2.setColumns(10);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblEnterTheThird);
		frame.getContentPane().add(lblEnterTheSecond);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(textField2);
		frame.getContentPane().add(textField1);
		frame.getContentPane().add(textField);
		
		btnAverage = new JButton("Average");
		btnAverage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String grade1 = textField.getText();
				String grade2 = textField1.getText();
				String grade3 = textField2.getText();
				
				int avgGrade = (Integer.parseInt(grade1) + Integer.parseInt(grade2) 
				+ Integer.parseInt(grade3))/3;
				
				textArea.setText(Integer.toString(avgGrade));
				
			}
		});
		btnAverage.setForeground(Color.BLACK);
		btnAverage.setBackground(Color.CYAN);
		btnAverage.setFont(new Font("Tahoma", Font.ITALIC, 18));
		btnAverage.setBounds(24, 187, 189, 58);
		frame.getContentPane().add(btnAverage);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 15));
		textArea.setBackground(new Color(240, 240, 240));
		textArea.setBounds(223, 204, 207, 22);
		frame.getContentPane().add(textArea);
	}
}
