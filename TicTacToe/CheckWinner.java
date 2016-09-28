package TicTacToe;

import javax.swing.*;

//this class contains the check if the game is over
public class CheckWinner
{
  private boolean isGameFinished;
  private JButton resultB[];

  public CheckWinner(boolean getIsGameFinished, JButton getB[])
  {
      resultB = getB;
      isGameFinished = getIsGameFinished;
  }

  public boolean checkIfWin()
  {
      checkWin(0,4,8);
      checkWin(2,4,6);
      checkWin(0,1,2);
      checkWin(3,4,5);
      checkWin(6,7,8);
      checkWin(0,3,6);
      checkWin(1,4,7);
      checkWin(2,5,8);

      return isGameFinished;
  }

  public void checkWin(int x, int y, int z)
  {
      // checking if X wins
      if (resultB[x].getText().equals("X")
              && resultB[y].getText().equals("X")
              && resultB[z].getText().equals("X"))
      {
          declareResult("X");
      }
      else if (resultB[x].getText().equals("O")
              && resultB[y].getText().equals("O")
              && resultB[z].getText().equals("O"))
      {
          declareResult("O");
      }
  }

  public void declareResult(String i)
  {
      if (!isGameFinished)
      {
          JOptionPane.showMessageDialog(null, i + " wins!");
          for (int j = 1; j < GUI.SPOTS; j++)
          {
              resultB[j].setEnabled(false);
          }
          isGameFinished = true;
      }
  }

  // when game is draw
  public void isDraw()
  {
      JOptionPane.showMessageDialog(null, "Draw!");
      isGameFinished = true;
  }
}

