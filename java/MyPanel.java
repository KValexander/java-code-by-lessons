package com.main;

// import packages
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Graphics2D;

import javax.swing.JPanel;

// import our packages
import com.main.tiles.TileManager;

public class MyPanel extends JPanel {

	// Screen dimensions
	private final int WIDTH = 320;
	private final int HEIGHT = 320;

	// Tile sizes
	public int tileWidth = 16;
	public int tileHeight = 16;

	// Instances
	TileManager tileManager = new TileManager(this);

	// Constructor
	MyPanel() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.black);
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
		for(int i = tileHeight; i <= HEIGHT; i += tileHeight)
			g2d.drawLine(0, i, WIDTH, i);
		for(int i = tileWidth; i <= WIDTH; i += tileWidth)
			g2d.drawLine(i, 0, i, HEIGHT);
	}
}