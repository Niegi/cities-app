package pl.niegowski.citiesapp;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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
        return cities.add(city);
    }

    @PutMapping
    public boolean updateCity(@RequestBody City city) {
        return cities.add(city);
    }

    @DeleteMapping
    public boolean deleteCity(@RequestParam int index) {
        return cities.removeIf(element -> element.getId() == index);
    }
}
