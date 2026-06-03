//41
import java.util.concurrent.*;
import java.util.*;

public class ExecutorDemo {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        System.out.println("=== Executor Service with Callable ===\n");

        // ── Simple Callable Tasks ──
        Callable<Integer> task1 = () -> {
            System.out.println("Task 1 running: Square of 5");
            Thread.sleep(1000);
            return 5 * 5;
        };

        Callable<Integer> task2 = () -> {
            System.out.println("Task 2 running: Square of 10");
            Thread.sleep(500);
            return 10 * 10;
        };

        Callable<Integer> task3 = () -> {
            System.out.println("Task 3 running: Square of 15");
            Thread.sleep(800);
            return 15 * 15;
        };

        Callable<String> task4 = () -> {
            System.out.println("Task 4 running: String task");
            Thread.sleep(600);
            return "Hello from Task 4!";
        };

        Callable<Double> task5 = () -> {
            System.out.println("Task 5 running: Area of circle r=7");
            Thread.sleep(700);
            return Math.PI * 7 * 7;
        };

        // ── Submit Tasks ──
        System.out.println("--- Submitting Tasks ---");
        Future<Integer> future1 = executor.submit(task1);
        Future<Integer> future2 = executor.submit(task2);
        Future<Integer> future3 = executor.submit(task3);
        Future<String>  future4 = executor.submit(task4);
        Future<Double>  future5 = executor.submit(task5);

        // ── Collect Results ──
        System.out.println("\n--- Collecting Results ---");
        System.out.println("Task 1 Result (5x5)          : " + future1.get());
        System.out.println("Task 2 Result (10x10)        : " + future2.get());
        System.out.println("Task 3 Result (15x15)        : " + future3.get());
        System.out.println("Task 4 Result (String)       : " + future4.get());
        System.out.println("Task 5 Result (Circle Area)  : " + String.format("%.2f", future5.get()));

        // ── Multiple Tasks Using List ──
        System.out.println("\n--- Submitting 5 Number Tasks Using List ---");
        List<Callable<Integer>> taskList = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            final int num = i;
            taskList.add(() -> {
                System.out.println("Computing cube of " + num);
                return num * num * num;
            });
        }

        List<Future<Integer>> futures = executor.invokeAll(taskList);

        System.out.println("\n--- Cube Results ---");
        for (int i = 0; i < futures.size(); i++) {
            System.out.println("Cube of " + (i + 1) + " = " + futures.get(i).get());
        }

        executor.shutdown();
        System.out.println("\nExecutor Shutdown. All tasks completed!");
    }
}