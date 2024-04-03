package hackerrank.algorithms.subdomains.s02_implementation;

public class Q24E_CatsAndAMouse {
    static String catAndMouse(int x, int y, int z) {
        // determine which cat will reach the mouse first
        // absolute units because of x-axis
        int unitsCatA = Math.abs(z - x);
        int unitsCatB = Math.abs(z - y);
        // conditional return
        if(unitsCatA < unitsCatB) return "Cat A";
        else if (unitsCatA > unitsCatB) return "Cat B";
        else return "Mouse C";

    }
}
