package BubbleSort;

import java.util.Arrays;
import java.util.Random;

/*
 * このプログラムでは、整数型の配列をバブルソートでソートしています。
 * まず、隣り合う2つの要素を比較し、必要に応じて交換します。
 * この操作を配列全体に対して繰り返し行い、最後には配列がソートされます。
 * 最後に、ソートされた配列を出力します。
 *
 * バブルソートの時間計算量は、最良の場合でもO(n)、
 * 平均と最悪の場合はO(n^2)となります。
 * 具体的には、内部ループがn-1から始まり、
 * 最悪の場合は各ループでn-i-1回比較と交換が行われるため、
 * n(n-1)/2回の比較と交換が行われます。
 * したがって、最悪の場合の計算量はO(n^2)となります。
 */
public class BubbleSort {
    public static void main(String[] args) {
        // ラムダ式を使用して、0から99までの数値をランダムに抽出して、配列に格納する
        int[] arr = new int[5];
        Random random = new Random();
        Arrays.setAll(arr, i -> random.nextInt(100));
        
        int n = arr.length;

        // 配列をソート
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        // ソートされた配列を出力
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}