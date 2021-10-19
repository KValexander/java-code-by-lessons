package com.main;

// Import packages
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Graphics2D;

import javax.swing.JPanel;

// Import own packages
import com.main.entities.Player;
import com.main.tiles.TileManager;

public class MyPanel extends JPanel implements Runnable{

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

	// FPS
	private final int FPS = 30;

	// Thread
	Thread gameThread;

	// Instances
	KeyHandler keyH = new KeyHandler();
	TileManager tileManager = new TileManager(this);
	Player player = new Player(this, keyH);

	// Constructor
	public MyPanel() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	// Mesh rendering method
	private void drawGrid(Graphics2D g2d) {
		g2d.setPaint(new Color(0xcccccc));
		for(int i = tileSize; i <= HEIGHT; i += tileSize)
			g2d.drawLine(0, i, WIDTH, i);
		for(int i = tileSize; i <= WIDTH; i += tileSize)
			g2d.drawLine(i, 0, i, HEIGHT);
	}

	// Game thread
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	// Game loop
	public void run() {
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;

		while(gameThread != null) {
			currentTime = System.nanoTime();

			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;

			if(delta >= 1) {
				update();
				repaint();
				delta--;
				drawCount++;
			}

			if(timer >= 1000000000) {
				System.out.println("FPS: " + drawCount);
				drawCount = 0;
				timer = 0;
			}

		}
	}

	// Update
	public void update() {

		player.update();

	}

	// Paint component
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		drawGrid(g2d);
		player.draw(g2d);
		tileManager.draw(g2d);

		g2d.dispose();
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