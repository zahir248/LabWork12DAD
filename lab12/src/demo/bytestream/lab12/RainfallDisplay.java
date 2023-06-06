//Exercise 5 task D


package demo.bytestream.lab12;

public class RainfallDisplay {
    private RainfallData rainfallData;

    public RainfallDisplay(RainfallData rainfallData) {
        this.rainfallData = rainfallData;
    }

    public void displayData() {
        double[] data = rainfallData.getRainfallData();

        System.out.println("Rainfall Data:");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("Day %d: %.1f mm\n", i + 1, data[i]);
        }
    }
}
