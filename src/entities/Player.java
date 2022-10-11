package com.main.entities;

// Import packages
// io
import java.io.IOException;
// awt
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
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

	// Camera size
	public final int screenX;
	public final int screenY;

	// Constructor
	public Player(MyPanel panel, KeyHandler keyH) {
		this.panel = panel;
		this.keyH = keyH;

		// Start position
		screenX = panel.screenWidth / 2 - panel.tileSize;
		screenY = panel.screenHeight / 2 - panel.tileSize;

		// Collision
		solidArea = new Rectangle(panel.tileSize / 4, panel.tileSize / 4, panel.tileSize - panel.tileSize / 2, panel.tileSize / 2);
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;

		// Set default values
		setDefaultValues();
		// Get player image
		getPlayerImage();
	}

	// Default values
	public void setDefaultValues() {
		worldX = panel.tileSize * (panel.maxWorldCol / 2) - (panel.tileSize);
		worldY = panel.tileSize * (panel.maxWorldRow / 2) - (panel.tileSize);
		speed = 4;
		direction = "down";
	}

	// Getting player images
	public void getPlayerImage() {
		// Catching exceptions
		try {

			up1 = ImageIO.read(getClass().getResourceAsStream("/assets/sprites/up1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/assets/sprites/up2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/assets/sprites/down1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/assets/sprites/down2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/assets/sprites/left1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/assets/sprites/left2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/assets/sprites/right1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/assets/sprites/right2.png"));

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
			if(keyH.upPressed == true)
				direction = "up";
			else if(keyH.downPressed == true)
				direction = "down";
			else if(keyH.leftPressed == true)
				direction = "left";
			else if(keyH.rightPressed == true)
				direction = "right";

			// Check tile collision
			collisionOn = false;
			panel.cChecker.checkTile(this);

			int objIndex = panel.cChecker.checkObject(this, true);
			pickUpObject(objIndex);

			// Player movement considering collision
			if(collisionOn == false) {
				switch(direction) {
					case "up": worldY -= speed; break;
					case "down": worldY += speed; break;
					case "left": worldX -= speed; break;
					case "right": worldX += speed; break;
				}
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

	public void pickUpObject(int i) {
		if (i != 999) {
			if (panel.obj[i].collision != true) {
				panel.obj[0] = null;
				panel.obj[1] = null;
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
		g2d.drawImage(image, screenX, screenY, panel.tileSize, panel.tileSize, null);

	}

}