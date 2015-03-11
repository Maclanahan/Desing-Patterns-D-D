package Item;

//package application;

import Character.PlayerCharacter;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Mace extends Weapon {

	public Mace() {
		image = new Image("file:mace.png", 40, 40, false, false);
		imageview = new ImageView(image);
		str = 20;
		intel = 8;
		def = 9;
		speed = 3;
		hp = 6;
		Tooltip t = new Tooltip("def:" + def + "\nint:" + intel + "\nspeed:"
				+ speed + "\nstr:" + str + "\nhp:" + hp);
		Tooltip.install(imageview, t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ImageView getImage() {
		return imageview;
	}

	@Override
	public int getStr() {
		// TODO Auto-generated method stub
		return str;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 102;
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
