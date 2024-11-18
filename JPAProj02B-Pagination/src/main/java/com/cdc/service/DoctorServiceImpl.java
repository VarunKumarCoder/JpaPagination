package com.cdc.service;

import java.awt.print.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cdc.entity.Doctor;
import com.cdc.repository.IDoctorRepository;

@Service("service")
public class DoctorServiceImpl implements IDoctorService {
	@Autowired
	private IDoctorRepository doctorRepo;

	@Override
	public Iterable<Doctor> showDoctorsBySorting(boolean asc, String... props) {
		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, props);
		Iterable<Doctor> it = doctorRepo.findAll(sort);
		return it;
	}

	@Override
	public Page<Doctor> showDoctotsInfoByPageNumber(int pageNo, int pageSize, boolean ascOrder, String props) {
		Sort sort = Sort.by(ascOrder ? Direction.ASC : Direction.DESC);
		Pageable pageable = (Pageable) PageRequest.of(pageNo, pageSize, sort);
		Page<Doctor> page = (Page<Doctor>) doctorRepo.findAll((Sort) pageable);
		return page;
	}

}
