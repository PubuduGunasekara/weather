public class WeatherReading {

    private final int temperature;
    private final int dewPoint;
    private final int windSpeed;
    private final int totalRain;

    public WeatherReading(int temperature, int dewPoint, int windSpeed, int totalRain) {
        if (dewPoint > temperature || windSpeed < 0 || totalRain < 0) {
            throw new IllegalArgumentException("Invalid weather values");
        }
        this.temperature = temperature;
        this.dewPoint = dewPoint;
        this.windSpeed = windSpeed;
        this.totalRain = totalRain;
    }

    // Accessors
    public int getTemperature() {
        return temperature;
    }

    public int getDewPoint() {
        return dewPoint;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public int getTotalRain() {
        return totalRain;
    }

    // Derived values
    public int getRelativeHumidity() {
        double numerator =
                Math.exp((17.625 * dewPoint) / (243.04 + dewPoint));
        double denominator =
                Math.exp((17.625 * temperature) / (243.04 + temperature));
        return (int) Math.round(100 * numerator / denominator);
    }

    public double getHeatIndex() {
        int R = getRelativeHumidity();
        double T = temperature;

        double c1 = -8.78469475556;
        double c2 = 1.61139411;
        double c3 = 2.33854883889;
        double c4 = -0.14611605;
        double c5 = -0.012308094;
        double c6 = -0.0164248277778;
        double c7 = 0.002211732;
        double c8 = 0.00072546;
        double c9 = -0.000003582;

        return c1
                + c2 * T
                + c3 * R
                + c4 * T * R
                + c5 * T * T
                + c6 * R * R
                + c7 * T * T * R
                + c8 * T * R * R
                + c9 * T * T * R * R;
    }

    public double getWindChill() {
        // Convert C → F
        double tempF = temperature * 9.0 / 5.0 + 32;

        double wcF = 35.74
                + 0.6215 * tempF
                - 35.75 * Math.pow(windSpeed, 0.16)
                + 0.4275 * tempF * Math.pow(windSpeed, 0.16);

        // Convert back to C
        return (wcF - 32) * 5.0 / 9.0;
    }

    @Override
    public String toString() {
        return "Reading: T = " + temperature +
                ", D = " + dewPoint +
                ", v = " + windSpeed +
                ", rain = " + totalRain;
    }
}
