import java.util.Scanner;
import java.util.*;

public class GameWord {

  //fields

  private String word;
  private List<String> spaces;
  private int lives = 6;
  private boolean check;
  private List<String> letters;
  
  //constructors
  
  public GameWord (String input) {
    this.word = input;
    this.letters = Arrays.asList(word.split(""));
    this.spaces = new ArrayList<String>();
  }

  //methods

  //returns amount of lives
  public int getlives() {
    return(lives);
  }

  //create a list of blank spaces the same length as the list of letters of the word
  public List getblanks() {
    for (int i=0; i < letters.size(); i++){
         spaces.add(i,"_");
    }
    return(spaces);
  }

  //returns the current list of blanks and guessed letters
  public List getspaces() {
    return(spaces);
  }
  
  //checks if the guessed letter exists in the word. If the letter does exist in the word,       the program changes all "_" in the position of the letter to that letter. If the letter        doesn't exist in the word, remove a life which will draw another part of the hangman.
  public void correctornot(String guessedletter) {
    check = false;
    for (int i=0; i < letters.size(); i++) {
      if (guessedletter.equals(letters.get(i))) {
        spaces.set(i, guessedletter);
        check = true;
      }
    } 
    if(check == false) {
      lives = lives - 1;
    }
  } 

  //returns list of letters in the selected word
  public List getletters() {
    return(letters);
  }

  //checks if all the blanks in the spaces list have turned into letters
  public boolean checkwin() {
    if (spaces.indexOf("_") == -1) {
      return true;
    }  
    else {
      return false;
    }
  }
}