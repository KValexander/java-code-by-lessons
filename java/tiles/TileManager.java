package com.main.tiles;

// Import packages
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;

// Import our packages
import com.main.MyPanel;

public class TileManager {
	MyPanel panel;
	Tile[] tile;

	public TileManager(MyPanel panel) {
		this.panel = panel;

		tile = new Tile[10];

		getTileImage();
	}

	public void getTileImage() {

		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/assets/floor.png"));
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/assets/void.png"));
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/assets/wall.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(tile[0].image, 0, 0, panel.tileWidth, panel.tileHeight, null);
		g2d.drawImage(tile[1].image, 16, 0, panel.tileWidth, panel.tileHeight, null);
		g2d.drawImage(tile[2].image, 32, 0, panel.tileWidth, panel.tileHeight, null);
	}

}