/**
 * 
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author downey
 *
 */
public class SelectionSort {

	/**
	 * Swaps the elements at indexes i and j.
	 */
	public static void swapElements(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * Finds the index of the lowest value
	 * between indices low and high (inclusive).
	 */
	public static int indexLowest(int[] array, int start) {
		int lowIndex = start;
		for (int i = start; i < array.length; i++) {
			if (array[i] < array[lowIndex]) {
				lowIndex = i;
			}
		}
		return lowIndex;
	}

	/**
	 * Sorts the cards (in place) using selection sort.
	 */
	public static void selectionSort(int[] array,String fileName) {
		long timeBefore = System.currentTimeMillis();
		for (int i = 0; i < array.length; i++) {
			int j = indexLowest(array, i);
			swapElements(array, i, j);
		}
		long timeAfter = System.currentTimeMillis();
		long length = timeAfter - timeBefore;
		System.out.println(fileName + " ran for " + String.valueOf(length) + " ms ");
	}

	/**
	 * @param args
	 * @return 
	 */
	public static int[] fileToArray(String fileName) {
		int[] array = {};
		int count = 0;
		int i = 0;
	    try (Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)))) {
	    	while (sc.hasNextLine()) {
	    		array = Arrays.copyOf(array, array.length + 1);
	    		array[array.length - 1] = sc.nextInt();
	    	}
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return array;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		selectionSort(fileToArray("FiveHundred.txt"),"FiveHundred.txt");
		selectionSort(fileToArray("OneThousand.txt"),"OneThousand.txt");
		selectionSort(fileToArray("FiveThousand.txt"),"FiveThousand.txt");
		selectionSort(fileToArray("EightThousand.txt"),"EightThousand.txt");
		selectionSort(fileToArray("TenThousand.txt"),"TenThousand.txt");
	}

}
