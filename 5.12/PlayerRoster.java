import java.util.Scanner;

public class PlayerRoster {
  //global variables;
  final int NUM_PLAYERS = 5;
  int [] jerseyNumbers = new int[NUM_PLAYERS];
  int [] playerRatings = new int[NUM_PLAYERS];
  int jerseyNumber = -100;
  int playerRating = -100;
  int playerNumber = 100;
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
		getSinglePlayerInput();
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
    playerNumber=i+1;

    while(i < NUM_PLAYERS) { 
      
      System.out.println("Enter player "+playerNumber+"'s jersey number:");
      jerseyNumbers[i] = getPlayerJerseyNumber();
      
      System.out.println("Enter player "+playerNumber+"'s rating:");
      playerRatings[i] = getPlayerRating();
	
      //end loop and regroup!
      i++;
      playerNumber++;
      jerseyNumber = -100;
      playerRating = -100;
      System.out.println("");
    }
    return;
  }

  public void getSinglePlayerInput() { 
    //regather input if it is out of range
    int jNumber = 0;
    int pRating = 0;
    jerseyNumber = -100;
    playerRating = -100;
    playerNumber = -100;

    while(playerNumber < 1 | playerNumber > NUM_PLAYERS) { 
      while(!scnr.hasNextInt()) {
        System.out.println("please enter a number between 1 and "+NUM_PLAYERS);
        scnr.next();
      }
      playerNumber = scnr.nextInt();
    }

    System.out.println("Enter a jersey number:");
    jerseyNumbers[playerNumber-1] = getPlayerJerseyNumber();

    System.out.println("Enter a new rating for player:");
    playerRatings[playerNumber-1] = getPlayerRating();
  }


  public int getPlayerJerseyNumber() {

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

  public int getPlayerRating() {
   
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
