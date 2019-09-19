// class AILevel1
//
// Author: Ovietobore Oghre 7793149
//
// REMARKS: performs the operations of a computer player
//
//-----------------------------------------
import java.util.Random;
public class AILevel2 extends ComputerPlayer implements ChessPlayer{
  
  public AILevel2(){
  
  }
  
  //------------------------------------------------------
  // makeMove
  //
  // PURPOSE: to play a move for the AI on hard level
  // PARAMETERS:
  // 1) 4 integers rowInit, colInit, rowFinal and colFinal representing the begisnning position of the piece
  //     and the end position of the piece
  // 2) a 2 dimensional array of pieces
  // Returns: none
  //------------------------------------------------------
  public void makeMove(ChessDisplay d, int rowInit, int colInit, int rowFinal, int colFinal){
    Random rand = new Random();
    int rand1 =rand.nextInt(8);
    int rand2 = rand.nextInt(8);
    int count =0;
    
    boolean checkMove = false; //to check if we already made a move
    //loop 10000 times 
    while( count<10000){
      checkMove = false;
      //if the previous move attacks any piece after 100000 iteratons
      if(super.isValidAI(d.getBoard(), rowFinal, colFinal, rand1, rand2) && d.getBoard()[rand1][rand2]!=null && !d.getBoard()[rand1][rand2].getTeam()){
        //if that piece can capture previous piece, capture
        if(super.isValidAI(d.getBoard(), rand1, rand2, rowFinal, colFinal)){
              d.summarizeMove(rand1, rand2, rowFinal, colFinal);
              if(!(d.getBoard()[rand1][rand2] instanceof Pawn)|| !(((Pawn)d.getBoard()[rand1][rand2]).checkForPromotion(d.getBoard(), rand1, rand2, rowFinal, colFinal)))
              {
                d.getBoard()[rowFinal][colFinal]=d.getBoard()[rand1][rand2];
                d.getBoard()[rand1][rand2]=null;
              }
              d.copyToExtraBoard();
              d.displayBoard();
              checkMove = true;
              break; 
        }

      }
      rand1 = rand.nextInt(8);
      rand2 = rand.nextInt(8);
      count++;
    }
    int rand3 = rand.nextInt(8);
    int rand4 = rand.nextInt(8);   
    if(!checkMove){
      while( !super.isValidAI(d.getBoard(), rand1, rand2, rand3, rand4)){
        rand1 =rand.nextInt(8);
        rand2 = rand.nextInt(8);
        rand3 = rand.nextInt(8);
        rand4 = rand.nextInt(8);
      }
    }
    if(!checkMove){
      d.summarizeMove(rand1, rand2, rand3, rand4);
      if(!(d.getBoard()[rand1][rand2] instanceof Pawn)|| !(((Pawn)d.getBoard()[rand1][rand2]).checkForPromotion(d.getBoard(), rand1, rand2, rand3, rand4)))
      {
        d.getBoard()[rand3][rand4]=d.getBoard()[rand1][rand2];
        d.getBoard()[rand1][rand2]=null;
        
      }
      d.copyToExtraBoard();
      d.displayBoard();
    } 
  }
    
}
