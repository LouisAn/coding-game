package puzzle.asciiart;

/**
 * Created by 1002486 on 2017. 9. 6..
 */
import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int L = in.nextInt();
    int H = in.nextInt();
    if (in.hasNextLine()) {
      in.nextLine();
    }
    String T = in.nextLine();

    HashMap<Integer, String[]> artMap = new HashMap<>();
    for (int i = 0; i < H; i++) {
      // a to z 를 배열에 담는다.
      String ROW = in.nextLine();
      int rowLength = ROW.length();

      for (int startPosition = 0, alphabet = 0; startPosition < rowLength; startPosition+=L, alphabet++) {
        String[] art;
        if (i == 0) {
          art = new String[5];
        } else {
          art = artMap.get(Character.getNumericValue('A') + alphabet);
        }
        art[i] = ROW.substring(startPosition, startPosition+L);

        artMap.put(Character.getNumericValue('A') + alphabet, art);
      }
    }


    // Print
    String[] row = new String[H];
    for (int i = 0; i < H; i++) {
      row[i] = "";
    }
    for (int i = 0; i < T.length(); i++) {
      char c = T.charAt(i);
      System.err.println(c);
      String[] arts = artMap.get(Character.getNumericValue(c));
      if (arts == null) {
        arts = artMap.get(Character.getNumericValue('Z') + 1);
      }
      for (int j = 0; j < arts.length; j++) {
        row[j] += arts[j];
      }
    }

    for (int i = 0; i < H; i++) {
      System.out.println(row[i]);
    }
  }
}