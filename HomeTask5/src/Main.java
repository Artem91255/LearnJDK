public class Main {
    public static void main(String[] args) {
        Program state = new Program();

        Philosopher1 thread1 = new Philosopher1(state);
        Philosopher2 thread2 = new Philosopher2(state);
        Philosopher3 thread3 = new Philosopher3(state);
        Philosopher4 thread4 = new Philosopher4(state);
        Philosopher5 thread5 = new Philosopher5(state);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

    }
}