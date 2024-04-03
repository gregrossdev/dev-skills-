package hackerrank.algorithms.subdomains.s02_implementation;

public class Q21E_DrawingBook {
    public static int pageCount(int n, int p) {
        int fromStart = p / 2; // Number of pages turned from the start
        int fromEnd = n / 2 - p / 2; // Number of pages turned from the end (Total pages from start - pages from start)
        return Math.min(fromStart, fromEnd); // Return the minimum of pages turned
    }
}
