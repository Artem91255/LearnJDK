public class Program {
    private volatile boolean fork1;
    private volatile boolean fork2;
    private volatile boolean fork3;
    private volatile boolean fork4;
    private volatile boolean fork5;

    public boolean isFork1() {
        return fork1;
    }

    public void setFork1(boolean fork1) {
        this.fork1 = fork1;
    }

    public boolean isFork2() {
        return fork2;
    }

    public void setFork2(boolean fork2) {
        this.fork2 = fork2;
    }

    public boolean isFork3() {
        return fork3;
    }

    public void setFork3(boolean fork3) {
        this.fork3 = fork3;
    }

    public boolean isFork4() {
        return fork4;
    }

    public void setFork4(boolean fork4) {
        this.fork4 = fork4;
    }
    public boolean isFork5() {
        return fork5;
    }

    public void setFork5(boolean fork5) {
        this.fork5 = fork5;
    }
}
