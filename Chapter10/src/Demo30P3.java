import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.DropMode;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Demo30P3 {

	private JFrame frame;
	private JTextField fn;
	private JTextField ln;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo30P3 window = new Demo30P3();
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
	public Demo30P3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 588, 542);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 192));
		panel.setForeground(new Color(64, 0, 128));
		panel.setBounds(0, 0, 572, 503);
		frame.getContentPane().add(panel);
		
		fn = new JTextField();
		fn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{
			
				if(fn.getText().equals("First Name"))
					fn.setText("");
			
			}
		});
		fn.setForeground(new Color(192, 192, 192));
		fn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		fn.setText("First Name");
		fn.setColumns(10);
		
		ln = new JTextField();
		ln.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(ln.getText().equals("Last Name"))
					ln.setText("");
			}
		});
		ln.setForeground(new Color(192, 192, 192));
		ln.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ln.setText("Last Name");
		ln.setColumns(10);
		
		JComboBox gradeBox = new JComboBox();
		gradeBox.setBackground(new Color(255, 255, 255));
		gradeBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		gradeBox.setModel(new DefaultComboBoxModel(new String[] {"Select Grade Level", "12", "11", "10"}));
		
		JComboBox schoolBox = new JComboBox();
		schoolBox.setModel(new DefaultComboBoxModel(new String[] {"Select School", "Crescent Heights", "Lester B. Pearson", "Western", "Forest Lawn", "James Fowler"}));
		schoolBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JTextArea disp = new JTextArea();
		disp.setBackground(new Color(0, 128, 192));
		//disp.setLineWrap(true);
		disp.setWrapStyleWord(true);
		 
		JButton submit = new JButton("Submit");
		submit.setFont(new Font("Tahoma", Font.ITALIC, 22));
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String grade="";
				String school="";
				
				String firstN = fn.getText();
				String lastN = ln.getText();
				
				if(gradeBox.getSelectedItem().equals("12"))
				{
					grade = "12";
				}
				else if(gradeBox.getSelectedItem().equals("11"))
				{
					grade = "11";
				}
				else
				{
					grade = "10";
				}
				
				
				if(schoolBox.getSelectedItem().equals("Crescent Heights"))
				{
					school = "Crescent Heights";
				}
				else if(schoolBox.getSelectedItem().equals("Lester B. Pearson"))
				{
					school = "Lester B. Pearson";
				}
				else if(schoolBox.getSelectedItem().equals("Western"))
				{
					school = "Western";
				}
				else if(schoolBox.getSelectedItem().equals("Forest Lawn"))
				{
					school = "Forest Lawn";
				}
				else
				{
					school = "James Fowler";
				}

				
				
				disp.setText(firstN + " " + lastN
						+ " is in grade " + grade
						+ " and goes to " + school);

			}
		});
		
		JLabel imgZone = new JLabel("Image placeholder");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(fn, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
								.addComponent(gradeBox, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
							.addGap(71)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(ln, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
								.addComponent(schoolBox, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(disp, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(imgZone, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)))
					.addGap(25)
					.addComponent(submit, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(submit, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(fn, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(ln, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addGap(39)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(schoolBox, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addComponent(gradeBox, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))))
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(42)
									.addComponent(disp))
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(imgZone, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))))
					.addGap(179))
		);
		panel.setLayout(gl_panel);
		
		
	}
}
