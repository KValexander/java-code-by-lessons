package com.main.objects;

// Import packages
// io
import java.io.IOException;
// imageio
import javax.imageio.ImageIO;

public class OBJ_Key extends SuperObject {

	// Constructor
	public OBJ_Key() {
		name = "Key";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/assets/objects/key.png"));
		} catch(IOException e) {
			e.printStackTrace();
		} 
	}

}