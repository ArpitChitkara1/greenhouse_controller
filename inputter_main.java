/**
 * The inputter_main class contains the main method that initializes the simulation components and creates the handler object.
 */
public class inputter_main {

    /**
     * The main method that initializes the simulation components and creates the handler object to manage interactions.
     * @param args Command-line arguments (not used in this application)
     */
    public static void main(String[] args) {
        simulation_file viewing = new simulation_file();
        Temp model = new Temp(viewing);
        Moisture_soil moisture = new Moisture_soil(viewing);
        humid humidity_1 = new humid(viewing);

        new handler(model, moisture, humidity_1, viewing);
    }
}
