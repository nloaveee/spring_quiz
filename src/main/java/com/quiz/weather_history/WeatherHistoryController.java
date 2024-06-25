package com.quiz.weather_history;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/weather_history")
public class WeatherHistoryController {

	// http://localhost:8080/weather_history/weather-list-view
	@GetMapping("weather-list-view")
	public String weatherListView() {

		return "weather_history/weatherList";
	}

	// http://localhost:8080/weather_history/add-weather-view
	@GetMapping("add-weather-view")
	public String addWeatherView() {

		return "weather_history/addWeather";
	}
}
