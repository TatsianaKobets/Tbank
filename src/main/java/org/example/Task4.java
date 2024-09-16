package org.example;

import java.util.Scanner;

public class Task4 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long l = scanner.nextLong();
    long r = scanner.nextLong();

    int count = 0;
    for (long i = l; i <= r; i++) {
      if (isComposite(i) && isPrime(countDivisors(i))) {
        count++;
      }
    }

    System.out.println(count);
  }

  public static boolean isPrime(long n) {
    if (n <= 1) {
      return false;
    }
    for (long i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean isComposite(long n) {
    return n > 1 && !isPrime(n);
  }

  public static long countDivisors(long n) {
    long count = 0;
    for (long i = 1; i * i <= n; i++) {
      if (n % i == 0) {
        count++;
        if (i * i != n) {
          count++;
        }
      }
    }
    return count;
  }
}
