import java.util.Arrays;
import java.util.LinkedList;

public class SortingAlgorithms {

	public int[] selection(int[] arr) 
	{
		System.out.println("\nSorting by selection in ascending order...\n");
		for (int i = 0; i < arr.length - 1; i++) 
		{
			int min = i; 
			for (int a = i + 1; a < arr.length; a++) 
			{ 
				if (arr[a] < arr[min]) 
				{ 
					min = a;
				}
				
			}
			int temparray = arr[min];
			arr[min] =  arr[i]; 
			arr[i] = temparray;
			
			System.out.println(Arrays.toString(arr));	
		}
		return arr;
	}
	
	public int[] selectionDescending(int[] arr) 
	{
		System.out.println("\nSorting by selection in descending order...\n");
		for (int i = 0; i < arr.length - 1; i++) 
		{
			int max = i; 
			for (int a = i + 1; a < arr.length; a++) 
			{ 
				if (arr[a] > arr[max]) 
				{ 
					max = a;
				}
				
			}
			int temparray = arr[max];
			arr[max] =  arr[i]; 
			arr[i] = temparray;
			
			System.out.println(Arrays.toString(arr));	
		}
		
		return arr;
	}
		
	public int[] insertion(int[] arr) 
	{
		System.out.println("\nSorting by insertion in ascending order...\n");
		for (int i = 1; i < arr.length; i++) {
			int t = arr[i];
			int j = i - 1;
			
			while (j >= 0 && arr[j] > t) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = t;
			System.out.println(Arrays.toString(arr));
		}
		
		return arr;
	}
	
	public int[] insertionDescending(int[] arr) 
	{
		System.out.println("\nSorting by insertion in descending order...\n");
		for (int i = 1; i < arr.length; i++) {
			int current = arr[i];
			int j = i - 1;
			
			while (j >= 0 && arr[j] < current) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = current;
			System.out.println(Arrays.toString(arr));
		}
		
		return arr;
	}
	
	private void merge(int[] arr, int[] tempArr, int first, int mid, int last) {
		int half1start = first;
		int half1end = mid;
		int half2start = mid + 1;
		int half2end = last;
		int index = half1start;
		
		while ((half1start <= half1end) && (half2start <= half2end))
		{
			if (arr[half1start] < arr[half2start])
			{
				tempArr[index] = arr[half1start];
				half1start++;	
			}
			else
			{
				tempArr[index] = arr[half2start];
				half2start++;
			}
			index++;
			}
		
		if (half1start > half1end)
			System.arraycopy(arr, half2start, tempArr, index, half2end - half2start + 1);
		else
			System.arraycopy(arr, half1start, tempArr, index, half1end - half1start + 1);
		System.arraycopy(tempArr, first, arr, first, last - first + 1);
		}
	
	public void mergeSort(int[] arr, int[] tempArr, int first, int last) {
		
		if (first < last)
		{
			int mid = (first + last) / 2;
			
			mergeSort(arr, tempArr, first, mid);
			mergeSort(arr, tempArr, mid + 1, last);
			
			merge(arr, tempArr, first, mid, last);
		}
	}
	
	static void swap(LinkedList<Person> ll, int i, int j) {
		
		Person temp = ll.get(i);
		ll.set(i, ll.get(j));
		ll.set(j, temp);
	}
	
	static int partitionAge(LinkedList<Person> ll, int low, int high) {
		
		CompareAge c = new CompareAge();
		
		
		int i = (low - 1);
		
		for(int j = low; j<= high - 1; j++) {
			
			if(c.compare(ll.get(j), ll.get(high)) > 1) {
				i++;
				swap(ll, i, j);
			}
		}
		swap(ll, i + 1, high);
		return (i + 1);
	}
	
	static int partitionName(LinkedList<Person> ll, int low, int high) {
		
		CompareName c = new CompareName();
		
		int i = (low - 1);
		
		for(int j = low; j<= high - 1; j++) {
			
			if(c.compare(ll.get(j), ll.get(high)) > 1) {
				i++;
				swap(ll, i, j);
			}
		}
		swap(ll, i + 1, high);
		return (i + 1);
	}
	
	static void quickSortAge(LinkedList<Person> ll, int low, int high) {
		
		if (low < high) {
			int pi = partitionAge(ll, low, high);
			
			quickSortAge(ll, low, pi - 1);
			quickSortAge(ll, pi + 1, high);
		}
	}
	
	static void quickSortName(LinkedList<Person> ll, int low, int high) {
		
		if (low < high) {
			int pi = partitionName(ll, low, high);
			
			quickSortName(ll, low, pi - 1);
			quickSortName(ll, pi + 1, high);
		}
	}
	
	
	static void printLL(LinkedList<Person> ll, int size) {
		
		for(int i = 0; i < size; i++)
			System.out.println(ll.get(i).getName() + " " + ll.get(i).getAge());

		System.out.println();
	}
	
	
}

