package pl.niegowski.citiesapp.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class City {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private LocalDate yearOfEstablishment;

    public City() {
    }

    public City(Long id, String name, LocalDate yearOfEstablishment) {
        this.id = id;
        this.name = name;
        this.yearOfEstablishment = yearOfEstablishment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getYearOfEstablishment() {
        return yearOfEstablishment;
    }

    public void setYearOfEstablishment(LocalDate yearOfEstablishment) {
        this.yearOfEstablishment = yearOfEstablishment;
    }
}
