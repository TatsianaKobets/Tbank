package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Task5 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String startTime = scanner.next();
    int n = scanner.nextInt();
    scanner.nextLine();

    Map<String, Team> teams = new HashMap<>();

    for (int i = 0; i < n; i++) {
      String[] input = scanner.nextLine().split(" ");
      String teamName = input[0];
      String time = input[1];
      String server = input[2];
      String result = input[3];

      Team team = teams.getOrDefault(teamName, new Team(teamName));
      teams.put(teamName, team);

      if (result.equals("ACCESSED") || result.equals("DENIED") || result.equals("FORBIDDEN")) {
        team.updateTime(startTime, time);
        if (result.equals("ACCESSED")) {
          team.accessed(server);
        } else if (result.equals("DENIED")) {
          team.denied(server);
        }
      }
    }

    List<Team> sortedTeams = new ArrayList<>(teams.values());
    sortedTeams.sort((t1, t2) -> {
      if (t1.getScore() != t2.getScore()) {
        return t2.getScore() - t1.getScore();
      } else if (t1.getPenalty() != t2.getPenalty()) {
        return t1.getPenalty() - t2.getPenalty();
      } else {
        return t1.getName().compareTo(t2.getName());
      }
    });

    int place = 1;
    for (Team team : sortedTeams) {
      System.out.println(
          place + " " + team.getName() + " " + team.getScore() + " " + team.getPenalty());
      place++;
    }
  }

  public static class Team {

    private String name;
    private int score;
    private int penalty;
    private Set<String> accessedServers;
    private Map<String, Integer> deniedServers;

    public Team(String name) {
      this.name = name;
      this.score = 0;
      this.penalty = 0;
      this.accessedServers = new HashSet<>();
      this.deniedServers = new HashMap<>();
    }

    public void updateTime(String startTime, String time) {
      int startMinutes = Integer.parseInt(startTime.split(":")[0]) * 60 + Integer.parseInt(
          startTime.split(":")[1]);
      int minutes =
          Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
      penalty += (minutes - startMinutes + 1439)
          % 1440; // добавляем разницу во времени, но не более 24 часов
    }

    public void accessed(String server) {
      accessedServers.add(server);
      score++;
    }

    public void denied(String server) {
      deniedServers.put(server, deniedServers.getOrDefault(server, 0) + 1);
      penalty += 20;
    }

    public String getName() {
      return name;
    }

    public int getScore() {
      return score;
    }

    public int getPenalty() {
      return penalty;
    }
  }

}
