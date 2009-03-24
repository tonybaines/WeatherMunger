package dojo.weather;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeatherStatSpec {
	@Test
	public void shouldBeConstructedUsingAnArrayOfItsAttributes() {
		WeatherStat stat = new WeatherStat(new int[] {1, 11, 10});
		assertEquals(1, stat.getDayNum());
		assertEquals(11, stat.getMaxTemp());
		assertEquals(10, stat.getMinTemp());
	}
	@Test
	public void shouldReturnTheDifferenceBetweenTheMinAndMaxTemp() {
		WeatherStat stat = new WeatherStat(new int[] {1, 11, 10});
		assertEquals(1, stat.getTempDifference());
	}
}
