package com.main;

// Import packages
// swing
import javax.swing.JFrame;

// Starting class
public class Main {
	// Program entry point
	public static void main(String[] args) {
		// A new instance of a frame
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Labyrinth");

		// A new instance of a panel
		MyPanel panel = new MyPanel();
		frame.add(panel);

		frame.pack();

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		// Setup game
		panel.setupGame();
		// Start thread
		panel.startMyThread();
	}
}