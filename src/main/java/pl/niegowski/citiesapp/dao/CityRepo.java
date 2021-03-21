package pl.niegowski.citiesapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.niegowski.citiesapp.dao.entity.City;

@Repository
public interface CityRepo extends CrudRepository<City, Long> {
}
