//Name :- Dev
/*
This is java code for Mine-Sweeper Game, it uses a 2-d array. 
Selection is made using co-ordinates and mines are placed randomly.
Mines are represented by a "B" when the game is over.

*/
import java.util.*;
public class MineSweeper{
public static void main(String []args){
        int array[][]=new int[8][8];            //This is a 2d Int array
        boolean array1[][]=new boolean[8][8];     //This is a 2d boolean array
        Scanner scan =new Scanner (System.in);
        drawFullGrid(array,array1); /*This is to draw the row and col so that user can make a selection*/
        initializeFullGrid(array);
         try{           //This is To handle ArrayIndexOutOfBoundsException exception
        System.out.print("Select a cell. Row value (a digit between 0 and 7):");
        int a=scan.nextInt();
        System.out.print("Select a cell. Column value (a digit between 0 and 7):");
        int b=scan.nextInt();
        while(array[a][b]!=11)
        {
        array1[a][b]=true;
        countbomb(a,b,array);
        revealGridCell(a,b,array,array1);
        drawFullGrid(array,array1);
        System.out.print("Select a cell. Row value (a digit between 0 and 7):");
        a=scan.nextInt();
        System.out.print("Select a cell. Column value (a digit between 0 and 7):");
        b=scan.nextInt();   //This is to prompt user for input
        array1[a][b]=true;
        }
        if (array[a][b]==11){     //here 11 indicates the value of my bomb so that i can check the mine in my array
        System.out.println("Kaboom! Game Over!");
        array[a][b]=10;
        gameOver(array);
        }
      }
      catch(ArrayIndexOutOfBoundsException exception) {   //this will ask for input again
        System.out.println("Please Enter a valid input");
        System.out.print("Select a cell. Row value (a digit between 0 and 7):");
        int a=scan.nextInt();
        System.out.print("Select a cell. Column value (a digit between 0 and 7):");
        int b=scan.nextInt();

        while(array[a][b]!=11)
        {
        array1[a][b]=true;
        countbomb(a,b,array);
        revealGridCell(a,b,array,array1);
        drawFullGrid(array,array1);
        System.out.print("Select a cell. Row value (a digit between 0 and 7):");
        a=scan.nextInt();
        System.out.print("Select a cell. Column value (a digit between 0 and 7):");
        b=scan.nextInt();
        array1[a][b]=true;
        }
        if (array[a][b]==11){     //This will check if user will input a place where there is a mine
        System.out.println("Kaboom! Game Over!");
        array[a][b]=10;
        gameOver(array);  //this will call the gameover method
        }


      }
        }
        public static void  countbomb(int m,int n,int [][]arr){
          int count=0;
          if(arr[m][n]!=11){       //This will count the mines in the corner as well as the centre of the 2d array if there are no mines
          if (n<7 && arr[m][n+1]==11){count++;
        } if (n>0 && arr[m][n-1]==11){count++;
        }if (  n>0&&m>0 && arr[m-1][n-1]==11){count++;
        }if (  m<7&&n>0 && arr[m+1][n-1]==11){count++;
        }if (  m>0&&n<7 && arr[m-1][n+1]==11){count++;
        }if (m>0 && arr[m-1][n]==11){count++;
        }if (m<7 && arr[m+1][n]==11){count++;
         }
          arr[m][n]=count;
          }
          }

        public static void revealGridCell(int a, int b,int [][]arr,boolean [][]arr1){
            if(arr[a][b]==0){
                  if(b<7){
                      countbomb(a,b+1,arr);
                        arr1[a][b+1]=true;}
                          if(b<7 && a<7){
        countbomb(a+1,b+1,arr);
          arr1[a+1][b+1]=true;  }
          if(a>0 && b<7){
          countbomb(a-1,b+1,arr);
          arr1[a-1][b+1]=true;
          }
          if(a>0){
          countbomb(a-1,b,arr);
          arr1[a-1][b]=true;
          }
          if(a<7){
        countbomb(a+1,b,arr);
          arr1[a+1][b]=true;
          }
          if(b>0 && a<7){
        countbomb(a+1,b-1,arr);
          arr1[a+1][b-1]=true;
          }
          if(b>0){
          countbomb(a,b-1,arr);
          arr1[a][b-1]=true;
          }
          if(a>0 && b>0){
          countbomb(a-1,b-1,arr);
          arr1[a-1][b-1]=true;
          }
          }
          }
      public static void gameOver(int [][]arr1){
        {
          System.out.println("   | 0  1  2  3  4  5  6  7");
          System.out.println("-----------------------------");

         for (int i=0; i<arr1.length;i++)
         {  System.out.print(" " + i + " |");
          for (int j=0; j<arr1[i].length; j++){
          if(arr1[i][j]==11){
          System.out.print(" B ");}
          else if(arr1[i][j]==0){
          System.out.print(" . ");}
          else if(arr1[i][j]==10){
          System.out.print(" X ");}
          else{
           System.out.print("  " + arr1[i][j]);}
          }
          System.out.println();
         }
        }
      }
public static void drawFullGrid(int [][]arr, boolean [][]arr1){
  {
  System.out.println("   | 0 1 2 3 4 5 6 7");
  System.out.println("--------------------");
  for (int i=0; i<arr.length;i++)
   {   System.out.print(" " + i + " |");
    for (int j=0; j<arr[i].length; j++)
    {
    if(arr1[i][j]==false)
    {   System.out.print(" .");
     }
  else if (arr[i][j]==0)
  {System.out.print("  ");
  }
  else
     {System.out.print(" " + arr[i][j]);
     }
     }  System.out.println();
  }
  }
}
public static void initializeFullGrid(int [][] arr){
  for(int i=0;i<10;i++){          //This will create twenty random number so that they can be used to place the mines
  Random r=new Random();
  int row=r.nextInt(8);
  int col=r.nextInt(8);
  arr[row][col]=11;
  }
}
}
