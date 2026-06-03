//40
public class VirtualThreadDemo {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("=== Virtual Threads (Java 21) ===\n");

        // ── Virtual Threads ──
        System.out.println("--- Starting 100,000 Virtual Threads ---");
        long virtualStart = System.currentTimeMillis();

        Thread[] virtualThreads = new Thread[100_000];

        for (int i = 0; i < 100_000; i++) {
            final int threadNum = i;
            virtualThreads[i] = Thread.ofVirtual().start(() -> {
                if (threadNum % 10000 == 0) {
                    System.out.println("Virtual Thread running: " + threadNum);
                }
            });
        }

        for (Thread t : virtualThreads) {
            t.join();
        }

        long virtualEnd = System.currentTimeMillis();
        long virtualTime = virtualEnd - virtualStart;

        System.out.println("Virtual Threads Done!");
        System.out.println("Time Taken: " + virtualTime + " ms\n");

        // ── Traditional Threads ──
        System.out.println("--- Starting 1,000 Traditional Threads ---");
        long traditionalStart = System.currentTimeMillis();

        Thread[] traditionalThreads = new Thread[1_000];

        for (int i = 0; i < 1_000; i++) {
            final int threadNum = i;
            traditionalThreads[i] = new Thread(() -> {
                if (threadNum % 100 == 0) {
                    System.out.println("Traditional Thread running: " + threadNum);
                }
            });
            traditionalThreads[i].start();
        }

        for (Thread t : traditionalThreads) {
            t.join();
        }

        long traditionalEnd = System.currentTimeMillis();
        long traditionalTime = traditionalEnd - traditionalStart;

        System.out.println("Traditional Threads Done!");
        System.out.println("Time Taken: " + traditionalTime + " ms\n");

        // ── Comparison ──
        System.out.println("=== Performance Comparison ===");
        System.out.println("Virtual Threads    : 100,000 threads in " + virtualTime + " ms");
        System.out.println("Traditional Threads:   1,000 threads in " + traditionalTime + " ms");

        if (virtualTime < traditionalTime) {
            System.out.println("Result: Virtual Threads are FASTER!");
        } else {
            System.out.println("Result: Virtual Threads handled 100x more threads efficiently!");
        }
    }
}