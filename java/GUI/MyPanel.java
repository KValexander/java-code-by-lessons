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

	ImageIcon image;
	JLabel label;

	MyPanel() {
		this.setPreferredSize(new Dimension(500, 500));
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;

		for(int i = 0; i < 500; i += 16) {
			g2D.drawLine(0, i, 500, i);
			g2D.drawLine(i, 0, i, 500);
		}
	}
}