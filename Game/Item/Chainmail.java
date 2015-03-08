package Item;

//package application;

import Character.PlayerCharacter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Chainmail extends Armor {
	private int str = 0;
	private int intel = 0;
	private int def = 0;
	private int speed = 0;
	private int dmg = 0;
	private Image image = new Image("file:nothing.png", 40, 40, false, false);
	private ImageView imageview = new ImageView(image);

	public Chainmail() {
		image = new Image("file:chainmail.png", 40, 40, false, false);
		imageview = new ImageView(image);
		str = 35;
		intel = 25;
		def = 30;
		speed = 20;
		// TODO Auto-generated constructor stub
	}

	public int getID() {
		// TODO Auto-generated method stub
		return 101;
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

	@Override
	public void equip(PlayerCharacter holder) {
		// TODO Auto-generated method stub

	}

}
