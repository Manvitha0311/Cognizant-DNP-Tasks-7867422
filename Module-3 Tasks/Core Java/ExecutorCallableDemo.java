import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Task implements Callable<Integer> {

    private int number;

    public Task(int number) {
        this.number = number;
    }

    @Override
    public Integer call() {
        int result = number * number;
        System.out.println("Processing: " + number + " by " + Thread.currentThread().getName());
        return result;
    }
}

public class ExecutorCallableDemo {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Future<Integer>[] futures = new Future[5];

        for (int i = 1; i <= 5; i++) {
            futures[i - 1] = executor.submit(new Task(i));
        }

        for (int i = 0; i < 5; i++) {
            try {
                Integer result = futures[i].get();
                System.out.println("Result: " + result);
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e.getMessage());
            }
        }

        executor.shutdown();
    }
}