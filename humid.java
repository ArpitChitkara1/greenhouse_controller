public class humid implements Runnable {
    public double humidity_in_air;
    public double minimum_humid_;
    public double maximum_humid;
    public double outered;
    public double inc_value;
    public double dec_value;
    public int current_rate;
    public boolean running;
    public simulation_file view;
    public String working_machine;
    /**
     * This class represents a humidity simulation that adjusts humidity levels based on various input parameters.
     */

    public humid(simulation_file view) {
        this.view = view;
    }
/**
 * Constructor for the humid class.
 */
    public synchronized void sethumidity(double temperature) {
        this.humidity_in_air = temperature;
        this.minimum_humid_ = temperature -3;
        this.maximum_humid = temperature +3;
    }
/**
 * Sets the initial humidity in air and calculates the minimum and maximum humidity thresholds.
 */
    public synchronized void setOutered(double externalTemperature) {
        this.outered = externalTemperature;
    }
/**
 * Sets the external humidity value that influences the simulation.
 */
    public synchronized void setInc_value(double inc_value) {
        this.inc_value = inc_value;
    }
/**
 * Sets the increment value used for increasing the humidity.
 */
    public synchronized void setDec_value(double dec_value) {
        this.dec_value = dec_value;
    }
/**
 * Sets the decrement value used for decreasing the humidity.
 */
 public synchronized void setCurrent_rate(int current_rate) {
        this.current_rate = current_rate;
    }
/**
 * Sets the rate at which the simulation updates the humidity.
 */
 public synchronized void start() {
        running = true;
        new Thread(this).start();
    }
    /**
     * Starts the humidity simulation.
     */

    public synchronized void stop() {
        running = false;
    }/**
     * Stops the humidity simulation.
     */

    @Override/**
     * The run method for the Runnable interface, continuously updates the humidity based on input parameters.
     */
    public void run() {
        while (running) {
            if (humidity_in_air <= minimum_humid_) {
                humidity_in_air += inc_value;
                working_machine = "Humidifier = ON";
            } else if (humidity_in_air >= maximum_humid) {
                humidity_in_air -= dec_value;
                working_machine = "Humidifier = OFF";
            } else {
                humidity_in_air += outered;
                working_machine = "Humidifier = OFF";
            }
            view.appendHumidity(humidity_in_air, working_machine);
            try {
                Thread.sleep(current_rate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
