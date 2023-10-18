import javax.swing.*;
import java.awt.event.ActionListener;
public class simulation_file {
    /**
     * This class represents a simulation of weather parameters, including temperature, humidity, and soil moisture.
     */
    public JButton openButton, saveButton, stopButton, startButton;
    public JTextField tempInput, TemperatureIncrementInput, TemperatureDecrementInput, temperaturesampleInput;
    public JLabel Temp, tempInc, tempDec, tempSample, wweatherjlabel;
    public JTextField humidityInput, humidityIncrementInput, humidityDecrementInput, humiditysampleInput;
    public JLabel hum, humINC, humDEC, humSample;
    public JTextField Soil_input, Soil_inc_input, Soil_Dec_input, Soil_sample_input;
    public JLabel Soil, Soil_inc, Soil_Dec, Soil_sample;
    public JTextField weatherField;
    public JTextArea aTextArea;
    public JTextField getSoil_input() {
        return Soil_input;
    }/**
     * Getter for soil_input.
     * @return Soil_input as JTextField
     */

    public JTextField getSoil_inc_input() {
        return Soil_inc_input;
    }/**
     * Getter for soil_inc_input.
     * @return Soil_inc_input as JTextField
     */
    public JTextField getSoil_Dec_input() {
        return Soil_Dec_input;
    }/**
     * Getter for soil_dec_input.
     * @return Soil_dec_input as JTextField
     */
    public JTextField getSoil_sample_input() {
        return Soil_sample_input;
    }/**
     * Getter for soil_sample_input.
     * @return Soil_sample_input as JTextField
     */

    public JTextField getHumidityInput() {
        return humidityInput;
    }/**
     * Getter for humidityInput.
     * @return humidityInput as JTextField
     */
    public JTextField getHumidityIncrementInput() {
        return humidityIncrementInput;
    }/**
     * Getter for humidityIncrementInput.
     * @return humidityIncrementInput as JTextField
     */
    public JTextField getHumidityDecrementInput() {
        return humidityDecrementInput;
    }/**
     * Getter for humidityDecrementInput.
     * @return humidityDecrementInput as JTextField
     */

    public JTextField getHumiditysampleInput() {
        return humiditysampleInput;
    }/**
     * Getter for humiditysampleInput.
     * @return humiditysampleInput as JTextField
     */

    public JTextField getWeatherField() {
        return weatherField;
    }/**
     * Getter for weatherField.
     * @return weatherField as JTextField
     */

