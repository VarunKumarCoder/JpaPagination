package com.cdc.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cdc.service.IDoctorService;

@Component
public class SortTestRunner implements CommandLineRunner {
	@Autowired
	private IDoctorService service;

	@Override
	public void run(String... args) throws Exception {
		service.showDoctorsBySorting(true, "docName").forEach(System.out::println);
		System.out.println("________________________________");
		service.showDoctorsBySorting(false, "docName").forEach(System.out::println);
	}

}
