     // CLASS: King class
     //
     // Author: Ovietobore Oghre 7793149
     //
     // REMARKS: Hold data members and methods for King piece
     //
     //-----------------------------------------
public class King extends Piece{
  public King (boolean b){
    setTeam(b);
    if(b){
      setSymbol("K");
    }
    else{
      setSymbol("k");
    }
  }
  
     //------------------------------------------------------
     // isValid
     //
     // PURPOSE:    checks if a proposed move is valid for a King
     // PARAMETERS:
     // 1) 4 integers rowInit, colInit, rowFinal and colFinal representing the begisnning position of the piece
     //     and the end position of the piece
     // 2) a 2 dimensional array of pieces
     // Returns: returns true if the proposed move is legal or false if it is illegal
     //-----------------------------------------------------
  boolean isValid(Piece [][] board, int rowInit, int colInit, int rowFinal, int colFinal ){
    boolean result = false;
    if( Math.abs(colFinal-colInit)<=1 && Math.abs(rowFinal-rowInit)<=1 && //check if the king moved 1 space in any direction
       (board[rowFinal][colFinal]==null || board[rowFinal][colFinal].getTeam()!=this.getTeam()) ){// check if the king moved to an empty square or one occupied by an opponent
      result = true;
    }
    return result;
  }
}