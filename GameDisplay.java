     // CLASS: GameDisplay interface
     //
     // Author: Ovietobore Oghre 7793149
     //
     // REMARKS: An interface specifying all the methods an implementation of a display will have
     //
     //-----------------------------------------
public interface GameDisplay {
  public int promptForOpponentDifficulty(int maxDifficulty);
  public void displayBoard();
  public void summarizeMove(int x1, int y1, int x2, int y2);
  public void gameOver(int winner);
} 