package Map;

import java.util.Observable;
import java.util.Scanner;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import application.GameScene;

public class MapScene extends Observable implements GameScene 
{
	private Scene scene;
	private Group root;
	private Text txt;
	private int numVisited = 0;
	
	public MapScene()
	{
		root = new Group();
		scene = new Scene(root, 640, 480, Color.WHITE);
		
		txt = new Text(100,100, "I'm The Map Scene!\n Visited " + numVisited + " times");
		
		root.getChildren().add(txt);
		
		Rectangle button = new Rectangle(200, 100, Color.RED);
		
		button.setOnMousePressed(new EventHandler<MouseEvent>()
		{
			public void handle(MouseEvent me)
			{
				//System.out.println("Mouse Pressed");
				//execute();
				setChanged();
				notifyObservers("COMBAT");
			}
		});
		
		button.xProperty().set(300);
		button.yProperty().set(300);
		
		root.getChildren().add(button);
		
		Rectangle button2 = new Rectangle(200, 100, Color.BLUE);
		
		button2.setOnMousePressed(new EventHandler<MouseEvent>()
		{
			public void handle(MouseEvent me)
			{
				//System.out.println("Mouse Pressed");
				//execute();
				setChanged();
				notifyObservers("INVENTORY");
			}
		});
		
		button2.xProperty().set(300);
		button2.yProperty().set(100);
		
		root.getChildren().add(button2);
		
	}
	
	@Override
	public void Start() 
	{
		/*int i, j, current = 0;
		   boolean play = true;
		   char c;
		   DungeonFactory df = new DungeonFactory();
		   Scanner scan = new Scanner(System.in);
		   String input;
		   Floor[] floors = df.getFloors();
		   char[][] copy;
		  
		   Player player = new Player(floors[current]);
		   
		   copy = new char[floors[current].getFloor().length][floors[current].getFloor()[current].length];
		   for ( i=0; i<copy.length; i++)
			   for ( j=0; j<copy[current].length; j++)
				   copy[i][j] = floors[current].getFloor()[i][j];
		   
		   copy[player.getRow()][player.getCol()] = 'P';
		   
		   for ( i=0; i<copy.length; i++ )
		   {
			   for ( j=0; j<copy[current].length; j++ )
				   System.out.print(copy[i][j]);
			
			   System.out.println("");
		   }
		   
		   while ( play )
		   {
			   copy = new char[floors[current].getFloor().length][floors[current].getFloor()[current].length];
			   for ( i=0; i<copy.length; i++)
				   for ( j=0; j<copy[current].length; j++)
					   copy[i][j] = floors[current].getFloor()[i][j];
			   
			   System.out.print("Enter direction(w,a,s,d):");
			   input = scan.next();
			   
			   if ( input.equals("w") && copy[player.getRow()-1][player.getCol()] != 'X' )
				   	player.setRow(player.getRow()-1);
			   else if ( input.equals("s") && copy[player.getRow()+1][player.getCol()] != 'X')
				   player.setRow(player.getRow()+1);
			   else if ( input.equals("a") && copy[player.getRow()][player.getCol()-1] != 'X')
				   player.setCol(player.getCol()-1);
			   else if ( input.equals("d") && copy[player.getRow()][player.getCol()+1] != 'X')
				   player.setCol(player.getCol()+1);
			   else if ( input.equals("quit") )
				   play = false;
			   
			   c = copy[player.getRow()][player.getCol()];
			   copy[player.getRow()][player.getCol()] = 'P';
		   
			   if ( c == 'E')
			   {
				   current += 1;
				   player = new Player(floors[current]);
				   
				   copy = new char[floors[current].getFloor().length][floors[current].getFloor()[current].length];
				   for ( i=0; i<copy.length; i++)
					   for ( j=0; j<copy[current].length; j++)
						   copy[i][j] = floors[current].getFloor()[i][j];
				   
				   c = copy[player.getRow()][player.getCol()];
				   copy[player.getRow()][player.getCol()] = 'P';
			   }
			   
			   if ( c == 'B')
				   play = false;
				   
			   for ( i=0; i<copy.length; i++ )
			   {
				   for ( j=0; j<copy[current].length; j++ )
					   System.out.print(copy[i][j]);
				
				   System.out.println("");
			   }
		   }
		   System.out.println("You won the game!");
		   scan.close();*/
	}

	@Override
	public Scene getScene() 
	{
		numVisited++;
		txt.textProperty().set("I'm The Map Scene!\n Visited " + numVisited + " times");
		return scene;
	}

	@Override
	public String getType() 
	{
		return "Map";
	}

	

}