    public JTextField getTempInput() {
        return tempInput;
    }/**
     * Getter for temp_input.
     * @return temp_input as JTextField
     */
    public JTextField getTemperatureIncrementInput() {
        return TemperatureIncrementInput;
    }/**
     * Getter for incremented_temp_input.
     * @return incremented_temp_input as JTextField
     */
    public JTextField getTemperatureDecrementInput() {
        return TemperatureDecrementInput;
    }
    public JTextField getTemperaturesampleInput() {
        return temperaturesampleInput;
    }
    /**
     * Constructor for Simulation class.
     * Initializes and configures the UI components.
     */
    simulation_file(){

        //create a new Jframe
        JFrame frame = new JFrame("Table Loop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 620);
        // frame.setLayout(new BorderLayout());


        JPanel panel = new JPanel();
        panel.setLayout(null);

        //create the new weather section
        wweatherjlabel = new JLabel("Weather (°C/min)");
        weatherField = new JTextField();

        //create a temperature input section
        Temp = new JLabel("Temperature-> (°C)");
        tempInc = new JLabel("Increasing rate ->(°C/Min)");
        tempDec = new JLabel("Decreasing rate-> (°C/Min)");
        tempSample = new JLabel("Temperature-> Update");
        tempInput = new JTextField();
        TemperatureIncrementInput = new JTextField();
        TemperatureDecrementInput = new JTextField();
        temperaturesampleInput = new JTextField();

        //create a humidity input section
        hum = new JLabel("Humidity (%)");
        humINC = new JLabel("Increasing rate (%/Min)");
        humDEC = new JLabel("Decreasing rate (%/Min)");
        humSample = new JLabel("Humidity Update ");
        humidityInput = new JTextField();
        humidityIncrementInput = new JTextField();
        humidityDecrementInput = new JTextField();
        humiditysampleInput = new JTextField();
/**
 * Appends a message to the JTextArea.
 * @param mesag Message to display in the JTextArea
 */

        //create a soil moisture input section
        Soil = new JLabel("Soil Moister (%)");
        Soil_inc = new JLabel("Increasing rate (%/Min)");
        Soil_Dec = new JLabel("Decreasing rate (%/Min)");
        Soil_sample = new JLabel("Soil Moister Update");
        Soil_input = new JTextField();
        Soil_inc_input = new JTextField();
        Soil_Dec_input = new JTextField();
        Soil_sample_input = new JTextField();
/**
 * Retrieves the temperature log from JTextArea.
 * @return String representation of the temperature log
 */
        //set the weatehr to the panel
        wweatherjlabel.setBounds(21, 151 , 251, 32);
        weatherField.setBounds(173, 152, 102, 31);
        panel.add(weatherField);
        panel.add(wweatherjlabel);

        //set the Temperature Components to the panels
        Temp.setBounds(21, 11 , 251, 30);
        tempInc.setBounds(20, 40, 250, 30);
        tempDec.setBounds(20, 70, 250, 30);
        tempSample.setBounds(20, 100, 250, 30);
        panel.add(Temp);
        panel.add(tempInc);
        panel.add(tempDec);
        panel.add(tempSample);

        //set the Humidity Components to the panels
        hum.setBounds(320, 10 , 250, 30);
        humINC.setBounds(320, 40, 250, 30);
        humDEC.setBounds(320, 70, 250, 30);
        humSample.setBounds(320, 100, 250, 30);
        panel.add(hum);
        panel.add(humINC);
        panel.add(humDEC);
        panel.add(humSample);
        //set the Humidity Components to the panels
        Soil.setBounds(620, 10 , 250, 30);
        Soil_inc.setBounds(620, 40, 250, 30);
        Soil_Dec.setBounds(620, 70, 250, 30);
        Soil_sample.setBounds(620, 100, 250, 30);
        panel.add(Soil);
        panel.add(Soil_inc);
        panel.add(Soil_Dec);
        panel.add(Soil_sample);

        //This is a new area

        tempInput.setBounds(175, 10 , 100, 30);
        TemperatureIncrementInput.setBounds(175, 40, 100, 30);
        TemperatureDecrementInput.setBounds(175, 70, 100, 30);
        temperaturesampleInput.setBounds(175, 100, 100, 30);
        panel.add(tempInput);
        panel.add(TemperatureIncrementInput);
        panel.add(TemperatureDecrementInput);
        panel.add(temperaturesampleInput);

        //set the Humidity Components to the panels
        humidityInput.setBounds(475, 10 , 100, 30);
        humidityIncrementInput.setBounds(475, 40, 100, 30);
        humidityDecrementInput.setBounds(475, 70, 100, 30);
        humiditysampleInput.setBounds(475, 100, 100, 30);
        panel.add(humidityInput);
        panel.add(humidityIncrementInput);
        panel.add(humidityDecrementInput);
        panel.add(humiditysampleInput);

        //set the Humidity Components to the panels
        Soil_input.setBounds(775, 10 , 100, 30);
        Soil_inc_input.setBounds(775, 40, 100, 30);
        Soil_Dec_input.setBounds(775, 70, 100, 30);
        Soil_sample_input.setBounds(775, 100, 100, 30);
        panel.add(Soil_input);
        panel.add(Soil_inc_input);
        panel.add(Soil_Dec_input);
        panel.add(Soil_sample_input);

        startButton = new JButton("START");
        stopButton = new JButton("STOP");
        saveButton = new JButton("SAVE");
        openButton = new JButton("OPEN");

        startButton.setBounds(320, 150 , 100, 30);
        stopButton.setBounds(475, 150, 100, 30);
        saveButton.setBounds(620, 150 , 100, 30);
        openButton.setBounds(775, 150, 100, 30);
        panel.add(startButton);
        panel.add(stopButton);
        panel.add(saveButton);
        panel.add(openButton);

        aTextArea = new JTextArea();
        aTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(aTextArea);
        scrollPane.setBounds(21, 201, 870, 340);
        panel.add(scrollPane);

        frame.add(panel);
        frame.setVisible(true);
    }


    public void addStopButtonListener(ActionListener listener){
        stopButton.addActionListener(listener);
    }
    public void addStartButtonListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }
    public void addOpenButtonActionListener(ActionListener listener) {
        openButton.addActionListener(listener);
    }

    public void addSaveButtonActionListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }



    public synchronized void appendTemperature(double temperature, String mesag) {
        aTextArea.append(String.format("Temperature : "+ temperature + " || " + mesag + "\n"));

    }
    public synchronized void appendSoilMoisture(double temperature, String mesag) {
        aTextArea.append(String.format("Soil Moisture : "+ temperature + " || " + mesag + "\n"));

    }
    public synchronized void appendHumidity(double temperature, String mesag) {
        aTextArea.append(String.format("Humidity : "+ temperature + " || " + mesag + "\n"));

    }

    public synchronized void appendText(String mesag) {
        aTextArea.append(String.format(mesag));

    }

    public String getinputs() {
        return "\n--Weather: " + weatherField.getText()+"\n--Temperature: "+ tempInput.getText()+
                " || Temperature Decrease rate: " + TemperatureDecrementInput.getText()+" || Temperature Increase rate: " + TemperatureIncrementInput.getText()+
                " || Temerature Sample rate (mille): " + temperaturesampleInput.getText()+"\n--Humidity: "+ humidityInput.getText()+
                " || Humidity Decrease rate: " + humidityDecrementInput.getText()+" || Humidity Increase rate: " + humidityIncrementInput.getText()+
                " || Humidity Sample rate (mille): " + humiditysampleInput.getText()+"\n--Soil Moister: " +Soil_input.getText()+
                " || Soil Moister Decrease rate: " +Soil_Dec_input.getText()+
                " || Soil Moister Increase rate: "+Soil_inc_input.getText()+" || Soil Moister Sample rate (mille): " +Soil_sample_input.getText()+ "\n\n";
    }

    public String getTemperatureLog() {
        return aTextArea.getText();
    }
}
