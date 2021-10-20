package com.main.entities;

// Import packages
// io
import java.io.IOException;
// awt
import java.awt.Color;
import java.awt.Graphics2D;
// awt image
import java.awt.image.BufferedImage;
// imageio
import javax.imageio.ImageIO;
// main
import com.main.MyPanel;
import com.main.KeyHandler;

// Player class inherit Entity class
public class Player extends Entity {

	// Variables for classes
	MyPanel panel;
	KeyHandler keyH;

	// Constructor
	public Player(MyPanel panel, KeyHandler keyH) {
		this.panel = panel;
		this.keyH = keyH;

		// Set default values
		setDefaultValues();
		// Get player image
		getPlayerImage();
	}

	// Default values
	public void setDefaultValues() {
		x = 100;
		y = 100;
		speed = 4;
		direction = "down";
	}

	// Getting player images
	public void getPlayerImage() {
		// Catching exceptions
		try {

			up1 = ImageIO.read(getClass().getResourceAsStream("/assets/up1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/assets/up2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/assets/down1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/assets/down2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/assets/left1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/assets/left2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/assets/right1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/assets/right2.png"));

		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	// Updating player data
	public void update() {

		// General check
		if(	keyH.upPressed == true ||
			keyH.downPressed == true ||
			keyH.leftPressed == true ||
			keyH.rightPressed == true) {

			// Checking keystrokes
			if(keyH.upPressed == true) {
				direction = "up";
				y -= speed;
			}
			else if(keyH.downPressed == true) {
				direction = "down";
				y += speed;
			}
			else if(keyH.leftPressed == true) {
				direction = "left";
				x -= speed;
			}
			else if(keyH.rightPressed == true) {
				direction = "right";
				x += speed;
			}

			// Sprite selection
			spriteCounter++;
			if(spriteCounter > 15) {
				if(spriteNum == 1) spriteNum = 2;
				else if(spriteNum == 2) spriteNum = 1;
				spriteCounter = 0;
			}
		}

	}

	// Rendering player data
	public void draw(Graphics2D g2d) {

		// Getting the right image
		BufferedImage image = null;
		switch(direction) {
		case "up":
			if(spriteNum == 1) image = up1;
			if(spriteNum == 2) image = up2;
			break;
		case "down":
			if(spriteNum == 1) image = down1;
			if(spriteNum == 2) image = down2;
			break;
		case "left":
			if(spriteNum == 1) image = left1;
			if(spriteNum == 2) image = left2;
			break;
		case "right":
			if(spriteNum == 1) image = right1;
			if(spriteNum == 2) image = right2;
			break;
		}

		// Rendering an image
		g2d.drawImage(image, x, y, panel.tileSize * 2, panel.tileSize * 2, null);

	}

}