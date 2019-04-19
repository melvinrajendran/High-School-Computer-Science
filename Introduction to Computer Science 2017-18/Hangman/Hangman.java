import java.util.Scanner;
public class Hangman {
	public static void main (String[]args) {

		Scanner reader = new Scanner (System.in); //initializing Scanner reader used for user inputs such as guesses, choice to play hangman game again

		String[] words = {"entry", "joust", "joker", "fazed", "stole", "money", "slurp", "quack", "tough", "juked"}; //array containing possible words
		int score = 0;
		int exit = 0;

		directions(); //calls method in order to print welcome message for user, in addition to game directions
		while (exit == 0) { //exit is variable used to repeat the game mutliple times, while variable score is incremented
			int randomNumberIndex = (int)(Math.random()*10);
			String[] word = new String[words[randomNumberIndex].length()]; //selection of random word from original array of words
			for (int i = 0; i < word.length; i++) {
				word[i] = "_";
			} // filling the array with underscores so long as the user has not guessed any individual letters
			int misses = 6;
			String lettersGuessed = "";
			boolean letterTrue = false;
			int correct = 0;
			while ((misses > 0) && (letterTrue == false)) { //while loop for each individual game of Hangman, runs so long as the user has misses remaining and has not already guessed the correct word
				for (int i = 0; i < word.length; i++) {
					System.out.print(word[i] + " ");
				} //prints array of underscores and/or letters in the word already found by the user
				information(misses, lettersGuessed);
				System.out.print("Guess letter: ");
				String guess = reader.nextLine();
				char charGuess = guess.charAt(0);
				lettersGuessed += guess + " "; //String and char variables of the user's guess for usage in the for loop comparisons
				for (int i = 0; i < words[randomNumberIndex].length(); i++) {
					if (charGuess == words[randomNumberIndex].charAt(i)) {
						letterTrue = false;
						System.out.println("\nFound " + guess + "!\n\n"); // if user's guess is in the word, the code prints "Found (letter)!"
						word[i] = guess;
						correct++;
						if (correct >= word.length) {
							letterTrue = true;
							break; //if the number of correct guesses is greater than or equal to the number of letters in the word, the word has been discovered before the user runs out of misses
						}
						break;
					}
					else if ((!(charGuess == words[randomNumberIndex].charAt(0))) && (!(charGuess == words[randomNumberIndex].charAt(1))) && (!(charGuess == words[randomNumberIndex].charAt(2))) && (!(charGuess == words[randomNumberIndex].charAt(3))) && (!(charGuess == words[randomNumberIndex].charAt(4)))) {
						letterTrue = false;
						System.out.println("\nNo " + guess + "!\n\n"); // if user's guess is not in the word, the code prints "No (letter)!"
						misses--;
						break;
					}
				}
			}
			String finalWord = ""; //variable to store the final word found by the user after his/her misses are up or he/she has found the correct word
			for (int i = 0; i < word.length; i++) {
				finalWord += word[i];
			}
			if (finalWord.equalsIgnoreCase(words[randomNumberIndex])) {
				System.out.println("You win!  The word is " + words[randomNumberIndex] + ".\n"); //if finalWord is equal to the correct word, the user wins and gains a point
				score++;
			}
			else {
				System.out.println("You've been hung!  The correct word is " + words[randomNumberIndex] + ".\n"); //if finalWord is not equal to the correct word, the user loses and does not have an increase to his/her score
			}

			System.out.print("Your score is " + score + ".  Would you like to play again? ([Y]es / [N]o): "); //displays user's score and asks him/her if he/she would like to play the game again
			String choice = reader.nextLine();
			while (!(choice.equalsIgnoreCase("Y")) && !(choice.equalsIgnoreCase("N"))) {
				System.out.print("Please enter a valid response ([Y]es / [N]o): "); //reinforcement to avoid code dysfunction
				choice = reader.nextLine();
			}
			System.out.println();
			if (choice.equalsIgnoreCase("N")) {
				exit++; //only if user enters "N", the while loop is exited
			}
		}
	}
	public static void directions() { //method to print welcome message and user directions
		System.out.println("Welcome to Hangman!\n");
		System.out.println("Rules:\tA randomly selected word will be shown as blanks, and you must guess a letter that you think is in the word.\n\tAll letters are shown in a \"guessed letters\" list, and if the letter is in the word, it will be filled in on\n\tthe blanks.  You have six incorrect quesses until you are hung, and you may play multiple times.  Good luck!\n");
	}
	public static void information(int misses, String lettersGuessed) { //method to print user's information during a certain game of Hangman, including his/her misses left and letters guessed
		System.out.print("\n\nMisses left: " + misses);
		System.out.print("\n\nLetters guessed: " + lettersGuessed);
		System.out.println("\n");
	}
}