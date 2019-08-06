package com.codegym.cms.repository;
//Khai bao phuong thuc chung cho tat ca repository

import java.util.List;

public interface Repository<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T model);

    void remove(Long id);
}
