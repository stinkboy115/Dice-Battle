import java.util.*;

class Calculate {
	
	public static int PlayerScore (int dice1, int dice2, int round) {
		
    	int playerScore = 0;
		
    	if (round < 10) {
    		
	    	if (dice1 == dice2) {
	
	    		playerScore = (dice1 + dice2) * 2;	
	    	}
	    	
	    	else {
	
	    		playerScore = (dice1 + dice2);
	    	}
    	}
    	
    	else if (round >= 10) {
    		
    		if (dice1 == dice2) {
    			
	    		playerScore = (dice1 + dice2) * 2 + round;	
	    	}
    		
	    	else {
	
	    		playerScore = dice1 + dice2 + round;
	    	}
    	}
		
    	 return playerScore;
    }
	
     public static int ComputerScore (int dice3, int dice4, int round) {
		
    	int computerScore = 0;
		
    	if (round < 10) {
    		
    		if (dice3 == dice4) {
	
	    		computerScore = (dice3 + dice4) * 2;	
	    	}
    		
	    	else {
	
	    		computerScore = (dice3 + dice4);
	    	}
    	}
    	
    	else if (round >= 10) {
    		
    		if (dice3 == dice4) {
	
	    		computerScore = (dice3 + dice4) * 2 + round;	
	    	}
    		
	    	else {
	
	    		computerScore = dice3 + dice4 + round;
	    	}
    	}
		
    	 return computerScore;
    }
 
     
	public static int userHPChange (int playerScore, int computerScore, int playerHP, int computerHP) {
		
		int userFinalChange = 0;

		if (playerScore > computerScore || playerScore == computerScore) {
			
			userFinalChange = playerHP;
		}
		
		else if (playerScore < computerScore) {
			
			userFinalChange = playerHP - computerScore; 
		}
		
		return userFinalChange;
		 
	}
	
	public static int computerHPChange (int playerScore, int computerScore, int playerHP, int computerHP) {
		
		int computerFinalChange = 0;

		if (playerScore < computerScore || playerScore == computerScore) {
			
			computerFinalChange = computerHP;
		}
		
		else if (playerScore > computerScore) {
			
			computerFinalChange = computerHP - playerScore; 
		}
		
		return computerFinalChange;
		 
	}


}
	    

public class DiceBattle {
	
