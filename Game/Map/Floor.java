package Map;

import java.util.Random;

public class Floor
{
   private static final int MIN_SIZE = 8;
   private static final int TOP_BOTTOM_BORDER = 3;
   private static final int LEFT_RIGHT_BORDER = 5;
   private Room[][] _rooms;
   private char[][] _floor;
   private int _rows, _cols, _width, _height;
   
   public Floor(int rows, int cols)
   {
      _rows = rows;
      _cols = cols;
      _width = 10;
      _height = 7;
      
      
      _floor = new char[(_rows*_height)+(TOP_BOTTOM_BORDER*2)][(_width*_cols)+(LEFT_RIGHT_BORDER*2)];
            
      constructRooms();
      createFloor();
   }
   
   private void constructRooms()
   {
      int x, y, count=0;
      Random rdm = new Random();
      
      x = rdm.nextInt(_cols);
      y = rdm.nextInt(_rows);
      
      while ( count < MIN_SIZE )
      {
         cleanFloor();
         count = roomRecursion(x,y,0);
      }
      
   }
   
   private int roomRecursion(int x, int y, int count)
   {
      RoomList list = new RoomList(x,y,_rooms);
      Random rdm = new Random();
      int i, num = 0, up, right, down, left;
      boolean upStatus, rightStatus, downStatus, leftStatus;
      
      upStatus = rightStatus = downStatus = leftStatus = false;
      
      while ( _rooms[x][y] instanceof EmptyRoom )
      {
         if ( x == 0 )
            up = 1;
         else if ( _rooms[x-1][y] instanceof EmptyRoom )
         {
            i = rdm.nextInt(2);
            
            if ( i == 0 )
            {
               up = 0;
               num += 1;
               upStatus = true;
            }
            else
               up = 1;
         }
         else
            up = _rooms[x-1][y].getDown();
            
         if ( x == _rooms.length-1 )
            down = 1;
         else if ( _rooms[x+1][y] instanceof EmptyRoom )
         {
            i = rdm.nextInt(2);
            
            if ( i == 0 )
            {
               down = 0;
               num += 1;
               downStatus = true;
            }
            else
               down = 1;
         }
         else
            down = _rooms[x+1][y].getUp();
            
         if ( y == 0 )
            left = 1;
         else if ( _rooms[x][y-1] instanceof EmptyRoom )
         {
            i = rdm.nextInt(2);
            
            if ( i == 0 )
            {
               left = 0;
               num += 1;
               leftStatus = true;
            }
            else
               left = 1;
         }
         else
            left = _rooms[x][y-1].getRight();
            
         if ( y == _rooms[0].length-1 )
            right = 1;
         else if ( _rooms[x][y+1] instanceof EmptyRoom )
         {
            i = rdm.nextInt(2);
            
            if ( i == 0 )
            {
               right = 0;
               num += 1;
               rightStatus = true;
            }
            else
               right = 1;
         }
         else
            right = _rooms[x][y+1].getLeft();
            
         _rooms[x][y] = list.getRoom( up, right, down, left );
      }
      
      if ( upStatus )
         count = roomRecursion(x-1,y,count);
         
      if ( rightStatus )
         count = roomRecursion(x,y+1,count);
         
      if ( downStatus )
         count = roomRecursion(x+1,y,count);
      
      if ( leftStatus )
         count = roomRecursion(x,y-1,count);
      
      return count + 1;
   }
   
   private void createFloor()
   {
      int i, j, m, n;
      char[][] temp;
   
      for (i=0; i<_rooms.length; i++)
         for (j=0; j<_rooms[0].length; j++)
         {
            temp = _rooms[i][j].getTiles();
            
            for (m=0; m<temp.length; m++)
               for (n=0; n<temp[0].length; n++)
                  _floor[(i*_height)+m+TOP_BOTTOM_BORDER][(j*_width)+n+LEFT_RIGHT_BORDER] = temp[m][n];
         }
   }
   
   public void cleanFloor()
   {
      int i, j;
      
      for ( i=0; i<_floor.length; i++ )
         for ( j=0; j<_floor[0].length; j++ )
            _floor[i][j] = 'X';
            
      _rooms = new Room[_rows][_cols];
      for ( i=0; i<_rooms.length; i++ )
         for ( j=0; j<_rooms[0].length; j++ )
            _rooms[i][j] = new EmptyRoom(i,j,_rooms);
   }
   
   public void printFloor()
   {
      int i, j;
      
      for ( i=0; i<_floor.length; i++ )
      {
         for ( j=0; j<_floor[0].length; j++ )
            System.out.print(_floor[i][j]);
            
         System.out.println(i+1);
      }
   }
}