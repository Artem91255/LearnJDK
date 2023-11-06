public class Philosopher4 extends Thread {
    private Program state;

    public Philosopher4(Program state) {
        this.state = state;
    }
    @Override
    public void run() {
        int i = 0;
        while (i <3){
            double a = 500 + Math.random()*3000;
            if (state.isFork4()==false && state.isFork3()==false) {
                System.out.println("Философ4 покушал " + i + " раз");
                //поменяли флаг
                state.setFork4(!state.isFork4());
                state.setFork3(!state.isFork3());
                if (state.isFork4() == true && state.isFork3() == true) {
                   //System.out.println("философ4 берет левую вилку Fork4 "+ state.isFork4());
                    //System.out.println("философ4 берет правую вилку Fork3 " + state.isFork3());
                    System.out.println("философ4 кушает");
                    try {
                        sleep((long) a);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    state.setFork4(!state.isFork4());
                    //System.out.println("философ4 кладет левую вилку Fork4 " + state.isFork4());
                    state.setFork3(!state.isFork3());
                    //System.out.println("философ4 кладет правую вилку Fork3 " +state.isFork3());
                    System.out.println("философ4 думает");
                    i++;
                    System.out.println("Философ4 покушал " + i + " раз");
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
