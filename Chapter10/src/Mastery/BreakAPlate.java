package Mastery;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.CardLayout;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class BreakAPlate {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BreakAPlate window = new BreakAPlate();
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
	public BreakAPlate() {
		initialize();
	}
		
		ImageIcon newPlates = new ImageIcon("../Chapter10/src/Mastery/plates1.gif");
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("BreakAPlate");
		frame.setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 495, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel plates = new JLabel("New label");
		plates.setBounds(25, 50, 425, 125);
		plates.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(plates);
		
		JButton playBtn = new JButton("Play");
		playBtn.setBounds(175, 186, 125, 30);
		frame.getContentPane().add(playBtn);
	}
}
