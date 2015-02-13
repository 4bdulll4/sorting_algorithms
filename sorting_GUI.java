package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.LayoutManager2;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;


public class sorting_GUI extends JFrame{
	
	private JLabel header;
	private JPanel topPanel;
	private JPanel centerPanel;
	private JPanel innerPanel;
	private JComboBox<String> cmBox;
	
	public sorting_GUI ()
	{
		super("Sort Me");
		  
		header = new JLabel("Sorting Algorithms Application");
		topPanel = new JPanel();
		centerPanel = new JPanel();
		innerPanel = new JPanel();
		cmBox = new JComboBox<String>();
		
		header.setFont(new Font("Myriad Pro", Font.PLAIN, 22));
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,15));				
		topPanel.add(header);
	// top Panel...	
		centerPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		centerPanel.setLayout(new BorderLayout(10,10));
		centerPanel.add(innerPanel,BorderLayout.CENTER);
		centerPanel.add(new JPanel(),BorderLayout.EAST);
		centerPanel.add(new JPanel(),BorderLayout.WEST);
		centerPanel.add(new JPanel(),BorderLayout.NORTH);
		centerPanel.add(new JPanel(),BorderLayout.SOUTH);
	// center Panel...	
		innerPanel.setBorder(BorderFactory.createTitledBorder("Choose your Option"));
		innerPanel.setLayout(new BorderLayout());		
	// inner Panel...
		this.add(topPanel,BorderLayout.NORTH);
		this.add(centerPanel,BorderLayout.CENTER);
		this.add(new JPanel(),BorderLayout.WEST);
		this.add(new JPanel(),BorderLayout.EAST);
		this.add(new JPanel(),BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		
		sorting_GUI frame = new sorting_GUI();
		
		frame.setBounds(200, 100,600 ,500);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	

}
