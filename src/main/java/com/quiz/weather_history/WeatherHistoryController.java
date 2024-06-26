package com.quiz.weather_history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.weather_history.bo.WeatherHistoryBO;
import com.quiz.weather_history.domain.WeatherHistory;

@Controller
@RequestMapping("/weather-history")
public class WeatherHistoryController {

	@Autowired
	private WeatherHistoryBO weatherHistoryBO;

	// 날씨 목록 화면
	// http://localhost:8080/weather-history/weather-list-view
	@GetMapping("weather-list-view")
	public String weatherListView(Model model) {
		// select db
		List<WeatherHistory> weatherHistoryList = weatherHistoryBO.getWeatherHistoryList();

		// model 담기
		model.addAttribute("weatherHistoryList", weatherHistoryList);

		// 화면 이동
		return "weather_history/weatherList";
	}

	// 날씨 추가 화면
	// http://localhost:8080/weather-history/add-weather-view
	@GetMapping("/add-weather-view")
	public String addWeatherView() {

		return "weather_history/addWeather";
	}

	// 날씨 추가 기능
	// weather-history/add-weather
	@PostMapping("/add-weather")
	public String addWeather(
			// Date로 들어오는 경우 @DateTimeFormat(pattern = "yyyy-MM-dd")를 사용
			// weatherHistory 객체로 가져오는 경우 domain에서 파라미터 위에 작성 @DateTimeFormat(pattern =
			// "yyyy-MM-dd")
			/*
			 * @RequestParam("date") LocalDate date,
			 * 
			 * @RequestParam("weather") String weather, @RequestParam("microDust") String
			 * microDust,
			 * 
			 * @RequestParam("temperatures") double
			 * temperatures, @RequestParam("precipitation") double precipitation,
			 * 
			 * @RequestParam("windSpeed") double windSpeed, Model model
			 */

			@ModelAttribute WeatherHistory weatherHistory, Model model) {

		// db insert
		weatherHistoryBO.addWeather(weatherHistory);

		// 웹에서는 메소드 호출이 불가능 해서 redirect를 해줘야 한다.
		// redirect => 날씨 목록
		return "redirect:/weather-history/weather-list-view";
	}

}
