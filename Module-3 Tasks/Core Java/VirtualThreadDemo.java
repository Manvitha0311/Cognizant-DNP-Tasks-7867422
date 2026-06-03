import java.util.ArrayList;
import java.util.List;

public class VirtualThreadDemo {

    public static void main(String[] args) throws InterruptedException {

        int count = 100000;
        List<Thread> threads = new ArrayList<>();

        long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            int id = i;

            Thread t = Thread.startVirtualThread(() -> {
                System.out.println("Virtual Thread: " + id);
            });

            threads.add(t);
        }

        for (Thread t : threads) {
            t.join();
        }

        long end = System.currentTimeMillis();

        System.out.println("Total Time: " + (end - start) + " ms");
    }
}