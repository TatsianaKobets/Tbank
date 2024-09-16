package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task6 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] times = new int[n];
    List<List<Integer>> dependencies = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      dependencies.add(new ArrayList<>());
    }
    for (int i = 0; i < n; i++) {
      times[i] = scanner.nextInt();
      int k = scanner.nextInt();
      for (int j = 0; j < k; j++) {
        dependencies.get(i).add(scanner.nextInt() - 1);
      }
    }
    System.out.println(getMinTime(times, dependencies));
  }

  public static long getMinTime(int[] times, List<List<Integer>> dependencies) {
    int n = times.length;
    long[] dp = new long[n];
    for (int i = 0; i < n; i++) {
      dp[i] = -1;
    }
    return dfs(times, dependencies, dp, 0);
  }

  public static long dfs(int[] times, List<List<Integer>> dependencies, long[] dp, int node) {
    if (dp[node] != -1) {
      return dp[node];
    }
    long maxTime = 0;
    for (int dependency : dependencies.get(node)) {
      maxTime = Math.max(maxTime, dfs(times, dependencies, dp, dependency));
    }
    dp[node] = maxTime + times[node];
    return dp[node];
  }
}
