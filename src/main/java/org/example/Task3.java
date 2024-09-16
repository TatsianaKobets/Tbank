package org.example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task3 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String sequence = scanner.nextLine();
    String requirements = scanner.nextLine();
    int k = Integer.parseInt(scanner.nextLine());

    Set<Character> reqSet = new HashSet<>();
    for (char c : requirements.toCharArray()) {
      reqSet.add(c);
    }

    int maxLen = 0;
    String result = "-1";
    int lastIndex = -1;

    for (int i = 0; i < sequence.length(); i++) {
      Set<Character> currSet = new HashSet<>();
      StringBuilder sb = new StringBuilder();
      for (int j = i; j < sequence.length(); j++) {
        char c = sequence.charAt(j);
        if (reqSet.contains(c)) {
          currSet.add(c);
          sb.append(c);
        }
        if (currSet.size() == reqSet.size()) {
          if (sb.length() <= k && sb.length() > maxLen) {
            maxLen = sb.length();
            result = sb.toString();
            lastIndex = j;
          } else if (sb.length() == maxLen && j > lastIndex) {
            result = sb.toString();
            lastIndex = j;
          }
        }
        if (currSet.size() == reqSet.size() && sb.length() > k) {
          break;
        }
      }
    }

    System.out.println(result);
  }
}
