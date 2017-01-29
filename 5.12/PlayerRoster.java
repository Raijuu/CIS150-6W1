import java.util.Scanner;

public class PlayerRoster {
  //global variables;
  final int NUM_PLAYERS = 5;
  int [] jerseyNumbers = new int[NUM_PLAYERS];
  int [] playerRatings = new int[NUM_PLAYERS];
  int jerseyNumber = -1;
  int playerRating = 0;
  int playerNumber = 0;
  String userInput = "";
  int i = 0;
  int ratingsInquiry = 0;
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
		updatePlayerRating();
		break;
     
      case "a": userInput = "";
        	outputPlayersAboveARating();
		break;

      case "r": userInput = "";
		replacePlayer();
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
    System.out.println("MENU");
    System.out.println("u - Update player rating");
    System.out.println("a - Output players above a rating");
    System.out.println("r - Replace player");
    System.out.println("o - Output roster");
    System.out.println("q - Quit\n");
    System.out.println("Choose an option:");

  }
  
  public void clearScanner() {
    while(scnr.hasNext()) {
      scnr.next();
    }
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
      jerseyNumber = -1;
      playerRating = 0;
      System.out.println("");
    }
    return;
  }

  public void updatePlayerRating() {
    jerseyNumber = -1;
    playerRating = -0;
    boolean noMatch = true;
    // TODO: clarify with customer, do jerseys need to be unique? Assuming yes for now.
    System.out.println("Enter a jersey number:");   
    jerseyNumber = getPlayerJerseyNumber();
    
    for(i = 0; i < NUM_PLAYERS; i++) {
      
      if(jerseyNumber == jerseyNumbers[i]) {
        System.out.println("Enter a new rating for players:");
        playerRatings[i] = getPlayerRating();
        System.out.println("Player rating: "+playerRating+" updated for jersey number:"+jerseyNumber);
        noMatch = false;
        break;
      }  
    }
    if(noMatch) {
      System.out.println("Jersey "+jerseyNumber+" not found, try using Output roster to verify");
    }
  }

  public void outputPlayersAboveARating() {
    System.out.println("Enter a rating:");
    ratingsInquiry = getPlayerRating(); 
    System.out.println("ABOVE "+ratingsInquiry);
    for(i = 0; i < NUM_PLAYERS; i++) {
      if(ratingsInquiry <= playerRatings[i]) {
        //System.out.println("Player "+(i+1)+" -- Jersey number: "+jerseyNumbers[i]", Rating: "+playerRatings[i]);
        printPlayerInfo(i);
      }
    }       

  }

  public void replacePlayer() {
    boolean noMatch = true;
    jerseyNumber = -1;
    playerRating = -0;
    int jnumber = -1;
    System.out.println("Enter a jersey number:");
    jnumber = getPlayerJerseyNumber();   
    for(i = 0; i < NUM_PLAYERS; i++) {
      if(jnumber == jerseyNumbers[i]) {
        jerseyNumber = -1;
        System.out.println("Enter a new jersey number:");
        jerseyNumbers[i] = getPlayerJerseyNumber();
        System.out.println("Enter a rating for the new player: ");
        playerRatings[i] = getPlayerRating();
	noMatch = false;
        break;
      }
    }
    if(noMatch) {
      System.out.println("No matching jersey number, try using Output roster to verify.");
    }
  }


  public int getPlayerJerseyNumber() {
    // TODO: Requirements did not specify jersey #'s need be unique, get user feedback. 

    // keep prompting if number is out of range:
    while(jerseyNumber < 0 | jerseyNumber > 99) {
      // sanitize input:
      while(!scnr.hasNextInt()) {
        System.out.println("Please enter a number between 0-99 ");
        scnr.next();
      }
      jerseyNumber = scnr.nextInt();
      //System.out.println("Please enter a number between 0-99");
    }
    return jerseyNumber;
  }

  public int getPlayerRating() {
    playerRating=0;  
    //keep prompting if number is out of range:
    while (playerRating < 1 | playerRating > 9) {
      // sanitize input:
      while(!scnr.hasNextInt()) {
        System.out.println("Please enter a number between 1-9");
        scnr.next();
      }
      playerRating = scnr.nextInt();
      //System.out.println("Please enter a number between 1-9");
    }
    return playerRating;
  }


  public void showRoster() {
    //Do the Roster Output
    for(i = 0; i < NUM_PLAYERS; i++) {
      //System.out.println("Player "+(i+1)+" -- Jersey number: "+jerseyNumbers[i]+", Rating: "+playerRatings[i]);
      printPlayerInfo(i);
    }

    return;
  }

  public void printPlayerInfo(int indexID) {
    System.out.println("Player "+(indexID+1)+" -- Jersey number: "+jerseyNumbers[indexID]+", Rating: "+playerRatings[indexID]);
  }


}
