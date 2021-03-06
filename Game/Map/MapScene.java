package Map;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Observable;
import java.util.Scanner;
import java.util.Random;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.layout.StackPane;
import application.GameScene;
import application.SceneSwitchInfo;

public class MapScene extends Observable implements GameScene 
{
	private Scene scene;
	private Group root;
	private Text leveltxt;
	private int steps = 0;
	private static int MIN_STEPS = 15;
	private static int ENCOUNTER_CHANCE = 5; // out of 100%
	private static int RISK_CHANCE = 70; // out of 100%. The higher, the more likely the player gets treasure
	
	private char[][] floor;
	private int current = 0, tileWidth = 64, tileHeight = 64;
	private ImageView[][] iv;
	private ImageView Hero;
	private DungeonFactory df = new DungeonFactory();
	private Floor[] floors = df.getFloors();

	private Player player = new Player(floors[current]);
	private StackPane invButton;
	private StackPane riskButton;
	
	
	public MapScene()
	{
		Rectangle button;
		Text txt;
		
		Scanner scan = new Scanner(System.in);
		
		root = new Group();
		scene = new Scene(root, 640, 480, Color.WHITE);
		
		addFloor();
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() 
				{
					public void handle(KeyEvent key)
					{
						Tile tile;
						steps += 1;
						
						if(checkWall(0,1,player) && (key.getText().equals("d") || key.getCode() == KeyCode.RIGHT))
						{
							movePlayer(0,-1);
							player.setCol(player.getCol()+1);
							
							Hero.setImage(new Image("Map/HeroRight.png"));
						}
						
						if(checkWall(0,-1,player) && (key.getText().equals("a") || key.getCode() == KeyCode.LEFT))
						{
							movePlayer(0,1);
							player.setCol(player.getCol()-1);
							
							Hero.setImage(new Image("Map/HeroLeft.png"));
						}
						
						if(checkWall(-1,0,player) && (key.getText().equals("w") || key.getCode() == KeyCode.UP))
						{
							movePlayer(1,0);
							player.setRow(player.getRow()-1);
							
							Hero.setImage(new Image("Map/HeroUp.png"));
						}
						
						if(checkWall(1,0,player) && (key.getText().equals("s") || key.getCode() == KeyCode.DOWN))
						{
							movePlayer(-1,0);
							player.setRow(player.getRow()+1);
							
							Hero.setImage(new Image("Map/HeroDown.png"));
						}
						
						if (floor[player.getRow()][player.getCol()] == 'T')
						{
							floor[player.getRow()][player.getCol()] = 'O';
							
							tile = new Tile(floor[player.getRow()][player.getCol()],current/2+1);
							iv[player.getRow()][player.getCol()].setImage(new Image(tile.getName()));
							
								
							setChanged();
							notifyObservers(new SceneSwitchInfo("TREASURE", current/2+1));
						}
							
						if (floor[player.getRow()][player.getCol()] == 'E')
						{
							current += 1;
							leveltxt.setText("Floor: " + (current+1));
							
							removeFloor();
							addFloor();
							refreshButtons();
						}
						
						if (floor[player.getRow()][player.getCol()] == 'B')
						{
							setChanged();
							notifyObservers(new SceneSwitchInfo("COMBAT", 50));
							
							//System.out.println("You beat the game!!!");
						}
						
						randomEncounter();
					}
				});
		
		scan.close();
		   
		//EventHandler handler = new EventHandler
		
		button = new Rectangle(100, 30, Color.RED);
		
		txt = new Text(110,40, "Risk");
		txt.setFill(Color.WHITE);
		txt.setFont(Font.font(null, FontWeight.NORMAL, 20));
		
		riskButton = new StackPane();
		riskButton.getChildren().addAll(button,txt);
		
		riskButton.layoutXProperty().set(530);
		riskButton.layoutYProperty().set(10);
		
