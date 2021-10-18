package com.main.tiles;

// Import packages
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.awt.Graphics2D;

import javax.imageio.ImageIO;

// Import own packages
import com.main.MyPanel;

public class TileManager {
	// Instances
	MyPanel panel;

	Tile[] tile;
	int mapTileNum[][];

	// Constructor
	public TileManager(MyPanel panel) {
		this.panel = panel;

		tile = new Tile[10];
		mapTileNum = new int[panel.maxScreenCol][panel.maxScreenRow];

		getTileImage();
		loadMap("/maps/map01.txt");
	}

	// Set tiles
	public void getTileImage() {

		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/assets/floor.png"));

			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/assets/wall.png"));
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/assets/void.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Load map
	public void loadMap(String filePath) {
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			int col = 0, row = 0;

			while (col < panel.maxScreenCol && row < panel.maxScreenRow) {

				String line = br.readLine();

				while (col < panel.maxScreenCol) {
					String numbers[] = line.split(" ");

					int num = Integer.parseInt(numbers[col]);
					mapTileNum[col][row] = num;
					col++;
				}
				if(col == panel.maxScreenCol) {
					col = 0;
					row ++;
				}

			}

			br.close();

		} catch(Exception e) {

		}
	}

	// Draw tiles
	public void draw(Graphics2D g2d) {

		int col = 0, row = 0;
		int x = 0, y = 0;

		while(col < panel.maxScreenCol && row < panel.maxScreenRow) {

			int tileNum = mapTileNum[col][row];

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