import java.util.Arrays;

public class SelectionSort{

	public static void selection(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			int min = arr[i];
			int minloc = i;
			for(int j = i; j < arr.length; j++) {
				if (arr[j] < min) {
					min = arr[j];
					minloc = j;

				}
			}
			swap(i, minloc, arr);
		}
	}

	// Swap 2 elements in one array
	public static void swap(int loc, int end, int[] arr) {
		int tmp = arr[loc];
		arr[loc] = arr[end];
		arr[end] = tmp;
	}

	// Generate a TRUE sorted array
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}


	// Generate a random array for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random() - (int) (maxValue + 1) * Math.random());
		}
		return arr;
	}

	// copy array
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// compare two arrays; iff two array is equal, return true
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// print every element in one array
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// tester
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			selection(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		selection(arr);
		printArray(arr);
	}				
}