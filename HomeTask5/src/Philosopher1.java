import static java.lang.Thread.sleep;

public class Philosopher1 extends Thread {

    private Program state;

    public Philosopher1(Program state) {
        this.state = state;
    }
    @Override
    public void run() {

        int i = 0;

        while (i <3){
            double a = 500 + Math.random()*3000;
        if (state.isFork1()==false && state.isFork5()==false) {
            //поменяли флаг
            state.setFork1(!state.isFork1());
            state.setFork5(!state.isFork5());
            if (state.isFork1() == true && state.isFork5() == true) {
                //System.out.println("философ1 берет левую вилку Fork1 "+ state.isFork1());
                //System.out.println("философ1 берет правую вилку Fork5 " + state.isFork5());
                System.out.println("философ1 кушает");
                try {
                    sleep((long) a);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                state.setFork1(!state.isFork1());
                //System.out.println("философ1 кладет левую вилку Fork1 " + state.isFork1());
                state.setFork5(!state.isFork5());
                //System.out.println("философ1 кладет правую вилку Fork4 " +state.isFork5());
                System.out.println("философ1 думает");
                i++;
                System.out.println("Философ1 покушал " + i + " раз");
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
