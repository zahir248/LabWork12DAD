//Exercise 5 task D

package demo.bytestream.lab12;

public class RainfallDataConsumer {
    public static void main(String[] args) {
        String filePath = "rainfall_data.bin"; // Path to the input file

        RainfallData rainfallData = new RainfallData();
        rainfallData.readData(filePath);

        RainfallDisplay rainfallDisplay = new RainfallDisplay(rainfallData);
        rainfallDisplay.displayData();

        RainfallStats rainfallStats = new RainfallStats(rainfallData);
        double averageRainfall = rainfallStats.computeAverage();
        System.out.println("Average Rainfall: " + averageRainfall + " mm");
    }
}