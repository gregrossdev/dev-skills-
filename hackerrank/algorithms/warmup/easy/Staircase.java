package easy;

import java.io.*;


class Result {

    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void staircase(int n) {
      for(int lp1=0;lp1<n;lp1++){
        for(int lp2=1;lp2<=n;lp2++)
          if(lp2 < n-lp1)
            System.out.print(" ");
          else 
          System.out.print("#");
      
        System.out.println("");
      }
        

    }

}

public class Staircase {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.staircase(n);

        bufferedReader.close();
    }
}
