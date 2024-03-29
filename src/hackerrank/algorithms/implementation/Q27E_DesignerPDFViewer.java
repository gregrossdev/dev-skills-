package hackerrank.algorithms.implementation;

import java.util.List;

public class Q27E_DesignerPDFViewer {
    public static int designerPdfViewer(List<Integer> h, String word) {
        // determine the area of the rectangle highlight in assuming all letters arewide.
        // by finding tallest letter value and multiplying by the word length
        int tallest = 0;
        // loop through word and find tallest letter
        for (char letter : word.toCharArray()) {
            int idx = letter - 'a'; // 'a' is 97
            tallest = Math.max(tallest, h.get(idx));
        }

        return tallest * word.length();
    }
}
