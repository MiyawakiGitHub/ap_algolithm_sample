package selectionSort;

import java.util.Arrays;
import java.util.Random;

/*
 * このプログラムでは、整数型の配列を選択ソートでソートしています。
 * まず、配列内で最小の要素を探し、その要素を配列の先頭の要素と交換します。
 * その後、先頭を除いた部分配列の中で最小値を探し、配列の2番目の要素と交換します。
 * このように、配列の要素を1つずつソートしていきます。
 * 最後に、ソートされた配列を出力します。
 * 
 * 選択ソートの時間計算量は、最良・平均・最悪の場合ともにO(n^2)となります。
 * 具体的には、内部ループがn-1から始まり、
 * 最悪の場合は各ループでn-i-1回の比較が行われます。
 * したがって、最悪の場合の計算量はO(n^2)となります。
 * ただし、選択ソートは内部ループで交換を行う必要がないため、
 * バブルソートよりも実行時間が短くなる場合があります。
 */


public class SelectionSort {
    public static void main(String[] args) {
        // ラムダ式を使用して、0から99までの数値をランダムに抽出して、配列に格納する
        int[] arr = new int[5];
        Random random = new Random();
        Arrays.setAll(arr, i -> random.nextInt(100));
        
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