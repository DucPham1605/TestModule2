package com.codegym.cms.controller;
import com.codegym.cms.model.City;
import com.codegym.cms.model.Country;
import com.codegym.cms.service.CityService;
import com.codegym.cms.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller
public class CityController {
@Autowired
private CityService cityService;

@Autowired
private CountryService countryService;

    @GetMapping("/cities")
    public ModelAndView listCities(Pageable pageable){
        Page<City> cities = cityService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/city/list");
        modelAndView.addObject("cities", cities);
        return modelAndView;

    }

    @GetMapping("/create-city")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/create-city")
    public ModelAndView saveCity(@ModelAttribute("city") City city){
        cityService.save(city);

        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city", new City());
        modelAndView.addObject("message", "New city created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-city/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        City city = cityService.findById(id);
        if(city != null) {
            ModelAndView modelAndView = new ModelAndView("/city/edit");
            modelAndView.addObject("city", city);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-city")
    public ModelAndView editCity(@ModelAttribute("city") City city){
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("/city/edit");
        modelAndView.addObject("city", city);
        modelAndView.addObject("message", "City updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-city/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        City city = cityService.findById(id);
        if(city != null) {
            ModelAndView modelAndView = new ModelAndView("/city/delete");
            modelAndView.addObject("city", city);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-city")
    public String deleteCity(@ModelAttribute("city") City city){
        cityService.remove(city.getId());
        return "redirect:cities";
    }

    @GetMapping("/view-city/{id}")
    public ModelAndView viewCity(@PathVariable Long id){
        City city = cityService.findById(id);
        if(city != null) {
            ModelAndView modelAndView = new ModelAndView("/city/view");
            modelAndView.addObject("city", city);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @ModelAttribute("countries")
    public Iterable<Country> countries(){
        return countryService.findAll();
    }

}
