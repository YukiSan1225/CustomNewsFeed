package com.nokid.erpg.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nokid.erpg.dto.LoginDto;
import com.nokid.erpg.dto.RegisterDto;

@Repository
public class LoginRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<RegisterDto> getAllInformation(){
		List<RegisterDto> result = new ArrayList<>();
		RegisterDto login = null;
		
		String sql = "select * from cuslogin";
		
		List<Map<String, Object>> resultMap = jdbcTemplate.queryForList(sql);
		
		for(Map r : resultMap) {
			login = new RegisterDto();
			
			login.setFirstName(r.get("FName").toString());
			login.setLastName(r.get("LName").toString());
			login.setPhoneNumber(r.get("Phone").toString());
			login.setEmailAddress(r.get("Email_Address").toString());
			login.setPassword(r.get("Password").toString());
			
			result.add(login);
		}
		
		return result;
	}
	
	public int authenticate(LoginDto user) {
		StringBuilder query = new StringBuilder()
				.append("select * from cuslogin")
				.append(" where Email_Address='"+user.getUsername()+"' and")
				.append(" Password='"+user.getPassword()+"'");
		
		List result = jdbcTemplate.queryForList(query.toString());
		
		if(result.size() == 1)
			return 1;
		else
			return 0;
	}
}
