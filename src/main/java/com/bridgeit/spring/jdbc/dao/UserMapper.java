package com.bridgeit.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import com.bridgeit.spring.jdbc.model.User;

public class UserMapper implements RowMapper<User>{
List<User> list=new ArrayList<User>();
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {		
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setCity(rs.getString("city"));			
		return user;
	}

}
