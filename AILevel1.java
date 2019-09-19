// class AILevel1
//
// Author: Ovietobore Oghre 7793149
//
// REMARKS: performs the operations of a computer player
//
//-----------------------------------------
import java.util.Random;
public class AILevel1 extends ComputerPlayer implements ChessPlayer{
  
  public AILevel1(){
  
  }
  
  //------------------------------------------------------
  // makeMove
  //
  // PURPOSE: to play a move for the AI on easy
  // PARAMETERS: a ChessDisplay
  // Returns: none
  //------------------------------------------------------
  public void makeMove(ChessDisplay d, int rowInit, int colInit, int rowFinal, int colFinal){
    //if(level==1){      
    Random rand = new Random();
    int row1 = rand.nextInt(8);
    int col1 = rand.nextInt(8);
    int row2 = rand.nextInt(8);
    int col2 = rand.nextInt(8);
    
    while( !super.isValidAI(d.getBoard(), row1, col1, row2, col2)){ //loop until a valid move is made randomly
      row1 = rand.nextInt(8);
      col1 = rand.nextInt(8);
      row2 = rand.nextInt(8);
      col2 = rand.nextInt(8);
    }
    d.summarizeMove(row1, col1, row2, col2);
    if(!(d.getBoard()[row1][col1] instanceof Pawn)|| !(((Pawn)d.getBoard()[row1][col1]).checkForPromotion(d.getBoard(), row1, col1, row2, col2)))
    {
      d.getBoard()[row2][col2]=d.getBoard()[row1][col1];
      d.getBoard()[row1][col1]=null;
      
    }
    d.copyToExtraBoard();
    d.displayBoard();
  }
    
}
