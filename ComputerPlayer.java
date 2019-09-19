// CLASS: ComputerPlayer
//
// Author: Ovietobore Oghre 7793149
//
// REMARKS: performs the operations of a computer player
//
//-----------------------------------------
public class ComputerPlayer{
  
  //constructor
  public ComputerPlayer() { 
    
  } 
  
  
  //------------------------------------------------------
  // isValidAi
  //
  // PURPOSE: to internally ensure that the AIs move is valid
  // PARAMETERS:
  // 1) 4 integers rowInit, colInit, rowFinal and colFinal representing the begisnning position of the piece
  //     and the end position of the piece
  // 2) a 2 dimensional array of pieces
  // Returns: returns true if the proposed move is legal or false if it is illegal
  //-----------------------------------------------------
  boolean isValidAI(Piece [][] board, int rowInit, int colInit, int rowFinal, int colFinal ){
    boolean result=false;
    if((rowInit != rowFinal || colInit!=colFinal) && board[rowInit][colInit] != null &&
       board[rowInit][colInit].getTeam()==false){ //a piece cannot stay on the ssame place
      //initial square must contain a computers piece
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
  
  
}
