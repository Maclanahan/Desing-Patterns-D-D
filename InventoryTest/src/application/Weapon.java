package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Weapon implements Item {
	private int def;
	private int intel;
	private int speed;
	private int str;
	private int dmg;
	private boolean equip;
	private int id;
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
	
	public boolean getEquip()
	{
		return equip;
	}

	public int getType() {
		return 2;
	}
}
