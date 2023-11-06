public class Philosopher2 extends Thread {

    private Program state;

    public Philosopher2(Program state) {
        this.state = state;
    }

    @Override
    public void run() {

        int i = 0;

        while (i <3){
            double a = 500 + Math.random()*3000;
            if (state.isFork1()==false && state.isFork2()==false) {
                //поменяли флаг
                state.setFork1(!state.isFork1());
                state.setFork2(!state.isFork2());
                if (state.isFork1() == true && state.isFork2() == true) {
                    //System.out.println("if2 gone");
                    //System.out.println("философ2 берет левую вилку Fork2 "+ state.isFork2());
                    //System.out.println("философ2 берет правую вилку Fork1 " + state.isFork1());
                    System.out.println("философ2 кушает");
                    try {
                        sleep((long) a);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    state.setFork2(!state.isFork2());
                    //System.out.println("философ2 кладет левую вилку Fork2 " + state.isFork2());
                    state.setFork1(!state.isFork1());
                    //System.out.println("философ2 кладет правую вилку Fork1 " +state.isFork1());
                    System.out.println("философ2 думает");
                    i++;
                    System.out.println("Философ2 покушал " + i + " раз");
                    try {
                        sleep((long) a);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
