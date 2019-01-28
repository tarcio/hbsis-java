package hbsis.dto;

import java.util.Date;
import java.util.List;

public class CityForecastDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private City city;
	private List<TemperatureItem> list;

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<TemperatureItem> getList() {
		return list;
	}

	public void setList(List<TemperatureItem> list) {
		this.list = list;
	}

	public static class City {

		private Long id;
		private String name;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	public static class TemperatureItem {

		private Date dt;
		private Temperature main;

		public Date getDt() {
			return dt;
		}

		public void setDt(Long seconds) {
			this.dt = new Date(seconds * 1000);
		}

		public Temperature getMain() {
			return main;
		}

		public void setMain(Temperature main) {
			this.main = main;
		}
	}

	public static class Temperature {

		private Long temp;
		private Long temp_min;
		private Long temp_max;

		public Long getTemp() {
			return temp;
		}

		public void setTemp(Long temp) {
			this.temp = temp;
		}

		public Long getTemp_min() {
			return temp_min;
		}

		public void setTemp_min(Long temp_min) {
			this.temp_min = temp_min;
		}

		public Long getTemp_max() {
			return temp_max;
		}

		public void setTemp_max(Long temp_max) {
			this.temp_max = temp_max;
		}
	}
}
