//Exercise 5 task D


package demo.bytestream.lab12;

public class RainfallStats {
    private RainfallData rainfallData;

    public RainfallStats(RainfallData rainfallData) {
        this.rainfallData = rainfallData;
    }

    public double computeAverage() {
        double[] data = rainfallData.getRainfallData();

        double sum = 0;
        for (double rainfall : data) {
            sum += rainfall;
        }

        return sum / data.length;
    }
}
