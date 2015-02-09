package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Character.PlayerCharacter;
import javafx.fxml.Initializable;

public class CombatController implements Initializable, ControlledScreen
{
	private ScreenController myController;
	private ArrayList<PlayerCharacter> _heros;
	
	@Override
	public void setScreenParent(ScreenController screenPage) 
	{
		myController = screenPage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		// TODO Auto-generated method stub
		
	}
	
	
	
	private void goToWorldScreen()
	{
		myController.setScreen(Main.worldScreen);
	}

	@Override
	public void updateData(ArrayList<PlayerCharacter> $heros) 
	{
		_heros = $heros;
		for(PlayerCharacter pc: _heros)
			System.out.println(pc._name);
		
	}

}
