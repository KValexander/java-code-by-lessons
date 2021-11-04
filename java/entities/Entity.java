package com.main.entities;

// Import packages
// awt
import java.awt.Rectangle;
// awt image
import java.awt.image.BufferedImage;

// Entity class
public class Entity {
	// Public variables
	public int worldX, worldY;
	public int speed;

	// Buffered image
	public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
	// Direction
	public String direction;

	// To animate an entity
	public int spriteCounter = 0;
	public int spriteNum = 1;

	// Collision
	public Rectangle solidArea;
	public boolean collisionOn = false;
}