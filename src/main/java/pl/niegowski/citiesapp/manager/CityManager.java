package pl.niegowski.citiesapp.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.niegowski.citiesapp.dao.CityRepo;
import pl.niegowski.citiesapp.dao.entity.City;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CityManager {

    private CityRepo cityRepo;

    @Autowired
    public CityManager(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    public Optional<City> findById(Long id) {
        return cityRepo.findById(id);
    }

    public Iterable<City> findAll() {
        return cityRepo.findAll();
    }

    public City save(City city) {
        return cityRepo.save(city);
    }

    public void delete(Long id) {
        cityRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initialDBFill() {
        save(new City(1L, "Cracow", LocalDate.of(1257, 1, 1)));
        save(new City(2L, "Zakopane", LocalDate.of(1578, 1, 1)));
    }
}
