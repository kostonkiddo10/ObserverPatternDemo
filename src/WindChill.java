/*

Wind Chill Calculation:
   If temperature < 50 degrees, compute wind chill based on temperature & Wind
   
   Otherwise, wind chill is same as temperature

*/

public class WindChill implements Observer, DisplayElement {
	private float windChill;
	private WeatherData weatherData;

	public WindChill(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public float computeWindchillIndex(float temp, float wind) {
		if (temp < 50.0) {
			float index = (float) (35.74 + 0.6215 * temp + (0.4275 * temp - 35.75) * Math.pow(wind, 0.16));
			return index;
		} else {
			return temp;
		}
	}

	@Override
	public void update(float temp, float humidity, float pressure, float wind) {

		windChill = computeWindchillIndex(temp, wind);

		display();
	}

	@Override
	public void display() {
		System.out.println("Wind Chill: " + windChill);
	}
}
	