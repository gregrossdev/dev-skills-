package hackerrank.algorithms.warmup.easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'timeConversion' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING s as parameter.
   */

  public static String timeConversion(String s) {
    String[] time = s.split(":");
    String hr = time[0];
    String min = time[1];
    String sec = time[2].substring(0, 2);
    String day = time[2].substring(2, 4);
    if (day.equals("AM")) {
      String y = (hr.equals("12") ? "00" : hr) + ":" + min + ":" + sec;
      return y;
    } 
    else {
      String x = (hr.equals("12") ? hr : Integer.parseInt(hr) + 12) + ":" + min + ":" + sec;
      return x;
    }
  }
  
}

public class TimeConversion {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = bufferedReader.readLine();

    String result = Result.timeConversion(s);

    bufferedWriter.write(result);
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
