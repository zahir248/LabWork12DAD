//Exercise 5 task D


package demo.bytestream.lab12;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class RainfallData {
    private double[] rainfallData;

    public void readData(String filePath) {
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(filePath))) {
            int numDays = 6; // Number of days of rainfall data
            rainfallData = new double[numDays];

            for (int i = 0; i < numDays; i++) {
                rainfallData[i] = inputStream.readDouble();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double[] getRainfallData() {
        return rainfallData;
    }
}
