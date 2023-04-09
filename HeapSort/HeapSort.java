package HeapSort;

import java.util.Arrays;

/*
 * このプログラムは、与えられた配列をヒープソートでソートします。
 * heapSort()メソッドは、与えられた配列をヒープ構造に変換し、
 * ヒープ構造のルート要素を配列の末尾と交換していきます。
 * heapify()メソッドは、与えられた配列をヒープ構造に変換するためのメソッドで、
 * 与えられた配列の先頭要素をルートノードとして、それ以下の部分木をヒープ構造に変換します。このプログラムの出力は以下のようになります。
 */

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = { 5, 1, 4, 2, 8, 7, 3, 6, 10, 9 };
        System.out.println("Original Array: " + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }
}



