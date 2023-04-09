package BinarySearch;


/*
 * このプログラムは、与えられたソート済み配列から目標の要素を2分探索で検索し、
 * そのインデックスを返します。
 * binarySearch()メソッドは、配列と目標の要素を引数として受け取り、
 * 配列の中央の要素と目標の要素を比較して大小関係を判定し、
 * 探索範囲を狭めていきます。
 * もし目標の要素が見つからなかった場合は、-1を返します。 
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int target = 8;
        int index = binarySearch(arr, target);

        if (index == -1) {
            System.out.println("Target element not found in the array.");
        } else {
            System.out.println("Target element found at index: " + index);
        }
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
