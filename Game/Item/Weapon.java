package Item;

//package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Weapon implements Item {
	protected int def;
	protected int intel;
	protected int speed;
	protected int str;
	protected int hp;
	private boolean equip;
	private int id;
	protected Image image = new Image("file:nothing.png", 40, 40, false, false);
	protected ImageView imageview = new ImageView(image);

	public Weapon() {
		// TODO Auto-generated constructor stub
	}

	public boolean equip() {
		// TODO Auto-generated method stub
		equip = true;
		return equip;
	}

	public boolean unequip() {
		// TODO Auto-generated method stub
		equip = false;
		return equip;
	}

	public boolean getEquip() {
		return equip;
	}

	public int getType() {
		return 2;
	}
}
