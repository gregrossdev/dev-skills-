package hackerrank.algorithms.subdomains.s02_implementation;

public class Q28E_UtopianTree {
    public static int utopianTree(int n) {
        // how tall after n cycles ?
        // initial height = 1;
        int height = 1;
        // first the size doubles and then increases by +1
        for (int period = 0; period < n; period++) {
            if(period % 2 == 0) height += height;
            else height += 1;
        }

        return height;
    }
}
