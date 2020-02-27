/* Name: William Usdane
 * Class ID: 434
 * Assignment 2
 * Description: A class files that will take numbers and put them into an integer
 * array of 10 elements
 */
package assign2;

/* A class that will take in variables and add them to an array, remove them from the 
 * same array, and print it out as a string
 */
public class SimpleList {
	//Initializes the integers for the class
	private int count;
	private int max;
	private int[] list;
	
	//Initializing SimpleList and initializing variables
	SimpleList(){
		/*Initializes int count as 0 and 
		 * int array list to have 10 elements
		*/
		count = 0;
		max = 10;
		list = new int[10];
		
		//Exits the function
		return;
	}
	
	//Function to add an element to list
	public void add(int num) {
		/*Checks to see if count is at it's max
		 * if it is, it will increase the max by 50%,
		 * then it will create a new array with the new
		 * max and transfer over the elements
		*/
		if(count == max) {
			max = max + max/2;
			int[] temp = list;
			list = new int[max];
			
			for(int i = 0; i < count; i++) {
				list[i] = temp[i];
			}
		}
		
		/*Goes through the list and moves the
		 * elements up one slot in the array
		 */
		if(count != 0) {
			for(int index = count; index > 0; index--) {
				list[index] = list[index - 1];
			}
		}
		
		//Sets the first index as the given number
		list[0] = num;
		
		//Increases the count
		count++;
		
		//Exits the function
		return;
	}
	
	
	//Returns the int count
	public int count() {
		//Returns the int count
		return count;
	}
	
	
	//Returns list as a string w/ " " in between each integer
	public String toString() {
		if(count == 0) {
			return null;
		}
		//Sets the first element of list into the display string
		String display = Integer.toString(list[0]);
		
		//Runs through the list and adds them to the string w/ " "
		for(int index = 1; index < count; index++) {
			display = display + " " + Integer.toString(list[index]);
		}
		
		//Exits functions and returns the formatted list
		return display;
	}
	
	//Searches for the index of the given value
	int search(int num) {
		//Initializes the variables for the function
		int place = -1;
		int index = 0;
		
		//Goes through the list
		do {
			/*Gives int place an index value if the
			 * number is found
			 */
			if(list[index] == num) {
				place = index;
			}
			
			//Increments the counter through the list
			index++;
		/*Stops the search if the number is found or it
		 * goes through the whole list
		 */
		}while(place == -1 && index < count); 
		
		//Exits function and returns int place
		return place;
	}

	/*Removes the number and moves the list over, if
	 *  the number is in the array
	 */
	void remove(int num) {
		//Uses the search function to find the number
		int place = search(num);
		
		/*If the index of the number is found, it will
		 * remove that number and shift the list over
		 */
		if(place != -1) {
			count--;
			for(int index = place; index < count; index++) {
				list[index] = list[index + 1];
			}
		}
		
		//Exits the function
		return;
	}
}
