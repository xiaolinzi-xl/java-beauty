public class Demo30_1 {
    private static boolean running = true;
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {
                    count++;
                }
                System.out.println("count: " + count);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                running = false;
            }
        });

        t1.start();
        Thread.sleep(1000);
        t2.start();

        t1.join();
        t2.join();
    }
}

// CPU缓存导致可见性问题