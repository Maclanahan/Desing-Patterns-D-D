package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Necklace extends Misc {

	public Necklace() {
		// TODO Auto-generated constructor stub
		image = new Image("file:necklace.jpg", 40, 40, false, false);
		imageview = new ImageView(image);
		str=5;
		intel=5;
		def=5;
		speed=5;

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ImageView getImage() {
		// TODO Auto-generated method stub
		return null;
	}

}
