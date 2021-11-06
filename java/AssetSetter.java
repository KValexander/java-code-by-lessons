package com.main;

// Import packages
// main objects
import com.main.objects.OBJ_Key;

public class AssetSetter {

	MyPanel panel;

	// Constructor
	public AssetSetter(MyPanel panel) {
		this.panel = panel;
	}

	// Set object
	public void setObject() {

		panel.obj[0] = new OBJ_Key();
		panel.obj[0].worldX = 34 * panel.tileSize;
		panel.obj[0].worldY = 34 * panel.tileSize;

	}

}