	public static void main (String[] args) {

		Scanner scan = new Scanner (System.in);
		Random numbers = new Random ();
		Calculate c = new Calculate();
		
		int defaultPlayerHP = 150;
		int easyCPU = 150;
		int normalCPU = 200;
		int hardCPU = 300;
		int customPlayer = 0;
		int customCPU = 0;
        int com = 0;
		int dice1 = numbers.nextInt(6) + 1;
		int dice2 = numbers.nextInt(6) + 1;
		int dice3 = numbers.nextInt(6) + 1;
		int dice4 = numbers.nextInt(6) + 1;
		
		System.out.print ("DICE BATTLE");
		System.out.print ("\nThis game is about User and CPU are given two dice and both of you rolled the dice randomly which is really fair for both of you. ");
		System.out.print ("\n\n- If User's score < CPU's score ==> User's HP decrease as the CPU's score. Same in vice versa.");
		System.out.print ("\n- If User's score = CPU's score ==> Draw (No one takes damage).");
		System.out.print ("\n- If User OR CPU roll doubles ==> Attack power is doubled.");

        System.out.print ("\n\nSelecting Custom: You get to decide how much HP you and CPU recieve");
		System.out.print ("\nEach level increase the AI's HP from 150, 200, to 300. ");
		System.out.print ("\n\nChoose a level (Easy, Normal, Hard, Custom): ");
		
			String option = scan.nextLine();

			
        while ( !(option.equalsIgnoreCase("Easy")) && !(option.equalsIgnoreCase("Normal")) && !(option.equalsIgnoreCase("Hard")) && !(option.equalsIgnoreCase("Custom"))) {
        	
        	System.out.print("Invalid Input. Please try to input the right command again: ");
        		option = scan.nextLine();
        }

        
	    if (option.equalsIgnoreCase("Easy")) {
			
           System.out.print("\nUser recieves " + defaultPlayerHP + "HP and CPU recieves " + easyCPU + "HP. ");
           		com = easyCPU;	
		}
		
	    else if (option.equalsIgnoreCase("Normal")) {

			System.out.print("\nUser recieves " + defaultPlayerHP + " HP and CPU recieves " + normalCPU + " HP. ");
				com = normalCPU;
	    }
		
		else if (option.equalsIgnoreCase("Hard")) {

			System.out.print ("\nUser recieves " + defaultPlayerHP + "HP and CPU recieves " + hardCPU + " HP. ");
            	com = hardCPU;
		}
	    

		else if (option.equalsIgnoreCase("Custom")) {
            
			System.out.print("\nEnter User's HP: ");
            	customPlayer = scan.nextInt();
            	defaultPlayerHP = customPlayer;
            	
            System.out.print ("\nEnter CPU'S HP: ");
				customCPU = scan.nextInt();
				com = customCPU;
		} 
	
	    
	    System.out.print ("\n*Note: After 10 rounds since no one win yet, the score will add up depend on the number of round.");
	    System.out.print ("\n");
	    // VAN NGUYEN, 11/18/2021

	    // MICHAEL BUTLER, 11/12/2021
	    int round = 0;
	    int count = 0;
	    int playerScore;
	    int computerScore;
	    String userInput;

	    do {

			round++;
			count++;
	
			System.out.print("\n_ Round " + round + ": ");
			System.out.print("Do you want to roll, heal, or quit? ");
	        	userInput = scan.next(); 
	        
	        // VAN NGUYEN, 11/16/2021 
	        while (!(userInput.equalsIgnoreCase("roll")) && !(userInput.equalsIgnoreCase("heal")) && !(userInput.equalsIgnoreCase("quit"))) {
	        	
	        	System.out.println ("==> System couldn't recognize the command you input. Please try again.");
	        	System.out.print ("\n_ Round " + round + ": ");
				System.out.print ("Do you want to roll, heal, or quit? ");
		        	userInput = scan.next(); 
	        }
	        
	        while (userInput.equalsIgnoreCase ("Heal") && defaultPlayerHP > 50) {
				
				System.out.println ("==> Since your HP is still higher than 50 HP. \n==> The heal tool is not available right now. ");
				System.out.print ("\n_ Round " + round + ": ");
				System.out.print ("Do you want to roll, heal, or quit? ");
		        	userInput = scan.next(); 
			}
	        // VAN NGUYEN, 11/16/2021 
	        
			// MICHAEL BUTLER, 11/12/2021
			if (userInput.equalsIgnoreCase ("Roll")) {
	
				dice1 = numbers.nextInt(6) + 1;
				dice2 = numbers.nextInt(6) + 1;
			    dice3 = numbers.nextInt(6) + 1;
				dice4 = numbers.nextInt(6) + 1;
	
				playerScore = c.PlayerScore (dice1, dice2, round);
				computerScore = c.ComputerScore (dice3, dice4, round);
	
				System.out.print ("\n+ User roll " + dice1 + " and " + dice2);
				System.out.print ("\n--> User Score: " + playerScore );
	
				System.out.print ("\n\n+ Computer roll " + dice3 + " and " + dice4);
				System.out.print ("\n--> Computer Score: " + computerScore );
				
				defaultPlayerHP = c.userHPChange(playerScore, computerScore, defaultPlayerHP, com);
				com = c.computerHPChange(playerScore, computerScore, defaultPlayerHP, com);
				// MICHAEL BUTLER, 11/12/2021

		        // VAN NGUYEN, 11/16/2021 
				if (defaultPlayerHP <= 0) {
					
					defaultPlayerHP = 0;
				}
				
				else if (com <= 0) {
					
					com = 0;
				}
				
				System.out.print ("\n\n*** Calculate both HP from User and CPU... ***\n");
				System.out.print ("==> User HP currently is " + defaultPlayerHP + " and CPU HP currently is " + com);
				
				System.out.println();
			}
			
			else if (userInput.equalsIgnoreCase ("Heal") && defaultPlayerHP <= 50) {
				
				if (option.equalsIgnoreCase("Easy")) {
					
					defaultPlayerHP += 0;
					System.out.println ("+ You are unable to use heal item for this Easy level. \n==> User HP currently is " + defaultPlayerHP);

				}
						
				else if (option.equalsIgnoreCase("Normal")) {
					
					defaultPlayerHP += 50;
					System.out.println ("+ Your HP is heal up to 50HP for this Normal level \n==> User HP currently is " + defaultPlayerHP);

				}
				
				else if (option.equalsIgnoreCase("Hard")) {
					
					defaultPlayerHP += 75;
					System.out.println ("+ Your HP is heal up to 75HP for this Hard level \n==> User HP currently is " + defaultPlayerHP);

				}
				else if (option.equalsIgnoreCase("Custom")) {
					defaultPlayerHP += 100;
					System.out.println ("+ Your HP is heal up to 100HP for this Custom level \n==> User HP currently is " + defaultPlayerHP);	
				}
			}
			
			else if (userInput.equalsIgnoreCase ("Quit")) {
				
				break;
			}
			
			
	    } while (defaultPlayerHP > 0 && com > 0);
	    
	    if (defaultPlayerHP > com) {
	    	
	    	System.out.print ("\nCongrats USER, you finally beat CPU (" + option + " level) after " + count + " rounds. \nThank you for playing this DICE BATTLE game.");
	    }
	    
	    else if (com > defaultPlayerHP) {
	    	
	    	System.out.print ("\nSorry, you was beaten by CPU (" + option + " level) after " + count + " rounds. You can do it next time.");
	    }
	    
	    // VAN NGUYEN, 12/01/2021 

    



	}
}








	

