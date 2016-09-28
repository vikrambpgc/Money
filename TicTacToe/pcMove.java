package TicTacToe;

import java.util.Random;

public class pcMove {
   
    // the AI behavior is merely a random selection of a cell/box to mark
    public int movePC() {
        Random gen = new Random();
        int a = gen.nextInt(GUI.SPOTS);
      
        return a;
    }
/*
	//First check to see if there is a winning computer movePC
		for(int i = 0; i < GUI.SPOTS; i++) {
		// if the space is taken i++
			if(GUI.gameButtons[i] == ""){
			
				// make a  new check array 
				new checkArray[] = GUI.gameButtons[];
				checkArray[i] = 'O'; 
				
				if(checkIfWin(checkArray)){
				   return i;   // return our winning index 
				}
				
			}
		
		
		}
*/		
		
	//Next check if there is a move that blocks the player from winning
	
	//Finally choose the OPEN spot with the most OPEN adjacent spots
	
	


}