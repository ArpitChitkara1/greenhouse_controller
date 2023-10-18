import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
/**
 * This class handles the interaction between the simulation models and the user interface.
 */
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
/**
 * Constructs the handler object that manages interaction between the simulation models and user interface.
 */
public class handler {
    public Temp model_temp;
    public Moisture_soil moistureinsoil;
    public humid humidity;
    public simulation_file viewings;


    /**
     * The Start_button class listens for start button actions and starts the simulations.
     */
    public handler(Temp model, Moisture_soil Moist, humid Humi, simulation_file viewed) {
        this.model_temp = model;
        this.viewings = viewed;
        this.moistureinsoil = Moist;
        this.humidity = Humi;
/**
 * Handles the start button action event and starts the simulations.
 */
 // attach listeners to viewed components
        viewed.addStartButtonListener(new Start_button());
        viewed.addStopButtonListener(new stop_button());
        viewed.addSaveButtonActionListener(new save_button());
        viewed.addOpenButtonActionListener(new opener());
    }
/**
 * The stop_button class listens for stop button actions and stops the simulations.
 */
    class Start_button implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //append the 13 text input form view
            double val_dec = Double.parseDouble(viewings.getTemperatureDecrementInput().getText());
            int rate = Integer.parseInt(viewings.getTemperaturesampleInput().getText());
            double new_temp = Double.parseDouble(viewings.getTempInput().getText());
            double diff = Double.parseDouble(viewings.getWeatherField().getText());
            double val_inc = Double.parseDouble(viewings.getTemperatureIncrementInput().getText());

/**
 * Handles the stop button action event and stops the simulations.
 */
            double humi = Double.parseDouble(viewings.getHumidityInput().getText());
            int sampleRate2 = Integer.parseInt(viewings.getHumiditysampleInput().getText());

            double val_inc2 = Double.parseDouble(viewings.getHumidityIncrementInput().getText());
            double val_dec2 = Double.parseDouble(viewings.getHumidityDecrementInput().getText());
            double val_dec3 = Double.parseDouble(viewings.getSoil_Dec_input().getText());
            int ratings = Integer.parseInt(viewings.getSoil_sample_input().getText());
            double x_1 = Double.parseDouble(viewings.getSoil_input().getText());
            double new_incval3 = Double.parseDouble(viewings.getSoil_inc_input().getText());


            model_temp.setTemp_required(new_temp);
            model_temp.setExt_temp(diff);
            model_temp.setIncremental_value(val_inc);
            model_temp.setDecremental_value(val_dec);
            model_temp.setRate_sample(rate);

            model_temp.start();


            moistureinsoil.setIncrementValue(val_inc2);
            moistureinsoil.setDecrementValue(val_dec2);
            moistureinsoil.setExt(diff);
            moistureinsoil.setRate_sample(sampleRate2);
            moistureinsoil.setMoist_1(x_1);

            moistureinsoil.start();

            humidity.sethumidity(humi);
            humidity.setDec_value(val_dec3);
            humidity.setCurrent_rate(ratings);

            humidity.setOutered(diff);
            humidity.setInc_value(new_incval3);
            humidity.start();

        }
    }

    class stop_button implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model_temp.stop();
            humidity.stop();
            moistureinsoil.stop();
        }
    }
    /**
     * The save_button class listens for save button actions and saves the simulation data to a file.
     */
    class save_button implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String content = viewings.getTemperatureLog();
            String initdata = viewings.getinputs();
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("Save.txt"));
                writer.write(initdata);
                writer.write(content);
                writer.close();
            } catch (IOException ex) {
                // TODO: handle exception
            }


        }
    }
    /**
     * The opener class listens for open button actions and opens the saved simulation data file.
     */
    class opener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("Save.txt"));
                String line;
                while ((line = reader.readLine()) != null) {
                    viewings.appendText(line + "\n");
                }
                reader.close();

            } catch (Exception ez) {
                // TODO: handle exception
            }

        }
    }
}