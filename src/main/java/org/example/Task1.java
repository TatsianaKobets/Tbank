package org.example;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Task1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine();
    scanner.close();

    String[] intervals = s.split(",");
    Set<Integer> numbers = new TreeSet<>();

    for (String interval : intervals) {
      if (interval.contains("-")) {
        String[] bounds = interval.split("-");
        int from = Integer.parseInt(bounds[0]);
        int to = Integer.parseInt(bounds[1]);
        for (int i = from; i <= to; i++) {
          numbers.add(i);
        }
      } else {
        numbers.add(Integer.parseInt(interval));
      }
    }

    for (Integer number : numbers) {
      System.out.print(number + " ");
    }
  }
}
