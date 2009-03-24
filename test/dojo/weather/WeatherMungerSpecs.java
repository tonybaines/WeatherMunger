package dojo.weather;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class WeatherMungerSpecs {
	private static WeatherMunger munger = new WeatherMunger();
	@Test
	public void shouldReadAFileAndReturnItsLinesAsAnArrayOfStrings() throws FileNotFoundException {
		List<String> lines = munger.readFile(new File("weather.dat"));
		assertEquals(42, lines.size());
	}

	@Test
	public void shouldExtractTheFirstThreeFieldsFromALineAsIntegers() {
		int[] fields = munger.extractFields("  1   10   30");
		assertEquals(1, fields[0]);
		assertEquals(10, fields[1]);
		assertEquals(30, fields[2]);
	}
	@Test
	public void shouldExtractTheFirstThreeFieldsFromAnotherLineAsIntegersWhenAStarIsPresent() {
		int[] fields = munger.extractFields("  2   30   40*");
		assertEquals(2, fields[0]);
		assertEquals(30, fields[1]);
		assertEquals(40, fields[2]);
	}
	
	@Test
	public void shouldFindTheDayWithTheSmallestTempRangeFromAListOfStats() {
		List<WeatherStat> data = new ArrayList<WeatherStat>();
		data.add(new WeatherStat(new int[]{1, 100, 1}));
		data.add(new WeatherStat(new int[]{2, 100, 99}));
		data.add(new WeatherStat(new int[]{3, 100, 2}));
		data.add(new WeatherStat(new int[]{4, 100, 3}));
		assertEquals(2, munger.dayWithSmallestTempRange(data));
	}
	
}
