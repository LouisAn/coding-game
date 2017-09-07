package puzzle.chucknorris;

import java.util.Scanner;

/**
 * Created by 1002486 on 2017. 9. 7..
 */
public class Solution {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    String MESSAGE = in.nextLine();

    // 1. 값 변환
    // ASCII 값으로 변경
    // bit 를 연결
    String s = str2HexString(MESSAGE);

    System.err.println("s = " + s);
    // 2. Chuck Norris 계산
    // 0 / 1 을 구분
    // 출력
    boolean one = false;
    int count = 0;
    Character binary = null;
    for (int i = 0; i < s.length(); i++) {
      if (binary == null) {
        binary = s.charAt(i);
        count = 1;
      } else {
        if (binary.equals(s.charAt(i))) {
          count++;
        } else {
          printChuck(binary, count);
          System.out.print(" ");

          binary = s.charAt(i);
          count = 1;
        }
      }
    }
    printChuck(binary, count);
  }

  private static String str2HexString(String msg) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < msg.length(); i++) {
      String binary = Integer.toBinaryString(msg.charAt(i));
      if (binary.length() < 7) {
        for (int j = 0; j < 7 - binary.length(); j++) {
          sb.append("0");
        }
      }
      sb.append(binary);
    }
    return sb.toString();
  }

  private static void printChuck(Character binary, int count) {
    StringBuilder sb = new StringBuilder();
    sb.append("0");
    if (binary.equals('0')) {
      sb.append("0");
    }
    sb.append(" ");

    for (int i=0; i<count; i++) {
      sb.append("0");
    }
    System.out.print(sb.toString());
  }
}