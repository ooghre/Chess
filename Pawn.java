// CLASS: Pawn class
//
// Author: Ovietobore Oghre 7793149
//
// REMARKS: Hold data members and methods for Pawn piece
//
//-----------------------------------------
import java.util.Scanner;
public class Pawn extends Piece {
  //constructor
  public Pawn (boolean b){
    setTeam(b);
    if(b){
      setSymbol("P");
    }
    else{
      setSymbol("p");
    }
  }
  
  //------------------------------------------------------
  // isValid
  //
  // PURPOSE:    checks if a proposed move is valid for a Pawn
  // PARAMETERS:
  // 1) 4 integers rowInit, colInit, rowFinal and colFinal representing the begisnning position of the piece
  //     and the end position of the piece
  // 2) a 2 dimensional array of pieces
  // Returns: returns true if the proposed move is legal or false if it is illegal
  //-----------------------------------------------------
  boolean isValid(Piece [][] board, int rowInit, int colInit, int rowFinal, int colFinal ){
    boolean result = false;
    if(board[rowFinal][colFinal]==null){ //move to an empty square
      if( this.getTeam()==true && rowFinal==rowInit-1 && colFinal ==colInit ){
        result = true;
      }
      else if( this.getTeam()==false && rowFinal==rowInit+1 && colFinal ==colInit ){
        result = true;
      }
    }
    else if(board[rowFinal][colFinal].getTeam()!=this.getTeam()){
      if(this.getTeam() && rowFinal==rowInit-1 && (colFinal ==colInit-1 || colFinal ==colInit+1 )){
        result = true;
      }
      else if(this.getTeam() ==false && rowFinal==rowInit+1 && (colFinal ==colInit-1 || colFinal ==colInit+1 )){
        result = true;
      }
    }
    return result;
  }
  
  //------------------------------------------------------
  // checkForPromotion
  //
  // PURPOSE: checks if a pawn is to be promoted
  // PARAMETERS:
  // 1) 4 integers rowInit, colInit, rowFinal and colFinal representing the begisnning position of the piece
  //     and the end position of the piece
  // 2) a 2 dimensional array of pieces
  // Returns: returns true if the proposed move is legal or false if it is illegal
  //-----------------------------------------------------
  public boolean checkForPromotion(Piece [][] board, int rowInit, int colInit, int rowFinal, int colFinal ){
    boolean result = false;
    Scanner scanner = new Scanner(System.in);
    String promote = "";
    if(rowFinal ==0 && board[rowInit][colInit].getTeam()){ // pawn promotion for player
      result = true;
      System.out.print("pawn promotion: choose the piece you want to promote to.");
      System.out.println("Enter b for bishop, k for knight, r for rook and q for queen");
      promote = scanner.next();
      while(! (promote.equals("b") || promote.equals("q") || promote.equals("r") || promote.equals("k"))){
        System.out.println("invalid entry. Enter b for bishop, k for knight, r for rook and q for queen");
        promote = scanner.next();
      }
    }
    else if(rowFinal ==7 && !board[rowInit][colInit].getTeam()){ //computer pawn promotiom
      result = true;
      promote = "q"; //AI always promotes to queen
    }
    if(promote.equals("b")){
      //bishop
      board[rowInit][colInit]= null;
      board[rowFinal][colFinal]= new Bishop(true);
    }
    else if(promote.equals("q")){
      //queen
      if(board[rowInit][colInit].getTeam()){
        board[rowInit][colInit]= null;
        board[rowFinal][colFinal]= new Queen(true);
      }
      else{
        board[rowInit][colInit]= null;
        board[rowFinal][colFinal]= new Queen(false);
      }
      
    }
    else if(promote.equals("r")){
      //rook
      board[rowInit][colInit]= null;
      board[rowFinal][colFinal]= new Rook(true);
    }
    
    else if(promote.equals("k")){
      //knight
      board[rowInit][colInit]= null;
      board[rowFinal][colFinal]= new Knight(true);
    }
    //scanner.close();
    return result;
  }
}