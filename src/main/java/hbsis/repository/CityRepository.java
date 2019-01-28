package hbsis.repository;

import hbsis.entity.City;

public interface CityRepository extends BaseRepository<City> {

	public City findByName(String name);
}
