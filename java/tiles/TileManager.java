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
	Tile[] tile;

	// Declaring an array of map tiles
	int mapTileNum[][];

	// Constructor
	public TileManager(MyPanel panel) {
		this.panel = panel;

		// Texture array initialization
		tile = new Tile[10];
		// Initializing an array of map tiles
		mapTileNum = new int[panel.maxScreenCol][panel.maxScreenRow];

		// Get tile image
		getTileImage();
		// Load map
		loadMap("/maps/map01.txt");
	}

	// Loading tiles
	public void getTileImage() {
		// Catching exceptions
		try {

			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/assets/floor.png"));

			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/assets/wall.png"));

			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/assets/void.png"));

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
			while(col < panel.maxScreenCol && row < panel.maxScreenRow) {

				// Retrieving a file line
				String line = br.readLine();

				// Map processing
				while(col < panel.maxScreenCol) {
					String numbers[] = line.split(" ");
					int num = Integer.parseInt(numbers[col]);
					mapTileNum[col][row] = num;
					col++;
				}
				if(col == panel.maxScreenCol) {
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
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;

		// Tiles processing
		while(col < panel.maxScreenCol && row < panel.maxScreenRow) {

			int tileNum = mapTileNum[col][row];

			// rendering tile
			g2d.drawImage(tile[tileNum].image, x, y, panel.tileSize, panel.tileSize, null);
			col++;
			x += panel.tileSize;

			if(col == panel.maxScreenCol) {
				col = 0;
				x = 0;
				row++;
				y += panel.tileSize;
			}

		}

	}


}