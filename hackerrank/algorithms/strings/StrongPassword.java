package hackerrank.algorithms.strings;

import java.io.*;

class Result {

  /*
   * Complete the 'minimumNumber' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   * 1. INTEGER n
   * 2. STRING password
   */

   public static int minimumNumber(int n, String password) {
    int output = 0;
    boolean[] checkPoint = new boolean[4];
    
    for(char ch : password.toCharArray()){
      if(Character.isUpperCase(ch))
        checkPoint[0] = true;
      else if(Character.isLowerCase(ch))
        checkPoint[1] = true;
      else if(Character.isDigit(ch))
        checkPoint[2] = true;
      else
        checkPoint[3] = true;
    }
    
    for(int i=0; i<4; i++)
        if(checkPoint[i]==false)
          output++;
    
    if(n<6 && n+output<6){
        return (6-n);
    }
    
    return output;
  }

}

public class StrongPassword {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    String password = bufferedReader.readLine();

    int answer = Result.minimumNumber(n, password);

    bufferedWriter.write(String.valueOf(answer));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
