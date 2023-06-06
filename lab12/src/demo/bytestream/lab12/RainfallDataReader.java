//Exercise 6

package demo.bytestream.lab12;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class RainfallDataReader {
    public static void main(String[] args) {
        String filePath = "rainfall_data.bin"; // Path to the input file

        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(filePath))) {
            int numStations = inputStream.readInt(); // Reading the number of stations

            int numDistricts = 0;
            int stationCount = 0;

            System.out.println("Rainfall Data:");
            System.out.println("----------------------------------");

            for (int i = 0; i < numStations; i++) {
                int stationId = inputStream.readInt();
                String stationName = inputStream.readUTF();
                String districtName = inputStream.readUTF();

                int[] rainfallData = new int[6];
                for (int j = 0; j < 6; j++) {
                    rainfallData[j] = inputStream.readInt();
                }

                // Display station data
                System.out.println("Station ID: " + stationId);
                System.out.println("Station Name: " + stationName);
                System.out.println("District Name: " + districtName);
                System.out.print("Rainfall Readings: ");
                for (int rainfall : rainfallData) {
                    System.out.print(rainfall + " ");
                }
                System.out.println("\n");

                stationCount++;
                if (i == 0 || !districtName.equals(inputStream.readUTF())) {
                    numDistricts++;
                }
            }

            double averageRainfall = 0;
            if (stationCount > 0) {
                averageRainfall = (double) (stationCount * 6) / numStations;
            }

            System.out.println("----------------------------------");
            System.out.println("Number of Stations: " + numStations);
            System.out.println("Number of Districts: " + numDistricts);
            System.out.println("Average Rainfall per Station: " + averageRainfall);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
