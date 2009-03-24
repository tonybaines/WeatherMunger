package dojo.weather;

public class WeatherStat {

	public int getDayNum() {
		return dayNum;
	}

	public int getMaxTemp() {
		return maxTemp;
	}

	public int getMinTemp() {
		return minTemp;
	}

	private int dayNum;
	private int maxTemp;
	private int minTemp;

	public WeatherStat(int[] attributes) {
		this.dayNum = attributes[0];
		this.maxTemp = attributes[1];
		this.minTemp = attributes[2];
	}

	public int getTempDifference() {
		return this.maxTemp - this.minTemp;
	}

}
