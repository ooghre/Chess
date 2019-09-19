     // CLASS: Knight class
     //
     // Author: Ovietobore Oghre 7793149
     //
     // REMARKS: Hold data members and methods for Knight piece
     //
     //-----------------------------------------
public class Knight extends Piece{
  //constructor
  public Knight(boolean b){
    setTeam(b);
    if(b){
      setSymbol("N");
    }
    else{
      setSymbol("n");
    }
  }
  
     //------------------------------------------------------
     // isValid
     //
     // PURPOSE:    checks if a proposed move is valid for a Knight
     // PARAMETERS:
     // 1) 4 integers rowInit, colInit, rowFinal and colFinal representing the begisnning position of the piece
     //     and the end position of the piece
     // 2) a 2 dimensional array of pieces
     // Returns: returns true if the proposed move is legal or false if it is illegal
     //-----------------------------------------------------
  public boolean isValid(Piece [][] board, int rowInit, int colInit, int rowFinal, int colFinal ){
    boolean result = false;
    if((board[rowFinal][colFinal]==null || board[rowFinal][colFinal].getTeam()!=this.getTeam())){ // check if the knight moved to an empty square or one occupied by an opponent
      if((Math.abs(rowFinal-rowInit)==2 && Math.abs(colFinal-colInit)==1) || 
         (Math.abs(rowFinal-rowInit)==1 && Math.abs(colFinal-colInit)==2)){
        result=true;
      }
    }
    return result;
  }
}