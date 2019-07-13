package com.nokid.erpg.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nokid.erpg.dto.RegisterDto;

@Repository
public class RegisterRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int registerUser(RegisterDto user) {
		StringBuilder query = new StringBuilder()
				.append("insert into cuslogin (FName, LName, Phone, Email_Address, Password")
				.append(" Password) values ('"+user.getFirstName()+"','"+user.getLastName()+"','")
				.append(""+user.getPhoneNumber()+"','"+user.getEmailAddress()+"','"+user.getPassword()+"')");
		
		
		int result = jdbcTemplate.update(query.toString());
		
		if(result == 1)
			return result;
		else
			return 0;
	}
}
