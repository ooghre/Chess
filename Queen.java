     // CLASS: Queen class
     //
     // Author: Ovietobore Oghre 7793149
     //
     // REMARKS: Hold data members and methods for Queen piece
     //
     //-----------------------------------------
public class Queen extends Piece {
  public Queen (boolean b){
      setTeam(b);
      if(b){
        setSymbol("Q");
      }
      else{
        setSymbol("q");
      }
  }
  
      //------------------------------------------------------
     // isValid
     //
     // PURPOSE:    checks if a proposed move is valid for a Queen
     // PARAMETERS:
     // 1) 4 integers rowInit, colInit, rowFinal and colFinal representing the begisnning position of the piece
     //     and the end position of the piece
     // 2) a 2 dimensional array of pieces
     // Returns: returns true if the proposed move is legal or false if it is illegal
     //-----------------------------------------------------
  public boolean isValid(Piece [][] board, int rowInit, int colInit, int rowFinal, int colFinal ){
    int j=0;
    boolean result = false;
    //ROOK CODE
    if(board[rowFinal][colFinal]==null || board[rowFinal][colFinal].getTeam()!=this.getTeam()){
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
      
      //BISHOP CODE
      //System.out.println("in here0");
      else if(Math.abs(rowInit-rowFinal) == Math.abs(colInit-colFinal)){
        if(rowFinal-rowInit == colFinal - colInit){
          j= Math.min(colInit, colFinal)+1;
          result = true;
          for(int i=Math.min(rowInit, rowFinal) +1 ; i<Math.max(rowInit, rowFinal);i++){
            if(board[i][j]!=null){
              result = false;
              break;
            }
            j++;
          }
        }
        else if(rowFinal-rowInit == -1 * (colFinal - colInit)){
          j= Math.max(colInit, colFinal)-1;
          result = true;
          for(int i=Math.min(rowInit, rowFinal) +1 ; i<Math.max(rowInit, rowFinal);i++){
            if(board[i][j]!=null){
              result = false;
              break;
            }
            j--;
          }
        }
      }
      
    }
    return result;
  }
}