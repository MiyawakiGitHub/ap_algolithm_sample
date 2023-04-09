package KMP;


/*
 * このコードは、kmpSearch関数を使って、
 * 与えられたテキスト内にパターンが存在するかどうかを検索し、
 * パターンが見つかった場合はそのインデックスを返します。
 * 最初に、buildLPS関数を使ってパターンの最長接頭辞・接尾辞テーブルを作成します。
 * 次に、テキストとパターンを比較して、
 * マッチしない場合にLPSテーブルを利用してパターンを適切な位置にスキップします。
 */

public class KMP {

    private static int[] buildLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int j = 0;
        int i = 1;

        lps[0] = 0;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }

    public static int kmpSearch(String text, String pattern) {
        if (pattern.isEmpty()) {
            return 0;
        }

        int[] lps = buildLPS(pattern);
        int j = 0;

        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = lps[j - 1];
            }

            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }

            if (j == pattern.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";

        int index = kmpSearch(text, pattern);

        if (index == -1) {
            System.out.println("Pattern not found");
        } else {
            System.out.println("Pattern found at index " + index);
        }
    }
}