/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boggle;

import java.util.*;
/**
 *
 * @author Garrett
 */
public class Boggle {

    /**
     * @param args the command line arguments
     */
    
    private static int correctCounter = 0;         // Stores the number of correct guesses so we can loop thru the array correctGuesses later.
    
    public static void main(String[] args) {
        // TODO code application logic here
       String finalWord = stringGen(0);            // Generate Random String to find words in
        
       String correctGuesses[];
       correctGuesses = new String[50];
       Boolean running = true;
        
       System.out.println(finalWord); 
        
       Scanner s = new Scanner(System.in);         // sets up user input
       
       while (running){                             // while user still wants to play...
           System.out.print("Enter a word found in this puzzle (or QUIT to quit): ");
            String input = s.nextLine();           // Gets user input
            if(quit(input)){
                break;
            }
            if (input.equals("yarrimapirate")) {
                yarrimapirate();
            }
            if(!compare(correctGuesses, input)) {  // guessed word isnt in prev list
                if(checkWord(finalWord, input)) {  // guessed word is found in string
                    correctGuesses[correctCounter] = input;
                    System.out.println("Yes," + input + " is in the puzzle.");
                    correctCounter++;
                }
                else {                             // exactly what next line says o.O
                    System.out.println(input + " is NOT in the puzzle.");
                }
            }
            else {
                System.out.println("Sorry, you have already found that word.");
            }
       }
       
       System.out.println("You found the following " + correctCounter + " words in the puzzle:");
       
       for(int x=0; x<correctCounter; x++) {       // lets print out all Correct guesses!
           System.out.println(correctGuesses[x]);
       }
       
    }
    
    public static String stringGen(int seed) {     // seed does nothing atm
        String word = "";                          // holds random string
        String letters = "abdefghilmnoprstuwxy";   // usable letters
        char   letter;                             // holds current letter that is added to (string)word
        
        Random randomGen = new Random();
        
        for(int x = 0; x<50; x++){                 // Create a random string of 50 characters
            int randomInt = randomGen.nextInt(20);
            letter = letters.charAt(randomInt);
            word = word + letter;
        }
        return word;                               // Finalized random string
    }
    
    // compare users current guess to a list of previous Correct guesses...
    public static Boolean compare(String prevGuess[], String currGuess) {
        for(int x = 0; x<correctCounter; x++) {
            if(prevGuess[x].equalsIgnoreCase(currGuess) == true) {
                return true;
            }
        }
        return false;
        
        //returns false if the currGuess isnt in prevGuess list
    }
    
    public static Boolean checkWord(String word, String guess) {
        return word.toLowerCase().contains(guess);
    }
    
    // you quitter!
    public static Boolean quit(String input) {
        return input.equalsIgnoreCase("QUIT");
    }

    // non-sense... testing ground
    public static void stats(String word) {
        String vowels = "aeiou";
        String consts = "abcdfghjklmnpqrstvwxz";
        String yy     = "y";                       // because sometimes...
        
        boolean found = false;
        
        int vCount    = 0;
        int cCount    = 0;
        int yyCount   = 0;
        
    }
    
    // easter-egg
    public static void yarrimapirate() {
        System.out.println("#############################################################################");
        System.out.println("#(@@@@)                    (#########)                   (@@@@@@@@(@@@@@@@@@#");
        System.out.println("#@@@@@@)___                 (####)~~~   /\\                ~~(@@@@@@@(@@@@@@@#");
        System.out.println("#@@@@@@@@@@)                 ~~~~      /::~-__               ~~~(@@@@@@@@)~~#");
        System.out.println("#@@@)~~~~~~                           /::::::/\\                  ~~(@@@@)   #");
        System.out.println("#~~~                              O  /::::::/::~--,                 ~~~~    #");
        System.out.println("#                                 | /:::::/::::::/{                         #");
        System.out.println("#                 |\\              |/::::/::::::/:::|                        #");
        System.out.println("#                |:/~\\           ||:::/:::::/::::::|                        #");
        System.out.println("#               |,/:::\\          ||/'::: /::::::::::|                       #");
        System.out.println("#              |#__--~~\\        |'#::,,/::::::::: __|   ,,'`,               #");
        System.out.println("#             |__# :::::\\       |-#\"\":::::::__--~~::| ,'     ',     ,,      #");
        System.out.println("#,    ,,     |____#~~~--\\,'',.  |_#____---~~:::::::::|         ',','  ',    #");
        System.out.println("# '.,'  '.,,'|::::##~~~--\\    `,||#|::::::_____----~~~|         ,,,     '.''#");
        System.out.println("#____________'----###__:::\\_____||#|--~~~~::::: ____--~______,,''___________#");
        System.out.println("#^^^  ^^^^^   |#######\\~~~^^O, | ### __-----~~~~_____########'  ^^^^  ^^^   #");
        System.out.println("#,^^^^^','^^^^,|#########\\_||\\__O###~_######___###########;' ^^^^  ^^^   ^^ #");
        System.out.println("#^^/\\/^^^^/\\/\\^^|#######################################;'/\\/\\/^^^/\\/^^^/\\/^#");
        System.out.println("#   /\\/\\/\\/\\/\\  /\\|####################################'      /\\/\\/\\/\\/\\    #");
        System.out.println("#\\/\\/\\     /\\/\\/\\  /\\/\\/\\/\\    /\\/\\/\\/\\/\\   /\\/\\/\\    /\\/\\/\\/\\      /\\/\\/\\/\\#");
        System.out.println("#spb\\/\\/\\    /\\/\\/\\/\\    /\\/\\/\\/\\    /\\/\\/\\/\\   /\\/\\/\\/\\    /\\/\\/\\/\\/\\      #");
        System.out.println("#############################################################################");
        System.out.println("Pirate Ship ASCII art found at http://www.chris.com/ascii/index.php?art=transportation/nautical");
    }
}
