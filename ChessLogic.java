// CLASS: ChessLogic class
//
// Author: Ovietobore Oghre 7793149
//
// REMARKS: carries  out the logic of the chess game(checks valid moves, moves pieces, checks for end of the game etc).
//   Implememts ChessController interface
//
//-----------------------------------------
import java.util.Scanner;
public class ChessLogic implements ChessController{
  private ChessPlayer ai;
  ChessDisplay d;
  
  //constructor
  public ChessLogic(ChessDisplay d){
    this.d = d;
    int level = d.promptForOpponentDifficulty(2);
    if(level==1){
      ai = new AILevel1();
    }
    else if(level==2){
      ai = new AILevel2();
    }
    
    
  }
  
  
  //------------------------------------------------------
  // movePiece
  //
  // PURPOSE: check if the proposed move is valid by calling is valid for the piece is question  
  // PARAMETERS:
  // 1) 4 integers rowInit, colInit, rowFinal and colFinal representing the begisnning position of the piece
  //     and the end position of the piece
  // 2) a 2 dimensional array of pieces
  // Returns: returns true if the proposed move is legal or false if it is illegal
  //-----------------------------------------------------
  public boolean movePiece(Piece [][] board, int rowInit, int colInit, int rowFinal, int colFinal ){
    boolean result=false;
    if((rowInit != rowFinal || colInit!=colFinal) && board[rowInit][colInit] != null &&
       board[rowInit][colInit].getTeam()==true){ //a piece cannot stay on the ssame place
      //initial square must contain a players piece
      //PAWN 
      if(board[rowInit][colInit] instanceof Pawn)
      {
        result=((Pawn)board[rowInit][colInit]).isValid(board, rowInit, colInit, rowFinal, colFinal);
      }
      
      //QUEEN
      else if(board[rowInit][colInit] instanceof Queen)//queen
      {
        result = ((Queen)board[rowInit][colInit]).isValid(board, rowInit, colInit, rowFinal, colFinal);
      }
      //ROOK
      else if(board[rowInit][colInit] instanceof Rook )//rook
      {
        result=((Rook)board[rowInit][colInit]).isValid(board, rowInit, colInit, rowFinal, colFinal);
      }
      
      
      else if(board[rowInit][colInit] instanceof Knight)//knight
      {
        result=((Knight)board[rowInit][colInit]).isValid(board, rowInit, colInit, rowFinal, colFinal);
        
      }
      else if(board[rowInit][colInit] instanceof Bishop)//bishop
      {
        result=((Bishop)board[rowInit][colInit]).isValid(board, rowInit, colInit, rowFinal, colFinal);
      }
      else if(board[rowInit][colInit] instanceof King)//king
      {
        result=((King)board[rowInit][colInit]).isValid(board, rowInit, colInit, rowFinal, colFinal);
      }
    }
    return result;
  }
  
