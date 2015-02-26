package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Sword extends Weapon {

	public Sword() {
		image = new Image("file:sword.png", 40, 40, false, false);
		imageview = new ImageView(image);
		str=5;
		intel=5;
		def=5;
		speed=5;
		dmg=5;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}
	public ImageView getImage()
	{
		return imageview;
	}
}
