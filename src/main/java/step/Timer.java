package step;

import utils.Consts;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

/**
 * Singleton Timer class
 *  - at given time periods calls every registered objects step() (refresh method)
 */
public class Timer {

    private List<Steppable> steppables;

    private Timer() {
        steppables = new ArrayList<>();
        startTimer();
    }

    public void addSteppable(Steppable steppable) {
        steppables.add(steppable);
    }

    public void removeSteppable(Steppable steppable) {
        steppables.remove(steppable);
    }

    private void tick() {
        for (Steppable steppable : steppables) {
            steppable.step();
        }
    }

    private void startTimer() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                tick();
            }
        };
        timer.schedule(task, Consts.Timing.STARTING_DELAY_MS,
                Consts.Timing.STEP_PERIOD_MS);
    }

    // Singleton impl
    private static Timer instance = null;

    public static Timer getTimer() {
        if (instance == null)
            instance = new Timer();

        return instance;
    }
}
