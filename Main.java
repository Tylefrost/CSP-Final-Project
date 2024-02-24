import java.util.Scanner;
import java.util.*;

public class Main {

  public static void main(String[] args) {

    //takes a string from Player 1 typing in console and stores it as the game word 
    Scanner word = new Scanner(System.in);
    System.out.println("Enter the game word:");
    String actualword = word.nextLine();

    //constructs the gameword object
    GameWord selectedword = new GameWord(actualword);
    
    //after Player 1 inputs the game word this artificially clears the console so that when       Player 2 begins guessing, they cannot see the answer
    for (int i = 0; i < 50; ++i) 
      System.out.println();

    //prints empty hangman pole to start
    System.out.println("-------");
    System.out.println("|     |");
    System.out.println("|      ");
    System.out.println("|");
    System.out.println("|");
    System.out.println("|");
    System.out.println("--------");

    //prints the blank spaces so Player 2 can see the length of the word
    System.out.println(selectedword.getblanks());

    //creating a object to store the guesses
    Scanner guesses = new Scanner(System.in);

    //repeat until game has been won
    while (selectedword.checkwin() == false && selectedword.getlives() > 0) {

      //prompts Player 2 to enter their guess
      System.out.println("Enter a letter to guess:");

      //stores the guess in the input object
      String input = guesses.nextLine();

      //checks the guess by comparing it to the answer. If it matches, then the corresponding       blank spaces are changed to the correctly guessed letter. If it doesn't match then a          life is removed. Each game Player 2 starts with 6 lives (a counter for the body parts         of the hangman that needs to be drawn)
      selectedword.correctornot(input);

      //if there have been no incorrect guesses nothing is drawn. Every life lost is another        part of the hangman drawn.
      if (selectedword.getlives() == 6){
        System.out.println("       ");
        System.out.println("-------");
        System.out.println("|     |");
        System.out.println("|      ");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("--------");
      }
      if (selectedword.getlives() == 5){
        System.out.println("       ");
        System.out.println("-------");
        System.out.println("|     |");
        System.out.println("|     O");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("--------");
      }
      if (selectedword.getlives() == 4){
        System.out.println("       ");
        System.out.println("-------");
        System.out.println("|     |");
        System.out.println("|     O");
        System.out.println("|     |");
        System.out.println("|");
        System.out.println("|");
        System.out.println("--------");
      }
      if (selectedword.getlives() == 3){
        System.out.println("       ");
        System.out.println("-------");
        System.out.println("|     |");
        System.out.println("|     O");
        System.out.println("|    /|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("--------");
      }
      if (selectedword.getlives() == 2){
        System.out.println("       ");
        System.out.println("-------");
        System.out.println("|     |");
        System.out.println("|     O");
        System.out.println("|    /|\\");
        System.out.println("|");
        System.out.println("|");
        System.out.println("--------");
      }
      if (selectedword.getlives() == 1){
        System.out.println("       ");
        System.out.println("-------");
        System.out.println("|     |");
        System.out.println("|     O");
        System.out.println("|    /|\\");
        System.out.println("|    /");
        System.out.println("|");
        System.out.println("--------");
      }
      if (selectedword.getlives() == 0){
        System.out.println("       ");
        System.out.println("-------");
        System.out.println("|     |");
        System.out.println("|     O");
        System.out.println("|    /|\\");
        System.out.println("|    / \\");
        System.out.println("|");
        System.out.println("--------");
      }
      
      //prints the current list of blanks and correctly guessed letters
      System.out.println(selectedword.getspaces());
    } 
    
    //prints the winning statement when checkwin is finally true
    if (selectedword.checkwin() == true) {
      System.out.println("You Win!");
    }
    else {
      System.out.println("You Lost");
    }
  } 
}


