package org.example.basic;

import java.time.Duration;
import java.time.Instant;

public class SequentialPrinter {
    public static void main(String[] args) {
        //Starting time
        Instant start = Instant.now();

        for(int i=0;i<=299;i++) {
            System.out.print(i + " ");
        }

        //Starting time
        Instant end = Instant.now();
        long time = Duration.between(start, end).toMillis();
        System.out.println("\n"+time+" ms");
    }
}
