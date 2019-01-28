package hbsis.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hbsis.dto.CityForecastDTO;
import hbsis.dto.CityWeatherDTO;
import hbsis.entity.City;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityControllerTest {

	@Autowired
	private CityController cityController;

	@Test
	public void contextLoads() throws Exception {

		assertThat(cityController).isNotNull();
	}

	@Test
	public void findAll() throws Exception {

		assertThat(cityController.findAll()).isNotNull();

		cityController.save("Blumenau");
		assertThat(cityController.findAll().size() > 0).isTrue();
	}

	@Test
	public void findByName() throws Exception {

		City city0 = cityController.findByName("Blumenau").getBody();
		assertThat(city0).isNotNull();

		City city1 = cityController.findByName("A very strange name for a city... Date: " + new Date().toString()).getBody();
		assertThat(city1).isNull();
	}

	@Test
	public void save() throws Exception {

		cityController.save("Belém");
		City city = cityController.findByName("Belém").getBody();

		assertThat(city).isNotNull();
		assertThat(city.getId()).isNotNull();
		assertThat(city.getName()).isNotNull();
	}

	@Test
	public void delete() throws Exception {

		City city0 = cityController.findByName("Belém").getBody();
		assertThat(city0).isNotNull();

		cityController.delete(city0.getName());
		city0 = cityController.findByName("Belém").getBody();

		assertThat(city0).isNull();

		City city1 = cityController.findByName("Blumenau").getBody();
		assertThat(city1).isNotNull();

		cityController.delete(city1.getName());
		city1 = cityController.findByName("Blumenau").getBody();

		assertThat(city1).isNull();
	}

	@Test
	public void findWeather() throws Exception {

		CityWeatherDTO dto = cityController.findWeather("Blumenau");

		assertThat(dto).isNotNull();
		assertThat(dto.getId()).isNotNull();
		assertThat(dto.getName()).isNotNull();
	}

	@Test
	public void findForecast() throws Exception {

		CityForecastDTO dto = cityController.findForecast("Blumenau");

		assertThat(dto).isNotNull();
		assertThat(dto.getCity()).isNotNull();
		assertThat(dto.getCity().getId()).isNotNull();
		assertThat(dto.getCity().getName()).isNotNull();

		assertThat(dto).isNotNull();
		assertThat(dto.getList()).isNotNull();
		assertThat(dto.getList().size() > 0).isTrue();
	}
}
