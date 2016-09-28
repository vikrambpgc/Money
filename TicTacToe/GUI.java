package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class GUI
{

	//Create final variable for number of spots on board
    public static final int SPOTS = 9;
    
	//Create Main Frame container
    private JFrame mainFrame;
    
	//3 Panels, for game panel, reset button, and message panel
    private JPanel gamePanel, resetPanel, messagePanel;
    
	//Buttons for resetting the game and an array of buttons for the game board
    private JButton resetButton, gameButtons[];
    
	//Create a label for displaying in game messages
    private JLabel messageLabel;
    
	//Number of legal moves yet to be made
    private int movesLeft;
    
	// X is human player. Determine if it is player's turn.
    private boolean isXTurn;
    
	//O will be the computer. Determine if computer's turn
    private boolean isOTurn;
    
	//Boolean to determine if game is finished
    private boolean isFinished;
	
    //Define what happens when the player performing an action
    private playerMove action;

    // Constructor to prepare the main frame
    public GUI()
    {
        prepareGUI();
        putStuffIn();
        movesLeft = SPOTS;
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    private void prepareGUI()
    {

        //Sets name of Main frame
        mainFrame = new JFrame("Tic Tac Toe");

        //Sets size of main frame
        mainFrame.setSize(350, 350);


        //Define panels
        gamePanel = new JPanel();
        resetPanel = new JPanel();
        messagePanel = new JPanel();


        //Define the reset button
        resetButton = new JButton("Reset");

        //Define array buttons
        gameButtons = new JButton[SPOTS];
        for (int i = 0; i < SPOTS; i++)
        {

            //Blank buttons to start game
            gameButtons[i] = new JButton("");
        }

        //Define label
        messageLabel = new JLabel("");


    }

	//Create method to populate the empty frame
    public void putStuffIn()
    {

       
        action = new playerMove(this);

		//Create panel layout.
        mainFrame.setLayout(new BorderLayout());
        
		//Game goes in center
		mainFrame.add(gamePanel, BorderLayout.CENTER);
        
		//Reset button goes on bottom
		mainFrame.add(resetPanel, BorderLayout.SOUTH);
		
		//Message panel goes on top
        mainFrame.add(messagePanel, BorderLayout.NORTH);

        // Define 3 row, 3 column layout for gamePanel
        gamePanel.setLayout(new GridLayout(3, 3, 5, 5));
       
	   for (int i = 0; i < SPOTS; i++)
        {
            gamePanel.add(gameButtons[i]);
            // adding action to the buttons
            gameButtons[i].addActionListener(action);
            // **** buttons are disabled first, will need to select game mode****
            gameButtons[i].setEnabled(true);
        }

        // Define panel containing reset button
        resetPanel.setLayout(new FlowLayout());
        resetPanel.add(resetButton);

        //Define panel containing messagePanel
        messagePanel.setLayout(new FlowLayout());
        messageLabel.setText("X Turn");
        messagePanel.add(messageLabel);


        // Add action listener to reset button
        resetButton.addActionListener(action);


    }

     //Create helper methods
	
	public void setMessageText(String text)
    {
        messageLabel.setText(text);
    }

    public JButton getButton(int i)
    {
        return gameButtons[i];
    }

    public JButton[] getButtonA()
    {
        return gameButtons;
    }

    public boolean getXTurn()
    {
        return isXTurn;
    }

    public void setXTurn(boolean bool)
    {
        isXTurn = bool;
    }

    public boolean getComplete()
    {
        return isFinished;
    }

    public void setComplete(boolean bool)
    {
        isFinished = bool;
    }

    public int getMovesLeft()
    {
        return movesLeft;
    }

    public void setMovesLeft(int moves)
    {
        movesLeft = moves;
    }

    public void reduceMovesLeft()
    {
        movesLeft--;
    }

    public boolean getOTurn()
    {
        return isOTurn;
    }

    public void setOTurn(boolean bool)
    {
        isOTurn = bool;
    }
}
