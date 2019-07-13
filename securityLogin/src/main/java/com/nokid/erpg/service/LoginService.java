package com.nokid.erpg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nokid.erpg.dto.LoginDto;
import com.nokid.erpg.dto.RegisterDto;
import com.nokid.erpg.repo.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository repo;
	
	public List<RegisterDto> getAllInformation(){
		return repo.getAllInformation();
	}
	
	public Integer authenticate(LoginDto user) {
		return repo.authenticate(user);
	}
}
