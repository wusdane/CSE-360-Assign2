/* Name: William Usdane
 * Class ID: 434
 * Assignment 2
 * Description: A class files that will take numbers and put them into an integer
 * array of 10 elements & will remove and add more integers.  This class will also
 * increase or decrease the size accordingly to if there is not enough spaces or too
 * many.
 * URL: https://github.com/wusdane/CSE-360-Assign2
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
	
	//Function to add an element to the front of the list
	public void add(int num) {
		/*Checks to see if count is at it's max
		 * if it is, it will increase the max by 50%,
		 * then it will create a new array with the new
		 * max and transfer over the elements
		*/
		if(count == max) {
			/*Checks if the max is odd or even &
			 * increases size accordingly & will add 1 to
			 * an odd number to make the max even
			 */
			if(max % 2 == 0) {
				max = max + max / 2;
			}else {
				max = max + max / 2 + 1;
			}
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
	
	//Function to add an element to the end of the list
	public void append(int num) {
		/*Checks to see if count is at it's max
		 * if it is, it will increase the max by 50%,
		 * then it will create a new array with the new
		 * max and transfer over the elements
		*/
		if(count == max) {
			/*Checks if the max is odd or even &
			 * increases size accordingly & will add 1 to
			 * an odd number to make the max even
			 */
			if(max % 2 == 0) {
				max = max + max / 2;
			}else {
				max = max + max / 2 + 1;
			}
			int[] temp = list;
			list = new int[max];
			
			for(int i = 0; i < count; i++) {
				list[i] = temp[i];
			}
		}
		
		//Sets the last index as the given number
		list[count] = num;
			
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
	
	//Returns the int max
	public int size() {
		//Returns the int max
		return max;
	}
	
	//Returns the first element
	public int first() {
		//Checks to see if there are any elements in the list
		int element = -1;
		
		//Grabs first element
		if(count != 0) {
			element = list[0];
		}
		
		//Returns not found or the element
		return element;
	}
	
	//Returns the last element
	public int last() {
		//Checks to see if there are any elements in the list
		int element = -1;
		
		//Grabs last element
		if(count != 0) {
			element = list[count - 1];
		}
		
		//Returns not found or the element
		return element;
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
	 *  the number is in the array & reduces the size
	 *  of the array if applicable
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
		
		//Decreases the max if it has more than 25% unused space
		if(count * 100 < max * 75 && count != 0) {
			max = count;
			int[] temp = list;
			list = new int[max];
			
			for(int i = 0; i < count; i++) {
				list[i] = temp[i];
			}
		//Checks if count is empty & will reduce the max to 1	
		}else if(count * 100 < max * 75 && count == 0) {
			max = 1;
			list = new int[1];
		}
		
		//Exits the function
		return;
	}
}
