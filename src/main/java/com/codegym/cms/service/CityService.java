package com.codegym.cms.service;

import com.codegym.cms.model.City;
import com.codegym.cms.model.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CityService {
    Page<City> findAll(Pageable pageable);

    City findById(Long id);

    void save(City customer);

    void remove(Long id);

}
