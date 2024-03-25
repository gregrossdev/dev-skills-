package hackerrank.algorithms.implementation;

public class Q23E_ElectronicsShop {
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        // determine most expensive keyboard and usb drive within a given budget
        int max = -1;

        // loop through both lists and check all combinations
        for (int keyboardPrice : keyboards) {
            for (int drivePrice : drives) {
                int price = keyboardPrice + drivePrice;

                if (price <= b && price > max)
                    max = price;
            }
        }

        return max;
    }
}
