import java.util.*;
class FruitMachineV2 {
  //We define the method which will called to determine if a a set of numbers is non-sequential.
  static boolean NonSequential(int r1, int r2, int r3) {
    int Mean = (r1 + r2+ r3)/3;
    return ((r1 == Mean || r2 == Mean || r3 == Mean ) && (r1 == Mean + 1 || r2 == Mean + 1 || r3 == Mean + 1) && (r1 == Mean -1 || r2 == Mean -1 || r3 == Mean -1));

  }
  public static void main(String[] args) {

    /*This program will emulate the functionality of fruit machines commonly found in casinos.
    *WillAY998 2016
    */
    Scanner scan = new Scanner(System.in);
    Random r = new Random();
    int Credits = 10;
    int UserChoice = 0;
    boolean Game = true;

    while (Game == true) {
      //The game menu is displayed and allows the user to navigate.
      System.out.println("Welcome to this Fruit Machine!" +"\n" + "Game Menu" +"\n" + "1. Credits Enquiry (1)" +"\n" + "2. Play (2)" +"\n" + "3. Quit Game (3)");
      UserChoice = scan.nextInt();

      //The user opts to quit the program.
      if (UserChoice == 3) {
        System.out.println("Credits remaining: " + Credits);
        System.out.println("Thank you for playing.");
        Game = false;
      }

      //The user makes an enquiry for their credits balance.
      if (UserChoice == 1) {
      System.out.println("You currently have " + Credits + " credits remaining.");
      }

      //The user decides the play the game.
      if (UserChoice == 2) {
        if (Credits == 0) {
          System.out.println("Game Over! Thanks for playing.");
          Game = false;
        }
      else if (Credits !=0) {
          //We generate our 3 random numbers
          int Reel1 = r.nextInt(6)+1;
          int Reel2 = r.nextInt(6)+1;
          int Reel3 = r.nextInt(6)+1;
          Credits--;
          System.out.println("Heres your spin! {||" + Reel1 + "||" + Reel2 + "||" + Reel3 + "||}");
          //To check if the user got 7-7-7
      if (Reel1 == 7 && Reel2 == 7 && Reel3 == 7) {
            Credits = (Credits + 150);
            System.out.println("Congratulations on your win of 150 credits, you currently have " + Credits + " credits remaining.");
          } //To check if all of the user's numbers are identical
		  else if (Reel1 == Reel2 && Reel1 == Reel3) {
             Credits = (Credits + 80);
             System.out.println("Congratulations on your win of 80 credits, you currently have " + Credits + " credits remaining.");
          } //To determine if the user's number is sequential
		  else if ((Reel3 - Reel2) == 1 && (Reel2 - Reel1) == 1){
             Credits = (Credits + 40);
             System.out.println("Congratulations on your win of 40 credits, you currently have " + Credits + " credits remaining.");
          } //To determine if the user's number is non sequential
      else if (NonSequential(Reel1,Reel2,Reel3)){
             Credits = (Credits + 25);
             System.out.println("Congratulations on your win of 25 credits, you currently have " + Credits + " credits remaining.");
          }  //To check if the any 2 of the user's numbers are matching even
		  else if  (Reel1 == Reel2 && Reel1 % 2 == 0 || Reel1 == Reel3 && Reel1 % 2 == 0 || Reel2 == Reel3 && Reel2 % 2 == 0) {
             Credits = (Credits + 10);
             System.out.println("Congratulations on your win of 10 credits, you currently have " + Credits + " credits remaining.");
          } //To check if any 2 of the user's numbers are matching odd
		  else if (Reel1 == Reel2 && Reel1 % 2 != 0 || Reel1 == Reel3 && Reel1 % 2 != 0 || Reel2 ==  Reel3 && Reel2 % 2 != 0) {
             Credits = (Credits + 5);
             System.out.println("Congratulations on your win of 5 credits, you currently have " + Credits + " credits remaining.");
          }  //To check if any 1 of the user's number is a 7
		  else  if (Reel1 == 7 || Reel2 == 7 || Reel3 == 7) {
             Credits = (Credits + 2);
             System.out.println("Congratulations on your win of 2 credits, you currently have " + Credits + " credits remaining.");
          }
		  else {
             System.out.println("Unlucky you did not win, you currently have " + Credits + " credits remaining.");
          }

          }

		  }

		  }

		  }
}
