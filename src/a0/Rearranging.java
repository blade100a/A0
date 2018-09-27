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

/*
 * 
 */
public class Rearranging {

	/**
	 * This method will take a list of items
	 * and sort the items to three parts,
	 * less then zero, equal to zero and greater
	 * than zero
	 * @param items Holds are the numbers to sort
	 */
	public static void rearranging(int[] items)
	{
		// Holds the size of the list
		int len = items.length;
		// Loops through and swap positions
		for(int x = 1; x < len; x++) {
			// Sorts the list putting less to greater
			if(items[x] < items[x - 1]) {
				swap(x, x-1, items);
				// resets the count
				x = 0;
			}
		}
	}

	/**
	 * This method will take two positions and
	 * a list of integer to switch spots of the two
	 * variables.
	 * @param i Holds position one number
	 * @param j Holds position two number
	 * @param items Holds all the integers 
	 */
	private static void swap(int i,int j,int[] items)
	{
		// Creates a mock variable so wont lose one
		int mock = items[i];
		// Switches the first to be second variable
		items[i] = items[j];
		// Then get the first to the second variable
		items[j] = mock;
	}

	public static void main(String[] args) {
		/* You can modify the main
		 * function in any way you like.
		 * We will not mark your main function.  
		 */
		int [] items={7,-3,0,0,8,-2};
		/*
		 * printing the values in the items before 
		 * calling the method rearranging
		 */
		for(int item:items)
		{
			// Prints the items of the list
			System.out.println(item);
		}
		
		//calling the rearranging method
		Rearranging.rearranging(items);
		/*
		 * printing the values in the items after 
		 * calling the method rearranging
		 */
		for(int item:items)
		{
			// Prints the items of the list
			System.out.println(item);
		}
	}
}