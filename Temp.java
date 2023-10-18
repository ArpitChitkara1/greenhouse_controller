public class Temp implements Runnable {
    public double temp_required;
    public double minimum_temp;
    public double maximum_temp;
    public double ext_temp;
    public double incremental_value;
    public double decremental_value;
    public int rate_sample;
    public boolean running;
    public simulation_file view;
    public String Machine;
    /**
     * This class represents a temperature simulation that adjusts temperature levels based on various input parameters.
     */
    public Temp(simulation_file view) {
        this.view = view;
    }/**
 * Constructor for the Temp class.
 */

    public synchronized void setTemp_required(double temp_required) {
        this.temp_required = temp_required;
        this.minimum_temp = temp_required -3;
        this.maximum_temp = temp_required +3;
    }/**
 * Sets the required temperature and calculates the minimum and maximum temperature thresholds.
 */

 public synchronized void setExt_temp(double ext_temp) {
        this.ext_temp = ext_temp;
    }
/**
 * Sets the external temperature value that influences the simulation.
 */
    public synchronized void setIncremental_value(double incremental_value) {
        this.incremental_value = incremental_value;
    }
/**
 * Sets the increment value used for increasing the temperature.
 */
    public synchronized void setDecremental_value(double decremental_value) {
        this.decremental_value = decremental_value;
    }
/**
 * Sets the decrement value used for decreasing the temperature.
 */
    public synchronized void setRate_sample(int rate_sample) {
        this.rate_sample = rate_sample;
    }
/**
 * Sets the rate at which the simulation updates the temperature.
 */
    public synchronized void start() {
        running = true;
        new Thread(this).start();
    }
/**
 * Starts the temperature simulation.
 */
    public synchronized void stop() {
        running = false;
    }

    @Override
    /**
     * The run method for the Runnable interface, continuously updates the temperature based on input parameters.
     */
    public void run() {
        while (running) {
            if (temp_required <= minimum_temp) {
                temp_required += incremental_value;
                Machine = "Furnace= ON   Air Conditioner= OFF";
            } else if (temp_required >= maximum_temp) {
                temp_required -= decremental_value;
                Machine = "Furnace= OFF   Air Conditioner= ON";
            } else {
                temp_required += ext_temp;
                Machine = "Furnace= OFF   Air Conditioner= OFF";
            }
            view.appendTemperature(temp_required, Machine);

            try {
                Thread.sleep(rate_sample);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
