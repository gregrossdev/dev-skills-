package hackerrank.algorithms.subdomains.s02_implementation;

public class Q35E_JumpingOnTheCloudsRevisited {
    public static int jumpingOnClouds(int[] c, int k) {
        int n = c.length;
        int energy = 100; // Initial energy level
        int i = 0; // Start from the first cloud

        // Simulate the jumps through the clouds
        do {
            i = (i + k) % n; // Move to the next cloud after k steps
            energy--; // Decrease energy by 1 for each jump
            if (c[i] == 1) {
                // If the cloud is a thundercloud, decrease energy by an additional 2 units
                energy -= 2;
            }
        } while (i != 0); // Repeat until reaching the starting cloud

        return energy;
    }
}