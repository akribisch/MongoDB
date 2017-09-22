package com.ywh;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ywh.dao.UserDao;
import com.ywh.dao.impl.UserDaoImpl;
import com.ywh.entity.NameEntity;
import com.ywh.entity.UserEntity;

public class ApplicationSpring {

	 public static void main(String[] args) {  
		  
	        System.out.println("Bootstrapping HelloMongo");  
	  
	        ConfigurableApplicationContext context = null;  
	        context = new ClassPathXmlApplicationContext("applicationContext.xml");  
	  
	        UserDao userDao = context.getBean(UserDaoImpl.class);  
	            userDao._test();  
	        String[] str={"one","two"};
	        UserEntity entity1 = new UserEntity();  
	        entity1.setId("1");  
	        entity1.setAge(1);  
	        entity1.setBirth(new Date());  
	        entity1.setPassword("asdfasdf");  
	        entity1.setRegionName("北京");  
	        entity1.setWorks(1);
	        entity1.setSpecial(str);
	        entity1.setName(new NameEntity("limingnihao","hello"));
	        userDao.insert(entity1);  
//	        userDao.update(entity1);  
	        userDao.createCollection();  
	      
	        List<UserEntity> list = userDao.findList(0, 10);  
	        for (UserEntity e : list) {  
	            System.out.println("all - id=" + e.getId() + ", age=" + e.getAge() + ", password=" + e.getPassword() + ", regionName=" + e.getRegionName() + ", special=" + Arrays.toString(e.getSpecial())  
	                    + ", name=" + e.getName().getUsername() + "-" + e.getName().getNickname() + ", birth=" + e.getBirth());  
	        }  
	  
	        list = userDao.findListByAge(1);  
	        for (UserEntity e : list) {  
	            System.out.println("age=1 - id=" + e.getId() + ", age=" + e.getAge() + ", password=" + e.getPassword() + ", regionName=" + e.getRegionName() + ", special="  
	                    + Arrays.toString(e.getSpecial()) + ", name=" + e.getName().getUsername() + "-" + e.getName().getNickname() + ", birth=" + e.getBirth());  
	        }  
	  
	        UserEntity e = userDao.findOne("1");  
	        System.out.println("id=1 - id=" + e.getId() + ", age=" + e.getAge() + ", password=" + e.getPassword() + ", regionName=" + e.getRegionName() + ", special=" + Arrays.toString(e.getSpecial())  
	                + ", name=" + e.getName().getUsername() + "-" + e.getName().getNickname() + ", birth=" + e.getBirth());  
	  
	        e = userDao.findOneByUsername("limingnihao");  
	        System.out.println("username=limingnihao - id=" + e.getId() + ", age=" + e.getAge() + ", password=" + e.getPassword() + ", regionName=" + e.getRegionName() + ", special="  
	                + Arrays.toString(e.getSpecial()) + ", name=" + e.getName().getUsername() + "-" + e.getName().getNickname() + ", birth=" + e.getBirth());  
	  
	          
	        System.out.println("DONE!");  
	    }  
}
