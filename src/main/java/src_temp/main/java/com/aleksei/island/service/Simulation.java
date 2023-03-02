package src_temp.main.java.com.aleksei.island.service;

public class Simulation {
    private Island island;
    public Simulation(int width, int height){
        island = new Island(width, height);
    }
    public void run(){
        while (true){
            island.simulate();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
                //TODO
            }
        }
    }
}
