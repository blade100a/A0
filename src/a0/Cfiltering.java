// **********************************************************
// Assignment0:
// UTORID: pahirath
// UT Student #: 1003371549
// Author: Harri Pahirathan
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my 
// own. I received
// help from no one in designing and 
// debugging my program.
// I have also read the plagiarism section 
// in the course info
// sheet of CSC B07 and understand 
// the consequences. In this semester
// we will select any three of your 
// assignments from total of 5 and run it
// for plagiarism check. 
// *********************************************************
package a0;

import java.util.List;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Cfiltering {
  // this is a 2d matrix i.e. user*movie
  private int userMovieMatrix[][];
  // this is a 2d matrix i.e. user*movie
  private float userUserMatrix[][];

  /**
   * Default Constructor.
   */
  public Cfiltering() {
    // this is 2d matrix of size 1*1
    userMovieMatrix = new int[1][1];
    // this is 2d matrix of size 1*1
    userUserMatrix = new float[1][1];
  }

  /**
   * Constructs an object which contains
   * two 2d matrices, one of size
   * users*movies which will store integer
   * movie ratings and one of size
   * users*users which will store float
   * similarity scores between pairs of
   * users.
   * 
   * @param numberOfUsers size of matrix variables.
   * @param numberOfMovies size of matrix variables.
   */
  public Cfiltering(int numberOfUsers,
		  int numberOfMovies) {
	  // Creates the variable for user matrix
	  this.userUserMatrix =
			  new float[numberOfUsers][numberOfUsers];
	  // Creates the variable for movie matrix
	  this.userMovieMatrix =
			  new int[numberOfUsers][numberOfMovies];
  }

  /**
   * The purpose of this method is to populate
   * the UserMovieMatrix. As input
   * parameters it takes in a rowNumber,
   * columnNumber and a rating value. The
   * rating value is then inserted in the
   * UserMovieMatrix at the specified
   * rowNumber and the columnNumber.
   * 
   * @param rowNumber The row number of
   * the userMovieMatrix.
   * @param columnNumber The column number
   * of the userMovieMatrix.
   * @param ratingValue The ratingValue to be 
   * inserted in the userMovieMatrix
   */
  public void populateUserMovieMatrix(int rowNumber,
		  int columnNumber,
      int ratingValue) {
	  // Places the ratings in the matrix variable
	  userMovieMatrix[rowNumber][columnNumber] = 
			  ratingValue;
  }

  /**
   * Determines how similar each pair of users
   * is based on their ratings. This
   * similarity value is represented with with
   * a float value between 0 and 1,
   * where 1 is perfect/identical similarity.
   * Stores these values in the
   * userUserMatrix.
   */
  public void calculateSimilarityScore() {
	  // Row and Column variables to loop through
	  int row;
	  int col;
	  // Hold the size of the matrix
	  int sizeMat = this.userUserMatrix.length;
	  // Loops through each rating in the matrix
	  for(row = 0; row < sizeMat; row++) {
		  for (col = 0; col < sizeMat; col++) {
			  // Uses this variable to round
			  float roundDif = 0;
			  // Holds the rating in loop
			  int ratings;
			  // Keeps the length of the row
			  int totRatings =
					  this.userMovieMatrix[row].length;
			  // Holds the difference of variables
			  int diff;
			  // Uses this to have 4 decimal points
			  DecimalFormat fourSpa =
					  new DecimalFormat("0.0000");
			  // loops through the ratings through row
			  for (ratings = 0; ratings < totRatings;
					  ratings ++) {
				  // Holds the variable for row Rating
				  int rowRate =
						  this.userMovieMatrix[row][ratings];
				  // Holds the variable for column Rating
				  int colRate =
						  this.userMovieMatrix[col][ratings];
				  // Calculates difference
				  // between both ratings
				  diff = rowRate - colRate;
				  // Rounds the difference to a float
				  roundDif += (float) Math.pow(diff, 2); 
			  }
			  // Roots the total rounded difference
			  float rateDist = (float) Math.sqrt(roundDif);
			  // Places it into a string 
			  // value of the round to 4 decimal
			  String stringRate =
					  fourSpa.format(1 / (1 +  rateDist));
			  // Takes string back to the float
			  float score = Float.valueOf(stringRate);
			  // Places the score of rating into matrix
			  this.userUserMatrix[row][col] = score;
		  }
	  }
  }

  /**
   * Prints out the similarity scores of
   * the userUserMatrix, with each row and
   * column representing each/single user
   * and the cell position (i,j)
   * representing the similarity score
   * between user i and user j.
   */
  public void printUserUserMatrix() {
	  // Row variable and Column to hold for loop
	  int row;
	  int col;
	  // Holds the length of the matrix
	  int matrixLen = this.userUserMatrix.length;
	  // Loops through the matrix and prints each row
	  for(row = 0; row < matrixLen; row++) {
		  // Proper format as requested so square bracket
		  System.out.print("[");
		  // Loops through ratings to print
		  for(col = 0; col < matrixLen - 1; col++) {
			  // Holds the rating
			  // currently in row and column
			  float rating =
					  this.userUserMatrix[row][col];
			  // Adds the comma and rating
			  System.out.printf("%.4f, ", rating);
		  }
		  // Holds the last rating of the row
		  float last =
				  this.userUserMatrix[row][matrixLen - 1];
		  // Places the last rating of the row
		  System.out.printf("%.4f", last);
		  // Adds the last square Bracket
		  System.out.print("]");
		  // Starts the next line
		  System.out.println("");
	  }
  }

  /**
   * This function finds and prints the
   * most similar pair of users in the
   * userUserMatrix.
   */
  public void findAndprintMostSimilarPairOfUsers() {
	  // Variables row and column to hold for loop
	  int row;
	  int col;
	  // Count variables to print each pair
	  int count;
	  // Holds the highest rate in matrix
	  float highRates = (float) -99.0000;
	  // List that hold the pair strings
	  List<String> simPairs = new ArrayList<String>();
	  // Holds the length of the matrix
	  int len = this.userUserMatrix.length;
	  // Holds the decimal format for similarity score
	  DecimalFormat df = new DecimalFormat("0.0000");
	  // Loops through matrix to find highest rating
	  for(row = 0; row < len; row++) {
		  for(col = 0; col < len; col++) {
			  // Variable holds the rating being tested
			  float locRate =
					  this.userUserMatrix[row][col];
			  // Does not check the diagonal
			  if(row == col) {
			  }
			  // Checks the rate is
			  // higher than current rate
			  else if(highRates < locRate) {
				  // New highest rate in the matrix
				  highRates = locRate;
			  }
		  }
	  }
	  // Loops through and obtains
	  // users of the highest rating
	  for(row = 0; row < len; row++) {
		  for(col = 0; col < len; col++) {
			  // Variable holds the rating being tested
			  float locRate =
					  this.userUserMatrix[row][col];
			  // Does not check diagonal of the matrix
			  if(row == col) {
			  }
			  // Finds the pair of users with rating
			  else if(highRates == locRate) {
				  // Holds actual user 1
				  int valR = row + 1;
				  // Holds actual user 2
				  int valC = col + 1;
				  // Checks if pair already belongs in the list
				  if(!(simPairs.contains("User"+ valC +
						  " and User" + valR))) {
					  // Adds the string into the sim list
					  simPairs.add(("User"+ valR +
							  " and User" + valC));
				  }
			  }
		  }
	  }
	  // Size of all the pairs
	  int size = simPairs.size();
	  // Loops through pairs to print in console
	  for(count = 0; count < size; count++) {
		  System.out.println(simPairs.get(count));
	  }
	  // Prints the string with similarity score
	  System.out.println("with similarity score of "
	  + df.format(highRates));
  }

  /**
   * This function finds and prints the most 
   * dissimilar pair of users in the
   * userUserMatrix.
   */
  public void findAndprintMostDissimilarPairOfUsers() {
	  // Variables row and column to hold for loop
	  int row;
	  int col;
	  // Count variable holds to print every pair
	  int count;
	  // Holds the lowest rate in matrix
	  float lowRates = (float) 10.0000;
	  // The list holds the pairs of lowest rates
	  List<String> difPairs = new ArrayList<String>();
	  // Holds the length of the matrix
	  int len = this.userUserMatrix.length;
	  // Holds the decimal format for similarity score
	  DecimalFormat df = new DecimalFormat("0.0000");
	  // Loops through matrix to find lowest rating
	  for(row = 0; row < len; row++) {
		  for(col = 0; col < len; col++) {
			  // Variable holds the rating being tested
			  float locRate =
					  this.userUserMatrix[row][col];
			  // Does not check the diagonal
			  if(row == col) {
			  }
			  // Checks the rate is higher than current rate
			  else if(lowRates > locRate) {
				  // New lowest rate in the matrix
				  lowRates = locRate;
			  }
		  }
	  }
	  // Loops through and obtains
	  // users of the highest rating
	  for(row = 0; row < len; row++) {
		  for(col = 0; col < len; col++) {
			  // Variable holds the rating being tested
			  float locRate =
					  this.userUserMatrix[row][col];
			  // Does not check the diagonal
			  if(row == col) {
			  }
			  // Finds the pair of users with rating
			  else if(lowRates == locRate) {
				  // Holds actual user 1
				  int valR = row + 1;
				  // Holds actual user 2
				  int valC = col + 1;
				  // Checks if pair already belongs in the list
				  if(!(difPairs.contains("User"+ valC +
						  " and User" + valR))) {
					  // Adds the string
					  // into the different list
					  difPairs.add(("User"+ valR +
							  " and User" + valC));
				  }
			  }
		  }
	  }
	  // Size of all the lowest pairs
	  int size = difPairs.size();
	  // Loops through pair to print in console
	  for(count = 0; count < size; count++) {
		  System.out.println(difPairs.get(count));
	  }
	  // Prints the string with similarity score
	  System.out.println("with similarity score of "
	  + df.format(lowRates));
  }
}
