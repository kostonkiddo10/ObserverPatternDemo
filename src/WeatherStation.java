

public class WeatherStation {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
	
		CurrentConditionsDisplay currentDisplay = 
			new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		WindChill windChill = new WindChill(weatherData);
		HeatIndex heatIndex = new HeatIndex(weatherData);
		
		
		weatherData.setMeasurements(80, 65, 30.4f, 5.0f);
		System.out.println("---------------------------");
		
		weatherData.setMeasurements(82, 70, 29.2f, 3.0f );
		System.out.println("---------------------------");

		weatherData.setMeasurements(78, 90, 29.2f, 10.0f );
		System.out.println("---------------------------");
		
		
		
		weatherData.setMeasurements(30, 80, 28.2f, 20.0f );
		System.out.println("---------------------------");
		
		weatherData.setMeasurements(0, 80, 28.2f, 70.0f );
		System.out.println("---------------------------");

	}
}

