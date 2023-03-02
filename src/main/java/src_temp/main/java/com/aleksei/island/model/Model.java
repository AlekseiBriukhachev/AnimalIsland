package src_temp.main.java.com.aleksei.island.model;

import com.aleksei.island.config.AppConfig;
import com.aleksei.island.entities.Location;

public class Model {
    private final AppConfig config = AppConfig.getAppConfig();
    private Location[][] simLocation = new Location[config.getIslandWidth()][config.getIslandHeight()];
    public Model(){
        createSimLocations();
    }

    private void createSimLocations() {
        for (int x = 0; x < config.getIslandWidth(); x++) {
            for (int y = 0; y < config.getIslandHeight(); y++) {
                simLocation[x][y] = new Location();
            }
        }
    }

    public Location[][] getSimLocation() {
        return simLocation;
    }

    public void setSimLocation(Location[][] simLocation) {
        this.simLocation = simLocation;
    }

    public void simulate() {
//        ScheduledExecutorService scheduleSimCycle = Executors.newScheduledThreadPool(5);
//        scheduleSimCycle.scheduleAtFixedRate(new Cycle(), 0, 500, TimeUnit.MILLISECONDS);
    }
}
