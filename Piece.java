     // CLASS: Piece class
     //
     // Author: Ovietobore Oghre 7793149
     //
     // REMARKS: Abstract parent class of all the chess pieces class
     //
     //-----------------------------------------
public abstract class Piece{
  private String symbol;
  private boolean team; //if team ==true it belongs to user else it belongs to computer
  
     //------------------------------------------------------
     // myMethod
     //
     // PURPOSE:    to get the symbol of the piece
     // PARAMETERS: none
     // Returns: the symbol
     //------------------------------------------------------
  public String getSymbol(){
    return symbol;
  }
  
  //------------------------------------------------------
     // myMethod
     //
     // PURPOSE:    to the team of the piece. if it is true, then ts a players piece else it is the computers piece
     // PARAMETERS: none
     // Returns: a true or false for the team
     //------------------------------------------------------
  public  boolean getTeam(){
    return team;
  }
  
  //------------------------------------------------------
     // setSymbol
     //
     // PURPOSE:  to set the symbol
     // PARAMETERS: the symbol
     // Returns: 
     //------------------------------------------------------
  public void setSymbol(String s){
    symbol =s;
  }
  
    //------------------------------------------------------
     // setTeam
     //
     // PURPOSE:  to set the team
     // PARAMETERS: the team
     // Returns: 
     //------------------------------------------------------
  public void setTeam(boolean b){
    team =b;
  }
}