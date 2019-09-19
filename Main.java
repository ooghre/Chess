     //-----------------------------------------
     // NAME  : Ovietobore Oghre
     // STUDENT NUMBER : 7793149
     // COURSE  : COMP 2150
     // INSTRUCTOR : Heather Mattherson
     // ASSIGNMENT : assignment 3
     // QUESTION : question 1      
     // 
     // REMARKS: To run an instance of a chess program
     //8
     //
     //-----------------------------------------
  public class Main{
  public static void main( String[]args){
    ChessDisplay dis = new ChessDisplay();
    ChessLogic logic = new ChessLogic(dis);
    logic.play();
  }
}