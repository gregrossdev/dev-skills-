package hackerrank.algorithms.subdomains;

import java.util.*;

public class Easy {
    /*
     * Warmup
     **********/

    // 01. Solve Me First
    public static int solveMeFirst(int a, int b) {
        // Hint: Type return a+b; below
        return a + b;
    }

    // 02. Simple Array Sum
    public static int simpleArraySum(List<Integer> ar) {
        // find the sum by adding all elements
        int sum = 0;
        // input: [1,2,3,4,10,11]
        // output: 33
        // example: 1 + 2 + 3 + 4 + 10 + 11 = 33
        // for each integer from list, add to sum
        for (Integer num : ar) {
            // 33 = 1 + 2 + 3 + 4 + 10 + 11
            sum += num;
        }

        // return 33;
        return sum;
    }

    // 03. Compare the Triplets
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        // compare each list item index
        // input: a = [5, 6, 7], b = [3, 6, 10]
        // output: [1, 1]
        List<Integer> score = new ArrayList<>();
        int aliceScore = 0;
        int bobScore   = 0;
        // if a[index] > b[index] alice scores a point
        // if a[index] < b[index] bob scores a point
        // if a[index] = b[index] neither scores a point
        for (int idx = 0; idx < a.size(); idx++) {
            int alice = a.get(idx);
            int bob  = b.get(idx);
            if(alice > bob) aliceScore++;
            if(alice < bob) bobScore++;
        }

        score.add(aliceScore);
        score.add(bobScore);
        // return [aliceScore, bobScore]

