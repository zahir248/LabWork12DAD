//Exercise 7

package demo.bytestream.lab12;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RainfallDataCreator3 {
    public static void main(String[] args) {
        String filePath = "rainfall_data.txt"; // Path to the output file

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Writing the rainfall data for two stations in each district
            String[][] stationData = {
                    // District 1: Alor Gajah
                    {"1", "Station A", "1", "10", "20", "30", "40", "50", "60"},
                    {"2", "Station B", "1", "15", "25", "35", "45", "55", "65"},
                    // District 2: Jasin
                    {"3", "Station C", "2", "12", "22", "32", "42", "52", "62"},
                    {"4", "Station D", "2", "18", "28", "38", "48", "58", "68"}
            };

            int numStations = stationData.length;

            writer.write(Integer.toString(numStations)); // Writing the number of stations
            writer.newLine();

            for (String[] data : stationData) {
                for (int i = 0; i < data.length; i++) {
                    writer.write(data[i]);
                    if (i < data.length - 1) {
                        writer.write(",");
                    }
                }
                writer.newLine();
            }

            System.out.println("Rainfall data created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