		riskButton.setOnMousePressed(new EventHandler<MouseEvent>()
		{
			public void handle(MouseEvent me)
			{
				Random rdm = new Random();
				int control = current/2 + 1;
				
				/*if ( current/2 + 2 > floors.length/2)
					control = floors.length/2;
				else
					control = current/2 + 2;*/
				
				if ( rdm.nextInt(100) < RISK_CHANCE)
				{
					setChanged();
					notifyObservers(new SceneSwitchInfo("TREASURE", control));
				}
				else
				{
					setChanged();
					notifyObservers(new SceneSwitchInfo("COMBAT", control));
				}
			}
		});
		
		root.getChildren().add(riskButton);
		
		button = new Rectangle(100, 30, Color.BLUE);
		
		txt = new Text(540,460, "Inventory");
		txt.setFill(Color.WHITE);
		txt.setFont(Font.font(null, FontWeight.NORMAL, 20));
		
		invButton = new StackPane();
		invButton.getChildren().addAll(button,txt);
		
		invButton.layoutXProperty().set(530);
		invButton.layoutYProperty().set(440);
		
		invButton.setOnMousePressed(new EventHandler<MouseEvent>()
				{
					public void handle(MouseEvent me)
					{
						//System.out.println("Mouse Pressed");
						//execute();
						setChanged();
						notifyObservers(new SceneSwitchInfo("INVENTORY", current/2 + 1));
					}
				});
		
		root.getChildren().add(invButton);
		
		leveltxt = new Text(10,30, "Floor: " + (current+1));
		leveltxt.setFill(Color.WHITE);
		leveltxt.setFont(Font.font(null, FontWeight.BOLD, 20));
		
		root.getChildren().add(leveltxt);
	}
	
	private boolean checkWall(int row, int col, Player player)
	{
		if ( floor[player.getRow()+row][player.getCol()+col] != 'X')
			return true;
		
		return false;
	}
	
	private void randomEncounter()
	{
		Random rdm = new Random();
		
		if ( steps > MIN_STEPS && rdm.nextInt(100) < ENCOUNTER_CHANCE)
		{
			//System.out.println("Battle Triggered");
			
			setChanged();
			notifyObservers(new SceneSwitchInfo("COMBAT", current/2 +1));
			
			steps = 0;
		}
	}
	
	private void removeFloor()
	{
		int i, j;
		
		for ( i=0; i<iv.length; i++ )
			for ( j=0; j<iv[0].length; j++ )
				root.getChildren().remove(iv[i][j]);
		
		root.getChildren().remove(Hero);
	}
	
	private void addFloor()
	{
		int i, j;
		Tile tile;
		Image image;
		iv = new ImageView[floors[current].getFloor().length][floors[current].getFloor()[current].length];
		floor = floors[current].getFloor();
		player = new Player(floors[current]);
		
		for ( i=0; i<iv.length; i++ )
			for ( j=0; j<iv[0].length; j++ )
			{
				tile = new Tile(floor[i][j], current/2+1);
				
				image = new Image(tile.getName());
				iv[i][j] = new ImageView(image);
				
				iv[i][j].setX((j*tileWidth)-(player.getCol()*tileWidth)+(scene.getWidth()/2)-(tileWidth/2));
				iv[i][j].setY((i*tileHeight)-(player.getRow()*tileHeight)+(scene.getHeight()/2)-(tileHeight/2));
				
				root.getChildren().add(iv[i][j]);
			}
		
		Hero = new ImageView(new Image("Map/HeroDown.png"));
		Hero.setX((scene.getWidth()/2)-(tileWidth/2));
		Hero.setY((scene.getHeight()/2)-(tileHeight/2));
		root.getChildren().add(Hero);
	}
	
	private void movePlayer(int row, int col)
	{
		int i, j;
		
		for ( i=0; i<iv.length; i++ )
			for ( j=0; j<iv[0].length; j++ )
			{
				iv[i][j].setX(iv[i][j].getX()+(col*tileWidth));
				iv[i][j].setY(iv[i][j].getY()+(row*tileHeight));
			}
	}
	
	private void refreshButtons()
	{
		invButton.toFront();
		riskButton.toFront();
		leveltxt.toFront();
	}
	
	@Override
	public void Start() 
	{
		
	}

	@Override
	public Scene getScene() 
	{
		return scene;
	}

	@Override
	public String getType() 
	{
		return "Map";
	}

	public int getDifficulty()
	{
		return current/2 + 1;
	}

}
