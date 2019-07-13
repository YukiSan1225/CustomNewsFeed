package com.nokid.erpg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nokid.erpg.dto.RegisterDto;
import com.nokid.erpg.repo.RegisterRepository;

@Service
public class RegisterService {
	
	@Autowired
	private RegisterRepository repo;
	
	public Integer registerUser(RegisterDto user) {
		return repo.registerUser(user);
	}
}
