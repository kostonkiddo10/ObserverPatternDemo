
	
public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float temperature;
	private float humidity;
	private float wind;
	
	private Subject weatherData;
	
	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	public void update(float temperature, float humidity, float pressure, float wind) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.wind = wind;
		display();
	}
	
	public void display() {
		System.out.println("Current conditions: " + temperature 
			+ "F degrees,  " + humidity + "% humidity" + " , and winds at " + wind +  "mph");
	}
}
