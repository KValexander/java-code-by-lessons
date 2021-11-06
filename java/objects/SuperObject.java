package com.main.objects;

// Import packages
// awt
import java.awt.Graphics2D;
// awt image
import java.awt.image.BufferedImage;
// main
import com.main.MyPanel;

public class SuperObject {

	// Public variables
	public BufferedImage image;
	public String name;
	public boolean collision = false;
	public int worldX, worldY;

	// Draw object
	public void draw(Graphics2D g2d, MyPanel panel) {
		int screenX = worldX - panel.player.worldX + panel.player.screenX;
		int screenY = worldY - panel.player.worldY + panel.player.screenY;

		// Border
		if(worldX + panel.tileSize > panel.player.worldX - panel.player.screenX &&
		   worldX - panel.tileSize < panel.player.worldX + panel.player.screenX &&
		   worldY + panel.tileSize > panel.player.worldY - panel.player.screenY &&
		   worldY - panel.tileSize < panel.player.worldY + panel.player.screenY) {
			// Rendering object
			g2d.drawImage(image, screenX, screenY, panel.tileSize, panel.tileSize, null);
		}
	}

}