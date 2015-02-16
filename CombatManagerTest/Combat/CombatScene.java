package Combat;

import java.util.ArrayList;

import Character.PlayerCharacter;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CombatScene 
{
	private Scene scene;
	private Group root;
	private ArrayList<TurnStep> _turn = new ArrayList<>();
	private ArrayList<PlayerCharacter> _heros;
	private ArrayList<PlayerCharacter> _enemies;
	private ArrayList<CharacterHolder> _characters = new ArrayList<>();
	private Selector select;
	
	private Rectangle button;
	
	public CombatScene(ArrayList<PlayerCharacter> $heros, ArrayList<PlayerCharacter> $enemies)
	{
		root = new Group();
		scene = new Scene(root, 640, 480, Color.GRAY);
		
		_heros = $heros;
		_enemies = $enemies;
		
		select = new Selector(_characters);
		
		setUpCharacters();
		
		setUpTurnButton();
		
		
	}
	
	private void setUpTurnButton() 
	{
		button = new Rectangle(100, 50, Color.RED);
		button.xProperty().set(320 - 50);
		button.yProperty().set(240 - 25);
		
		button.arcHeightProperty().set(5);
		button.arcWidthProperty().set(5);
		button.strokeProperty().set(Color.BLACK);
		button.strokeWidthProperty().set(2);
		
		button.setOnMousePressed(new EventHandler<MouseEvent>()
		{
			public void handle(MouseEvent me)
			{
				System.out.println("Turn Button Pressed");
				
			}
		});
	}

	private void addObjectsToScene() 
	{
		Group g = new Group();
		
		for(CharacterHolder ch : _characters)
		{
			g.getChildren().add(ch.getObjects());
		}
		
		g.getChildren().add(button);
		
		root.getChildren().add(g);
	}

	private void setUpCharacters() 
	{
		if(_heros.size() > 0)
		{
			TurnStep turn = new TurnStep(select);
			_characters.add(new HeroHolder(_heros.get(0), turn, select, 160, 15));
			_turn.add(turn);
		}
		
		if(_heros.size() > 1)
		{
			TurnStep turn = new TurnStep(select);
			_characters.add(new HeroHolder(_heros.get(1), turn, select, 40, 90));
			_turn.add(turn);
		}
		
		if(_heros.size() > 2)
		{
			TurnStep turn = new TurnStep(select);
			_characters.add(new HeroHolder(_heros.get(2), turn, select, 40, 240));
			_turn.add(turn);
		}
		
		if(_heros.size() > 3)
		{
			TurnStep turn = new TurnStep(select);
			_characters.add(new HeroHolder(_heros.get(3), turn, select, 160, 330));
			_turn.add(turn);
		}
		
		if(_enemies.size() > 0)
		{
			TurnStep turn = new TurnStep(select);
			_characters.add(new EnemyHolder(_enemies.get(0), turn, select, 400, 15));
			_turn.add(turn);
		}
		
		if(_enemies.size() > 1)
		{
			TurnStep turn = new TurnStep(select);
			_characters.add(new EnemyHolder(_enemies.get(1), turn, select, 520, 90));
			_turn.add(turn);
		}
		
		if(_enemies.size() > 2)
		{
			TurnStep turn = new TurnStep(select);
			_characters.add(new EnemyHolder(_enemies.get(2), turn, select,  520, 240));
			_turn.add(turn);
		}
		
		if(_enemies.size() > 3)
		{
			TurnStep turn = new TurnStep(select);
			_characters.add(new EnemyHolder(_enemies.get(3), turn, select, 400, 330));
			_turn.add(turn);
		}
		
	}

	public Scene getScene()
	{
		return scene;
	}

	public void doSomething() 
	{
		//root.getChildren().add();
		addObjectsToScene();
	}
}
