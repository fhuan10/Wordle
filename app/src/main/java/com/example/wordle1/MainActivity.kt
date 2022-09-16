package com.example.wordle1

import android.graphics.Color
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.wordle1.FourLetterWordList.FourLetterWordList

class MainActivity : AppCompatActivity() {

    /**
     * author: shobhan
     * This function helps to hide or show the keyboard.
     */
    fun setKeyboardVisibility(show: Boolean) {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        if (show) {
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
        } else {
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
    }

    // Get a random four letter word from a list
    var wordToGuess = FourLetterWordList.getRandomFourLetterWord();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Declare variables to the 'view' elements
        val guess1 = findViewById<TextView>(R.id.Guess1);
        val guess2 = findViewById<TextView>(R.id.Guess2);
        val guess3 = findViewById<TextView>(R.id.Guess3);
        val guessCheck1 = findViewById<TextView>(R.id.GuessCheck1);
        val guessCheck2 = findViewById<TextView>(R.id.GuessCheck2);
        val guessCheck3 = findViewById<TextView>(R.id.GuessCheck3);
        var guessCheckResult1 = findViewById<TextView>(R.id.GuessCheckResult1);
        var guessCheckResult2 = findViewById<TextView>(R.id.GuessCheckResult2);
        var guessCheckResult3 = findViewById<TextView>(R.id.GuessCheckResult3);
        var userInput1 = findViewById<TextView>(R.id.userInput1);
        var userInput2 = findViewById<TextView>(R.id.userInput2);
        var userInput3 = findViewById<TextView>(R.id.userInput3);
        val submitButton = findViewById<Button>(R.id.button);
        val answer = findViewById<TextView>(R.id.Answer);
        var userInput = findViewById<EditText>(R.id.editUserInput);

        answer.text = wordToGuess;
        var count = 1;  // Counter variable to represent what turn the user is on

        /**
         * When the user clicks on the "SUBMIT" button,
         *   1. Automatically close the phone keyboard
         *   2. Clear the user's input in the text box
         *   3. Compare the user's input to the word the user is guessing
         *   4. Display the user's input and which letter did they guess right for each guess/turn
         *   5. Win/lose condition (if the user successfully guess the word or use all 3 guesses)
         */
        submitButton.setOnClickListener{
            setKeyboardVisibility(false);  // Turns off the keyboard

            // Convert the user's input into a string, and
            // make it all uppercase, in order to be compared to the word they're guessing
            var userString = userInput.text.toString().uppercase();
            var result = checkGuess(userString);

            userInput.text.clear(); // Clear the user's input in the textbox

            /**
             * For every input the user makes, update the texts,
             * and turn on the text visibility
             * to display the user's input and what letter did they guess right
             */
            if (count == 1) {
                userInput1.text = userString;
                guessCheckResult1.text = result;

                guess1.isVisible = true;
                guessCheck1.isVisible = true;
                guessCheckResult1.isVisible = true;
                userInput1.isVisible = true;
            } else if (count == 2) {
                userInput2.text = userString;
                guessCheckResult2.text = result;

                guess2.isVisible = true;
                guessCheck2.isVisible = true;
                guessCheckResult2.isVisible = true;
                userInput2.isVisible = true;
            } else {
                userInput3.text = userString;
                guessCheckResult3.text = result;

                guess3.isVisible = true;
                guessCheck3.isVisible = true;
                guessCheckResult3.isVisible = true;
                userInput3.isVisible = true;
            }

            /**
             * If the user either guess the word correctly at most 3 turns OR uses all 3 turns up,
             * display the word they're guessing, and make the 'Submit' button no longer usable
             * Otherwise,
             * increase the count
             */
            if (result == "OOOO" || count == 3) {
                answer.isVisible = true;
                submitButton.isClickable = false;
                submitButton.setBackgroundColor(Color.DKGRAY);
            } else {
                count++;
            }
        }


    }

    /**
     * Parameters / Fields:
     *   wordToGuess : String - the target word the user is trying to guess
     *   guess : String - what the user entered as their guess
     *
     * Returns a String of 'O', '+', and 'X', where:
     *   'O' represents the right letter in the right place
     *   '+' represents the right letter in the wrong place
     *   'X' represents a letter not in the target word
     */
    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
}