     // CLASS: GameDisplay interface
     //
     // Author: Ovietobore Oghre 7793149
     //
     // REMARKS: An interface specifying all the methods an implementation of a display will have
     //
     //-----------------------------------------
import java.util.Scanner;
public class ChessDisplay implements GameDisplay{
  private String [][] boardExtra;// board containing the line numbers and dashes to seperate lines
  private Piece [][] board;// board with only the chess pieces
  
  //constructor
  public ChessDisplay(){
    boardExtra = new String [18][18];
    board = new Piece [8][8];
    for(int i=0; i<boardExtra.length;i++){
      for(int j=0; j<boardExtra.length;j++){
        boardExtra[i][j]=" ";
      }
    }

    initializeBoard();
  }
  
  //getter method
  public Piece [][] getBoard(){
    return board;
  }
  
    //------------------------------------------------------
     // initializeBoard
     //
     // PURPOSE: to set the board to its default beginning state
     // PARAMETERS: none
     // Returns: none
     //------------------------------------------------------
  public void initializeBoard(){
   
    for(int i=0; i<board.length;i++){ //place both sets of pawns
      board[1][i]=new Pawn(false);
      board[6][i]=new Pawn(true);
    }
    //players pieces
    board[7][0]=new Rook(true);
    board[7][1]=new Knight(true);
    board[7][2]=new Bishop(true);
    board[7][3]=new King(true);
    board[7][4]=new Queen(true);
    board[7][5]=new Bishop(true);
    board[7][6]=new Knight(true);
    board[7][7]=new Rook(true);
    
    //computers pieces
    board[0][0]=new Rook(false);
    board[0][1]=new Knight(false);
    board[0][2]=new Bishop(false);
    board[0][3]=new King(false);
    board[0][4]=new Queen (false);
    board[0][5]=new Bishop(false);
    board[0][6]=new Knight(false);
    board[0][7]=new Rook(false);
    
    for(int i=2;i<board.length-2;i++){
      for(int j=0; j<board.length;j++){
        board[i][j]=null;
      }
    }
    copyToExtraBoard();
    
    //setting the empty spaces in the board
     for(int i=1; i<boardExtra.length/2; i++){
      boardExtra[0][2*i]=""+i;
      for(int j=0;j<boardExtra.length; j++){
        boardExtra[(2*i)-1][j]="-";
        if(j%2!=0){
          boardExtra[2*i][j]="|";
        }
      }
       boardExtra[2*i][0]=""+i;
    }
  }
  
  
    //------------------------------------------------------
     // copyToExtraBoard
     //
     // PURPOSE: to copy all the pieces from the board with just the pieces to the actual board that contains line numbers and dashes
     // PARAMETERS: none
     // Returns: none
     //------------------------------------------------------
  public void copyToExtraBoard(){
    for(int i=0; i<board.length;i++){
      for(int j=0; j<board.length;j++){
        if(board[i][j]!=null){
          boardExtra[(i+1)*2][(j+1)*2]=(board[i][j]).getSymbol();
        }
        else{
          boardExtra[(i+1)*2][(j+1)*2]=" ";
        }
      }
    }
  }
  

  
     //------------------------------------------------------
     // displayBoard
     //
     // PURPOSE: to print the board
     // PARAMETERS: none
     // Returns: none
     //------------------------------------------------------
  public void displayBoard(){
    for(int i=0; i<boardExtra.length;i++){
      for(int j=0; j<boardExtra.length;j++){
        System.out.print(boardExtra[i][j]);
      }
      System.out.print("\n");
    }
  }
  
     //------------------------------------------------------
     // copyToExtraBoard
     //
     // PURPOSE: to set the difficulty of the computer
     // PARAMETERS: an integer representing the max difficulty
     // Returns: the difficulty level
     //------------------------------------------------------
  public int promptForOpponentDifficulty(int maxDifficulty){
    Scanner scanner = new Scanner(System.in);
    System.out.println("chose your level of difficulty: 1 easy, 2: hard");
    String dif = scanner.next();
    //while()
    int difficulty;
    while(!isNumeric(dif) || Integer.parseInt(dif)>maxDifficulty || Integer.parseInt(dif)<1  ){ //loop while the number is too big
      System.out.println("invalid input. Choose your level of difficulty: 1 easy, 2: hard");
      dif = scanner.next();
    }
    difficulty = Integer.parseInt(dif);
    //scanner.close();
    return difficulty;
  }
  
     //------------------------------------------------------
     // summarizeMove
     //
     // PURPOSE: to print the last move
     // PARAMETERS: 4 integers rowInit, colInit, rowFinal and colFinal representing the beginning position of the piece
     // Returns: 
     //------------------------------------------------------
  public void summarizeMove(int rowInit, int colInit, int rowFinal, int colFinal){
    Piece piece = board[rowInit][colInit];
    Piece captured = board[rowFinal][colFinal];
    System.out.print("" + piece.getClass().getSimpleName() + " moved from ( " + (rowInit+1) + ", " + (colInit +1) + ") to ( ");
    System.out.println((rowFinal+1) + " , " + (colFinal+1) +").");
    if(captured ==null){
      System.out.println("no capture made");
    }
    else{
      System.out.println(captured.getClass().getSimpleName() + " captured");
    }
  }
  
     //------------------------------------------------------
     // gameOver
     //
     // PURPOSE: print out a message stating who won
     // PARAMETERS: an integer representing the winner
     // Returns: 
     //------------------------------------------------------
  public void gameOver(int winner){
    if(winner ==1){
      System.out.println("Computer won");
    }
    else if(winner ==0){
      System.out.println("Player won");
    }
    else if(winner ==2){
      System.out.println("Player forfeited. Computer won");
    }
    
  }
  public boolean isNumeric(String s) {  
    return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
  }
}