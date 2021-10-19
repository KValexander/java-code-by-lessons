package com.main.entities;

// Import packages
import java.awt.Color;
import java.awt.Graphics2D;

// Import own packages
import com.main.MyPanel;
import com.main.KeyHandler;

public class Player extends Entity{

	MyPanel panel;
	KeyHandler keyH;

	// Constructor
	public Player(MyPanel panel, KeyHandler keyH) {
		this.panel = panel;
		this.keyH = keyH;

		setDefaultValues();
	}

	public void setDefaultValues() {
		x = 100;
		y = 100;
		speed = 4;
	}

	public void update() {
		if(keyH.upPressed == true) y -= speed;
		if(keyH.downPressed == true) y += speed;
		if(keyH.leftPressed == true) x -= speed;
		if(keyH.rightPressed == true) x += speed;
	}

	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.white);
		g2d.fillRect(x, y, panel.tileSize, panel.tileSize);
	}

}