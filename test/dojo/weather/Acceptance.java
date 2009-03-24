package dojo.weather;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;


public class Acceptance {
	@Test
	public void shouldReturnTheDayWithTheSmallestTempRange() throws FileNotFoundException {
		WeatherMunger munger = new WeatherMunger();
		assertEquals(14, munger.dayWithSmallestTempRange(new File("weather.dat")));
	}
}
