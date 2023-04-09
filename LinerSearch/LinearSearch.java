package LinerSearch;

/*
 * このプログラムは、与えられた配列から目標の要素を線形探索で検索し、
 * そのインデックスを返します。
 * linearSearch()メソッドは、配列と目標の要素を引数として受け取り、
 * 配列の先頭から順に要素を検索して目標の要素が見つかった場合はそのインデックスを返します。
 * もし目標の要素が見つからなかった場合は、-1を返します。
 */

public class LinearSearch {

    public static void main(String[] args) {
        int[] arr = { 5, 1, 4, 2, 8, 7, 3, 6, 10, 9 };
        int target = 8;
        int index = linearSearch(arr, target);

        if (index == -1) {
            System.out.println("Target element not found in the array.");
        } else {
            System.out.println("Target element found at index: " + index);
        }
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }
}
