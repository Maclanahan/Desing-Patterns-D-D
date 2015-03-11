package Item;

//package application;

import Character.PlayerCharacter;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Necklace extends Misc {

	public Necklace() {
		// TODO Auto-generated constructor stub
		image = new Image("file:necklace.jpg", 40, 40, false, false);
		imageview = new ImageView(image);
		str = 8;
		intel = 8;
		def = 3;
		speed = 3;
		hp = 15;
		Tooltip t = new Tooltip("def:" + def + "\nint:" + intel + "\nspeed:"
				+ speed + "\nstr:" + str + "\nhp:" + hp);
		Tooltip.install(imageview, t);

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
	public int getHP() {
		// TODO Auto-generated method stub
		return hp;
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
