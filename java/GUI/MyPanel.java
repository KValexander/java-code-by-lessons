package com.main.GUI;

import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MyPanel extends JPanel {

	private final int WIDTH = 453;
	private final int HEIGHT = 917;

	ImageIcon image;
	JLabel label;

	MyPanel() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;

		for(int i = 0; i < HEIGHT; i += 16)
			g2D.drawLine(0, i, WIDTH, i);
		for(int i = 0; i < WIDTH; i += 16)
			g2D.drawLine(i, 0, i, HEIGHT);
	}
}