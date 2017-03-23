import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{2, 52, 784, 41, 75, 8, 0, 11};
        System.out.println("Array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        int[] resultedArray = sortMergeRecursive(array);
        System.out.println();
        System.out.println("Merge Sort: resulted array ");
        for (int i = 0; i < resultedArray.length; i++) {
            System.out.print(resultedArray[i] + " ");
        }
    }
    public static int[] sortMergeRecursive(int[] array) {
        if (array.length < 2) return array;
        int middle = array.length / 2;
        int [] array1 = sortMergeRecursive(Arrays.copyOfRange(array, 0, middle));
        int [] array2 = sortMergeRecursive(Arrays.copyOfRange(array, middle,array.length));
        return mergeSort(array1,array2);
    }

    public static int[] mergeSort(int[] array1, int[] array2) {
        int a = 0;
        int b = 0;
        int[] resultedArray = new int[array1.length+array2.length];
        for (int i = 0; i < resultedArray.length; i++) {
            if (b < array2.length && a < array1.length) {
                if (array1[a] > array2[b]) {
                    resultedArray[i] = array2[b];
                    b++;
                }
                else {
                    resultedArray[i] = array1[a];
                    a++;
                }
            } else if (b < array2.length) {
                resultedArray[i] = array2[b];
                b++;
            } else {
                resultedArray[i] = array1[a];
                a++;
            }
        }
        return resultedArray;
    }
}
