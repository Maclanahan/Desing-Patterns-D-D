public abstract class Room
{
   protected char[][] _tile;
   protected int _up, _right, _down, _left, _x, _y;
   
   public Room(int x, int y, Room rooms[][])
   { 
      _x = x;
      _y = y;
      
      init(rooms);
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
                       {'X','X','X','X','X','X','X','X','X','X'},
                       {'X','X','X','X','X','X','X','X','X','X'},
                       {'X','X','X','X','X','X','X','X','X','X'},
                       {'X','X','X','X','X','X','X','X','X','X'}};
               
     _tile = temp;
   }
   
   public void printRoom()
   {
      int row, col;
      
      for ( row=0; row<_tile.length; row++ )
      {
         for ( col=0; col<_tile[0].length; col++ )
            System.out.print(_tile[row][col]);
            
         System.out.println("");
      }
      
      System.out.println("up:" + _up + "\nright:" + _right +
                        "\ndown:" + _down + "\nleft:" + _left);
   }
   
   private void setBounds(Room rooms[][]){}
   
   public char[][] getTiles()
   {
      return _tile;
   }
   
   public int getUp()
   {
      return _up;
   }
   
   public int getRight()
   {
      return _right;
   }
   
   public int getDown()
   {
      return _down;
   }
   
   public int getLeft()
   {
      return _left;
   }
   
}