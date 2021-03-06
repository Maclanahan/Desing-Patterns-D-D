package Item;

//package application;

import Character.PlayerCharacter;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pike extends Weapon {

	public Pike() {
		image = new Image("file:pike.png", 40, 40, false, false);
		imageview = new ImageView(image);
		str = 25;
		intel = 20;
		def = 15;
		speed = 20;
		hp = 11;
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
