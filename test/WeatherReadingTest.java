import static org.junit.Assert.*;
import org.junit.Test;

public class WeatherReadingTest {

    @Test
    public void testValidCreation() {
        WeatherReading r = new WeatherReading(23, 12, 3, 12);
        assertEquals(23, r.getTemperature());
        assertEquals(12, r.getDewPoint());
        assertEquals(3, r.getWindSpeed());
        assertEquals(12, r.getTotalRain());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDewPoint() {
        new WeatherReading(10, 15, 2, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWindSpeed() {
        new WeatherReading(10, 5, -1, 0);
    }

    @Test
    public void testRelativeHumidityRange() {
        WeatherReading r = new WeatherReading(30, 20, 5, 0);
        int rh = r.getRelativeHumidity();
        assertTrue(rh >= 0 && rh <= 100);
    }

    @Test
    public void testHeatIndexCalculation() {
        WeatherReading r = new WeatherReading(30, 20, 2, 0);
        double hi = r.getHeatIndex();
        assertTrue(hi > 30);
    }

    @Test
    public void testWindChillLowerThanTemp() {
        WeatherReading r = new WeatherReading(5, 0, 20, 0);
        assertTrue(r.getWindChill() < r.getTemperature());
    }

    @Test
    public void testToString() {
        WeatherReading r = new WeatherReading(23, 12, 3, 12);
        assertEquals(
                "Reading: T = 23, D = 12, v = 3, rain = 12",
                r.toString()
        );
    }
}
