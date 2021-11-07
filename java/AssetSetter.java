package com.main;

// Import packages
// main objects
import com.main.objects.OBJ_Key;
import com.main.objects.OBJ_Gate;

public class AssetSetter {

	MyPanel panel;

	// Constructor
	public AssetSetter(MyPanel panel) {
		this.panel = panel;
	}

	// Set object
	public void setObject() {

		panel.obj[0] = new OBJ_Key();
		panel.obj[0].worldX = 54 * panel.tileSize;
		panel.obj[0].worldY = 38 * panel.tileSize;

		panel.obj[1] = new OBJ_Gate();
		panel.obj[1].worldX = 34 * panel.tileSize;
		panel.obj[1].worldY = 58 * panel.tileSize;

	}

}