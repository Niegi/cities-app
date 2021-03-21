package pl.niegowski.citiesapp.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.niegowski.citiesapp.dao.entity.City;
import pl.niegowski.citiesapp.manager.CityManager;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/cities")
public class CityApi {

    private CityManager cityManager;

    @Autowired
    public CityApi(CityManager cityManager) {
        this.cityManager = cityManager;
    }

    @GetMapping("/all")
    public Iterable<City> getCities() {
        return cityManager.findAll();
    }

    @GetMapping
    public Optional<City> getById(@RequestParam Long index) {
        return cityManager.findById(index);
    }

    @PostMapping
    public City addCity(@RequestBody City city) {
        City addingCity = cityManager.save(city);
        if (addingCity != null){
            log.info("City {} added successfully", city.getName());
            return addingCity;
        }
        log.warn("Provided city can't be added");
        return null;
    }

    @PutMapping
    public City updateCity(@RequestBody City city) {
        City addingCity = cityManager.save(city);
        if (addingCity != null){
            log.info("City {} updated successfully", city.getName());
            return addingCity;
        }
        log.warn("Provided city can't be updated");
        return null;
    }

    @DeleteMapping
    public void deleteCity(@RequestParam Long index) {
        log.info("Deleting city with id {}", index);
        cityManager.delete(index);
    }
}
