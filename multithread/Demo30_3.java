public class Demo30_3 {
    private static boolean ready = false;
    private static int value = 1;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!ready) {

                }
                System.out.println(value);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                value = 2;
                ready = true;
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

// 指令重排导致了有序性问题