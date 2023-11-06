public class Philosopher3 extends Thread {

        private Program state;

        public Philosopher3(Program state) {
            this.state = state;
        }
        @Override
        public void run() {

            int i = 0;

            while (i <3){
                double a = 500 + Math.random()*3000;
                if (state.isFork3()==false && state.isFork2()==false) {
                    //поменяли флаг
                    state.setFork3(!state.isFork3());
                    state.setFork2(!state.isFork2());
                    if (state.isFork3() == true && state.isFork2() == true) {
                        //System.out.println("философ3 берет левую вилку Fork3 "+ state.isFork3());
                        //System.out.println("философ3 берет правую вилку Fork2 " + state.isFork2());
                        System.out.println("философ3 кушает");
                        try {
                            sleep((long) a);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        state.setFork3(!state.isFork3());
                        //System.out.println("философ3 кладет левую вилку Fork3 " + state.isFork3());
                        state.setFork2(!state.isFork2());
                        //System.out.println("философ3 кладет правую вилку Fork2 " +state.isFork2());
                        System.out.println("философ3 думает");
                        i++;
                        System.out.println("Философ3 покушал " + i + " раз");
                        System.out.println();
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
