import java.util.Scanner;

public class PlayerRoster {
  //global variables;
  final int NUM_PLAYERS = 5;
  int [] jerseyNumbers = new int[NUM_PLAYERS];
  int [] playerRatings = new int[NUM_PLAYERS];
  int jerseyNumber = -100;
  int playerRating = -100;
  String userInput = "";
  int i = 0;
  boolean userActive = true;

  Scanner scnr = new Scanner(System.in);

  public static void main(String[] args) {
    PlayerRoster Roster = new PlayerRoster();
    System.out.println("\f");
    
    Roster.getRosterInput();
    
    while(Roster.userActive) {
      Roster.printMenu();
      Roster.getMenuResponse(); 
      Roster.handleMenuResponse();
    }
  }

  public void handleMenuResponse() {
    switch(userInput) {
      case "u": userInput = ""; 
		break;
     
      case "a": userInput = "";
        	break;

      case "r": userInput = "";
		//showRoster();
        	break;

      case "o": userInput = "";
        	showRoster();
		break;

      case "q": userInput = "";
		userActive = false;
        	break;
    }
  }


  public void printMenu() {
    System.out.println("\n\n**********");
    System.out.println("MENU");
    System.out.println("u - Update player rating");
    System.out.println("a - Output players above a rating");
    System.out.println("r - Replace player");
    System.out.println("o - Output roster");
    System.out.println("q - Quit\n");
    System.out.println("Choose an option:");

    }

  public void getMenuResponse() {
    //keep prompting while answer isn't valid:
    while(!userInput.equals("u") && !userInput.equals("a") && !userInput.equals("r") && !userInput.equals("o") && !userInput.equals("q") ) {
        userInput = scnr.next();
    } 
  }

   public void getRosterInput() {
     i = 0;
     while(i < NUM_PLAYERS) {
        
        jerseyNumbers[i] = getPlayerJerseyNumber(i);

	//save value to team collection;
        // TODO: Requirements did not specify jersey #'s need be unique, get user feedback. 
	//jerseyNumbers[i] = jerseyNumber; 

        //PlayerRating Input
        //System.out.println("Enter player "+(i+1)+"'s rating:");
        
	//keep prompting if number is out of range:
	//while (playerRating < 1 | playerRating > 9) {
	  // sanitize input:
	 // while(!scnr.hasNextInt()) {
	 //   System.out.println("Please enter a number between 1-9");
	 //   scnr.next();
	 // }
	 // playerRating = scnr.nextInt();
	//}
	
	playerRatings[i] = getPlayerRating(i);
	
	//save value to team collection: 
        //playerRatings[i] = playerRating;
	
	//end loop and regroup!
	i++;
	jerseyNumber = -100;
	playerRating = -100;
	System.out.println("");
      }
      return;
   }

   public int getPlayerJerseyNumber(int playerNumber) {
	playerNumber++;
        //PlayerJersey Input
        System.out.println("Enter player "+playerNumber+"'s jersey number:");

        // keep prompting if number is out of range:
        while(jerseyNumber < 0 | jerseyNumber > 99) {
          // sanitize input:
          while(!scnr.hasNextInt()) {
            System.out.println("Please enter a number between 0-99 ");
            scnr.next();
          }
            jerseyNumber = scnr.nextInt();
        }
     return jerseyNumber;
   }

   public int getPlayerRating(int playerRating) {
   
     //PlayerRating Input
     System.out.println("Enter player "+(i+1)+"'s rating:");

     //keep prompting if number is out of range:
     while (playerRating < 1 | playerRating > 9) {
       // sanitize input:
       while(!scnr.hasNextInt()) {
         System.out.println("Please enter a number between 1-9");
         scnr.next();
       }
       playerRating = scnr.nextInt();
     }
     return playerRating;
   }


   public void showRoster() {
      //Do the Roster Output
      System.out.println("+-----------------------------------------+");
      for(i = 0; i < NUM_PLAYERS; i++) {
	System.out.println("| Player "+(i+1)+" -- Jersey number: "+jerseyNumbers[i]+", Rating: "+playerRatings[i]+ " |");
      }
      System.out.println("+-----------------------------------------+");

      return;
   }

}
