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
    /*Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }
    scanner.close();

    int[] b = new int[n];
    b[0] = a[0] == -1 ? 1 : a[0];
    for (int i = 1; i < n; i++) {
      if (a[i] == -1) {
        b[i] = b[i - 1];
      } else if (a[i] > b[i - 1]) {
        b[i] = a[i];
      } else {
        System.out.println("NO");
        return;
      }
    }

    int[] c = new int[n];
    c[0] = b[0];
    for (int i = 1; i < n; i++) {
      c[i] = b[i] - b[i - 1];
      if (c[i] <= 0) {
        System.out.println("NO");
        return;
      }
    }

    System.out.println("YES");
    for (int i = 0; i < n; i++) {
      System.out.print(c[i] + " ");
    }
  }
}*/
