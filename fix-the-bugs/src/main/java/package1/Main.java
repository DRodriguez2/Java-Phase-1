package package1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static ArrayList<Integer> arrlist = new ArrayList<Integer>();
	private static ArrayList<Integer> expenses = new ArrayList<Integer>();

	public static void main(String[] args) {
		/* System.out.println("Hello World!"); */
		System.out.println("\n**************************************\n");
		System.out.println("\tWelcome to TheDesk \n");
		System.out.println("**************************************");
		addSampleExpeditures();
		optionsSelection();

	}

	private static void addSampleExpeditures() {
		expenses.add(1000);
		expenses.add(2300);
		expenses.add(45000);
		expenses.add(32000);
		expenses.add(110);
	}

	private static void optionsSelection() {
		String[] arr = { "1. I wish to review my expenditure", "2. I wish to add my expenditure",
				"3. I wish to delete my expenditure", "4. I wish to sort the expenditures",
				"5. I wish to search for a particular expenditure", "6. Close the application" };
		int[] arr1 = { 1, 2, 3, 4, 5, 6 };
		int slen = arr1.length;
		for (int i = 0; i < slen; i++) {
			System.out.println(arr[i]);
			// display the all the Strings mentioned in the String array
		}

		expenses.addAll(arrlist);
		System.out.println("\nEnter your choice:\t");
		Scanner sc = new Scanner(System.in);
		int options = sc.nextInt();
		for (int j = 1; j <= slen; j++) {
			if (options == j) {
				switch (options) {
				case 1:
					System.out.println("Your saved expenses are listed below: \n");
					System.out.println(expenses + "\n");
					optionsSelection();
					break;
				case 2:
					System.out.println("Enter the value to add your Expense: \n");
					int value = sc.nextInt();
					expenses.add(value);
					System.out.println("Your value is updated\n");
					expenses.addAll(arrlist);
					System.out.println(expenses + "\n");
					optionsSelection();

					break;
				case 3:
					System.out.println(
							"You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
					int con_choice = sc.nextInt();
					if (con_choice == options) {
						expenses.clear();
						System.out.println(expenses + "\n");
						System.out.println("All your expenses are erased!\n");
					} else {
						System.out.println("Oops... try again!");
					}
					optionsSelection();
					break;
				case 4:
					sortExpenses(expenses);
					optionsSelection();
					break;
				case 5:
					searchExpenses(expenses);
					optionsSelection();
					break;
				case 6:
					closeApp();
					break;
				default:
					System.out.println("You have made an invalid choice!");
					break;
				}
			}
		}

	}

	private static void closeApp() {
		System.out.println("Closing your application... \nThank you!");
	}

	/**
	 * Simple linear search algorithm that iterates through the array list searching
	 * for the item.
	 * 
	 * @param arrayList
	 */
	private static void searchExpenses(ArrayList<Integer> arrayList) {
		System.out.println("Enter the expense you need to search:\t");
		Scanner sc = new Scanner(System.in);
		int value = sc.nextInt();
		boolean found = false;
		for (int i = 0; i < arrayList.size(); i++) {
			if (arrayList.get(i) == value) {
				System.out.println("Value found at index: " + i);
				found = true;
			}
		}

		if (found)
			return;
		else
			System.out.println("Value not found.");

	}

	/**
	 * Uses a quick sort to sort array  list.
	 * 
	 * @param arrayList
	 */
	private static void sortExpenses(ArrayList<Integer> arrayList) {
		System.out.print("Expenses sorted with quicksort: ");  
		quickSort(arrayList, 0,  arrayList.size()-1);
		arrayList.forEach(i -> System.out.print(i +  " "));
		System.out.println();

	}

	/**
	 * Swaps the values at 2 indices in an array list.
	 * 
	 * @param arrayList
	 * @param i
	 * @param j
	 */
	private static void swap(ArrayList<Integer> arrayList, int i, int j) {
		int temp = arrayList.get(i);
		arrayList.set(i, arrayList.get(j));
		arrayList.set(j, temp);
	}

	/**
	 * Basic implementation for quick sort algorithm on an array list.
	 * Uses partition() method to put the pivot in the correct place then  
	 * recursive calls quick sort on left and right sides of the  pivot. 
	 * @param arrayList
	 * @param low
	 * @param high
	 */
	private static void quickSort(ArrayList<Integer> arrayList, int low, int high) {

		if (low < high) {
			int pivot = partition(arrayList, low, high);

			quickSort(arrayList, low, pivot - 1);
			quickSort(arrayList, pivot + 1, high);
		}

	}
	
	/**
	 * Partition method for placing the pivot in the correct place by moving elements
	 * less than the pivot to the left of the pivot and elements greater than the pivot
	 * to the right of the pivot. 
	 * Returns the position of the pivot after it is in the correct place.
	 * For this implementation the pivot always is the right most element within the partition range.
	 * @param arrayList
	 * @param low
	 * @param high
	 * @return
	 */
	private static int partition(ArrayList<Integer> arrayList, int low, int high) {
		
		int pivot = arrayList.get(high);
		int  pointer = low - 1;
		
		for(int i = low; i <= high - 1; i++) {
			if(arrayList.get(i) < pivot) {
				pointer += 1;
				swap(arrayList, pointer, i);
			}
		}
		pointer += 1; 
		swap(arrayList, pointer, high);
		
		return pointer;

	}

}
