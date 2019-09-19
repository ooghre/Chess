     // CLASS: Bishop class
     //
     // Author: Ovietobore Oghre 7793149
     //
     // REMARKS: Hold data members and methods for bishop piece
     //
     //-----------------------------------------
public class Bishop extends Piece {
  
  //constructor
  public Bishop (boolean b){
    setTeam(b);
    if(b){
      setSymbol("B");// players piece 
    }
    else{
      setSymbol("b"); //computers piece
    }
  }
  
     //------------------------------------------------------
     // isValid
     //
     // PURPOSE:    checks if a proposed move is valid for a bishop
     // PARAMETERS:
     // 1) 4 integers rowInit, colInit, rowFinal and colFinal representing the begisnning position of the piece
     //     and the end position of the piece
     // 2) a 2 dimensional array of pieces
     // Returns: returns true if the proposed move is legal or false if it is illegal
     //-----------------------------------------------------
  public boolean isValid(Piece [][] board, int rowInit, int colInit, int rowFinal, int colFinal ){
    int j=0;
    boolean result = false;
    if(board[rowFinal][colFinal]==null || board[rowFinal][colFinal].getTeam()!=this.getTeam()){ //the final position is empty or the final position contains an opponets piece
      if(Math.abs(rowInit-rowFinal) == Math.abs(colInit-colFinal)){ 
        if(rowFinal-rowInit == colFinal - colInit){
          j= Math.min(colInit, colFinal)+1;
          result = true;
          for(int i=Math.min(rowInit, rowFinal) +1 ; i<Math.max(rowInit, rowFinal);i++){
            if(board[i][j]!=null){
              result = false;
              break;
            }//if
            j++;
          }//for
        }//if
        else if(rowFinal-rowInit == -1 * (colFinal - colInit)){
          j= Math.max(colInit, colFinal)-1;
          result = true;
          for(int i=Math.min(rowInit, rowFinal) +1 ; i<Math.max(rowInit, rowFinal);i++){//correct later
            if(board[i][j]!=null){
              result = false;
              break;
            }//if
            j--;
          }//for
        }//else if
      }//if
    }//if
    return result;
  }//end isValid
}