package com.nokid.erpg.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nokid.erpg.dto.LoginDto;
import com.nokid.erpg.dto.RegisterDto;
import com.nokid.erpg.service.LoginService;
import com.nokid.erpg.service.RegisterService;

@RestController
@CrossOrigin
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private RegisterService registerService;

	private static Logger log = Logger.getLogger(LoginController.class);

	@GetMapping("/v1/login/getInformation")
	public ResponseEntity<List<RegisterDto>> getAllInformation() {
		log.info("/v1/login/getInformation called..");
		return new ResponseEntity<List<RegisterDto>>(loginService.getAllInformation(), HttpStatus.OK);
	}

	@PostMapping("/v1/login")
	public ResponseEntity<Integer> authenticate(@RequestBody LoginDto user) {
		log.info("/v1/login called");
		return new ResponseEntity<Integer>(loginService.authenticate(user), HttpStatus.OK);
	}

	@PostMapping("/v1/register")
	public ResponseEntity<Integer> registerUser(@RequestBody RegisterDto user) {
		log.info("/v1/register called");
		return new ResponseEntity<Integer>(registerService.registerUser(user), HttpStatus.OK);
	}
}
