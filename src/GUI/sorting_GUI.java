package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;


public class sorting_GUI extends JFrame{
	
	private final int HGAP = 10;
	private final int VGAP = 25;
	private final int GAP = 10;
	private JLabel header;
	private JPanel topPanel;
	private JPanel bigPanel;
	private JPanel centerPanel;	
	private JPanel inputPanel,selectionPanel,outputPanel;
	private JLabel inputLabel,selectionLabel,outputLabel;
	private JButton browseBtn,okBtn,saveBtn;
	private JComboBox<String> selectionBox;
	private String[] selectionMenu = {"Selection","Bubble","Insertion","Shell","Merge","Quick","Heap"};
	
	public sorting_GUI ()
	{
		super("Sort Me");
		  
		header = new JLabel("Sorting Algorithms Application");
		bigPanel = new JPanel(new BorderLayout(GAP,GAP));
		topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,0,GAP));
		centerPanel = new JPanel(new GridLayout(3,1,GAP,GAP));		
		inputPanel =  new JPanel(new FlowLayout(FlowLayout.LEFT,HGAP,VGAP));
		selectionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,HGAP,VGAP));
		outputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,HGAP,VGAP));	
		inputLabel = 	new JLabel("Select the file that you want to sort. (Recommended: .txt) ");
		selectionLabel = new JLabel("Which sorting algorithm would you like to perform the sorting?");
		outputLabel = new JLabel("Select the directory that you want to save your sorted file.");
		browseBtn = new JButton("Browse");
		okBtn = new JButton("OK");
		saveBtn = new JButton("Save");
		selectionBox = new JComboBox<String>();
		
	/* ------------- Big Panel ------------- */
		bigPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		bigPanel.add(topPanel,BorderLayout.NORTH);
		bigPanel.add(centerPanel,BorderLayout.CENTER);
	// -----------------------------------------;
		
	/* ------------- Top Panel ------------- */	
		header.setFont(new Font("Myriad Pro", Font.PLAIN, 22));			
		topPanel.add(header);
	// -----------------------------------------;	
		
	/* ------------- Center Panel ------------- */
		
		centerPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		centerPanel.add(inputPanel);		
		centerPanel.add(outputPanel);
		centerPanel.add(selectionPanel);
	// -----------------------------------------;
		
	/* ------------- Input Panel ------------- */			
		inputPanel.setBorder(BorderFactory.createTitledBorder("How to Input Data?   "));
		inputPanel.add(inputLabel,BorderLayout.WEST);
		inputPanel.add(browseBtn);
		
	// -----------------------------------------;
		
	/* ------------- Output Panel ------------- */	
		outputPanel.setBorder(BorderFactory.createTitledBorder("Where to Save?   "));
		outputPanel.add(outputLabel);
		outputPanel.add(saveBtn);
	// -----------------------------------------;	
		
	/* ------------- Selection Panel ------------- */	
		selectionPanel.setBorder(BorderFactory.createTitledBorder("How do you want to sort your data?   "));	
		selectionPanel.add(selectionLabel);
		selectionPanel.add(selectionBox);
		selectionPanel.add(okBtn);
	// -----------------------------------------;
		
		
	/* ------------- JCheckBox ------------- */	
		for (int i = 0; i < selectionMenu.length; i++) {
			selectionBox.addItem(selectionMenu[i]);
		}
	// -----------------------------------------;

		this.add(bigPanel);
		
	}
	
	public static void main(String[] args) {
		
		sorting_GUI frame = new sorting_GUI();
		
		frame.setBounds(200, 100,600 ,500);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	

}
