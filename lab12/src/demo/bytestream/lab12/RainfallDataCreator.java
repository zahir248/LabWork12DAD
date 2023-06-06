//Exercise 5 task B

package demo.bytestream.lab12;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class RainfallDataCreator {
    public static void main(String[] args) {
        String filePath = "rainfall_data.bin"; // Path to the output file

        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(filePath))) {
            // Writing the rainfall data for 6 days
            double[] rainfallData = {10.5, 8.2, 15.0, 5.7, 11.9, 6.4};

            for (double rainfall : rainfallData) {
                outputStream.writeDouble(rainfall);
            }

            System.out.println("Rainfall data created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
