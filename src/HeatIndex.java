/*
Heat Index Calculation: 
  If temperature > 80 degrees, computer heat Index based on temperature and humidity
  
  Otherwise, heat index is same as temperature
  
*/
public class HeatIndex implements Observer, DisplayElement {
	private float heatIndex;
	private WeatherData weatherData;

	public HeatIndex(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	private float computeHeatIndex(float t, float rh) {
		if (t > 80.0) {
			float index = (float) ((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh) + (0.00941695 * (t * t)) + (0.00728898 * (rh * rh))
					+ (0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh)) +
					(0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + (0.0000291583 *
					(rh * rh * rh)) + (0.00000142721 * (t * t * t * rh)) +
					(0.000000197483 * (t * rh * rh * rh)) - (0.0000000218429 * (t * t * t * rh * rh)) +
					0.000000000843296 * (t * t * rh * rh * rh)) -
					(0.0000000000481975 * (t * t * t * rh * rh * rh)));
			return index;
		} else {
			return t;
		}
	}

	@Override
	public void update(float temp, float humidity, float pressure, float wind) {
		if(temp>80) heatIndex = computeHeatIndex(humidity, wind);
		else heatIndex = temp;

		display();
	}

	@Override
	public void display() {
		System.out.println("Heat index: " + heatIndex);
	}

}