package TicTacToe;

import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class playerMove implements ActionListener
{
    private GUI gameGUI;

    public playerMove(GUI getGUI)
    {

        gameGUI = getGUI;
    }

    public void actionPerformed(ActionEvent event)
    {
        gameGUI.setMessageText("X Turn");
        CheckWinner result = new CheckWinner(gameGUI.getComplete(), gameGUI.getButtonA());
        pcMove pcMove = new pcMove();

        if (event.getActionCommand() == "Reset")
        {
            for (int i = 0; i < GUI.SPOTS; i++)
            {
                gameGUI.getButton(i).setText("");
                gameGUI.getButton(i).setEnabled(true);
            }

            gameGUI.setComplete(false);
            gameGUI.setMovesLeft(GUI.SPOTS);

            return;
        }


        //Human player move     
        for (int i = 0; i < GUI.SPOTS; i++)
        { // player's move
            if (event.getSource().equals(gameGUI.getButton(i)))
            {
                gameGUI.getButton(i).setText("X");
                gameGUI.getButton(i).setEnabled(false);
                gameGUI.setXTurn(false);
                gameGUI.reduceMovesLeft();
            }
        }

        //Check to see if game is over
        gameGUI.setComplete(result.checkIfWin());
        if (gameGUI.getComplete()) //no need to go on
            return;

        // AI response
        if (gameGUI.getMovesLeft() != 0 && !gameGUI.getComplete())
        {
            int move;
            gameGUI.setMessageText("O Turn");
            //continue to look for unused buttons
            move = pcMove.movePC();
            while (!gameGUI.getButton(move).getText().equals(""))
            {
                if (gameGUI.getMovesLeft() == 0)
                {
                    result.isDraw();
                    return;
                }
                move = pcMove.movePC();
            }

            //at this point we have found a button that has not been
            //marked
            gameGUI.getButton(move).setText("O");
            gameGUI.getButton(move).setEnabled(false);
            gameGUI.reduceMovesLeft();

            //Check to see if game is over
            gameGUI.setComplete(result.checkIfWin());

        }
        
        gameGUI.setMessageText("X Turn");
        if (gameGUI.getMovesLeft() == 0 && !gameGUI.getComplete())
        { // conditions
            // for draw
            result.isDraw();
        }
    }
}
