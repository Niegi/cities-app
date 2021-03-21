package pl.niegowski.citiesapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/cities")
public class CityApi {

    private List<City> cities;

    public CityApi(List<City> cities) {
        this.cities = cities;
        cities.add(new City(1, "Cracow", LocalDate.of(1257, 1, 1)));
        cities.add(new City(2, "Zakopane", LocalDate.of(1578, 1, 1)));
    }

    @GetMapping("/all")
    public List<City> getCities() {
        return cities;
    }

    @GetMapping
    public City getById(@RequestParam int index) {
        return cities.stream()
                .filter(city -> city.getId() == index)
                .findFirst()
                .get();
    }

    @PostMapping
    public boolean addCity(@RequestBody City city) {
        if (cities.add(city)){
            log.info("City {} added successfully", city.getName());
            return true;
        }
        log.warn("Provided city can't be added");
        return false;
    }

    @PutMapping
    public boolean updateCity(@RequestBody City city) {
        return cities.add(city);
    }

    @DeleteMapping
    public boolean deleteCity(@RequestParam int index) {
        if (cities.removeIf(element -> element.getId() == index)) {
            log.info("City with index {} deleted successfully", index);
            return true;
        }
        log.warn("Provided index can't be deleted");
        return false;
    }
}
