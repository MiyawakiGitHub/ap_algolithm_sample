package selectionSort;

/*
 * このプログラムでは、整数型の配列を選択ソートでソートしています。
 * まず、配列内で最小の要素を探し、その要素を配列の先頭の要素と交換します。
 * その後、先頭を除いた部分配列の中で最小値を探し、配列の2番目の要素と交換します。
 * このように、配列の要素を1つずつソートしていきます。
 * 最後に、ソートされた配列を出力します。
 */


public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 11 };
        int n = arr.length;

        // 配列をソート
        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }

        // ソートされた配列を出力
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}