        return score;
    }

    // 04. A Very Big Sum
    public static long aVeryBigSum(List<Long> ar) {
        // calculate and print sum of elements in array
        // input: [1000000001, 1000000002, 1000000003, 1000000004, 1000000005]
        // output: 5000000015
        long sum = 0;
        // sum each long value in array
        for (Long value: ar) {
            sum += value;
        }

        // return sum of elements
        return sum;
    }

    // 05. Diagonal Difference
    public static int diagonalDifference(List<List<Integer>> arr) {
        // calculate the absolute difference between the sums of its diagonals
        // input: [[11, 2,   4],
        //         [04, 5,   6],
        //         [10, 8, -12]]
        // output: 15
        int ltr = 0;
        int rtl = 0;
        int n = arr.size();
        for (int idx = 0; idx < arr.size(); idx++) {
            // ltr diagonal ltr = 11 + 5 + -12
            // ltr = [ltr[0] + ltr[1] + ltr[2]]
            // ltr = 04
            ltr += arr.get(idx).get(idx);
            // rtl diagonal rtl =  4 + 5 + 10
            // rtl = [rtl[2] + rtl[1] + rtl[0]]
            // rtl = 19
            // (3 - 1) - 0 = 2
            // (3 - 1) - 1 = 1
            // (3 - 1) - 2 = 0
            rtl += arr.get(idx).get((n - 1) - idx);

            // rtl += arr.get(idx).get(Math.abs(idx - (n - 1)));

        }

        // return absolute difference from ltr to rtl
        // 04 - 19 = -15
        // absolute diff = 15
        return Math.abs(ltr - rtl);

    }

    // 06. Plus Minus
    public static void plusMinus(List<Integer> arr) {
        // calculate the ratios of its elements that are positive, negative, and zero.
        // input: [-4, 3, -9, 0, 4, 1]
        // output:
        //----------
        // postive values / number of values
        // System.out.println(0.500000)
        // negative values / number of values
        // System.out.println(0.333333)
        // zero values / number of values
        // System.out.println(0.166667)
        //--------------------------------------------------
        int totalValues = arr.size();
        double positiveValues = 0;
        double negativeValues = 0;
        double zeroValues     = 0;

        for (int idx = 0; idx < totalValues; idx++) {
            int value = arr.get(idx);
            if(value > 0) positiveValues++;
            else if (value < 0) negativeValues++;
            else zeroValues++;
        }

        System.out.println(String.format("%.6f", positiveValues/totalValues));
        System.out.println(String.format("%.6f", negativeValues/totalValues));
        System.out.println(String.format("%.6f",     zeroValues/totalValues));

    }

    // 07. Staircase
    public static void staircase(int n) {
        // print a staircase of size n
        // staircase draws from rtl
        // n = height
        int height = n;
        for (int i = 1; i <= height; i++) {
            for(int j = 1; j <= height - i; j++){
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }

    }

    // 08. Mini-Max Sum
    public static void miniMaxSum(List<Integer> arr) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        long totalSum = 0;

        for (int i = 0; i < arr.size(); i++) {
            int currentNumber = arr.get(i);

            totalSum += currentNumber;

            if (currentNumber > max) {
                max = currentNumber;
            }

            if (currentNumber < min) {
                min = currentNumber;
            }
        }

        long minSum = totalSum - max;
        long maxSum = totalSum - min;

        System.out.println(minSum + " " + maxSum);
    }

    // 09. Birthday Cake Candles
    public static int birthdayCakeCandles(List<Integer> candles) {
        // count the tallest candles
        // input: [3,2,1,3]
        // output: 2
        int howMany = 0;
        int max = Integer.MIN_VALUE;

        for (Integer candle : candles) {
            // find the tallest
            if(candle > max) {
                max = candle;
                howMany = 1;
            }
            // count how many
            else if(candle == max) howMany++;
        }


        return howMany;
    }

    // 10. Time Conversion
    public static String timeConversion(String s) {
        String timeOfDay = s.substring(s.length() - 2);
        String formattedTime;

        if (timeOfDay.equals("PM")) {
            int hour = Integer.parseInt(s.substring(0, 2));
            formattedTime = (hour == 12) ? s.substring(0, 8) : String.format("%02d%s", hour + 12, s.substring(2, 8));
        } else {
            int hour = Integer.parseInt(s.substring(0, 2));
            formattedTime = (hour == 12) ? String.format("%02d%s", 0, s.substring(2, 8)) : s.substring(0, 8);
        }

        return formattedTime;
    }

    /*
     * Implementation
     ******************/

    // 11. Grading Students
    public static List<Integer> gradingStudents(List<Integer> grades) {
        // round all the grades based off of the following policy
        // if less than 40 keep as is
        // subtract grade from next mulitple of 5
        // if less than 3 then round to next multiple of 5
        //  else remain the same
        // input:  [73,67,38,33]
        // output: [75,67,40,33]
        List<Integer> roundedGrades = new ArrayList<>();

        for (int grade : grades) {
            if(grade < 38 || grade % 5 < 3) roundedGrades.add(grade);
            else {
                int roundedGrade = (grade / 5 + 1) * 5;
                roundedGrades.add(roundedGrade);
            }
        }

        return roundedGrades;
    }

    // 12. Apple and Orange
    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        // find how many apples and oranges land within range of  (s - t) which is sams house
        int noOfApples  = 0;
        int noOfOranges = 0;

        // +d moved right, -d moved left
        // add each fruit distance to the position of the tree
        // apples
        for (int apple : apples) {
            int posDist = a + apple;
            if(posDist >= s && posDist <= t) noOfApples++;
        }

        // oranges
        for (int orange : oranges) {
            int posDist = b + orange;
            if(posDist >= s && posDist <= t) noOfOranges++;
        }

        System.out.println(noOfApples);
        System.out.println(noOfOranges);
    }

    // 13. Number Line Jumps
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // check if both kangaroos end in the same location
        int kangaroo1 = x1;
        int kangaroo2 = x2;
        int maxJumps = 10000;
        int jumps = 0;
        while (jumps < maxJumps) {
            kangaroo1 += v1;
            kangaroo2 += v2;

            if(kangaroo1 == kangaroo2) return "YES";

            jumps++;
        }

        return "NO";
    }

    // 14. Between Two Sets
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int lcmA = lcmOfArray(a);
        int gcdB = gcdOfArray(b);

        int count = 0;
        for (int i = lcmA, j = 2; i <= gcdB; i = lcmA * j, j++) {
            if (gcdB % i == 0) {
                count++;
            }
        }

        return count;
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    static int lcmOfArray(List<Integer> arr) {
        int result = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            result = lcm(result, arr.get(i));
        }
        return result;
    }

    static int gcdOfArray(List<Integer> arr) {
        int result = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            result = gcd(result, arr.get(i));
        }
        return result;
    }

    // 15. Breaking the Records
    public static List<Integer> breakingRecords(List<Integer> scores) {
        // count number of games either max or min points were scored
        List<Integer> records = new ArrayList<>();

        int maxCount = 0;
        int minCount = 0;
        int maxScore = scores.get(0);
        int minScore = scores.get(0);

        for (int score : scores) {
            if(score < minScore) {
                minScore = score;
                minCount++;
            }
            if(score > maxScore) {
                maxScore = score;
                maxCount++;
            }
        }

        records.add(maxCount);
        records.add(minCount);

        return records;
    }

    // 16. Subarray Division
    public static int birthday(List<Integer> s, int d, int m) {
        // count how many segments are possible
        int count = 0;
        // target value is d (rons birthdate)
        int sum = 0;
        // number of values possible is m (rons birth month)
        // Initialize the sliding window
        for (int i = 0; i < m; i++) {
            sum += s.get(i);
        }

        // Check the first window
        if (sum == d) {
            count++;
        }

        // Move the window and check subsequent subarrays
        for (int i = m; i < s.size(); i++) {
            sum += s.get(i) - s.get(i - m); // Slide the window by adding the next element and removing the first element

            // Check if the sum equals the target
            if (sum == d) {
                count++;
            }
        }

        return count;
    }

    // 17. Migratory Birds
    public static int migratoryBirds(List<Integer> arr) {
        // count elements in array
        // [2,2,3,4,4,5,5,5]
        // { 2:2, 3:1, 4:2, 5:3 }
        // return 5
        Map<Integer, Integer> count = new HashMap<>();

        // create count occurences object
        for (int birdId : arr) {
            count.put(birdId, count.getOrDefault(birdId, 0) + 1);
        }

        int bird = -1;
        int maxCount = 0;

        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            int birdType  = entry.getKey();
            int birdCount = entry.getValue();
            if (birdCount > maxCount || (birdCount == maxCount && birdType < bird)) {
                bird = birdType;
                maxCount = birdCount;
            }
        }


        // return element max count
        // if multiple elements have max count
        // return smallest id reference
        return bird;

    }

    // 18. Day of the Programmer
    public static String dayOfProgrammer(int year) {
        // convert date to another date
        // if leap year the 256th day is Sept 12
        // else Sept 13
        String day = "";
        if (year == 1918) {
            return "26.09.1918";
        }
        if((year < 1918 && year % 4 == 0) || (year > 1918 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))) {
            day = "12";
        }
        else {
            day = "13";
        }


        return day + ".09." + year;
    }

    // 19. Bill Division
    public static void bonAppetit(List<Integer> bill, int k, int b) {
        // split the bill between anna and brian
        int total = 0;
        for (int idx = 0; idx < bill.size(); idx++) {
            if(idx != k) total += bill.get(idx);
        }

        int annaCost = total / 2;
        if (annaCost == b) System.out.println("Bon Appetit");
        else System.out.println(b - annaCost);

    }

    // 20. Sales by Match
    public static int sockMerchant(int n, List<Integer> ar) {
        // count socks that do not have pairs
        int count = 0;
        // {1:3, 2:3, 3:1}
        Map<Integer, Integer> socks = new HashMap<>();
        for(int idx = 0; idx < ar.size(); idx++)
            socks.put(ar.get(idx), socks.getOrDefault(ar.get(idx), 0) + 1);

        for (Map.Entry<Integer, Integer> entry : socks.entrySet())
            count += entry.getValue() / 2;

        return count;
    }

    // 21. Drawing Book
    public static int pageCount(int n, int p) {
        int fromStart = p / 2; // Number of pages turned from the start
        int fromEnd = n / 2 - p / 2; // Number of pages turned from the end (Total pages from start - pages from start)
        return Math.min(fromStart, fromEnd); // Return the minimum of pages turned
    }

    // 22. Counting Valleys
    public static int countingValleys(int steps, String path) {
        // count the number of valleys walked through.
        int count = 0;

        int seaLevel = 0;
        boolean inValley = false;

        char[] charArray = path.toCharArray();
        for(char letter: charArray) {
            if(letter == 'U') seaLevel++;
            else if(letter == 'D') seaLevel--;

            if(seaLevel == 0) {
                if(inValley) count++;
                inValley = false;
            }
            else if(seaLevel < 0) inValley = true;
        }


        return count;
    }

    // 23. Electronics Shop
    public static int getMoneySpent(int[] keyboards, int[] drives, int b) {
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

    // 24. Cats and Mouse
    public static String catAndMouse(int x, int y, int z) {
        // determine which cat will reach the mouse first
        // absolute units because of x-axis
        int unitsCatA = Math.abs(z - x);
        int unitsCatB = Math.abs(z - y);
        // conditional return
        if(unitsCatA < unitsCatB) return "Cat A";
        else if (unitsCatA > unitsCatB) return "Cat B";
        else return "Mouse C";

    }

    // 25. Picking Numbers
    public static int pickingNumbers(List<Integer> a) {
        Map<Integer, Integer> frequencyMap = new HashMap<>(); // Create a HashMap to store frequency of numbers

        // Count the frequency of each number in the array
        for (int num : a) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxCount = 0; // Maximum count of elements satisfying the condition

        // Iterate through the keys in the frequency map
        for (int key : frequencyMap.keySet()) {
            int count = frequencyMap.get(key); // Get the frequency of the current number
            if (frequencyMap.containsKey(key - 1)) {
                count += frequencyMap.get(key - 1); // Add the frequency of the previous number if present
            }
            maxCount = Math.max(maxCount, count); // Update maxCount with the maximum count found
        }

        return maxCount;
    }

    // 26. The Hurdle Race
    public static int hurdleRace(int k, List<Integer> height) {
        // How many doses of the potion must the character take to be able to jump all of the hurdles.
        // max number in list - max jump
        int max = 0;
        for (int maxHeight : height)
            if(maxHeight > max) max = maxHeight;

        int potions = max - k;
        if(potions > 0) return potions;
        else return 0;
    }

    // 27. Designer PDF Viewer
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

    // 28. Utopian Tree
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

    // 29. Angry Professor
    public static String angryProfessor(int k, List<Integer> a) {
        // determine if the class is cancelled
        // if greater than k (threshold)
        String cancelledClass = "";
        int inClassCount = 0;
        for(int student: a) {
            if(student <= 0) inClassCount++;
        }

        if(inClassCount >= k) cancelledClass = "NO";
        else cancelledClass = "YES";

        return cancelledClass;
    }

    // 30. Beautiful Days at the Movies
    public static int beautifulDays(int i, int j, int k) {
        int beautifulCount = 0;

        for (int day = i; day <= j; day++) {
            int reverse = reverse(day); // Get the reverse of the day
            int absoluteDifference = Math.abs(day - reverse); // Calculate the absolute difference

            if (absoluteDifference % k == 0) {
                beautifulCount++; // Increment the count if the absolute difference is divisible by k
            }
        }

        return beautifulCount;
    }

    static int reverse(int num) {
        int reversed = 0;
        while (num != 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }

    // 31. Viral Advertising
    public static int viralAdvertising(int n) {
        // determine how many people have liked the ad by the end of a given day
        // shared with exactly 5 recipients per day
        int shared = 5;
        // liked ( recipients / 2 )
        int liked = (int) Math.floor(shared / 2.0);
        int cumulative = liked; // total likes

        for(int day = 2; day <= n; day++) {
            // ( recipients / 2 ) like and share with 3 friends on the following day
            shared = liked * 3;
            liked = (int) Math.floor(shared / 2.0);
            cumulative += liked;
        }

        return cumulative;

    }

    // 32. Save the Prisoner!
    public static int saveThePrisoner(int n, int m, int s) {
        // Find chair number that last candy is distributed to
        // s = startingChair
        // n = numberOfPrisoners
        // m = numberOfSweets

        // Calculate the chair number in a circular manner
        int chair = (s + m - 1) % n;

        // Handle the edge case when chair number is 0 (last chair)
        if (chair == 0) {
            chair = n; // Set to the last chair
        }

        // Return the chair number of the last prisoner to receive candy
        return chair;
    }

    // 33. Circular Array Rotation
    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        // perform a number of right circular rotations and return the values of the elements at the given indices
        List<Integer> results = new ArrayList<>();
        // rotated array
        int n = a.size();
        Integer[] rotatedArray = new Integer[n];
        for (int idx = 0; idx < n; idx++) {
            // rotate index by k rotations find updated index by finding remainder
            // (0 + 2) % 5 = 2
            // (1 + 2) % 5 = 3
            // (2 + 2) % 5 = 4
            // (3 + 2) % 5 = 0
            // (4 + 2) % 5 = 1
            int rIdx = (idx + k) % n;
            rotatedArray[rIdx] = a.get(idx);
        }

        List<Integer> rotatedList = Arrays.asList(rotatedArray);
        for (int queryIdx : queries) {
            results.add(rotatedList.get(queryIdx));
        }

        return results;

    }

    // 34. Sequence Equation
    public static List<Integer> permutationEquation(List<Integer> p) {
        // find any integer  such that p(p(y)) = x and keep a history of the values of  in a return array
        List<Integer> result = new ArrayList<>();

        // Create a map to store the index of each element
        Map<Integer, Integer> map = new HashMap<>();

        // Populate the map with the index of each element
        for (int i = 0; i < p.size(); i++) {
            map.put(p.get(i), i + 1); // Add 1 to convert to 1-based index
        }

        // Step 3: Iterate over the sequence
        for (int y = 1; y <= p.size(); y++) {
            // Find the index of y in the sequence
            int i = map.get(y);

            // Find the index of i in the sequence to get p(p(y))
            int j = map.get(i);

            // Step 5: Add p(p(y)) to the result list
            result.add(j);
        }

        // Step 6: Return the list of values
        return result;
    }

    // 35. Jumping on the Clouds: Revisited
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

    // 36. Find Digits
    public static int findDigits(int n) {
        // Given an integer, for each digit that makes up the integer determine whether it is a divisor. Count the number of divisors occurring within the integer.
        int countDivisors = 0;
        // convert int to string to get values in an array
        String nStr = Integer.toString(n);
        for(int idx = 0; idx < nStr.length(); idx++) {
            int number = Character.getNumericValue(nStr.charAt(idx));
            if(number != 0 && n % number == 0) countDivisors++;
        }

        return countDivisors;
    }

    // 37. Append and Delete
    public static String appendAndDelete(String s, String t, int k) {
        if (s.length() + t.length() <= k) return "Yes";

        int lengthOfCommonSubstring = 0;
        for (int i = 0; i < s.length() && i < t.length() ; i++) {
            if (s.charAt(i) == t.charAt(i)) {
                lengthOfCommonSubstring++;
                continue;
            }
            break;
        }

        int minNecessaryOperations = (s.length() - lengthOfCommonSubstring) + (t.length() - lengthOfCommonSubstring);
        if (minNecessaryOperations > k) return "No";
        if (minNecessaryOperations == k) return "Yes";

        int restOperations = k - minNecessaryOperations;

        if (lengthOfCommonSubstring * 2 >= restOperations) return restOperations % 2 == 0 ? "Yes" : "No";

        return "Yes";
    }

    // 38. Sherlock and Squares
    public static int squares(int a, int b) {
        // Calculate the square root of a and round it up to the nearest integer
        int sqrtA = (int) Math.ceil(Math.sqrt(a));

        // Calculate the square root of b and round it down to the nearest integer
        int sqrtB = (int) Math.floor(Math.sqrt(b));

        // Count the number of square integers between sqrtA and sqrtB, inclusive
        // The number of square integers is equal to the number of integers between sqrtA and sqrtB, plus 1
        // This is because we're considering the integers inclusive of both sqrtA and sqrtB
        int count = sqrtB - sqrtA + 1;

        // Return the count of square integers within the range [a, b]
        return count;
    }

    // 39. Library Fine
    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        // Calculate the fine for returning the book late
        int fine = 0;
        // same year?
        // the fine is fixed at 10000
        if(y1 > y2) fine = 10000;
            // same month?
            // The fine is calculated as 500 * (the number of months late)
        else if(y1 == y2 && m1 > m2) fine = 500 * (m1 - m2);
            // same day?
            // The fine is calculated as 15 * (the number of days late)
        else if(y1 == y2 && m1 == m2 && d1 > d2) fine = 15 * (d1 - d2);
        // on time
        // if book return date <= return date the fine is 0
        return fine;
    }

    // 40. Cut the sticks

    // 41. Repeated String

    // 42. Jumping on the Clouds

    // 43. Equalize the Array

}
