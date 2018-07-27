package com.bridgeit.spring.jdbc.main;

import java.util.List;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.bridgeit.spring.jdbc.dao.UserDao;
import com.bridgeit.spring.jdbc.model.User;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringJdbc.xml");
		UserDao userDao = (UserDao) context.getBean("userDaoImpl");
		User user = (User) context.getBean("user");
		System.out.println("enter your choice");
		System.out.println("enter 1 for add user");
		System.out.println("enter 2 for update");
		System.out.println("enter 3 for delete");
		System.out.println("enter 4 for display by Id");
		System.out.println("enter 5 for display all users");
		int choice = scan.nextInt();
		switch (choice) {
		case 1:
			User newUser=new User();
			System.out.println("enter id");
			int id=scan.nextInt();
			System.out.println("enter name");
			String name=scan.next();
			System.out.println("enter city");
			String city=scan.next();
			newUser.setId(id);
			newUser.setName(name);
			newUser.setCity(city);
			userDao.save(newUser);
			break;
		case 2:
			System.out.println("enter id of user to update");
			int userId=scan.nextInt();
			System.out.println("enter name to update");
			String userName=scan.next();
			System.out.println("enter city to update");
			String userCity=scan.next();
			user.setName(userName);
			user.setCity(userCity);
			userDao.update(user,userId);
			break;
		case 3:
			System.out.println("enter id to delete");
			int existId=scan.nextInt();
			userDao.deleteById(existId);
			break;
		case 4:
			System.out.println("enter id to view user info");
			int displayId=scan.nextInt();
			User userDetails = userDao.getById(displayId);
			System.out.println(" user details : " + userDetails);
			break;
		case 5:
			List<User> list = userDao.displayAll();
			System.out.println(list);
			break;
		}
		((AbstractApplicationContext) context).close();
	}
}
