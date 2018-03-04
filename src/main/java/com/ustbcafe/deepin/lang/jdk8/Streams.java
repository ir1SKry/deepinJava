package com.ustbcafe.deepin.lang.jdk8;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Rudy Steiner on 2017/8/26.
 * JDK 8 stream feature
 *
 */
public class Streams {
    private enum Status {
    OPEN, CLOSED
    };

    private static final class Task {
    private final Status status;
    private final Integer points;

    Task( final Status status, final Integer points ) {
        this.status = status;
        this.points = points;
    }

    public Integer getPoints() {
        return points;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format( "[%s, %d]", status, points );
    }
    }
   public static void main(String[] args){
       final Collection< Task > tasks = Arrays.asList(
               new Task( Status.OPEN, 5 ),
               new Task( Status.OPEN, 13 ),
               new Task( Status.CLOSED, 8 )
       );
       // Calculate total points of all active tasks using sum()
       final long totalPointsOfOpenTasks = tasks
               .stream()
               .filter( task -> task.getStatus() == Status.OPEN )
               .mapToInt( Task::getPoints )
               .sum();
// Calculate total points of all active tasks using sum()

       // Calculate total points of all tasks
       final double totalPoints = tasks
               .stream()
               .parallel()
               .map( task -> task.getPoints() ) // or map( Task::getPoints )
               .reduce( 0, Integer::sum );

       System.out.println( "Total points (all tasks): " + totalPoints );

       System.out.println( "Total points: " + totalPointsOfOpenTasks );
       System.out.println( "Total points: " + totalPointsOfOpenTasks );
   }
}
