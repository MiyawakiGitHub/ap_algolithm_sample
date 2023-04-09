package ShellSort;

import java.util.Arrays;
import java.util.Random;

/*
 * このプログラムでは、シェルソートを実装しています。
 * シェルソートは、配列を一定間隔（間隔をソート間隔と呼びます）で分割し、
 * それぞれの部分配列に対して挿入ソートを実行することで、配列をソートします。
 * shellSortメソッドでは、ソート間隔を設定し、挿入ソートを実行します。
 * gapを配列サイズの半分からスタートし、挿入ソートを実行するたびに、
 * gapを半分にして間隔を縮小していきます。挿入ソートでは、間隔gapごとに部分配列をソートします。内部ループでは、現在の要素を退避し、それ以前の部分配列を逆方向にスキャンし、挿入位置を見つけます。そして、現在の要素をその挿入位置に挿入します。
 */
public class ShellSort {

    public static void main(String[] args) {
        // ラムダ式を使用して、0から99までの数値をランダムに抽出して、配列に格納する
        int[] arr = new int[15];
        Random random = new Random();
        Arrays.setAll(arr, i -> random.nextInt(100));
        
        System.out.println("Original Array: " + Arrays.toString(arr));
        shellSort(arr,5);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    public static void shellSort(int[] arr, int gap) {
        int n = arr.length;
        System.out.println("Initial Array: " + Arrays.toString(arr));

        // 並び替えに使用する間隔を設定する
        for (int i = gap; i > 0; i /= 2) {

            // 挿入ソートを間隔ごとに実行する
            for (int j = i; j < n; j++) {
                int temp = arr[j];
                int k;
                for (k = j; k >= i && arr[k - i] > temp; k -= i) {
                    arr[k] = arr[k - i];
                }
                arr[k] = temp;
            }

            System.out.println("Array after gap " + i + " sort: " + Arrays.toString(arr));
        }
    }
}
