package Item;
//package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Necklace extends Misc {
	private int str = 0;
	private int intel = 0;
	private int def = 0;
	private int speed = 0;
	private int dmg = 0;
	private Image image = new Image("nothing.png", 40, 40, false, false);
	private ImageView imageview = new ImageView(image);


	public Necklace() {
		// TODO Auto-generated constructor stub
		image = new Image("file:necklace.jpg", 40, 40, false, false);
		imageview = new ImageView(image);
		str = 6;
		intel = 5;
		def = 5;
		speed = 5;

	}

	public int getID() {
		// TODO Auto-generated method stub
		return 103;
	}

	@Override
	public ImageView getImage() {
		// TODO Auto-generated method stub
		return imageview;
	}

	@Override
	public int getStr() {
		// TODO Auto-generated method stub
		return str;
	}

	@Override
	public int getInt() {
		// TODO Auto-generated method stub
		return intel;
	}

	@Override
	public int getDmg() {
		// TODO Auto-generated method stub
		return dmg;
	}

	@Override
	public int getDef() {
		// TODO Auto-generated method stub
		return def;
	}

	@Override
	public int getSpd() {
		// TODO Auto-generated method stub
		return speed;
	}

}
