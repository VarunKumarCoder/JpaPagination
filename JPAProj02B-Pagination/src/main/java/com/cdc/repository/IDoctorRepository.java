package com.cdc.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cdc.entity.Doctor;

public interface IDoctorRepository extends PagingAndSortingRepository<Doctor, Integer> {

}
