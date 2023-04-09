package InsertionSort;
/*このプログラムでは、整数型の配列を挿入ソートでソートしています。
 * まず、配列の2番目の要素から開始し、挿入するべき要素を決定します。
 * 次に、挿入する位置を探索するために、
 * 先行するソートされた部分配列を逆方向にスキャンします。
 * 適切な位置が見つかったら、要素を挿入します。
 * この操作を配列全体に対して繰り返し行うことで、最終的に配列がソートされます。
 * 最後に、ソートされた配列を出力します。
 * 
 * 挿入ソートの時間計算量は、最良の場合O(n)、
 * 平均と最悪の場合はO(n^2)となります。
 * 具体的には、内部ループがn-1から始まり、
 * 最悪の場合は各ループでi回の比較が行われます。
 * したがって、最悪の場合の計算量はO(n^2)となります。
 * ただし、配列が部分的にソートされている場合、内部ループでの比較が減るため、
 * 実行時間が短くなることがあります。
 */

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
    public static void main(String[] args) {

        // ラムダ式を使用して、0から99までの数値をランダムに抽出して、配列に格納する
        int[] arr = new int[5];
        Random random = new Random();
        Arrays.setAll(arr, i -> random.nextInt(100));
        
        int n = arr.length;

        // 配列をソート
        for (int i = 1; i < n; ++i) {
            // ソートされた配列を出力
            for (int k = 0; k < n; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();

            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {

 
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;

        }

        // ソートされた配列を出力
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
