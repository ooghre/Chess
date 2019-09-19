     // CLASS: ChessController interface
     //
     // Author: Ovietobore Oghre 7793149
     //
     // REMARKS: An interface specifying all the methods an implementation of a chessController will have
     //
     //-----------------------------------------
public interface ChessController {
  public boolean movePiece( Piece [][] board, int rowInit, int colInit, int rowFinal, int colFinal);
  public void reset();
} 