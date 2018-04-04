package com.es2.blackboxpartitioning;

public class ArrayUtils
{	

	/**
	 * Find index of the minimum value
	 * @param list receives the list of values
	 * @return index of minimum element of array
	 */
	public static int findMin(int[] list)
	{	
		if(!(list != null && list.length > 0)) throw new AssertionError("failed precondition");

		int indexOfMin = 0;
		for(int i = 1; i < list.length; i++)
		{	if(list[i] < list[indexOfMin])
			{	indexOfMin = i;
			}
		}

		return indexOfMin;
	}


	/**
	 * Resize array (with errors)
	 * @param list receives the list of values
	 * @param newSize the new array size
	 * pre: list != null, newSize >= 0
	 * post: nothing. the method does not succeed it resizing the
	 * argument
	 */
	public static void badResize(int[] list, int newSize)
	{	
		if(!(list != null && newSize >= 0)) throw new AssertionError("failed precondition");

		int[] temp = new int[newSize];
		int limit = Math.min(list.length, newSize);

		for(int i = 0; i < limit; i++)
		{	temp[i] = list[i];
		}

		// Changing pointer, not pointee. This breaks the
		// relationship between the parameter and argument
		list = temp;
	}


	/**
	 * Resize an array
	 * @param list receives the list of values
	 * @param newSize the new array size
	 * pre: list != null, newSize >= 0
	 * @returns the new list
	 */
	public static int[] goodResize(int[] list, int newSize)
	{	
		if(!(list != null && newSize >= 0)) throw new AssertionError("failed precondition");

		int[] result = new int[newSize];
		int limit = Math.min(list.length, newSize);

		for(int i = 0; i < limit; i++)
		{	result[i] = list[i];
		}

		return result;
	}


	/**
	 * Prints out the indices and values of all pairs of numbers in list such that list[a] + list[b] = target
	 * @param list receives the list of values
	 * pre: list != null
	 */
	public static void findAndPrintPairs(int[] list, int target)
	{	
		if(!(list != null)) throw new AssertionError("failed precondition");

		for(int i = 0; i < list.length; i++)
		{	for(int j = i + 1; j < list.length; j++)
			{	if(list[i] + list[j] == target)
				{	System.out.println("The two elements at indices " + i + " and " + j
						+ " are " + list[i] + " and " + list[j] + " add up to " + target);
				}
			}
		}
	}


	/**
	 * Sort the elements of list so that they are in ascending order
	 * @param list receives the list of values
	 * pre: list != null;
	 */
	public static void bubblesort(int[] list)
	{
		if(!(list != null)) throw new AssertionError("failed precondition");

		int temp;
		boolean changed = true;
		for(int i = 0; i < list.length && changed; i++)
		{	changed = false;
			for(int j = 0; j < list.length - i - 1; j++)
			{	assert (j > 0) && (j + 1 < list.length) : "loop counter j " + j +
					"is out of bounds.";
				if(list[j] > list[j+1])
				{	changed = true;
					temp = list[j + 1];
					list[j + 1] = list[j];
					list[j] = temp;
				}
			}
		}

		assert isAscending( list );
	}

	/**
	 * Prints the list of values
	 * @param list receives the list of values
	 */
	public static void showList(int[] list)
	{	for(int i = 0; i < list.length; i++)
			System.out.print( list[i] + " " );
	}

	/**
	 *  @param list receives the list of values
	 *  	pre: list != null
	 *  @return Return true if list is sorted in ascending order, false otherwise 
	*/
	public static boolean isAscending( int[] list )
	{	boolean ascending = true;
		int index = 1;
		while( ascending && index < list.length )
		{	assert index >= 0 && index < list.length;

			ascending = (list[index - 1] <= list[index]);
			index++;
		}

		return ascending;
	}
}