  //------------------------------------------------------
  // Play
  //
  // PURPOSE: play a move, and to rotate turns between the AI and the player. It also checks for when the game ends
  // PARAMETERS:
  // Returns: No return
  //-----------------------------------------------------
  public void play(){
    boolean playAgain = true;
    String rowInit;
    String colInit;
    String rowFinal;
    String colFinal;
    int row1;
    int col1;
    int row2;
    int col2;
    d.displayBoard();
    Scanner scanner = new Scanner(System.in);
    //loop while the player chooses to play again
    while(playAgain){
      System.out.println("Enter a number between 1 and 8 for the row of the piece you want to move or 9 to quit");
      rowInit = scanner.next();
      while(!d.isNumeric(rowInit) || Integer.parseInt(rowInit)>9 || Integer.parseInt(rowInit)<1){
        System.out.println("invalid number. Enter a number between 1 and 8 for the row of the piece you want to move or 9 to quit");
        rowInit = scanner.next();
      }
      row1 =Integer.parseInt(rowInit);
      if(row1==9){
        d.gameOver(2);
        System.out.println("Do you want to play again. Press n for no, or any other character for yes");
        if(scanner.next().equals("n")){
          playAgain = false;
          printTerminationMessage();
        }
        else {
          reset();
        }
      }
      else{
        row1= row1-1; //converting it to an array index
        System.out.println("Enter a number between 1 and 8 for the col of the piece you want to move");
        colInit=scanner.next();
        while(!d.isNumeric(colInit) || Integer.parseInt(colInit)>8 || Integer.parseInt(colInit)<1){
          System.out.println("invalid number. Enter a number between 1 and 8 for the row of the piece you want to move");
          colInit = scanner.next();
        }
        col1=Integer.parseInt(colInit);
        col1= col1-1; //converting it into an array index
        System.out.println("Enter a number between 1 and 8 for the row number of where you want the piece to move");
        rowFinal=scanner.next();
        while(!d.isNumeric(rowFinal) || Integer.parseInt(rowFinal)>8 || Integer.parseInt(rowFinal)<1){
          System.out.println("invalid number. Enter a number between 1 and 8 for the row of the piece you want to move");
          rowFinal = scanner.next();
        }
        row2=Integer.parseInt(rowFinal);
        row2= row2-1; //converting it into an array index
        System.out.println("Enter a number between 1 and 8 for the col number of where you want the piece to move");
        colFinal=scanner.next();
        while(!d.isNumeric(colFinal) || Integer.parseInt(colFinal)>8 || Integer.parseInt(rowFinal)<1){
          System.out.println("invalid number. Enter a number between 1 and 8 for the row of the piece you want to move");
          colFinal = scanner.next();
        }
        col2=Integer.parseInt(colFinal);
        col2= col2-1; //converting it into an array index
        while( !movePiece(d.getBoard(), row1, col1, row2, col2)){
          System.out.println("Invalid move");
          System.out.println("Enter a number between 1 and 8 for the row of the piece you want to move or 9 to quit");
          rowInit = scanner.next();
          while(!d.isNumeric(rowInit) || Integer.parseInt(rowInit)>9 || Integer.parseInt(rowInit)<1){
            System.out.println("invalid number. Enter a number between 1 and 8 for the row of the piece you want to move or 9 to quit");
            rowInit = scanner.next();
          }
          row1 =Integer.parseInt(rowInit);
          if(row1==9) break;
          row1= row1-1; //converting it to an array index
          System.out.println("Enter a number between 1 and 8 for the col of the piece you want to move");
          colInit=scanner.next();
          while(!d.isNumeric(colInit) || Integer.parseInt(colInit)>8 || Integer.parseInt(colInit)<1){
            System.out.println("invalid number. Enter a number between 1 and 8 for the col of the piece you want to move");
            colInit = scanner.next();
          }
          col1=Integer.parseInt(colInit);
          col1= col1-1; //converting it into an array index
          System.out.println("Enter a number between 1 and 8 for the row number of where you want the piece to move");
          rowFinal=scanner.next();
          while(!d.isNumeric(rowFinal) || Integer.parseInt(rowFinal)>8 || Integer.parseInt(rowFinal)<1){
            System.out.println("invalid number. Enter a number between 1 and 8 for the row of where you want the piece to move");
            rowFinal = scanner.next();
          }
          row2=Integer.parseInt(rowFinal);
          row2= row2-1; //converting it into an array index
          System.out.println("Enter a number between 1 and 8 for the col number of where you want the piece to move");
          colFinal=scanner.next();
          while(!d.isNumeric(colFinal) || Integer.parseInt(colFinal)>8 || Integer.parseInt(rowFinal)<1){
            System.out.println("invalid number. Enter a number between 1 and 8 for the col number of where you want the piece to move");
            colFinal = scanner.next();
          }
          col2=Integer.parseInt(colInit);
          col2= col2-1; //converting it into an array index
        }//end while
        
        //player chooses to quit
        if(row1==9){
          d.gameOver(2);
          System.out.println("Do you want to play again. Press n for no, or any other character for yes");
          if(scanner.next().equals("n")){
            playAgain = false;
            printTerminationMessage();
          }
          else{
            reset();
          }
        }
        else{
        Piece piece = d.getBoard()[row2][col2];
        
        //check if a king was captured for end of the game
        //if its not a king continue
        if(! (piece instanceof King)){
          d.summarizeMove(row1, col1, row2, col2);
          if(!(d.getBoard()[row1][col1] instanceof Pawn)|| !(((Pawn)d.getBoard()[row1][col1]).checkForPromotion(d.getBoard(), row1, col1, row2, col2)))
          {
            d.getBoard()[row2][col2]=d.getBoard()[row1][col1];
            d.getBoard()[row1][col1]=null;
            
          }
          d.copyToExtraBoard();
          d.displayBoard();
          ai.makeMove(d, row1, col1, row2, col2);
          
        }
        //if a king was captured
        else{
          if(piece.getTeam()){
            d.gameOver(1);
          }
          else{
            d.gameOver(0);
          }
          System.out.println("Do you want to play again. Press n for no, or any other character for yes");
          if(scanner.next().equals("n")){
            playAgain = false;
            printTerminationMessage();
          }
          else {
            reset();
          }
        }  
      }
      }
    }
    //scanner.close();
  }
  
  //------------------------------------------------------
  // reset
  //
  // PURPOSE:   reset a new game. reinitialize the board
  // PARAMETERS: none
  // Returns: none
  //-----------------------------------------------------
  public void reset(){
    d.initializeBoard();
    int level = d.promptForOpponentDifficulty(2);
    if(level==1){
      ai = new AILevel1();
    }
    else if(level==2){
      ai = new AILevel2();
    }
  }
  
    //------------------------------------------------------
  // printTerminationMessage
  //
  // PURPOSE: to print a messaging saying we've reached the end
  // PARAMETERS: none
  // Returns: none
  //-----------------------------------------------------
  public void printTerminationMessage(){
    System.out.println("thanks for playing");
    System.out.println("end of processing");
  }
}