package pl.niegowski.citiesapp;

import java.time.LocalDate;

public class City {

    private int id;
    private String name;
    private LocalDate yearOfEstablishment;

    public City() {
    }

    public City(int id, String name, LocalDate yearOfEstablishment) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getYearOfEstablishment() {
        return yearOfEstablishment;
    }

    public void setYearOfEstablishment(LocalDate yearOfEstablishment) {
        this.yearOfEstablishment = yearOfEstablishment;
    }
}
