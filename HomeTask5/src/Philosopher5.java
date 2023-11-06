public class Philosopher5 extends Thread {
    private Program state;

    public Philosopher5(Program state) {
        this.state = state;
    }
    @Override
    public void run() {
        int i = 0;

        while (i <3){
            double a = 500 + Math.random()*3000;
            if (state.isFork5()==false && state.isFork4()==false) {
                //поменяли флаг
                state.setFork4(!state.isFork4());
                state.setFork5(!state.isFork5());

                if (state.isFork5() == true && state.isFork4() == true) {
                    //System.out.println("философ5 берет левую вилку Fork5 "+ state.isFork5());
                    //System.out.println("философ5 берет правую вилку Fork4 " + state.isFork4());
                    System.out.println("философ5 кушает");
                    try {
                        sleep((long) a);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    state.setFork5(!state.isFork5());
                    //System.out.println("философ5 кладет левую вилку Fork5 " + state.isFork5());
                    state.setFork4(!state.isFork4());
                    //System.out.println("философ5 кладет правую вилку Fork4 " +state.isFork4());
                    System.out.println("философ5 думает");
                    i++;
                    System.out.println("Философ5 покушал " + i + " раз");
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
