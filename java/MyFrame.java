package com.main;

// Import packages
import javax.swing.JFrame;

public class MyFrame extends JFrame{

	// Instances
	MyPanel panel = new MyPanel();

	// Constructor
	public MyFrame() {

		this.setTitle("Labyrinth");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		this.add(panel);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}