package Map;

public class RDLRoom extends Room
{
   
   public RDLRoom(int x, int y, Room rooms[][])
   {  
      super(x,y,rooms);
   }
   
   protected void init(Room rooms[][])
   {
      setBounds(rooms);
      createRoom();
   }
   
   private void createRoom()
   {
     char[][] temp =  {{'X','X','X','X','X','X','X','X','X','X'},
                       {'X','X','X','X','X','X','X','X','X','X'},
                       {'X','X','X','X','X','X','X','X','X','X'},
                       {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                       {'X','X','X',' ',' ',' ',' ','X','X','X'},
                       {'X','X','X','X',' ',' ','X','X','X','X'},
                       {'X','X','X','X',' ',' ','X','X','X','X'}};
               
     _tile = temp;
   }
   
   private void setBounds(Room rooms[][])
   {
      _up = 1;
      _right = 0;
      _down = 0;
      _left = 0;
   }   
}