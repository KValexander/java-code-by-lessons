package com.main;

// Import packages
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Graphics2D;

import javax.swing.JPanel;

// Import own packages
import com.main.tiles.TileManager;

public class MyPanel extends JPanel {

	// Screen settings
	private final int minTileSize = 16;
	private int scale = 1;
	
	// Tile settings
	public final int tileSize = minTileSize * scale;
	public final int maxScreenCol = 20;
	public final int maxScreenRow = 20;

	// Screen dimensions
	private final int WIDTH = tileSize * maxScreenCol;
	private final int HEIGHT = tileSize * maxScreenRow;

	// Instances
	KeyHandler keyH = new KeyHandler();
	TileManager tileManager = new TileManager(this);

	// Constructor
	MyPanel() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.black);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		drawGrid(g2d);
		tileManager.draw(g2d);

		g2d.dispose();
	}

	// Mesh rendering method
	private void drawGrid(Graphics2D g2d) {
		g2d.setPaint(new Color(0xcccccc));
		for(int i = tileSize; i <= HEIGHT; i += tileSize)
			g2d.drawLine(0, i, WIDTH, i);
		for(int i = tileSize; i <= WIDTH; i += tileSize)
			g2d.drawLine(i, 0, i, HEIGHT);
	}

	// Get WIDTH
	public int getWidth() {
		return WIDTH;
	}

	// Get HEIGHT
	public int getHeight() {
		return HEIGHT;
	}
}