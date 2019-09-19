     // CLASS: ChessPlayer interface
     //
     // Author: Ovietobore Oghre 7793149
     //
     // REMARKS: An interface specifying all the methods an implementation of a ChessPlayer will have
     //
     //-----------------------------------------
public interface ChessPlayer {
  public void makeMove(ChessDisplay d, int rowInit, int colInit, int rowFinal, int colFinal);
}