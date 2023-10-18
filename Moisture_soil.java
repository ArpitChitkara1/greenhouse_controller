public class Moisture_soil implements Runnable {
    public double moist_1;
    public double min_moist;
    public double max_moist;
    public double ext;
    public double incrementValue;
    public double decrementValue;
    public int rate_sample;
    public boolean running;
    public simulation_file view;
    public String Machine;
    /**
     * This class represents a soil moisture simulation that adjusts moisture levels based on various input parameters.
     */

    public Moisture_soil(simulation_file view) {
        this.view = view;
    }/**
 * Sets the initial soil moisture value and calculates the minimum and maximum moisture levels.
 */

 public synchronized void setMoist_1(double temperature) {
        this.moist_1 = temperature;
        this.min_moist = temperature -3;
        this.max_moist = temperature +3;
    }

/**
 * Sets the external temperature value that influences soil moisture.*/
    public synchronized void setExt(double externalTemperature) {
        this.ext = externalTemperature;
    }
/**
 * Sets the increment value used for increasing soil moisture.*/
    public synchronized void setIncrementValue(double incrementValue) {
        this.incrementValue = incrementValue;
    }
/**
 * Sets the decrement value used for decreasing soil moisture.
 */
    public synchronized void setDecrementValue(double decrementValue) {
        this.decrementValue = decrementValue;
    }
/**
 * Sets the rate at which the simulation updates soil moisture.
 */
    public synchronized void setRate_sample(int rate_sample) {
        this.rate_sample = rate_sample;
    }
    /**
     * Starts the soil moisture simulation.
     */
    public synchronized void start() {
        running = true;
        new Thread(this).start();
    }
    /**
     * Stops the soil moisture simulation.
     */

    public synchronized void stop() {
        running = false;
    }
    /**
     * The run method for the Runnable interface, continuously updates the soil moisture based on input parameters.
     */
    @Override
    public void run() {
        while (running) {
            if (moist_1 <= min_moist) {
                moist_1 += incrementValue;
                Machine = "Sprinkler System = ON";
            } else if (moist_1 >= max_moist) {
                moist_1 -= decrementValue;
                Machine = "Sprinkler System = OFF";
            } else {
                moist_1 += ext;
                Machine = "Sprinkler System = OFF";
            }
            view.appendSoilMoisture(moist_1, Machine);
            try {
                Thread.sleep(rate_sample);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
