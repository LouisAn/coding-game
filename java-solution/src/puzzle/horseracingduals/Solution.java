package puzzle.horseracingduals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();

    List<Integer> ps = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      int pi = in.nextInt();
      ps.add(pi);
    }

    ps.sort((o1, o2) -> {
      if (o1 == o2) { return 0; }
      if (o1 > o2) { return 1; }
      else { return -1; }
    });

    Integer p1 = null;
    Integer result = 10000000;
    for (Integer p : ps) {
      if (p1 == null) {
        p1 = p;
      } else {
        if ((p - p1) < result) {
          result = (p - p1);
        }
        p1 = p;
      }
    }

    System.out.println(result);
  }
}