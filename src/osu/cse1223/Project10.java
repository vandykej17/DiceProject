/*
 * Project10.java
 *
 *   A program that plays and scores a round of the game Poker Dice.  In this game,
 *   five dice are rolled.  The player is allowed to select a number of those five dice
 *   to re-roll.  The dice are re-rolled and then scored as if they were a poker hand.
 *   The following hands MUST be scored in this assignment:
 *   	* High card
 *   	* One Pair
 *   	* Two Pair
 *   	* Three of a Kind
 *   	* Full House
 *   	* Four of a Kind
 *   	* Five of a Kind
 *   For extra credit, you may also implement:
 *   	* Straight
 *
 * @author Lucas Van Dyke
 * @version 3/30/18
 *
 */
package osu.cse1223;

import java.util.Scanner;


public class Project10 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] originalArray = new int[5];
        int[] longerArray = new int[11];

        boolean cont = true;

        while (cont) {
            resetDice(originalArray);
            rollDice(originalArray);
            promptForReroll(originalArray, in);
            rollDice(originalArray);
            System.out.println("Your final dice: " + diceToString(originalArray));

            longerArray = getCounts(originalArray);
            System.out.print(getResult(longerArray) + "!");
            System.out.print("Why isn't this printing");


            cont = promptForPlayAgain(in);
        }
    }

    // Given an array of integers as input, sets every element of the array to zero.
    public static void resetDice(int[] dice) {
        int index = 0;
        while (index < dice.length) {
            dice[index] = 0;
            index++;
        }

    }

    // Given an array of integers as input, checks each element of the array.  If the value
    // of that element is zero, generate a number between 1 and 10 and replace the zero with
    // it.  Otherwise, leave it as is and move to the next element.
    public static void rollDice(int[] dice) {
        // Fill in the body
        int index = 0;
        while (index < dice.length) {
            if (dice[index] == 0) {
                dice[index] = (int) (Math.random() * 10) + 1;
            }
            index++;
        }
    }

    // Given an array of integers as input, create a formatted String that contains the
    // values in the array in the order they appear in the array.  For example, if the
    // array contains the values [0, 3, 7, 5, 2] then the String returned by this method
    // should be "0 3 7 5 2".
    public static String diceToString(int[] dice) {
        String dicetoString = "";
        int index = 0;
        while (index < dice.length) {
            dicetoString = dicetoString + " " + dice[index];
            index++;
        }

        return dicetoString;
    }


    // Given an array of integers and a Scanner as input, prompt the user with a message
    // to indicate which dice should be re-rolled.  If the user enters a valid index (between
    // 0 and the total number of dice -1) then set the die at that index to zero.  If the
    // user enters a -1, end the loop and return to the calling program.  If the user enters
    // any other invalid index, provide an error message and ask again for a valid index.
    public static void promptForReroll(int[] dice, Scanner inScanner) {
        System.out.println("Your current dice: " + diceToString(dice));
        System.out.print("Select a die to re-roll (-1 to keep remaining dice): ");
        int reRoll = Integer.parseInt(inScanner.nextLine());
        while (reRoll != -1) {
            while (reRoll < -1 || reRoll > 4) {
                System.out.println("Error: Index must be between 0 and 4 (-1 to quit)!");
                System.out.print("Select a die to re-roll (-1 to keep remaining dice): ");
                reRoll = Integer.parseInt(inScanner.nextLine());
            }

            if (reRoll == -1) {
                break;
            } else {

                dice[reRoll] = 0;
                System.out.println("Your current dice: " + diceToString(dice));
                System.out.print("Select a die to re-roll (-1 to keep remaining dice): ");
                reRoll = Integer.parseInt(inScanner.nextLine());
            }
        }
        System.out.println("Keeping remaining dice...");
        System.out.println("Rerolling...");
    }

    // Given a Scanner as input, prompt the user to play again.  The only valid entries
    // from the user are 'Y' or 'N', in either upper or lower case.  If the user enters
    // a 'Y' the method should return a value of true to the calling program.  If the user
    // enters a 'N' the method should return a value of false.  If the user enters anything
    // other than Y or N (including an empty line), an error message should be displayed
    // and the user should be prompted again until a valid response is received.
    public static boolean promptForPlayAgain(Scanner inScanner) {
        System.out.print("Would you like to play again [Y/N]?: ");
        String playAgain = inScanner.nextLine();


        while (!(playAgain.equals("Y") || playAgain.equals("y") || playAgain.equals("N") || playAgain.equals("n"))) {
            System.out.println("ERROR! Only 'Y' or 'N' allowed as input!");
            System.out.print("Would you like to play again [Y/N]?: ");
            playAgain = inScanner.nextLine();
        }

        if (playAgain.equals("Y") || playAgain.equals("y")) {
            return true;
        } else {
            return false;
        }

    }

    // Given an array of integers, determines the result as a hand of Poker Dice.  The
    // result is determined as:
    //	* Five of a kind - all five integers in the array have the same value
    //	* Four of a kind - four of the five integers in the array have the same value
    //	* Full House - three integers in the array have the same value, and the remaining two
    //					integers have the same value as well (Three of a kind and a pair)
    //	* Three of a kind - three integers in the array have the same value
    //	* Two pair - two integers in the array have the same value, and two other integers
    //					in the array have the same value
    //	* One pair - two integers in the array have the same value
    //	* Highest value - if none of the above hold true, the Highest Value in the array
    //						is used to determine the result
    //
    //	The method should evaluate the array and return back to the calling program a String
    //  containing the score from the array of dice.
    //
    //  EXTRA CREDIT: Include in your scoring a Straight, which is 5 numbers in sequence
    //		[1,2,3,4,5] or [2,3,4,5,6] or [3,4,5,6,7] etc..
    public static String getResult(int[] dice) {
        int index = 0;
        int largest = 0;
        int secondLargest = 0;
        int first = 0;
        int one = 0;
        String result = "";

//		Finds max number of dice
        while (index < dice.length) {
            if (dice[index] > largest) {
                largest = dice[index];
            }
            index++;
        }

        index = 0;
//		How many have only 1 value
        while (index < dice.length) {
            if (dice[index] == 1) {
                one++;
            }
            index++;
        }

        index = 0;
        while (index < dice.length) {
            if (dice[index] > secondLargest && dice[index] < largest) {
                secondLargest = dice[index];
            }
            index++;
        }

        index = 0;
        while (dice[index] < 1) {
            first = index;
            index++;
        }

        index = 0;
        int indexHightoLow = dice.length - 1;
        while (dice[indexHightoLow] < 1) {
            indexHightoLow--;
        }

        boolean straight = false;
        if (dice[first] == 1 && dice[first + 1] == 1 && dice[first + 2] == 1 && dice[first + 3] == 1 && dice[first + 4] == 1) {
            straight = true;
        }

        if (largest == 5) {
            result = "Five of a kind";
        } else if (largest == 4) {
            result = "Four of a kind";
        } else if (largest == 3 && secondLargest == 2) {
            result = "Full House";
        } else if (largest == 3) {
            result = "Three of a kind";
        } else if (straight) {
            result = "Straight";
        } else if (largest == 2 && one == 1) {
            result = "Two Pair";
        } else if (largest == 2) {
            result = "One Pair";
        } else {
            result = "Highest card " + indexHightoLow;
        }


        return result;

    }

    // Given an array of integers as input, return back an array with the counts of the
    // individual values in it.  You may assume that all elements in the array will have
    // a value between 1 and 10.  For example, if the array passed into the method were:
    //   [1, 2, 3, 3, 7]
    // Then the array of counts returned back by this method would be:
    // [1, 1, 2, 0, 0, 0, 1, 0, 0, 0]
    // (Where index 0 holds the counts of the value 1, index 1 holds the counts of the value
    //  2, index 2 holds the counts of the value 3, etc.)
    // HINT:  This method is very useful for determining the score of a particular hand
    //  of poker dice.  Use it as a helper method for the getResult() method above.
    public static int[] getCounts(int[] dice) {

        int[] countArray = new int[11];
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        int seven = 0;
        int eight = 0;
        int nine = 0;
        int ten = 0;
        int index = 0;

        while (index < dice.length) {
            if (dice[index] == 1) {
                one++;
            } else if (dice[index] == 2) {
                two++;
            } else if (dice[index] == 3) {
                three++;
            } else if (dice[index] == 4) {
                four++;
            } else if (dice[index] == 5) {
                five++;
            } else if (dice[index] == 6) {
                six++;
            } else if (dice[index] == 7) {
                seven++;
            } else if (dice[index] == 8) {
                eight++;
            } else if (dice[index] == 9) {
                nine++;
            } else if (dice[index] == 10) {
                ten++;
            }
            index++;
        }

        countArray[0] = one;
        countArray[1] = two;
        countArray[2] = three;
        countArray[3] = four;
        countArray[4] = five;
        countArray[5] = six;
        countArray[6] = seven;
        countArray[7] = eight;
        countArray[8] = nine;
        countArray[9] = ten;

        return countArray;
    }


}