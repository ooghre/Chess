     // CLASS: Rook class
     //
     // Author: Ovietobore Oghre 7793149
     //
     // REMARKS: Hold data members and methods for Rook piece
     //
     //-----------------------------------------
public class Rook extends Piece{
  public Rook(boolean b){
      setTeam(b);
      if(b){
        setSymbol("R");
      }
      else{
        setSymbol("r");
      }
  }
  
     //------------------------------------------------------
     // isValid
     //
     // PURPOSE:    checks if a proposed move is valid for a Rook
     // PARAMETERS:
     // 1) 4 integers rowInit, colInit, rowFinal and colFinal representing the begisnning position of the piece
     //     and the end position of the piece
     // 2) a 2 dimensional array of pieces
     // Returns: returns true if the proposed move is legal or false if it is illegal
     //-----------------------------------------------------
  public boolean isValid(Piece [][] board, int rowInit, int colInit, int rowFinal, int colFinal ){
    boolean result =false;  
    if(board[rowFinal][colFinal]==null || board[rowFinal][colFinal].getTeam()!=this.getTeam()){ // check if the Rook moved to an empty square or one occupied by an opponent
      if(rowFinal!= rowInit && colInit == colFinal){ //moving along row
        result = true;
        for(int i=Math.min(rowFinal, rowInit) +1; i<Math.max(rowFinal, rowInit); i++){
          if(board[i][colFinal]!=null){ //if any square between row final and row initial has something in it set boolean to false
            result = false;
            break;
          }
        }
      }
      else if(rowFinal== rowInit && colInit != colFinal){ //moving along col
        result = true;
        for(int i=Math.min(colFinal, colInit)+1; i<Math.max(colFinal, colInit); i++){
          if(board[rowFinal][i]!=null){ //if any square between col final and col initial has something in it set boolean to false
            result = false;
            break;
          }
        }
      }
      
    }
    return result;
  }
}