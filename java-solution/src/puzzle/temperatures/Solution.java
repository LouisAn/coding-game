package puzzle.temperatures;

import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt(); // the number of temperatures to analyse
    if (in.hasNextLine()) {
      in.nextLine();
    }
    String temps = in.nextLine(); // the n temperatures expressed as integers ranging from -273 to 5526

    int result;

    if (n > 0) {
      String[] tempArray = temps.split(" ");
      result = Integer.parseInt(tempArray[0]);
      for (String tempString : tempArray) {
        int temp = Integer.parseInt(tempString);
        int resultAbs = Math.abs(result);
        int tempAbs = Math.abs(temp);
        if (resultAbs == tempAbs) {
          if (result < 0 && temp > 0) {
            result = temp;
          }
        } else if (resultAbs > tempAbs) {
          result = temp;
        }
      }
    } else {
      result = 0;
    }

    System.out.println(result);
  }
}