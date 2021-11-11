package com.main.objects;

// Import packages
// io
import java.io.IOException;
// imageio
import javax.imageio.ImageIO;

public class OBJ_Gate extends SuperObject {

	// Constructor
	public OBJ_Gate() {
		name = "Gate";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/assets/objects/gate2.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}

}