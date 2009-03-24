package dojo.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WeatherMunger {

	public int dayWithSmallestTempRange(File file) throws FileNotFoundException {
		List<WeatherStat> data = new ArrayList<WeatherStat>();
		for (String line : readFile(file)) {
			data.add(new WeatherStat(extractFields(line)));
		}
		return dayWithSmallestTempRange(data);
	}

	public List<String> readFile(File file) throws FileNotFoundException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		List<String> lines = new ArrayList<String>();
		try {
			while (reader.ready()) {
				lines.add(reader.readLine());
			}
		} catch (IOException e) {
			System.err.println(e.getLocalizedMessage());
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				System.err.println(e.getLocalizedMessage());
			}
		}
		return lines;
	}

	public int[] extractFields(String string) {
		String[] fields = string.split("\\D+");
		return new int[] { Integer.parseInt(fields[1]),
				Integer.parseInt(fields[2]), Integer.parseInt(fields[3]) };
	}

	public int dayWithSmallestTempRange(List<WeatherStat> data) {
		WeatherStat stat = new WeatherStat(
				new int[] { 0, Integer.MAX_VALUE, 0 });
		for (WeatherStat weatherStat : data) {
			if (weatherStat.getTempDifference() < stat.getTempDifference()) {
				stat = weatherStat;
			}
		}

		return stat.getDayNum();
	}

}
