package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Clothes extends Armor {

	public Clothes() {
		image = new Image("file:clothes.jpg", 40, 40, false, false);
		imageview = new ImageView(image);
		str=5;
		intel=5;
		def=5;
		speed=5;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ImageView getImage() {
		// TODO Auto-generated method stub
		return imageview;
	}

}
