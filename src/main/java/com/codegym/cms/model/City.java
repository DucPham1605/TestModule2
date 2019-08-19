package com.codegym.cms.model;

import javax.persistence.*;

@Entity
@Table(name="cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double area;
    private Long population;
    private double gdp;
    private String description;

    @ManyToOne
    @JoinColumn(name = "country_id")
   private Country country;

    public City() {
    }

    public City(String name, double area, Long population, double gdp, String description, Country country) {
        this.name = name;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
        this.country = country;
    }

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

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public double getGdp() {
        return gdp;
    }

    public void setGdp(double gdp) {
        this.gdp = gdp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
