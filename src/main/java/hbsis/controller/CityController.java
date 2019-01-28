package hbsis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import hbsis.dto.CityForecastDTO;
import hbsis.dto.CityWeatherDTO;
import hbsis.entity.City;
import hbsis.repository.CityRepository;

@RestController
@RequestMapping("/api/v1")
public class CityController extends BaseController {

	@Value("${app.openweather.url.weather}")
	private String openWeatherURLWeather;

	@Value("${app.openweather.url.forecast}")
	private String openWeatherURLForecast;

	@Value("${app.openweather.apikey}")
	private String openWeatherApiKey;

	@Autowired
	private CityRepository cityRepository;

	@GetMapping("/city")
	public List<City> findAll() {

		return cityRepository.findAll();
	}

	@GetMapping("/city/{name}")
	public ResponseEntity<City> findByName(@PathVariable(value = "name") String name) {

		return ResponseEntity.ok().body(cityRepository.findByName(name));
	}

	@GetMapping("/city/save/{name}")
	public ResponseEntity<City> save(@PathVariable(value = "name") String name) {

		if (cityRepository.findByName(name) != null)
			return null;

		CityWeatherDTO cityWeatherDTO = findWeather(name);

		if (cityWeatherDTO == null)
			return null;

		City city = new City();

		city.setId(cityWeatherDTO.getId());
		city.setName(cityWeatherDTO.getName());

		return ResponseEntity.ok().body(cityRepository.save(city));
	}

	@GetMapping("/city/delete/{name}")
	public void delete(@PathVariable(value = "name") String name) {

		City city = cityRepository.findByName(name);

		if (city == null)
			return;

		cityRepository.delete(city);
	}

	@GetMapping("/city/weather/{name}")
	public CityWeatherDTO findWeather(@PathVariable(value = "name") String name) {

		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(openWeatherURLWeather);
		uriComponentsBuilder.queryParam("apikey", openWeatherApiKey);
		uriComponentsBuilder.queryParam("q", name);

		RestTemplate restTemplate = new RestTemplate();
		CityWeatherDTO cityWeatherDTO = restTemplate.getForObject(uriComponentsBuilder.build().toUri(), CityWeatherDTO.class);

		return cityWeatherDTO;
	}

	@GetMapping("/city/forecast/{name}")
	public CityForecastDTO findForecast(@PathVariable(value = "name") String name) {

		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(openWeatherURLForecast);
		uriComponentsBuilder.queryParam("apikey", openWeatherApiKey);
		uriComponentsBuilder.queryParam("q", name);

		RestTemplate restTemplate = new RestTemplate();
		CityForecastDTO cityForecastDTO = restTemplate.getForObject(uriComponentsBuilder.build().toUri(), CityForecastDTO.class);

		return cityForecastDTO;
	}
}
