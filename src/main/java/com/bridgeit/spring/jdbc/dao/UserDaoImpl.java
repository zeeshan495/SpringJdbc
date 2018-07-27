package com.bridgeit.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import com.bridgeit.spring.jdbc.model.User;

public class UserDaoImpl implements UserDao {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void save(User user) {
		String query = "insert into User values(?,?,?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] obj = { user.getId(), user.getName(), user.getCity() };
		int status = jdbcTemplate.update(query, obj);
		if (status != 0)
			System.out.println("successfully saved");
		else
			System.out.println("failed to save");

	}

	public User getById(int id) {
		String query = "select id,name,city from User where id=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		User user = jdbcTemplate.queryForObject(query, new Object[] { id }, new UserMapper() );
		return user;
	}
	
	public void update(User user,int userId) {
		String query = "update User set  name=?, city=? where id="+userId;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] obj = {  user.getName(), user.getCity()};
		int status = jdbcTemplate.update(query, obj);
		if (status != 0)
			System.out.println("successfully updated");
		else
			System.out.println("failed to update");
	}
	
	public void deleteById(int id) {
		String query = "delete from User where id=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);		
		int status = jdbcTemplate.update(query, id);
		if (status != 0)
			System.out.println("successfully deleted");
		else
			System.out.println("failed to delete");
	}	
	
	public List<User> displayAll() {
		String query = "select * from User ";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<User> list = jdbcTemplate.query(query, new UserMapper());
		return list;
	}

	// public List getByCity(String city)
	// {
	// String query="select name from User where city=?";
	// JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
	// User user=(User) jdbcTemplate.queryForMap(query, new Object[]{city},new
	// ResultSetExtractor(){
	// public List extractData(ResultSet rs) throws SQLException,
	// DataAccessException {
	// List list=new ArrayList();
	// while(rs.next())
	// {
	// User user=new User();
	//
	// }
	// return list;
	// }
	// });
	// return user;
	// }
}
