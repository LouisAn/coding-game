package puzzle.mimetype;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by 1002486 on 2017. 9. 12..
 */
public class Solution {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt(); // Number of elements which make up the association table.
    int Q = in.nextInt(); // Number Q of file names to be analyzed.

    Map<String, String> extMap = new HashMap<>();
    for (int i = 0; i < N; i++) {
      String EXT = in.next(); // file extension
      String MT = in.next(); // MIME type.
      extMap.put(EXT.toLowerCase(), MT);
    }
    in.nextLine();
    for (int i = 0; i < Q; i++) {
      String FNAME = in.nextLine(); // One file name per line.
      if (FNAME.lastIndexOf(".") == FNAME.length() - 1) {
        FNAME = FNAME.substring(FNAME.length() - 1);
      }
      String[] split = FNAME.split("\\.");
      if (split != null && split.length > 1) {
        String mt = extMap.get(split[split.length - 1].toLowerCase());
        if (mt != null) {
          System.out.println(mt);
        } else {
          System.out.println("UNKNOWN");
        }
      } else {
        System.out.println("UNKNOWN");
      }
    }
  }
}