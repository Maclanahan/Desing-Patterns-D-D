package rooms;

public class EmptyRoom extends Room
{
   
   public EmptyRoom(int x, int y, Room rooms[][])
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
     char[][] temp =  {{'X','X','X','X','X','X','X','X','X'},
                       {'X','X','X','X','X','X','X','X','X'},
                       {'X','X','X','X','X','X','X','X','X'},
                       {'X','X','X','X','X','X','X','X','X'},
                       {'X','X','X','X','X','X','X','X','X'},
                       {'X','X','X','X','X','X','X','X','X'},
                       {'X','X','X','X','X','X','X','X','X'}};
               
     _tile = temp;
   }
   
   private void setBounds(Room rooms[][])
   {
      _up = _right = _down = _left = 0;
      
      if ( _x == rooms.length-1 )
         _down = 1;
      
      if ( _x == 0 )
         _up = 1;
         
      if ( _y == rooms[0].length-1 )
         _right = 1;
         
      if ( _y == 0 )
         _left = 1;
   }   
}