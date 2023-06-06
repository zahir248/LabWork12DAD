//Exercise 7

package demo.bytestream.lab12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RainfallDataReader2 {
    public static void main(String[] args) {
        String filePath = "rainfall_data.txt"; // Path to the input file

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int numStations = Integer.parseInt(reader.readLine()); // Reading the number of stations

            int numDistricts = 0;
            int stationCount = 0;

            System.out.println("Rainfall Data:");
            System.out.println("----------------------------------");

            String line;
            while ((line = reader.readLine()) != null) {
                String[] stationData = line.split(",");

                int stationId = Integer.parseInt(stationData[0]);
                String stationName = stationData[1];
                String districtId = stationData[2];

                int[] rainfallData = new int[6];
                for (int i = 0; i < 6; i++) {
                    rainfallData[i] = Integer.parseInt(stationData[i + 3]);
                }

                // Display station data
                System.out.println("Station ID: " + stationId);
                System.out.println("Station Name: " + stationName);
                System.out.println("District ID: " + districtId);
                System.out.print("Rainfall Readings: ");
                for (int rainfall : rainfallData) {
                    System.out.print(rainfall + " ");
                }
                System.out.println("\n");

                stationCount++;
                if (stationCount == 1 || !districtId.equals(stationData[2])) {
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

