package com.main.tiles;

// Import packages
// io
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
// awt
import java.awt.Graphics2D;
// imageio
import javax.imageio.ImageIO;
// main
import com.main.MyPanel;

// TileManager class
public class TileManager {

	// MyPanel variable
	MyPanel panel;

	// Declaring an array of textures
	public Tile[] tile;

	// Declaring an array of map tiles
	public int mapTileNum[][];

	// Constructor
	public TileManager(MyPanel panel) {
		this.panel = panel;

		// Texture array initialization
		tile = new Tile[10];
		// Initializing an array of map tiles
		mapTileNum = new int[panel.maxWorldCol][panel.maxWorldRow];

		// Get tile image
		getTileImage();
		// Load map
		loadMap("/maps/world01.txt");
	}

	// Loading tiles
	public void getTileImage() {
		// Catching exceptions
		try {

			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/assets/floor.png"));

			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/assets/wall.png"));
			tile[1].collision = true;

			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/assets/void.png"));
			tile[2].collision = true;

		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	// Loading map
	public void loadMap(String filePath) {
		// Catching exceptions
		try {
			// Getting file
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;

			// File processing
			while(col < panel.maxWorldCol && row < panel.maxWorldRow) {

				// Retrieving a file line
				String line = br.readLine();

				// Map processing
				while(col < panel.maxWorldCol) {
					String numbers[] = line.split(" ");
					int num = Integer.parseInt(numbers[col]);
					mapTileNum[col][row] = num;
					col++;
				}
				if(col == panel.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			br.close();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	// Rendering tiles
	public void draw(Graphics2D g2d) {

		// Tile rendering configurations
		int worldCol = 0;
		int worldRow = 0;

		// Tiles processing
		while(worldCol < panel.maxWorldCol && worldRow < panel.maxWorldRow) {

			int tileNum = mapTileNum[worldCol][worldRow];

			// Camera configuration
			int worldX = worldCol * panel.tileSize;
			int worldY = worldRow * panel.tileSize;
			int screenX = worldX - panel.player.worldX + panel.player.screenX;
			int screenY = worldY - panel.player.worldY + panel.player.screenY;

			// Border
			if(worldX + panel.tileSize * 2 > panel.player.worldX - panel.player.screenX &&
			   worldX - panel.tileSize * 2 < panel.player.worldX + panel.player.screenX &&
			   worldY + panel.tileSize * 2 > panel.player.worldY - panel.player.screenY &&
			   worldY - panel.tileSize * 2 < panel.player.worldY + panel.player.screenY) {
				// Rendering tile
				g2d.drawImage(tile[tileNum].image, screenX, screenY, panel.tileSize, panel.tileSize, null);
			}

			worldCol++;

			if(worldCol == panel.maxWorldCol) {
				worldCol = 0;
				worldRow++;
			}

		}

	}


}