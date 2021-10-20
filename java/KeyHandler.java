package com.main;

// Import packages
// awt event
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// KeyHandler class inherit KeyListener interface
public class KeyHandler implements KeyListener {

	// Directions of pressing
	public boolean upPressed, downPressed, leftPressed, rightPressed;

	// Method inherited from interface
	@Override
	public void keyTyped(KeyEvent e) {}

	// Method inherited from interface
	// Pressing a key
	@Override
	public void keyPressed(KeyEvent e) {

		// Get the key pressed
		int code = e.getKeyCode();

		// Checking keystrokes
		if(code == KeyEvent.VK_W) upPressed = true;
		if(code == KeyEvent.VK_S) downPressed = true;
		if(code == KeyEvent.VK_A) leftPressed = true;
		if(code == KeyEvent.VK_D) rightPressed = true;
	}

	// Method inherited from interface
	// Key release
	@Override
	public void keyReleased(KeyEvent e) {

		// Get the key pressed
		int code = e.getKeyCode();

		// Checking keystrokes
		if(code == KeyEvent.VK_W) upPressed = false;
		if(code == KeyEvent.VK_S) downPressed = false;
		if(code == KeyEvent.VK_A) leftPressed = false;
		if(code == KeyEvent.VK_D) rightPressed = false;

	}

}