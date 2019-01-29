package ru.geekbrains.classes;

import ru.geekbrains.classes.obstacles.Obstacle;

public class Course {
    Obstacle obstacles[];

    Course(Obstacle ...obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) {
        for (Participant participant : team.getMembers()) {
            for (Obstacle obstacle : obstacles) {
                obstacle.doIt(participant);
                if (!participant.isOnDistance()) {
                    break;
                }
            }
        }
    }
}
