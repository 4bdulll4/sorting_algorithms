package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import sorting_algorithms.Bubble;
import sorting_algorithms.Heap;
import sorting_algorithms.Insertion;
import sorting_algorithms.Merge;
import sorting_algorithms.Quick;
import sorting_algorithms.Selection;
import sorting_algorithms.Shell;



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
	private String[] selectionMenu = {"Select One","Selection","Bubble","Insertion","Shell","Merge","Quick","Heap"};
	private JFileChooser chooser;
	private int arr[];

	public sorting_GUI ()
	{
		super("Sort Me");
		  
		header = 		 new JLabel("Sorting Algorithms Application");
		bigPanel = 	 	 new JPanel(new BorderLayout(GAP,GAP));
		topPanel =	  	 new JPanel(new FlowLayout(FlowLayout.LEFT,0,GAP));
		centerPanel = 	 new JPanel(new GridLayout(3,1,GAP,GAP));		
		inputPanel = 	 new JPanel(new BorderLayout(GAP,GAP));
		selectionPanel = new JPanel(new BorderLayout(GAP,GAP));
		outputPanel = 	 new JPanel(new BorderLayout(GAP,GAP));	
		inputLabel = 	 new JLabel("Select the file that you want to sort. (Recommended: .txt) ");
		selectionLabel = new JLabel("Which sorting algorithm would you like to perform the sorting?");
		outputLabel = 	 new JLabel("Select the directory that you want to save your sorted file.");
		browseBtn = 	 new JButton("Browse");
		okBtn = 		 new JButton("OK");
		saveBtn = 		 new JButton("  Save   ");
		selectionBox = 		 new JComboBox<String>();
		chooser = new JFileChooser();		
		
	/* ------------- Big Panel ------------- */
		bigPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		bigPanel.add(topPanel,BorderLayout.NORTH);
		bigPanel.add(centerPanel,BorderLayout.CENTER);
		bigPanel.add(new JLabel("Copyright © 4BDULLL4. All rights reserved."),BorderLayout.SOUTH);
	// -----------------------------------------;
		
	/* ------------- Top Panel ------------- */	
		header.setFont(new Font("Poetsen One", Font.PLAIN, 22));	
		topPanel.add(header);
	// -----------------------------------------;	
		
	/* ------------- Center Panel ------------- */
		
		centerPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		centerPanel.add(inputPanel);		
		centerPanel.add(outputPanel);
		centerPanel.add(selectionPanel);
	// -----------------------------------------;
		
	/* ------------- Input Panel ------------- */			
		inputPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		JPanel innerInputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,HGAP,VGAP));
		inputPanel.add(innerInputPanel);
		innerInputPanel.setBorder(BorderFactory.createTitledBorder("How to Input Data?   "));
		innerInputPanel.add(inputLabel,BorderLayout.WEST);
		innerInputPanel.add(new JLabel("                            "));
		innerInputPanel.add(browseBtn);
		
	// -----------------------------------------;
		
	/* ------------- Output Panel ------------- */	
		outputPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		JPanel innerOutputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,HGAP,VGAP));
		outputPanel.add(innerOutputPanel);
		innerOutputPanel.setBorder(BorderFactory.createTitledBorder("Where to Save?   "));
		innerOutputPanel.add(outputLabel);
		innerOutputPanel.add(new JLabel("                            "));
		innerOutputPanel.add(saveBtn);
	// -----------------------------------------;	
		
	/* ------------- Selection Panel ------------- */	
		selectionPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		JPanel innerSelectionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,HGAP,VGAP));
		selectionPanel.add(innerSelectionPanel);
		innerSelectionPanel.setBorder(BorderFactory.createTitledBorder("How do you want to sort your data?   "));	
		innerSelectionPanel.add(selectionLabel);
		innerSelectionPanel.add(selectionBox);
		innerSelectionPanel.add(okBtn);
	// -----------------------------------------;
		
		
	/* ------------- JCheckBox ------------- */	
		for (int i = 0; i < selectionMenu.length; i++) {
			selectionBox.addItem(selectionMenu[i]);
		}
	// -----------------------------------------;

		this.add(bigPanel);
		
		Handler handler = new Handler();
		browseBtn.addActionListener(handler);
		saveBtn.addActionListener(handler);
		okBtn.addActionListener(handler);
		selectionBox.addActionListener(handler);
	}
	
	private class Handler implements ActionListener 
	{

		public PrintWriter writer;
		public File inputFile;
		public File outputFile;
		public fileChooser reader = new fileChooser();
		public JOptionPane optionPane = new JOptionPane();
		
		public void actionPerformed(ActionEvent e) {							
			
			if(e.getSource() == browseBtn)
			{
				int returnVal = chooser.showOpenDialog(chooser);
				
				if(returnVal == JFileChooser.APPROVE_OPTION)
				{
					inputFile = chooser.getSelectedFile();		// returns the directory of the file and assigns it to file object.
					reader.setSize(inputFile);					// scans the file thru given directory and counts number of lines.
					arr = new int[reader.N];					// initializes the array with returned variable that has been counted before.
					reader.getData(inputFile, arr);				// this method is simply reads the file again and copies the content to the array.								
				}
			}
			else if(e.getSource() == saveBtn)
			{				
				int returnVal = chooser.showSaveDialog(chooser);
				
				if(returnVal == JFileChooser.APPROVE_OPTION)
				{
					outputFile = chooser.getSelectedFile();
					
				}
			}
			if(e.getSource() == okBtn)
			{
				try {
					writer = new PrintWriter(outputFile);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
													
				if(selectionBox.getSelectedItem() == selectionMenu[1])			// Selection Sort
				{
					Selection selection = new Selection();				
					selection.sort(arr, arr.length);
					
					for (int i = 0; i < arr.length; i++) {
						writer.println(arr[i]);
					}					
					writer.close();
					JOptionPane.showMessageDialog(optionPane, "Congratulations! "
							+ "Your file Succesfully has been Sorted.\nOpen: " + outputFile,"Done", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(selectionBox.getSelectedItem() == selectionMenu[2])		// Bubble Sort
				{
					Bubble bubble = new Bubble();
					bubble.sort(arr, arr.length);
					
					for (int i = 0; i < arr.length; i++) {
						writer.println(arr[i]);
					}
					writer.close();
					JOptionPane.showMessageDialog(optionPane, "Congratulations! "
							+ "Your file Succesfully has been Sorted.\nOpen: " + outputFile,"Done", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(selectionBox.getSelectedItem() == selectionMenu[3])		// Insertion Sort
				{
					Insertion insertion = new Insertion();
					insertion.sort(arr, arr.length);
					
					for (int i = 0; i < arr.length; i++) {
						writer.println(arr[i]);
					}
					writer.close();
					JOptionPane.showMessageDialog(optionPane, "Congratulations! "
							+ "Your file Succesfully has been Sorted.\nOpen: " + outputFile,"Done", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(selectionBox.getSelectedItem() == selectionMenu[4])		// Shell Sort
				{
					Shell shell = new Shell();
					shell.sort(arr, arr.length);
					
					for (int i = 0; i < arr.length; i++) {
						writer.println(arr[i]);
					}
					writer.close();
					JOptionPane.showMessageDialog(optionPane, "Congratulations! "
							+ "Your file Succesfully has been Sorted.\nOpen: " + outputFile,"Done", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(selectionBox.getSelectedItem() == selectionMenu[5])		// Merge Sort
				{
					Merge merge = new Merge();
					merge.sort(arr);
					
					for (int i = 0; i < arr.length; i++) {
						writer.println(arr[i]);
					}
					writer.close();
					JOptionPane.showMessageDialog(optionPane, "Congratulations! "
							+ "Your file Succesfully has been Sorted.\nOpen: " + outputFile,"Done", JOptionPane.INFORMATION_MESSAGE);
				}
				
				else if(selectionBox.getSelectedItem() == selectionMenu[6])		// Quick Sort
				{
					Quick quick = new Quick();
					quick.sort(arr);
					
					for (int i = 0; i < arr.length; i++) {
						writer.println(arr[i]);
					}
					writer.close();
					JOptionPane.showMessageDialog(optionPane, "Congratulations! "
							+ "Your file Succesfully has been Sorted.\nOpen: " + outputFile,"Done", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(selectionBox.getSelectedItem() == selectionMenu[7])		// Heap Sort
				{
					Heap heap = new Heap();
					heap.sort(arr);
					
					for (int i = 0; i < arr.length; i++) {			
						writer.println(arr[i]);
					}
					writer.close();
					JOptionPane.showMessageDialog(optionPane, "Congratulations! "
							+ "Your file Succesfully has been Sorted.\nOpen: " + outputFile,"Done", JOptionPane.INFORMATION_MESSAGE);
				}
				
				else 
				{
					JOptionPane.showMessageDialog(optionPane, "Please Select a Method", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}}}
	
	public static void main(String[] args) {
		
		sorting_GUI frame = new sorting_GUI();
		
		frame.setBounds(200, 100,650 ,600);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
	}
}
