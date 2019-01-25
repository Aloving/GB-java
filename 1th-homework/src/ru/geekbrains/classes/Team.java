package ru.geekbrains.classes;

public class Team {
    Participant[] participants;
    String name;

    Team(String name, Participant[] participants) {
        this.participants = participants;
        this.name = name;
    }

    public String getTeamName() {
        return name;
    }

    public Participant[] getMembers() {
        return participants;
    }

    public void showTeamMembers() {
        for (Participant participant : participants) {
            System.out.println("member" + participant + ", " + "team" + this.getTeamName());
        }
    }

    public void showResults() {
        for (Participant participant : participants) {
            System.out.println(participant);
        }
    }
}
