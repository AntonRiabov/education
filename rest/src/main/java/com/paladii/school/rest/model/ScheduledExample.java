package com.paladii.school.rest.model;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledExample {
    final static DateFormat fmt = DateFormat.getTimeInstance(DateFormat.LONG);
    public static void main(String[] args) throws InterruptedException {
        // Create a scheduled thread pool with 5 core threads
        ScheduledThreadPoolExecutor sch = (ScheduledThreadPoolExecutor)
                Executors.newScheduledThreadPool(5);

        // Create a task for one-shot execution using schedule()
        Runnable oneShotTask = new Runnable(){
            @Override
            public void run() {
                System.out.println("\t Task3 Time: "
                        + fmt.format(new Date()));
            }
        };

        // Create another task
        Runnable delayTask = new Runnable(){
            @Override
            public void run() {
                try{
                    System.out.println("\t Task2 Time: "
                            + fmt.format(new Date()));

                }catch(Exception e){

                }
            }
        };

        // And yet another
        Runnable periodicTask = new Runnable(){
            @Override
            public void run() {
                try{
                    System.out.println("Task1 Time: "
                            + fmt.format(new Date()));

                }catch(Exception e){

                }
            }
        };
         sch.setRemoveOnCancelPolicy(true);
        System.out.println("Submission Time: " + fmt.format(new Date()));
//      ScheduledFuture<?> oneShotFuture = sch.schedule(oneShotTask, 5, TimeUnit.SECONDS);
//      ScheduledFuture<?> delayFuture = sch.scheduleWithFixedDelay(delayTask, 5, 5, TimeUnit.SECONDS);
        ScheduledFuture<?> periodicFuture = sch.scheduleAtFixedRate(periodicTask, 5, 5, TimeUnit.SECONDS);
        ScheduledFuture<?> periodicFuture1 = sch.scheduleAtFixedRate(delayTask, 5, 5, TimeUnit.SECONDS);
        ScheduledFuture<?> periodicFuture2 = sch.scheduleAtFixedRate(oneShotTask, 5, 5, TimeUnit.SECONDS);

        Thread.sleep(30000);
        periodicFuture.cancel(true);
        Thread.sleep(3000);
        periodicFuture1.cancel(true);
        Thread.sleep(3000);
        periodicFuture2.cancel(true);
    }
}