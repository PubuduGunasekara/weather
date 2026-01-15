public class Main {

    public static void main(String[] args) {

        WeatherReading reading =
                new WeatherReading(23, 12, 3, 12);

        // Automatically calls reading.toString()
        System.out.println(reading);
    }
}