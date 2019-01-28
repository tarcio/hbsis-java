package hbsis.dto;

public class CityWeatherDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;

	private Temperature main;

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

	public Temperature getMain() {
		return main;
	}

	public void setMain(Temperature main) {
		this.main = main;
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
